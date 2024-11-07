package org.example;

import org.example.models.Opinion;
import org.example.models.Pelicula;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Servicio {
    private SessionFactory sessionFactory;

    public Servicio(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    /**
     * Este metodo guarda en la base de datos una pelicula nueva
     * **/
    public void guardarPelicula(Pelicula peli){sessionFactory.inTransaction(session -> session.persist(peli));}

    /**
     * Este metodo muestra todas las opiniones pertenecientes a un usuario
     * **/
    public List<Opinion> opinionesUsuario(String user){
        try(Session session = sessionFactory.openSession()){
         return session.createQuery("from Opinion where usuario = :elUsuario", Opinion.class)
                 .setParameter("elUsuario", user)
                 .list();
        }
    }

    /**
     * Este metodo guarda una opinion nueva, asociandola a una pelicula ya existente
     * a través del id
     * **/
    public void guardarOpinion(Long idPeli, Opinion opinion) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Pelicula pelicula = session.get(Pelicula.class, idPeli);

            opinion.setPelicula(pelicula);
            pelicula.getOpiniones().add(opinion);
            session.persist(opinion);
            session.getTransaction().commit();
        }
    }
    /**
     * Este metodo muestra las peliculas con una nota inferior o igual a 3
     * **/
    public List<String> peliculasBajaPuntuacion(){
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("select p.titulo from Pelicula p join p.opiniones o where o.puntuacion <= 3", String.class)
                    .list();
        }
    }


}
