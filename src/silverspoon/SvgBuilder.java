package silverspoon;

import java.awt.*;
import java.net.*;
import java.io.*;
import javax.swing.*;

import com.kitfox.svg.*;
import com.kitfox.svg.app.beans.*;
import java.util.LinkedList;

/**
 * @author Jaroslav, Milan
 */
class IconPanel extends JPanel {

    public static final long serialVersionUID = 0;

    final SVGIcon icon;

    private String config;

    public IconPanel(String c) {
        StringReader reader = new StringReader(c);
        URI uri = SVGCache.getSVGUniverse().loadSVG(reader, "myImage");
        icon = new SVGIcon();
        icon.setSvgURI(uri);

        // FIRST 555 , 354
        // SECOND 640 , 390
        // THIRD 640 , 390
        setPreferredSize(new Dimension(640, 390));
    }

    public void paintComponent(Graphics g) {
        final int width = getWidth();
        final int height = getHeight();

        g.setColor(getBackground());
        g.fillRect(0, 0, width, height);

        icon.paintIcon(this, g, 0, 0);
    }
}

public class SvgBuilder extends javax.swing.JFrame {

    public static final long serialVersionUID = 0;

    IconPanel panel;

    private String PrepareBoard(String config) {
        String result = "";
        int slotX;
        int slotY;
        switch (config) {
            case "1":
                result = "<svg width=\"555\" height=\"354\">\n"
                        + "\n"
                        + "  <rect x=\"0\" y=\"0\" rx=\"20\" ry=\"20\" width=\"544\" height=\"354\"\n"
                        + "  style=\"fill:rgb(0,122,6);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "\n"
                        + "  <rect x=\"46\" y=\"85\" rx=\"0\" ry=\"0\" width=\"380\" height=\"188\"\n"
                        + "  style=\"fill:rgb(51,51,51);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "<circle cx=\"23\" cy=\"23\" r=\"19\" fill=\"rgb(184,177,128)\"/>\n"
                        + "<circle cx=\"23\" cy=\"23\" r=\"8\" fill=\"white\"/>\n"
                        + "\n"
                        + "  <circle cx=\"410\" cy=\"23\" r=\"19\" fill=\"rgb(184,177,128)\"/>\n"
                        + "  <circle cx=\"410\" cy=\"23\" r=\"8\" fill=\"white\"/>\n"
                        + "\n"
                        + "  <circle cx=\"23\" cy=\"331\" r=\"19\" fill=\"rgb(184,177,128)\"/>\n"
                        + "  <circle cx=\"23\" cy=\"331\" r=\"8\" fill=\"white\"/>\n"
                        + "\n"
                        + "  <circle cx=\"410\" cy=\"331\" r=\"19\" fill=\"rgb(184,177,128)\"/>\n"
                        + "  <circle cx=\"410\" cy=\"331\" r=\"8\" fill=\"white\"/>"
                        + "<rect x=\"46\" y=\"85\" width=\"379\" height=\"188\"\n"
                        + "  style=\"fill:rgb(51,51,51);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "\n"
                        + "  <rect x=\"455\" y=\"237\" width=\"100\" height=\"89\"\n"
                        + "  style=\"fill:rgb(176,176,176);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "\n"
                        + "  <rect x=\"455\" y=\"237\" width=\"100\" height=\"83\"\n"
                        + "  style=\"fill:rgb(214,214,214);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "\n"
                        + "  <rect x=\"455\" y=\"243\" rx=\"0\" ry=\"0\" width=\"100\" height=\"77\"\n"
                        + "  style=\"fill:rgb(204,204,204);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "\n"
                        + "  <rect x=\"535\" y=\"258\" width=\"20\" height=\"10\"\n"
                        + "  style=\"fill:rgb(26,26,26);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "\n"
                        + "  <rect x=\"538\" y=\"260\" width=\"20\" height=\"6\"\n"
                        + "  style=\"fill:rgb(229,229,229);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "\n"
                        + "  <rect x=\"535\" y=\"295\" width=\"20\" height=\"10\"\n"
                        + "  style=\"fill:rgb(26,26,26);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "\n"
                        + "  <rect x=\"538\" y=\"297\" width=\"20\" height=\"6\"\n"
                        + "  style=\"fill:rgb(229,229,229);stroke:black;stroke-width:0;opacity:1\"/>"
                        + "<text x=\"455\" y=\"230\" fill=\"white\">ETHERNET</text>\n"
                        + "<text x=\"57\" y=\"52\" fill=\"white\">GPIO</text> \n";
                
                int[] pA = {47, 7, 47, 34, 50, 37, 60, 37, 63, 34, 63, 7, 60, 4, 50, 4, 47, 7};
                slotX = 53;
                slotY = 10;

                for (int k = 0; k < 20; k++) {
                    result += "<polygon points=\"";
                    for (int m = 0; m < 18; m++) {
                        if (m % 2 != 0) {
                            result += pA[m] + " ";
                        } else {
                            result += pA[m] + ",";
                            pA[m] += 17;
                        }
                    }
                    result += "\"\n"
                            + "  style=\"fill:rgb(64,64,64);stroke:purple;stroke-width:0\"/>"
                            + "<rect x=\"" + slotX + "\" y=\"" + slotY + "\" width=\"4\" height=\"4\"\n"
                            + "style=\"fill:rgb(184,177,128);stroke:black;stroke-width:0;opacity:1\"/>"
                            + "<rect x=\"" + slotX + "\" y=\"" + (slotY + 17) + "\" width=\"4\" height=\"4\"\n"
                            + "style=\"fill:rgb(184,177,128);stroke:black;stroke-width:0;opacity:1\"/>";

                    if (k < 19) {

                        result += "<rect x=\"" + (slotX + 10) + "\" y=\"" + (slotY - 3) + "\" width=\"1\" height=\"27\"\n"
                                + "style=\"fill:rgb(0,0,0);stroke:black;stroke-width:0;opacity:1\"/>";
                    }

                    slotX += 17;
                }
                break;
            case "2":
                result = "<svg width=\"640\" height=\"390\">\n"
                        + "\n"
                        + "  <rect x=\"10\" y=\"0\" rx=\"33\" ry=\"33\" width=\"400\" height=\"390\"\n"
                        + "  style=\"fill:rgb(0,0,0);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "  <rect x=\"100\" y=\"0\" rx=\"90\" ry=\"90\" width=\"540\" height=\"390\" \n"
                        + "  style=\"fill:rgb(0,0,0);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "\n"
                        + "  <rect x=\"150\" y=\"91\" width=\"379\" height=\"188\"\n"
                        + "  style=\"fill:rgb(51,51,51);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "\n"
                        + "  <circle cx=\"115\" cy=\"22\" r=\"17\" fill=\"rgb(214,185,49)\"/>\n"
                        + "  <circle cx=\"115\" cy=\"22\" r=\"13\" fill=\"white\"/>\n"
                        + "  <circle cx=\"596\" cy=\"43\" r=\"17\" fill=\"rgb(214,185,49)\"/>\n"
                        + "  <circle cx=\"596\" cy=\"43\" r=\"13\" fill=\"white\"/>\n"
                        + "  <circle cx=\"115\" cy=\"368\" r=\"17\" fill=\"rgb(214,185,49)\"/>\n"
                        + "  <circle cx=\"115\" cy=\"368\" r=\"13\" fill=\"white\"/>\n"
                        + "  <circle cx=\"596\" cy=\"346\" r=\"17\" fill=\"rgb(214,185,49)\"/>\n"
                        + "  <circle cx=\"596\" cy=\"346\" r=\"13\" fill=\"white\"/>\n"
                        + "\n"
                        + "  <rect x=\"145\" y=\"5\" width=\"414\" height=\"36\"\n"
                        + "  style=\"fill:rgb(51,51,51);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "  <rect x=\"145\" y=\"349\" width=\"414\" height=\"36\"\n"
                        + "  style=\"fill:rgb(51,51,51);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "\n"
                        + "  <text x=\"136\" y=\"18\" fill=\"white\">2</text>\n"
                        + "  <text x=\"136\" y=\"39\" fill=\"white\">1</text>\n"
                        + "  <text x=\"561\" y=\"18\" fill=\"white\">46</text>\n"
                        + "  <text x=\"561\" y=\"39\" fill=\"white\">45</text>\n"
                        + "  <text x=\"136\" y=\"362\" fill=\"white\">2</text>\n"
                        + "  <text x=\"136\" y=\"383\" fill=\"white\">1</text>\n"
                        + "  <text x=\"561\" y=\"362\" fill=\"white\">46</text>\n"
                        + "  <text x=\"561\" y=\"383\" fill=\"white\">45</text>\n"
                        + "\n"
                        + "  <rect x=\"551\" y=\"230\" width=\"89\" height=\"88\"\n"
                        + "  style=\"fill:rgb(176,176,176);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "\n"
                        + "  <rect x=\"0\" y=\"120\" width=\"128\" height=\"112\"\n"
                        + "  style=\"fill:rgb(176,176,176);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "\n"
                        + "  <rect x=\"0\" y=\"283\" width=\"98\" height=\"63\"\n"
                        + "  style=\"fill:rgb(84,84,84);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "  <rect x=\"0\" y=\"283\" width=\"11\" height=\"63\"\n"
                        + "  style=\"fill:rgb(51,51,51);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "  <rect x=\"3\" y=\"283\" width=\"5\" height=\"63\"\n"
                        + "  style=\"fill:rgb(0,0,0);stroke:black;stroke-width:0;opacity:1\"/>"
                        + "<polygon points=\"600,238 633,244 633,262 600,268 600,264 624,256 624,251 600,242\"     \n"
                        + "  style=\"fill:rgb(220,220,220);stroke:purple;stroke-width:0\"/>\n"
                        + "<polygon points=\"600,281 633,287 633,305 600,311 600,307 624,299 624,294 600,285\"     \n"
                        + "  style=\"fill:rgb(220,220,220);stroke:purple;stroke-width:0\"/>"
                        + "<text x=\"143\" y=\"52\" style=\"fill:rgb(51,51,51)\">P8</text>"
                        + "<text x=\"143\" y=\"346\" style=\"fill:rgb(51,51,51)\">P9</text>";

                slotX = 148;
                slotY = 8;

                // KARTRIDZ BOARD 2
                for (int r = 0; r < 2; r++) {
                    for (int s = 0; s < 23; s++) {
                        result += "<rect x=\"" + slotX + "\" y=\"" + slotY + "\" width=\"12\" height=\"12\"\n"
                                + "style=\"fill:rgb(0,0,0);stroke:black;stroke-width:0;opacity:1\"/>\n"
                                + "<rect x=\"" + (slotX + 9) + "\" y=\"" + slotY + "\" width=\"3\" height=\"12\"\n"
                                + "style=\"fill:rgb(81,81,81);stroke:black;stroke-width:0;opacity:1\"/>\n"
                                + "<rect x=\"" + slotX + "\" y=\"" + slotY + "\" width=\"12\" height=\"3\"\n"
                                + "style=\"fill:rgb(30,30,30);stroke:black;stroke-width:0;opacity:1\"/>\n"
                                + "<rect x=\"" + slotX + "\" y=\"" + (slotY + 9) + "\" width=\"12\" height=\"3\"\n"
                                + "style=\"fill:rgb(81,81,81);stroke:black;stroke-width:0;opacity:1\"/>\n"
                                + "<rect x=\"" + slotX + "\" y=\"" + slotY + "\" width=\"3\" height=\"12\"\n"
                                + "style=\"fill:rgb(30,30,30);stroke:black;stroke-width:0;opacity:1\"/>\n"
                                + "<rect x=\"" + slotX + "\" y=\"" + (slotY + 344) + "\" width=\"12\" height=\"12\"\n"
                                + "style=\"fill:rgb(0,0,0);stroke:black;stroke-width:0;opacity:1\"/>\n"
                                + "<rect x=\"" + (slotX + 9) + "\" y=\"" + (slotY + 344) + "\" width=\"3\" height=\"12\"\n"
                                + "style=\"fill:rgb(81,81,81);stroke:black;stroke-width:0;opacity:1\"/>\n"
                                + "<rect x=\"" + slotX + "\" y=\"" + (slotY + 344) + "\" width=\"12\" height=\"3\"\n"
                                + "style=\"fill:rgb(30,30,30);stroke:black;stroke-width:0;opacity:1\"/>\n"
                                + "<rect x=\"" + slotX + "\" y=\"" + (slotY + 9 + 344) + "\" width=\"12\" height=\"3\"\n"
                                + "style=\"fill:rgb(81,81,81);stroke:black;stroke-width:0;opacity:1\"/>\n"
                                + "<rect x=\"" + slotX + "\" y=\"" + (slotY + 344) + "\" width=\"3\" height=\"12\"\n"
                                + "style=\"fill:rgb(30,30,30);stroke:black;stroke-width:0;opacity:1\"/>\n";

                        slotX += 18;
                    }

                    slotX = 148;
                    slotY += 18;
                }

                // SVIETIACICH 6x
                slotX = 309;

                for (int s = 0; s < 6; s++) {
                    result += "<rect x=\"" + slotX + "\" y=\"333\" width=\"14\" height=\"14\"\n"
                            + "style=\"fill:rgb(51,51,51);stroke:black;stroke-width:0;opacity:1\"/>\n"
                            + "<rect x=\"" + (slotX + 4) + "\" y=\"337\" width=\"6\" height=\"6\"\n"
                            + "style=\"fill:rgb(255,221,93);stroke:black;stroke-width:0;opacity:1\"/>\n";
                    slotX += 18;
                }
                break;
            case "3":
                result = "<svg width=\"640\" height=\"390\">\n"
                        + "\n"
                        + "  <rect x=\"3\" y=\"0\" rx=\"7\" ry=\"7\" width=\"300\" height=\"387\"\n"
                        + "  style=\"fill:rgb(0,0,0);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "  <rect x=\"150\" y=\"0\" rx=\"7\" ry=\"7\" width=\"476\" height=\"387\"\n"
                        + "  style=\"fill:rgb(0,0,0);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "\n"
                        + "  <rect x=\"120\" y=\"82\" width=\"379\" height=\"188\"\n"
                        + "  style=\"fill:rgb(51,51,51);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "\n"
                        + "  <circle cx=\"141\" cy=\"22\" r=\"20\" fill=\"rgb(158,182,148)\"/>\n"
                        + "  <circle cx=\"141\" cy=\"22\" r=\"16\" fill=\"black\"/>\n"
                        + "  <circle cx=\"141\" cy=\"22\" r=\"15\" fill=\"rgb(214,185,49)\"/>\n"
                        + "  <circle cx=\"141\" cy=\"22\" r=\"9\" fill=\"white\"/>\n"
                        + "\n"
                        + "  <circle cx=\"604\" cy=\"22\" r=\"20\" fill=\"rgb(158,182,148)\"/>\n"
                        + "  <circle cx=\"604\" cy=\"22\" r=\"16\" fill=\"black\"/>\n"
                        + "  <circle cx=\"604\" cy=\"22\" r=\"15\" fill=\"rgb(214,185,49)\"/>\n"
                        + "  <circle cx=\"604\" cy=\"22\" r=\"9\" fill=\"white\"/>\n"
                        + "\n"
                        + "  <circle cx=\"141\" cy=\"365\" r=\"20\" fill=\"rgb(158,182,148)\"/>\n"
                        + "  <circle cx=\"141\" cy=\"365\" r=\"16\" fill=\"black\"/>\n"
                        + "  <circle cx=\"141\" cy=\"365\" r=\"15\" fill=\"rgb(214,185,49)\"/>\n"
                        + "  <circle cx=\"141\" cy=\"365\" r=\"9\" fill=\"white\"/>\n"
                        + "\n"
                        + "  <circle cx=\"604\" cy=\"365\" r=\"20\" fill=\"rgb(158,182,148)\"/>\n"
                        + "  <circle cx=\"604\" cy=\"365\" r=\"16\" fill=\"black\"/>\n"
                        + "  <circle cx=\"604\" cy=\"365\" r=\"15\" fill=\"rgb(214,185,49)\"/>\n"
                        + "  <circle cx=\"604\" cy=\"365\" r=\"9\" fill=\"white\"/>\n"
                        + "\n"
                        + "  <rect x=\"265\" y=\"5\" width=\"317\" height=\"36\"\n"
                        + "  style=\"fill:rgb(51,51,51);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "\n"
                        + "  <rect x=\"164\" y=\"5\" width=\"98\" height=\"36\"\n"
                        + "  style=\"fill:rgb(30,30,30);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "  <text x=\"177\" y=\"52\" fill=\"white\">SATA DATA</text>\n"
                        + "\n"
                        + "  <rect x=\"265\" y=\"346\" width=\"317\" height=\"36\"\n"
                        + "  style=\"fill:rgb(51,51,51);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "\n"
                        + "  <text x=\"265\" y=\"46\" fill=\"white\">1</text>\n"
                        + "  <text x=\"320\" y=\"46\" fill=\"white\">11</text>\n"
                        + "  <text x=\"385\" y=\"46\" fill=\"white\">21</text>\n"
                        + "  <text x=\"450\" y=\"46\" fill=\"white\">31</text>\n"
                        + "  <text x=\"515\" y=\"46\" fill=\"white\">41</text>\n"
                        + "\n"
                        + "  <rect x=\"174\" y=\"297\" width=\"82\" height=\"93\"\n"
                        + "  style=\"fill:rgb(176,176,176);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "  <text x=\"182\" y=\"294\" fill=\"white\">USB2 USB1</text>\n"
                        + "\n"
                        + "  <rect x=\"0\" y=\"15\" width=\"70\" height=\"42\"\n"
                        + "  style=\"fill:rgb(30,30,30);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "  <rect x=\"15\" y=\"15\" width=\"18\" height=\"42\"\n"
                        + "  style=\"fill:rgb(140,140,140);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "  <text x=\"14\" y=\"68\" fill=\"white\">POWER</text>\n"
                        + "\n"
                        + "  <rect x=\"29\" y=\"297\" width=\"86\" height=\"86\"\n"
                        + "  style=\"fill:rgb(176,176,176);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "  <text x=\"34\" y=\"294\" fill=\"white\">DATA CARD</text>\n"
                        + "\n"
                        + "  <rect x=\"525\" y=\"230\" width=\"115\" height=\"97\"\n"
                        + "  style=\"fill:rgb(176,176,176);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "  <text x=\"528\" y=\"227\" fill=\"white\">ETHERNET</text> \n"
                        + "\n"
                        + "  <text x=\"295\" y=\"351\" fill=\"white\">41</text>\n"
                        + "  <text x=\"360\" y=\"351\" fill=\"white\">31</text>\n"
                        + "  <text x=\"425\" y=\"351\" fill=\"white\">21</text>\n"
                        + "  <text x=\"490\" y=\"351\" fill=\"white\">11</text>\n"
                        + "  <text x=\"563\" y=\"351\" fill=\"white\">1</text>"
                        + "  <rect x=\"68\" y=\"154\" width=\"15\" height=\"109\"\n"
                        + "  style=\"fill:rgb(60,60,60);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "  <rect x=\"0\" y=\"156\" width=\"70\" height=\"105\"\n"
                        + "  style=\"fill:rgb(176,176,176);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "  <rect x=\"70\" y=\"169\" width=\"20\" height=\"80\"\n"
                        + "  style=\"fill:rgb(190,190,190);stroke:black;stroke-width:0;opacity:1\"/>"
                        + "  <rect x=\"600\" y=\"255\" width=\"40\" height=\"14\"\n"
                        + "  style=\"fill:rgb(26,26,26);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "  <rect x=\"605\" y=\"258\" width=\"36\" height=\"8\"\n"
                        + "  style=\"fill:rgb(229,229,229);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "\n"
                        + "  <rect x=\"600\" y=\"288\" width=\"40\" height=\"14\"\n"
                        + "  style=\"fill:rgb(26,26,26);stroke:black;stroke-width:0;opacity:1\"/>\n"
                        + "  <rect x=\"605\" y=\"291\" width=\"36\" height=\"8\"\n"
                        + "  style=\"fill:rgb(229,229,229);stroke:black;stroke-width:0;opacity:1\"/>"
                        + "  <rect x=\"580\" y=\"170\" width=\"53\" height=\"45\"\n"
                        + "  style=\"fill:rgb(176,176,176);stroke:black;stroke-width:0;opacity:1\"/>"
                        + "  <rect x=\"557\" y=\"101\" width=\"80\" height=\"33\"\n"
                        + "  style=\"fill:rgb(30,30,30);stroke:black;stroke-width:0;opacity:1\"/>"
                        + "<text x=\"537\" y=\"122\" fill=\"white\">HP</text>"
                        + "<polygon points=\"186,354 186,387 206,387 206,354 202,354 202,380 190,380 190,354\" style=\"fill:rgb(230,230,230);stroke:purple;stroke-width:0\"/>\n"
                        + "\n"
                        + "<polygon points=\"224,354 224,387 244,387 244,354 240,354 240,380 229,380 229,354\" style=\"fill:rgb(230,230,230);stroke:purple;stroke-width:0\"/>";

                // PORTY DOSKA 3        
                slotX = 274;
                slotY = 16;

                for (int r = 0; r < 2; r++) {
                    for (int v = 0; v < 24; v++) {
                        result += "<circle cx=\"" + slotX + "\" cy=\"" + slotY + "\" r=\"4\" fill=\"rgb(0,0,0)\"/>\n"
                                + "<circle cx=\"" + slotX + "\" cy=\"" + slotY + "\" r=\"1\" fill=\"rgb(213,186,23)\"/>\n"
                                + "<circle cx=\"" + slotX + "\" cy=\"" + (slotY + 341) + "\" r=\"4\" fill=\"rgb(0,0,0)\"/>\n"
                                + "<circle cx=\"" + slotX + "\" cy=\"" + (slotY + 341) + "\" r=\"1\" fill=\"rgb(213,186,23)\"/>\n";
                        slotX += 13;
                    }
                    slotX = 274;
                    slotY += 14;
                }
                break;
        }
        return result;
    }

