import java.io.File;
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
        Person person = new Person("Mario", 30, "Informazioni extra");

        System.out.println("Nome: " + person.getNome());
        System.out.println("Età: " + person.getAge());  
        System.out.println("Info: " + person.getInfo());

        new Main().inXML(person);
    }

    public void inXML(Person person) {
        try {
            // PREPARAZIONE{
            // Creare una fabbrica di costruttori di documenti
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            // Creare un costruttore di documenti
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            // Definire un nuovo documento
            Document document = documentBuilder.newDocument();
            // }

            // Creare l'elemento radice
            Element root = document.createElement("person");
            document.appendChild(root);

            // Aggiungere nome
            Element nameElement = document.createElement("name");
            nameElement.appendChild(document.createTextNode(person.getNome()));
            root.appendChild(nameElement);

            // Aggiungere età
            Element ageElement = document.createElement("age");
            ageElement.appendChild(document.createTextNode(String.valueOf(person.getAge())));
            root.appendChild(ageElement);

            // Aggiungere informazioni
            Element infoElement = document.createElement("info");
            infoElement.appendChild(document.createTextNode(person.getInfo()));
            root.appendChild(infoElement);

            // Creare l'istanza di TransformerFactory
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);

            // Creare il file XML
            StreamResult streamResult = new StreamResult(new File("person.xml"));

            // Trasformare il DOM in un file XML
            transformer.transform(domSource, streamResult);

            System.out.println("File XML creato con successo!");

        } catch (ParserConfigurationException | TransformerException pce) {
            pce.printStackTrace();
        }
    }
}
