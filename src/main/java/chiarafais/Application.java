package chiarafais;

import chiarafais.dao.LibriDAO;
import chiarafais.dao.PrestitiDAO;
import chiarafais.dao.RivisteDAO;
import chiarafais.dao.UtentiDAO;
import chiarafais.entities.Libro;
import chiarafais.entities.Prestito;
import chiarafais.entities.Rivista;
import chiarafais.entities.Utente;
import chiarafais.enums.TipoRivista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;


public class Application {

    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("u4w3venerdi");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        //richiesta 1 creazione elementi del catalogo, libri e riviste
        LibriDAO ld = new LibriDAO(em);
        Libro libro1= new Libro("ci sto provando",2024,142,"io","horror");
        Libro libro2= new Libro("avrà funzionato?",2024,1400,"chiara","dramma");
        Libro libro3= new Libro("sarò una front-end ho appena deciso :) ",2024,135,"maddalena","giallo");
        Libro libro4= new Libro("devo trovare questo libroooo",2010,135,"maddalena","giallo");
//        ld.save(libro1);
//        ld.save(libro2);
//        ld.save(libro3);
//        ld.save(libro4);

        RivisteDAO rd = new RivisteDAO(em);
        Rivista rivista1 = new Rivista("prova rivista",2014,277, TipoRivista.MENSILE);
        Rivista rivista2 = new Rivista("questa è una rivista",2010,234, TipoRivista.MENSILE);
        Rivista rivista3 = new Rivista("un altra rivista",2024,57, TipoRivista.SEMESTRALE);
        Rivista rivista4 = new Rivista("wow, è una rivista!",2022,70, TipoRivista.SETTIMANALE);
//        rd.save(rivista1);
//        rd.save(rivista2);
//        rd.save(rivista3);
//        rd.save(rivista4);


        UtentiDAO ud = new UtentiDAO(em);
        Utente chiara = new Utente("Chiara","Fais", LocalDate.of(2003,9,15));
        Utente aldo = new Utente("Aldo","Baglio",LocalDate.of(1950,6,30));
        Utente giovanni = new Utente("Giovanni","Storti",LocalDate.of(1990,8,7));
//        ud.save(chiara);
//        ud.save(aldo);
//        ud.save(giovanni);


        System.out.println("**********************Ricerca per ISBN************************");
        Libro libroISBN2 =ld.findByIsbn(2);
        Rivista rivistaISBN3 = rd.findByIsbn(3);
        Rivista rivistaISBN6 = rd.findByIsbn(6);

        System.out.println("**********************Eliminazione tramite ISBM************************");
//        eliminazione elemento dal catalogo tramite codice ISBN OK FUNZIONA (so che non è correttissimo aver usato dei long come id e ISBN
//        ma non volevo complicarmi troppo la vita, preferivo cercare di finire)
//        ld.deleteByIsbn(1);

        System.out.println("**********************Ricerca per anno di pubblicazione libro/rivista************************");
           ld.libroPerAnnoPubblicazione(2010);
           rd.rivistaPerAnnoPubblicazione(2014);

        System.out.println("**********************Ricerca libro per autore, le riviste non hanno autore!************************");
        ld.libroPerAutore("maddalena");

        System.out.println("**********************Ricerca per titolo o per parte di esso************************");
        ld.libroPerTitolo("devo");
        rd.rivistaPerTitolo("questa è una rivista");

        System.out.println("**********************Ricerca degli elementi attualmente in prestito tramite un numero di tessera utente************************");
        Utente chiaraTessera = ud.findById(1);
        PrestitiDAO pd = new PrestitiDAO(em);
        Prestito prestito1 = new Prestito(chiaraTessera,LocalDate.of(2024,5,7),rivistaISBN6,LocalDate.of(2024,6,3));
        pd.save(prestito1);


        pd.PrestitiPerUtente(1);
        pd.PrestitiScadutiNonRestituiti();

        em.close();
        emf.close();

        System.out.println("Hello World!");
    }
}
