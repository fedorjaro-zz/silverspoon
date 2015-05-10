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

        setPreferredSize(new Dimension(555, 354));
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

    private String PrepareSvg(LinkedList<String> config) {
        String result;
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
                + "\n"
                + "  <polygon points=\"46,9 46,37 51,42 58,42 63,37 63,9 58,4 51,4 46,9\"\n"
                + "  style=\"fill:rgb(51,51,51);stroke:purple;stroke-width:0\"/>"
                + "\n";
        
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

        int[] pA = {46, 9, 46, 37, 51, 42, 58, 42, 63, 37, 63, 9, 58, 4, 51, 4, 46, 9};

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
                   + "  style=\"fill:rgb(51,51,51);stroke:purple;stroke-width:0\"/>";
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

       
                java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SvgBuilder(list).setVisible(true);
            }
        });
    }

}
