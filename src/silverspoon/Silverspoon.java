/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silverspoon;

import java.io.File;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


/**
 *
 * @author fedorjaro
 */
public class Silverspoon {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        JaxpParser jp = new JaxpParser(new File("src/silverspoon/config.xml"));
        Document doc = jp.getDocument();

        jp.saveToFile(new File("src/silverspoon/config.xml"));

    }
        
}
