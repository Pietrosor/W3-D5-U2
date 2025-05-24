package service;

import entity.Libro;
import entity.Rivista;
import repository.LibroRepository;
import repository.RivistaRepository;
import java.util.List;

public class CatalogoService {

    private final LibroRepository libroRepository;
    private final RivistaRepository rivistaRepository;


    public CatalogoService() {
        this.libroRepository = new LibroRepository();
        this.rivistaRepository = new RivistaRepository();
    }


    public void aggiungiLibro(Libro libro) {
        libroRepository.salva(libro);
    }


    public void aggiungiRivista(Rivista rivista) {
        rivistaRepository.salva(rivista);
    }


    public Libro cercaLibro(String isbn) {
        return libroRepository.trovaPerISBN(isbn);
    }


    public Rivista cercaRivista(String isbn) {
        return rivistaRepository.trovaPerISBN(isbn);
    }


    public List<Libro> elencoLibri() {
        return libroRepository.trovaTutti();
    }


    public List<Rivista> elencoRiviste() {
        return rivistaRepository.trovaTutte();
    }


    public void rimuoviLibro(Libro libro) {
        libroRepository.elimina(libro);
    }


    public void rimuoviRivista(Rivista rivista) {
        rivistaRepository.elimina(rivista);
    }


    public void chiudi() {
        libroRepository.chiudi();
        rivistaRepository.chiudi();
    }
}