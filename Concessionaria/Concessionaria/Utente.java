
import java.util.ArrayList;

public class Utente{
    private String username;
    private String password;
    private static int ultimoId = 0;
    private int id;
    private ArrayList<Veicolo> storico;
    private int budget;

    public Utente(String username,String password,int budget){
        this.username=username;
        this.password=password;
        this.id=generaNuovoId();
        this.budget=budget;
        // this.storico= new ArrayList<Veicolo>();
    }
    private static synchronized int generaNuovoId() {
        return ++ultimoId;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Veicolo> getStorico() {
        return storico;
    }

    public int getBudget() {
        return budget;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
    public void printStorico(){
        for (Veicolo x : storico) {
            x.getAll();
        }
    }
    
}
