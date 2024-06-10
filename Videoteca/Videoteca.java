import java.util.ArrayList;

public class Videoteca{
    public static void main(String[] args) {
        ArrayList<Film> collezioneFilm = new ArrayList<>();
        collezioneFilm.add(new Film("Pulp Fiction", 1994));
        collezioneFilm.add(new Film("Inception", 2010));
        collezioneFilm.add(new Film("La La Land", 2016));
        collezioneFilm.add(new Film("Il Padrino", 1972));
        collezioneFilm.add(new Film("Interstellar", 2014));
        collezioneFilm.add(new Film("Forrest Gump", 1994));
        collezioneFilm.add(new Film("Fight Club", 1999));
        collezioneFilm.add(new Film("Il Signore degli Anelli: La Compagnia dell'Anello", 2001));
        collezioneFilm.add(new Film("Shutter Island", 2010));
        collezioneFilm.add(new Film("The Matrix", 1999));
        
    }
}