    private String PrepareSvg(LinkedList<String> config) {
        String result;
        result = PrepareBoard(config.pop());
        
         // KRABICKY
         int NumberOfBoxes = config.size();
         NumberOfBoxes--;
         int rows = (NumberOfBoxes / 4) + (NumberOfBoxes % 4 == 0 ? 0 : 1);
        
         int x = 65;
         int y = 0;
         switch(rows) {
         case 1: 
         y = 160;
         break;
         case 2: 
         y = 130;
         result += "<line x1=\"400\" y1=\"150\" x2=\"417\" y2=\"150\" style=\"stroke:rgb(255,255,255); \n" 
         + "  stroke-width:2\"/>"
         + "<line x1=\"417\" y1=\"150\" x2=\"417\" y2=\"180\" style=\"stroke:rgb(255,255,255); \n" 
         + "  stroke-width:2\"/>"
         + "<line x1=\"417\" y1=\"180\" x2=\"53\" y2=\"180\" style=\"stroke:rgb(255,255,255); \n" 
         + "  stroke-width:2\"/>" 
         + "<line x1=\"53\" y1=\"180\" x2=\"53\" y2=\"210\" style=\"stroke:rgb(255,255,255); \n" 
         + "  stroke-width:2\"/>"
         + "<line x1=\"53\" y1=\"210\" x2=\"73\" y2=\"210\" style=\"stroke:rgb(255,255,255); \n" 
         + "  stroke-width:2\"/>";
         break;
         case 3:
         y = 100;
         result += "<line x1=\"400\" y1=\"120\" x2=\"417\" y2=\"120\" style=\"stroke:rgb(255,255,255); \n" 
         + "  stroke-width:2\"/>"
         + "<line x1=\"417\" y1=\"120\" x2=\"417\" y2=\"150\" style=\"stroke:rgb(255,255,255); \n" 
         + "  stroke-width:2\"/>"
         + "<line x1=\"417\" y1=\"150\" x2=\"53\" y2=\"150\" style=\"stroke:rgb(255,255,255); \n" 
         + "  stroke-width:2\"/>" 
         + "<line x1=\"53\" y1=\"150\" x2=\"53\" y2=\"180\" style=\"stroke:rgb(255,255,255); \n" 
         + "  stroke-width:2\"/>"
         + "<line x1=\"53\" y1=\"180\" x2=\"73\" y2=\"180\" style=\"stroke:rgb(255,255,255); \n" 
         + "  stroke-width:2\"/>";
                
         result += "<line x1=\"400\" y1=\"180\" x2=\"417\" y2=\"180\" style=\"stroke:rgb(255,255,255); \n" 
         + "  stroke-width:2\"/>"
         + "<line x1=\"417\" y1=\"180\" x2=\"417\" y2=\"210\" style=\"stroke:rgb(255,255,255); \n" 
         + "  stroke-width:2\"/>"
         + "<line x1=\"417\" y1=\"210\" x2=\"53\" y2=\"210\" style=\"stroke:rgb(255,255,255); \n" 
         + "  stroke-width:2\"/>" 
         + "<line x1=\"53\" y1=\"210\" x2=\"53\" y2=\"240\" style=\"stroke:rgb(255,255,255); \n" 
         + "  stroke-width:2\"/>"
         + "<line x1=\"53\" y1=\"240\" x2=\"73\" y2=\"240\" style=\"stroke:rgb(255,255,255); \n" 
         + "  stroke-width:2\"/>";
         break;
         }
         switch(NumberOfBoxes) {
         case 1: x = 200;break;
         case 2: x = 160;break;
         case 3: x = 110;break;
         }
        
         result += "<text fill=\"white\" x=\"" + (80) + "\" y=\"" + (27) + "\">" + config.pop() + "</text>";
        
         int counter = 1;
        
         result += "<g fill=\"white\" stroke=\"white\" stroke-width=\"2\">\n" 
         + "    <path stroke-dasharray=\"5,5\" d=\"M97 42" 
         + " " + (x+35) + " " + (y) + "\"/>\n" 
         + "  </g>";
        
         for (int j = 0; j < rows; j++) {
         for (int i = 0; i < 4; i++) {
         if (counter > NumberOfBoxes)
         break;
         counter++;
                
         result += "<rect x=\"" + x + "\" y=\"" + y + "\" rx=\"0\" ry=\"0\" width=\"70\" height=\"40\"\n"
         + "style=\"fill:rgb(255,255,255);stroke:black;stroke-width:0;opacity:1\"/>\n";

         if ((NumberOfBoxes > 1) && (i < 3) && (counter <= NumberOfBoxes)) {
         result += "<line x1=\"" + (x+70) + "\" y1=\"" + (y+20) + "\" x2=\"" 
         + (x+90) + "\" y2=\"" + (y+20) + "\" style=\"stroke:rgb(255,255,255); \n" 
         + "  stroke-width:2\"/>";
         }
                
         if (counter == NumberOfBoxes + 1) {
         result += "<g fill=\"white\" stroke=\"white\" stroke-width=\"2\">\n" 
         + "    <path stroke-dasharray=\"5,5\" d=\"M" + (x+70) + " " + (y+20) 
         + " " + "455 280\"/>\n"
         + "  </g>";
         }

         result += "<text x=\"" + (x + 15) + "\" y=\"" + (y + 23) + "\">" + config.pop() + "</text>";

         x += 90;

         }
         x = 65;
         y += 60;
         }
        result += "</svg>";
        return result;
    }

    /**
     * Creates new form SVGIconDemo
     *
     * @param Config
     */
    public SvgBuilder(LinkedList<String> config) {
        panel = new IconPanel(PrepareSvg(config));

        initComponents();

        this.getContentPane().add(panel, BorderLayout.CENTER);

        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }

    public static void main(String args[]) {
        final LinkedList<String> list = new LinkedList<>();
        list.add("2");
        list.add("PH7");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SvgBuilder(list).setVisible(true);
            }
        });
    }

}
