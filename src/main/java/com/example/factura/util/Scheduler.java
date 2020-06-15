package com.example.factura.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Scheduler {
    @Scheduled(cron = "0 0 0 1 1/1 ? *")
    public void doTask(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Ejecutando el: "+ now.toString());
    }
}
