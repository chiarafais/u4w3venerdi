package chiarafais.entities;


import chiarafais.enums.TipoRivista;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
//@DiscriminatorValue("elemento_rivista")
public class Rivista extends ElementoCatalogo{

    @Enumerated(EnumType.STRING)
    @Column
    private TipoRivista tipoRivista;

    public Rivista (){

    }

    public Rivista(long isbn, String titolo, LocalDate annoPubblicazione, int numeroPagine, TipoRivista tipoRivista) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
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
