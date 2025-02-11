package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import vista.BancoVista;

public class Main {
    public static void main(String[] args) {
       new ClassPathXmlApplicationContext("bancoContext.xml");


    }
}
