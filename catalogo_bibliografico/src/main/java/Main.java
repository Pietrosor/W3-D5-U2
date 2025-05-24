
import entity.Libro;
import service.CatalogoService;

public class Main {
    public static void main(String[] args) {


        CatalogoService catalogoService = new CatalogoService();


        Libro libro = new Libro("123456789", "Il titolo del libro", 2025, 350, "Autore Sconosciuto", "Genere Sconosciuto");


        catalogoService.aggiungiLibro(libro);
        System.out.println("Libro aggiunto con ISBN: " + libro.getIsbn());




        catalogoService.chiudi();
    }
}