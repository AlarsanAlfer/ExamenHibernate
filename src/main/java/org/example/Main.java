package org.example;

import org.example.models.Opinion;
import org.example.models.Pelicula;
import org.hibernate.Session;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Session session = HibernateUtil.getSessionFactory().openSession();
        Servicio serv = new Servicio(HibernateUtil.getSessionFactory());


//        Pelicula nuevapelicula = new Pelicula();
//        nuevapelicula.setTitulo("Nueva Pelicula");
//        serv.guardarPelicula(nuevapelicula);



//         serv.opinionesUsuario("user1@example.com").forEach(System.out::println);



//        Opinion op = new Opinion();
//        op.setDescripcion("Esta peli e malísima");
//        op.setUsuario("user1@example.com");
//        op.setPuntuacion(2);
//
//        serv.guardarOpinion(6L, op);



//        serv.peliculasBajaPuntuacion().forEach(System.out::println);


    }
}