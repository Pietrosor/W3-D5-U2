package service;

import entity.Libro;
import entity.Rivista;
import repository.LibroRepository;
import repository.RivistaRepository;
import java.util.List;

public class CatalogoService {

    private final LibroRepository libroRepository;
    private final RivistaRepository rivistaRepository;

    // Costruttore inizializza le repository
    public CatalogoService() {
        this.libroRepository = new LibroRepository();
        this.rivistaRepository = new RivistaRepository();
    }

    // Metodo per aggiungere un Libro
    public void aggiungiLibro(Libro libro) {
        libroRepository.salva(libro);
    }

    // Metodo per aggiungere una Rivista
    public void aggiungiRivista(Rivista rivista) {
        rivistaRepository.salva(rivista);
    }

    // Metodo per cercare un Libro tramite ISBN
    public Libro cercaLibro(String isbn) {
        return libroRepository.trovaPerISBN(isbn);
    }

    // Metodo per cercare una Rivista tramite ISBN
    public Rivista cercaRivista(String isbn) {
        return rivistaRepository.trovaPerISBN(isbn);
    }

    // Metodo per ottenere l'elenco di tutti i Libri
    public List<Libro> elencoLibri() {
        return libroRepository.trovaTutti();
    }

    // Metodo per ottenere l'elenco di tutte le Riviste
    public List<Rivista> elencoRiviste() {
        return rivistaRepository.trovaTutte();
    }

    // Metodo per rimuovere un Libro
    public void rimuoviLibro(Libro libro) {
        libroRepository.elimina(libro);
    }

    // Metodo per rimuovere una Rivista
    public void rimuoviRivista(Rivista rivista) {
        rivistaRepository.elimina(rivista);
    }

    // Metodo per chiudere le risorse delle repository
    public void chiudi() {
        libroRepository.chiudi();
        rivistaRepository.chiudi();
    }
}