package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.AppConfig;
import vista.BancoVista;

public class Main {
    public static void main(String[] args) {
       new AnnotationConfigApplicationContext(AppConfig.class);


    }
}
