package repository;

import entity.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class LibroRepository {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public LibroRepository() {
        // "CatalogoBibliografico" è il nome della persistence unit definita in persistence.xml
        emf = Persistence.createEntityManagerFactory("CatalogoBibliografico");
        em = emf.createEntityManager();
    }

    // Metodo per salvare un Libro nel database
    public void salva(Libro libro) {
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }

    // Metodo per trovare un Libro tramite il suo ISBN (chiave primaria)
    public Libro trovaPerISBN(String isbn) {
        return em.find(Libro.class, isbn);
    }

    // Metodo per recuperare tutti i libri presenti nel database
    public List<Libro> trovaTutti() {
        TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l", Libro.class);
        return query.getResultList();
    }

    // Metodo per aggiornare un Libro
    public Libro aggiorna(Libro libro) {
        em.getTransaction().begin();
        Libro updatedLibro = em.merge(libro);
        em.getTransaction().commit();
        return updatedLibro;
    }

    // Metodo per eliminare un Libro dal database
    public void elimina(Libro libro) {
        em.getTransaction().begin();
        if (!em.contains(libro)) {
            libro = em.merge(libro);
        }
        em.remove(libro);
        em.getTransaction().commit();
    }

    // Metodo per chiudere le risorse
    public void chiudi() {
        if (em.isOpen()) {
            em.close();
        }
        if (emf.isOpen()) {
            emf.close();
        }
    }
}