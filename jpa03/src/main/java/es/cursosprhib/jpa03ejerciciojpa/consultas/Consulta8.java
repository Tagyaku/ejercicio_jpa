package es.cursosprhib.jpa03ejerciciojpa.consultas;

import java.util.List;

import es.cursosprhib.jpa03.EMF;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Categoria;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Cliente;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta8 {
 public static void main(String[] args) {

        EntityManager eManager = EMF.getInstance().createEntityManager();

        // Listar cantidad de productos comprados por cada categoria de cliente
        System.out.println("1--------------------------------");

        String jpqlString = "SELECT c.categoria, COUNT(p.idProducto) FROM Producto p JOIN p.clientes c GROUP BY c.categoria";        TypedQuery<Object[]> query = eManager.createQuery(jpqlString, Object[].class);

        List<Object[]> resultados = query.getResultList();

        for (Object[] resultado : resultados) {
            String categoria = (String) resultado[0];  
            Long cantidadProductos = (Long) resultado[1];   
            System.out.println("Categoria: " + categoria + ", Cantidad de productos: " + cantidadProductos);
        }
    }
 }
