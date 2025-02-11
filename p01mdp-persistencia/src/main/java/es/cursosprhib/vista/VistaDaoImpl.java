package es.cursosprhib.vista;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import es.cursosprhib.mediosdepago.modelo.Cliente;
import es.cursosprhib.mediosdepago.modelo.Cuenta;
import es.cursosprhib.mediosdepago.modelo.Extracto;
import es.cursosprhib.mediosdepago.persistencia.ClienteDaoImpl;
import es.cursosprhib.mediosdepago.persistencia.ExtractoDaoImpl;
import jakarta.annotation.PostConstruct;

@Component("VistaDao")
public class VistaDaoImpl implements VistaDao {

    private ClienteDaoImpl clienteDaoImpl;
    private ExtractoDaoImpl extractoDaoImpl;

    private Cuenta cuenta;

    @Autowired
    public VistaDaoImpl(@Lazy ClienteDaoImpl clienteDaoImpl, @Lazy ExtractoDaoImpl extractoDaoImpl) {
        this.clienteDaoImpl = clienteDaoImpl;
        this.extractoDaoImpl = extractoDaoImpl;
    }

    @Override
    @PostConstruct
    public void iniciarAplicacion() {
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Introduzca el nombre del cliente que quiere buscar:");
        String nombre = sc.next();
        List<Cliente> clientes = clienteDaoImpl.findByNombre(nombre);
        System.out.println(clientes);

        System.out.println("---------------------------------------------------");

        // Mostrar todos los clientes
        System.out.println("A continuación, cuando pulse Enter se mostrarán todos los clientes.");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Cliente> allClientes = clienteDaoImpl.findAll();
        System.out.println(allClientes);

        System.out.println("---------------------------------------------------");

        // Buscar cliente por ID
        System.out.println("Introduzca el ID del cliente que quiere buscar:");
        Integer id = sc.nextInt();
        Cliente cliente = clienteDaoImpl.findByIdEager(id);
        System.out.println(cliente);

        System.out.println("---------------------------------------------------");

        // Buscar extracto de cuenta
        System.out.println("Buscando extracto, introduzca el ID de la cuenta:");
        Integer idCuenta = sc.nextInt();

        System.out.println("Introduzca el mes:");
        int mes = sc.nextInt();

        System.out.println("Introduzca el año:");
        int año = sc.nextInt();

        cuenta = new Cuenta();
        cuenta.setIdCuenta(idCuenta);

        Extracto extracto = extractoDaoImpl.findExtracto(cuenta, año, mes);
        System.out.println(extracto);
    }
}
