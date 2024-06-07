package chiarafais.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Utente {
    @Column
    private String nome;
    @Column
    private String cognome;
    @Column
    private LocalDate dataDiNascita;

    @Id
    @Column
    @GeneratedValue
    private int numeroDiTessera;
    @OneToMany(mappedBy = "utente")
    private List<Prestito> prestitoList;

    public Utente (){

    }

    public Utente (String nome, String cognome, LocalDate dataDiNascita){
        this.nome=nome;
        this.cognome=cognome;
        this.dataDiNascita=dataDiNascita;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", numeroDiTessera=" + numeroDiTessera +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public int getNumeroDiTessera() {
        return numeroDiTessera;
    }

    public List<Prestito> getPrestitoList() {
        return prestitoList;
    }

    public void setPrestitoList(List<Prestito> prestitoList) {
        this.prestitoList = prestitoList;
    }
}
