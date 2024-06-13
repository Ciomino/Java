import java.util.ArrayList;

public class Concessionaria {
    ArrayList<Veicolo> catalogo = new ArrayList<>();


    public Concessionaria(ArrayList<Veicolo> catalogo){
        this.catalogo = catalogo;
    }

    public void stampaCatalogo(){
        for (Veicolo catalogues : catalogo) {
            catalogues.getAll();
        }
    }

    
}


