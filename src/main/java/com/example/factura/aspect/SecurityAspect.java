package com.example.factura.aspect;

import com.example.factura.model.Bill;
import com.example.factura.model.User;
import com.example.factura.service.BillService;
import com.example.factura.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@Aspect
@Component
public class SecurityAspect {

    @Autowired
    UserService serviceUser;

    @Autowired
    BillService serviceBill;

    @Before("@annotation(auth) && args(nroDocumento,codPeriodo)")
    public void checkAccess(JoinPoint jp,Authorization auth,String nroDocumento, String codPeriodo){

        System.out.println("Verificando autenticacion");

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String header = request.getHeader("Authorization"); //Basic YWxhZGRpbjpvcGVuc2VzYW1l
        String [] arrayAuth = header.split(" ");
        String userPassBase64 = arrayAuth[1];
        String decodeUserPass = new String (Base64.getDecoder().decode(userPassBase64.getBytes()));
        String [] credentials = decodeUserPass.split(":");

        User user = new User();
        user.setUsername(credentials[0]);
        user.setPassword(credentials[1]);

        if(user.getUsername().isEmpty() || user.getPassword().isEmpty())
            throw new RuntimeException("No se tienen datos de autenticacion");

        boolean result = serviceUser.login(user);

        if(!result)
            throw new RuntimeException("Usuario y/o contraseña incorrectos");

        System.out.println("Credenciales correctas. Se procede a ejecutar el metodo");


        System.out.println(String.format("Verificando generacion de factura para cliente %s en el periodo %s",nroDocumento,codPeriodo));


        Bill billObject = serviceBill.getBillByClientIdAndPeriod(nroDocumento, codPeriodo);

        if(billObject != null)
            throw new RuntimeException(String.format("La factura %s del cliente %s para el periodo %s ya existe no se puede generar","Fac"+billObject.getId(),billObject.getNroDocumento(),billObject.getPeriodo()));

        System.out.println("Factura no generada se procede a generar esta");


    }

}
