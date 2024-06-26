package chiarafais.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name="elemento_bibliografico")
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn
public abstract class ElementoCatalogo {
    @Id
    @GeneratedValue
    protected long isbn;
    @Column(nullable = false)
    protected String titolo;
    @Column(nullable = false)
    protected int annoPubblicazione;
    @Column(nullable = false)
    protected int numeroPagine;
    @OneToMany(mappedBy = "isbn")
    private List<ElementoCatalogo> elementoCatalogoList;

    public ElementoCatalogo(){

    }

    public ElementoCatalogo( String titolo, int annoPubblicazione, int numeroPagine) {
        this.titolo=titolo;
        this.annoPubblicazione=annoPubblicazione;
        this.numeroPagine=numeroPagine;
    }

    @Override
    public String toString() {
        return "ElementoCatalogo{" +
                "isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                ", elementoCatalogoList=" + elementoCatalogoList +
                '}';
    }

    public long getIsbn() {
        return isbn;
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public List<ElementoCatalogo> getElementoCatalogoList() {
        return elementoCatalogoList;
    }

    public void setElementoCatalogoList(List<ElementoCatalogo> elementoCatalogoList) {
        this.elementoCatalogoList = elementoCatalogoList;
    }

}
