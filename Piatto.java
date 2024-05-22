import java.util.HashMap;

public class Piatto {
    public  HashMap<String, Integer> ingredientiP;
    private HashMap<String, Integer> ingredientiScelta;

    public Piatto(HashMap<String, Integer> ingredientiP,HashMap<String , Integer> ingredientiScelta){
        this.ingredientiP = ingredientiP;
        this.ingredientiScelta = ingredientiScelta;
    }

    public HashMap<String, Integer> getIngredientiP() {
        return ingredientiP;
    }

    public HashMap<String, Integer> getIngredientiScelta() {
        return ingredientiScelta;
    }

    public void setIngredientiP(HashMap<String, Integer> ingredientiP) {
        this.ingredientiP = ingredientiP;
    }

    public void setIngredientiScelta(HashMap<String, Integer> ingredientiScelta) {
        this.ingredientiScelta = ingredientiScelta;
    }

    
}
