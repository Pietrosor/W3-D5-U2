
import entity.Libro;
import service.CatalogoService;

public class Main {
    public static void main(String[] args) {

        // Inizializza il service del catalogo
        CatalogoService catalogoService = new CatalogoService();

        // Crea un nuovo libro per testare la persistenza
        Libro libro = new Libro("123456789", "Il titolo del libro", 2025, 350, "Autore Sconosciuto", "Genere Sconosciuto");

        // Aggiungi il libro al catalogo
        catalogoService.aggiungiLibro(libro);
        System.out.println("Libro aggiunto con ISBN: " + libro.getIsbn());

        // Puoi anche effettuare altre operazioni, ad esempio ricercare libri o stampare la lista dei libri

        // Chiudi le risorse (EntityManager, EntityManagerFactory)
        catalogoService.chiudi();
    }
}