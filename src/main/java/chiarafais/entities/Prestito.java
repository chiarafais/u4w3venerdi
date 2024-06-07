package chiarafais.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@NamedQuery(
        name = "PrestitiPerUtente",
        query = "SELECT p FROM Prestito p WHERE p.utente.numeroDiTessera = :numeroTessera AND p.dataRestituzioneEffettiva IS NULL"
)
@NamedQuery(
        name = "PrestitiScadutiNonRestituiti",
        query = "SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva < CURRENT_DATE AND dataRestituzioneEffettiva<dataRestituzionePrevista"
)
public class Prestito {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne

    @JoinColumn(name="utente_id")

    private Utente utente;
    @ManyToOne
    @JoinColumn(name="isbn_id")
    private ElementoCatalogo elementoPrestato;
    @Column
    private LocalDate dataInizioPrestito;
    @Column
    private LocalDate dataRestituzionePrevista;
    @Column
    private LocalDate dataRestituzioneEffettiva;




    public Prestito() {
    }

    public Prestito(Utente utente, LocalDate dataInizioPrestito, ElementoCatalogo elementoPrestato, LocalDate dataRestituzioneEffettiva) {
        this.utente = utente;
        this.dataInizioPrestito = dataInizioPrestito;
        this.elementoPrestato = elementoPrestato;
        this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "utente=" + utente +
                ", elementoPrestato=" + elementoPrestato +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public ElementoCatalogo getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(ElementoCatalogo elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }
}
