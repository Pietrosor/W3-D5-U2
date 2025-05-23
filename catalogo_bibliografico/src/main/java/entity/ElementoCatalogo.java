package entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class ElementoCatalogo {

    @Id
    private String isbn;              // Codice ISBN univoco

    private String titolo;            // Titolo dell'elemento
    private int annoPubblicazione;    // Anno di pubblicazione
    private int numeroPagine;         // Numero di pagine

    // Costruttore senza argomenti necessario per JPA
    public ElementoCatalogo() {
    }

    // Costruttore con argomenti per comodità
    public ElementoCatalogo(String isbn, String titolo, int annoPubblicazione, int numeroPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    // Getter e Setter
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
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
}