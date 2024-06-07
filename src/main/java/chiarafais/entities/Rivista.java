package chiarafais.entities;


import chiarafais.enums.TipoRivista;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("elemento_rivista")
@NamedQuery(
        name = "rivistaPerAnnoPubblicazione",
        query = "SELECT r FROM Rivista r WHERE r.annoPubblicazione = :annoPubblicazione"
)
@NamedQuery(
        name = "rivistaPerTitolo",
        query = "SELECT r FROM Rivista r WHERE r.titolo LIKE :titolo"
)
public class Rivista extends ElementoCatalogo{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoRivista tipoRivista;

    public Rivista (){

    }

    public Rivista(String titolo, int annoPubblicazione, int numeroPagine, TipoRivista tipoRivista) {
        super( titolo, annoPubblicazione, numeroPagine);
        this.tipoRivista=tipoRivista;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "tipoRivista=" + tipoRivista +
                ", isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

    public TipoRivista getTipoRivista() {
        return tipoRivista;
    }

    public void setTipoRivista(TipoRivista tipoRivista) {
        this.tipoRivista = tipoRivista;
    }

}
