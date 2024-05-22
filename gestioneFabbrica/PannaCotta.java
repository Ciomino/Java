
import java.util.ArrayList;

public class PannaCotta {
    private String nome;
    private ArrayList<String> ingredienti;
    private double prezzo;

    public PannaCotta(String nome, ArrayList<String> ingredienti, double prezzo){
        this.nome=nome;
        this.ingredienti=ingredienti;
        this.prezzo=prezzo;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<String> getIngredienti() {
        return ingredienti;
    }

    public double getPrezzo() {
        return prezzo;
    }
    
    public String getAll() {
        String pannaCottaInfo = "Nome: " + nome + "\n";
        pannaCottaInfo += "Ingredienti:\n";
        for (String ingrediente : ingredienti) {
            pannaCottaInfo += " - " + ingrediente + "\n";
        }
        pannaCottaInfo += "Prezzo: " + prezzo + "€";
        return pannaCottaInfo;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void aggiungiIngrediente(String newIngredient){
        if(!(newIngredient.isEmpty())){
            ingredienti.add(newIngredient);
        }
    }
}
