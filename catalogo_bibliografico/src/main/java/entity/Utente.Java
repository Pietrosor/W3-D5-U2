package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Utente {

    @Id
    private String numeroTessera;

    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;

    public Utente() {
    }

    public Utente(String numeroTessera, String nome, String cognome, LocalDate dataDiNascita) {
        this.numeroTessera = numeroTessera;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }


    public String getNumeroTessera() {
        return numeroTessera;
    }
    public void setNumeroTessera(String numeroTessera) {
        this.numeroTessera = numeroTessera;
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
}