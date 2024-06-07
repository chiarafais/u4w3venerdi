package chiarafais.dao;

import jakarta.persistence.EntityManager;
import chiarafais.entities.Libro;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;


public class LibriDAO {
    private final EntityManager em;

    public LibriDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Libro libro) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(libro);
        transaction.commit();
        System.out.println("Libro " + libro.getTitolo() + " aggiunto correttamente al database!");
    }


    public Libro findByIsbn(long isbn) {
        Libro libro = em.find(Libro.class, isbn);
        if (libro != null) {
            System.out.println("Libro con isbn " + isbn + ":"  + libro);
        } else {
            System.out.println("Nessun libro trovato con l'ISBN: " + isbn);
        }
        return libro;
    }
    public void deleteByIsbn (long isbn) {
        Libro found = this.findByIsbn(isbn);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Libro con ISBN " + found.getIsbn() + " eliminato correttamente dal database!");

    }

    public void libroPerAnnoPubblicazione(int annoPubblicazione) {
        TypedQuery<Libro> query = em.createNamedQuery("libroPerAnnoPubblicazione", Libro.class);
        query.setParameter("annoPubblicazione", annoPubblicazione);
        List<Libro> libri = query.getResultList();

        if (!libri.isEmpty()) {
            System.out.println("Libri pubblicati nell'anno " + annoPubblicazione + ":");
            for (Libro libro : libri) {
                System.out.println(libro);
            }
        } else {
            System.out.println("Nessun libro trovato pubblicato nell'anno " + annoPubblicazione);
        }

    }
    public List<Libro> libroPerAutore(String autore) {
        TypedQuery<Libro> query = em.createNamedQuery("libroPerAutore", Libro.class);
        query.setParameter("autore", "%" + autore + "%");
        List<Libro> libri = query.getResultList();

        if (!libri.isEmpty()) {
            System.out.println("Riviste dell'autore \"" + autore + "\":");
            for (Libro libro : libri) {
                System.out.println(libro);
            }
        } else {
            System.out.println("Nessuna rivista trovata per l'autore \"" + autore + "\"");
        }

        return libri;
    }

    public List<Libro> libroPerTitolo(String titolo) {
        TypedQuery<Libro> query = em.createNamedQuery("libroPerTitolo", Libro.class);
        query.setParameter("titolo", "%" + titolo + "%");
        List<Libro> libri = query.getResultList();

        if (!libri.isEmpty()) {
            System.out.println("Libri con il titolo contenente " + titolo + ":");
            for (Libro libro : libri) {
                System.out.println(libro);
            }
        } else {
            System.out.println("Nessun libro trovato con il titolo contenente " + titolo );
        }

        return libri;
    }
}
