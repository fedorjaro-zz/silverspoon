/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package silverspoon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * This class parses documents
 * 
 * @author Michal Hlinka
 */
public class DocParser {

    private File file;
    private Document document = null;
    
    /**
     * Takes XMLFile and parses it onto a document
     * 
     * @param xmlFile XMLFile to be parsed onto a document
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws IOException 
     */
    public DocParser(File xmlFile) throws SAXException, ParserConfigurationException, IOException {
        this.file = xmlFile;
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setValidating(false);
        dbFactory.setNamespaceAware(false);
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        dBuilder.setErrorHandler(new SimpleErrorHandler()); 
        document = dBuilder.parse(file);
    }
    
    /**
     * Takes XML string and parses it onto a document
     * 
     * @param xml XMLstring to be parsed onto a document
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws IOException 
     */
    public DocParser(String xml) throws SAXException, ParserConfigurationException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        builder.parse(is);
    }
    
    /**
     * Returns document
     * 
     * @return document
     */
    public Document getDocument(){
        return document;
    }
    
    /**
     * Saves the current document to a file
     * 
     * @param file File to be saved
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void saveToFile(File file) throws TransformerConfigurationException, TransformerException{
        TransformerFactory tFactory =TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(file);
        transformer.transform(source, result); 
    }
    
    /**
     * Takes xmlSource string and saves it as a file
     * 
     * @param file to be saved with xmlSource parameter as its source
     * @param xmlSource String that will be saved as a file
     * @throws IOException 
     */
    public static void stringToDom(File file, String xmlSource) throws IOException 
    {
        FileWriter fw = new FileWriter(file);
        fw.write(xmlSource);
        fw.close();
    }
    
}
