import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        User user = InputUser.createUser();
        System.out.println(user.toString());

        System.out.println("Vuoi salvare le tue informazioni in un file .XML?  1)si  2)no");
        main.inXML(user);
        
    }
    private int x = 0;

    public void inXML(User user){
        try {
            x++;
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("company");
            document.appendChild(root);

            Element employee = document.createElement("employee");
            root.appendChild(employee);

            // Aggiungere un attributo all'elemento employee
            employee.setAttribute("id", String.valueOf(x));

            // Creare e aggiungere i sotto-elementi a employee
            Element firstName = document.createElement("firstname");
            firstName.appendChild(document.createTextNode(user.getFirstName()));
            employee.appendChild(firstName);

            Element lastName = document.createElement("lastname");
            lastName.appendChild(document.createTextNode(user.getLastName()));
            employee.appendChild(lastName);

            Element email = document.createElement("email");
            email.appendChild(document.createTextNode(user.getEmail()));
            employee.appendChild(email);

            Element age = document.createElement("age");
            age.appendChild(document.createTextNode(String.valueOf(user.getAge())));
            employee.appendChild(age);

            // Creare l'istanza di TransformerFactory
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);

            // Creare il file XML
            StreamResult streamResult = new StreamResult(new File("tommy_manu.xml"));

            // Trasformare il DOM in un file XML
            transformer.transform(domSource, streamResult);

            System.out.println("File XML creato con successo!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

    public static boolean getScelta() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            String ris = in.readLine(); // Leggi una linea di input
            if (ris.equals("1")) { // Confronta la stringa letta con "1"
                return true; // Restituisci true se l'utente ha scelto "1" (si)
            } else {
                return false; // Restituisci false se l'utente ha scelto qualsiasi cosa diversa da "1" (no)
            }
        } catch (IOException e) {
            e.printStackTrace(); // Gestione dell'eccezione di input/output
            return false; // In caso di errore, restituisci false
        }
    }
}
    