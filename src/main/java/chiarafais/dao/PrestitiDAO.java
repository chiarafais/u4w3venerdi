package chiarafais.dao;


import chiarafais.entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PrestitiDAO {
    private final EntityManager em;

    public PrestitiDAO(EntityManager em) {this.em = em;}

    public void save(Prestito prestito) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(prestito);
        transaction.commit();
        System.out.println("Prestito di " + prestito.getUtente() + " aggiunto correttamente al database!");
    }
    public void PrestitiPerUtente(int numeroTessera) {
        TypedQuery<Prestito> query = em.createNamedQuery(
                "PrestitiPerUtente",
                Prestito.class
        );
        query.setParameter("numeroTessera", numeroTessera);
        List<Prestito> prestiti = query.getResultList();

        if (prestiti.isEmpty()) {
            System.out.println("Nessun prestito ancora non restituito trovato per l'utente con numero di tessera: " + numeroTessera);
        } else {
            System.out.println("Prestiti trovati per l'utente con numero di tessera: " + numeroTessera);
            for (Prestito prestito : prestiti) {
                System.out.println(prestito);
            }
        }
    }
    public void PrestitiScadutiNonRestituiti() {
        TypedQuery<Prestito> query = em.createNamedQuery(
                "PrestitiScadutiNonRestituiti",
                Prestito.class
        );
        List<Prestito> prestiti = query.getResultList();

        if (prestiti.isEmpty()) {
            System.out.println("Nessun prestito scaduto e non restituito trovato.");
        } else {
            System.out.println("Prestiti scaduti e non restituiti trovati:");
            for (Prestito prestito : prestiti) {
                System.out.println(prestito);
            }
        }
    }

}
