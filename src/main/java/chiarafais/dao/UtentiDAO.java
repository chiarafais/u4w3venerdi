package chiarafais.dao;

import chiarafais.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UtentiDAO {
    private final EntityManager em;

    public UtentiDAO(EntityManager em) {this.em = em;}

    public void save(Utente utente) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(utente);
        transaction.commit();
        System.out.println("Utente " + utente.getNome() + " aggiunto correttamente al database!");
    }

    public Utente findById(int id) {
        return em.find(Utente.class, id);
    }

//    public Utente findByNumber(int numeroDiTessera) {
//        return em.find(Utente.class, numeroDiTessera);
//    }
}
