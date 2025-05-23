package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
public class Rivista extends ElementoCatalogo {

    @Enumerated(EnumType.STRING)
    private Periodicita periodicita; // Valore ENUM: SETTIMANALE, MENSILE, SEMESTRALE

    // Costruttore senza argomenti (richiesto da JPA)
    public Rivista() {
    }

    // Costruttore con argomenti
    public Rivista(String isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    // Getter e Setter per periodicita
    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
}