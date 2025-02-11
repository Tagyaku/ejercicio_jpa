package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import vista.BancoVista;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bancoContext.xml");

        BancoVista bancoVista = ctx.getBean(BancoVista.class);

        bancoVista.iniciarAplicacion();

        ctx.close();
    }
}
