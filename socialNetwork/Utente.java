
public class Utente{
    private String username;
    private String password;
    private String email;
    private String numero;
    private int eta;

    public Utente(String username,String password,String email,String numero,int eta){
        this.username=username;
        this.password=password;
        this.email=email;
        this.numero=numero;
        this.eta=eta;
    }
    //GET
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getNumero(){
        return numero;
    }

    public int getEta() {
        return eta;
    }
    // SET
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setEta(int eta) {
        this.eta = eta;
    }
}

