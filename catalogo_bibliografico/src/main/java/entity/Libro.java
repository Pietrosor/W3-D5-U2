package entity;

import jakarta.persistence.Entity;

@Entity
public class Libro extends ElementoCatalogo {

    private String autore;
    private String genere;

    // Costruttore senza argomenti (necessario per JPA)
    public Libro() {
    }

    // Costruttore con argomenti per comodità
    public Libro(String isbn, String titolo, int annoPubblicazione, int numeroPagine,
                 String autore, String genere) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    // Getter e Setter per autore
    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    // Getter e Setter per genere
    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}