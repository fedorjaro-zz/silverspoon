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
 *
 * @author Michal
 */
class DocParser {

    private File file;
    private Document document = null;
    
    public DocParser(File xmlFile) throws SAXException, ParserConfigurationException, IOException {
        this.file = xmlFile;
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setValidating(false);
        dbFactory.setNamespaceAware(false);
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        dBuilder.setErrorHandler(new SimpleErrorHandler()); 
        document = dBuilder.parse(file);
    }
    
    public DocParser(String xml) throws SAXException, ParserConfigurationException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        builder.parse(is);
    }
    
    /*public static Document loadXMLFromString(String xml) throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        return builder.parse(is);
    }*/
    
    public Document getDocument(){
        return document;
    }
    
    
    public void saveToFile(File file) throws TransformerConfigurationException, TransformerException{
        TransformerFactory tFactory =TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(file);
        transformer.transform(source, result); 
    }
    
    public static void stringToDom(File file, String xmlSource) throws IOException 
    {
        FileWriter fw = new FileWriter(file);
        fw.write(xmlSource);
        fw.close();
    }
    
}
