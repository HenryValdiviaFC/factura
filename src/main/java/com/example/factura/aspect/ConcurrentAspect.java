package com.example.factura.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Aspect
@Component
public class ConcurrentAspect {

    private Lock lock = new ReentrantLock();

    @Around("@annotation(LockThread) && args(nroDocumento,codPeriodo)")
    public Object lockProcess(ProceedingJoinPoint joinPoint){
        Object object = null;
        System.out.println("Antes del bloqueo: "+joinPoint.toString());
        lock.lock();
        try {
            object = joinPoint.proceed();
            System.out.println(object.toString());
        } catch (Throwable throwable) {
            System.out.println("Error: "+throwable.getMessage());
        }
        finally {
            lock.unlock();
            System.out.println("Desbloqueando");
        }
        return object;
    }
}
