public class Film {
    private String titolo;
    private int anno;

    public Film(String titolo, int anno){
        this.titolo=titolo;
        this.anno=anno;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }
    
}
