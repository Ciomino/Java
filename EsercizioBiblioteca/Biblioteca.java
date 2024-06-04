
import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Libro> libriDisponibili;

    public Biblioteca() {
        this.libriDisponibili = new ArrayList<>();
    }

    public void prestaLibro(String titoloLibro) {
        Libro libro = trovaLibro(titoloLibro);

        if (libro != null && libro.getCopieDisponibili() > 0) {
            libro.decrementaCopieDisponibili();
            libro.incrementaCopieInPrestito();
            System.out.println("Libro " + titoloLibro + " prestato con successo");
        } else {
            if (libro == null) {
                System.out.println("Libro " + titoloLibro + " non trovato");
            } else {
                System.out.println("Libro " + titoloLibro + " non disponibile");
            }
        }
    }

    public void restituisciLibro(String titoloLibro) {
        Libro libro = trovaLibro(titoloLibro);

        if (libro != null && libro.getCopieInPrestito() > 0) {
            libro.incrementaCopieDisponibili();
            libro.decrementaCopieInPrestito();
            System.out.println("Libro " + titoloLibro + " restituito con successo");
        } else {
            if (libro == null) {
                System.out.println("Libro " + titoloLibro + " non trovato");
            } else {
                System.out.println("Libro " + titoloLibro + " non e' stato prestato");
            }
        }
    }

    public void aggiungiLibro(String titoloLibro, int copieDisponibili) {
        Libro libro = new Libro(titoloLibro, copieDisponibili);
        libriDisponibili.add(libro);
        System.out.println("Libro " + titoloLibro + " aggiunto con successo");
    }

    public void rimuoviLibro(String titoloLibro) {
        Libro libro = trovaLibro(titoloLibro);

        if (libro != null) {
            libriDisponibili.remove(libro);
            System.out.println("Libro " + titoloLibro + " rimosso con successo");
        } else {
            System.out.println("Libro " + titoloLibro + " non trovato");
        }
    }

    public void stampaLibriDisponibili() {
        System.out.println("Libri disponibili:");

        for (Libro libro : libriDisponibili) {
            System.out.println("- " + libro.getTitoloLibro() + " (" + libro.getCopieDisponibili() + " copie disponibili)");
        }
    }

    private Libro trovaLibro(String titoloLibro) {
        for (Libro libro : libriDisponibili) {
            if (libro.getTitoloLibro().equals(titoloLibro)) {
                return libro;
            }
        }
        return null;
    }
}
