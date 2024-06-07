package chiarafais.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("elemento_libro")
@NamedQuery(
        name = "libroPerAnnoPubblicazione",
        query = "SELECT l FROM Libro l WHERE l.annoPubblicazione = :annoPubblicazione"
)
@NamedQuery(
        name = "libroPerAutore",
        query = "SELECT l FROM Libro l WHERE l.autore LIKE :autore"
)
@NamedQuery(
        name = "libroPerTitolo",
        query = "SELECT l FROM Libro l WHERE l.titolo LIKE :titolo"
)
public class Libro extends ElementoCatalogo{
    @Column(nullable = false)
    private String autore;
    @Column(nullable = false)
    private String genere;

    public Libro(){

    }

    public Libro( String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super( titolo, annoPubblicazione, numeroPagine);
        this.autore=autore;
        this.genere=genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", numeroPagine=" + numeroPagine +
                ", annoPubblicazione=" + annoPubblicazione +
                '}';
    }

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}
