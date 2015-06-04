/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silverspoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author tomaspecuch
 */
public class ListMaker {
    
    private LinkedList<String> list;
    
    public ListMaker(Document doc, int boardNumber) {
        NodeList nodelist =  doc.getDocumentElement().getElementsByTagName("from");
        List<Element> from = new ArrayList<>();
        
        for (int i = 0; i < nodelist.getLength(); i++) {
            from.add((Element) nodelist.item(i));
        }
        
        String unparsedString = from.get(0).getAttribute("uri");
        String parsedString[] = unparsedString.split("://",2);

        String parsedString2[] = parsedString[1].split("\\?",2);

        list = new LinkedList<>();
        list.add(String.valueOf(boardNumber));
        list.add(parsedString2[0]);
        list.add(parsedString[0]);
        
        nodelist =  doc.getDocumentElement().getElementsByTagName("to");
        List<Element> to = new ArrayList<>();
        
        for (int i = 0; i < nodelist.getLength(); i++) {
            to.add((Element) nodelist.item(i));
        }
        
        for (int i=0; i<to.size(); i++) {
             
            unparsedString = to.get(i).getAttribute("uri");
            parsedString = unparsedString.split(":",2);
            list.add(parsedString[0]);
            //System.out.println(parsedString[0]);
        }
    }
    
    public LinkedList<String> getList()
    {
        return this.list;
    }
}
