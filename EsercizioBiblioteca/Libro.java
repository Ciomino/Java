public class Libro {

    private String titoloLibro;
    private int copieDisponibili;
    private int copieInPrestito;

    public Libro(String titoloLibro, int copieDisponibili) {
        this.titoloLibro = titoloLibro;
        this.copieDisponibili = copieDisponibili;
        this.copieInPrestito = 0;
    }

    public String getTitoloLibro() {
        return titoloLibro;
    }

    public int getCopieDisponibili() {
        return copieDisponibili;
    }

    public void decrementaCopieDisponibili() {
        copieDisponibili--;
    }

    public void incrementaCopieDisponibili() {
        copieDisponibili++;
    }

    public int getCopieInPrestito() {
        return copieInPrestito;
    }

    public void incrementaCopieInPrestito() {
        copieInPrestito++;
    }

    public void decrementaCopieInPrestito() {
        copieInPrestito--;
    }
}
