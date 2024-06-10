import java.util.ArrayList;

public class Utente {
    private String id;
    private String nome;
    private ArrayList<Film> filmNoleggiati;

    public Utente(String id, String nome){
        this.id=id;
        this.nome=nome;
    }

    public void noleggiaFilm(Film film){
        filmNoleggiati.add(film);
    }
    public void elencoNoleggi(){
        filmNoleggiati.forEach((film) -> System.out.println(film));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Film> getFilmNoleggiati() {
        return filmNoleggiati;
    }

    public void setFilmNoleggiati(ArrayList<Film> filmNoleggiati) {
        this.filmNoleggiati = filmNoleggiati;
    }
    
}
