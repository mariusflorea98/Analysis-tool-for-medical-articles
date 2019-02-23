package proiectpi2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Map;
import static proiectpi2.Date.dom;
 
public class BarChart extends JPanel {
 
  private static int[] values=new int[7];
  private static String[] labels=new String[dom.keySet().size()];  
  private static Color[] colors;
  private static String title;
  public static int ok=0;
  
  public BarChart(int[] values, String[] labels, Color[] colors, String title) {
    this.labels = labels;
    this.values = values;
    this.colors = colors;
    this.title = title;
  }
 
  public  void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (values == null || values.length == 0) {
      return;
    }
 
    int minValue = 0;
    int maxValue = 0;
    for (int i = 0; i < values.length; i++) {
      if (minValue > values[i]) {
        minValue = values[i];
      }
      if (maxValue < values[i]) {
        maxValue = values[i];
      }
    }
 
    Dimension dim = getSize();
    int panelWidth = dim.width;
    int panelHeight = dim.height;
    int barWidth = panelWidth / values.length;
 
    Font titleFont = new Font("Book Antiqua", Font.BOLD, 15);
    FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
 
    Font labelFont = new Font("Book Antiqua", Font.PLAIN, 14);
    FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);
 
    int titleWidth = titleFontMetrics.stringWidth(title);
    int stringHeight = titleFontMetrics.getAscent();
    int stringWidth = (panelWidth - titleWidth) / 2;
    g.setFont(titleFont);
    g.drawString(title, stringWidth, stringHeight);
 
    int top = titleFontMetrics.getHeight();
    int bottom = labelFontMetrics.getHeight();
    if (maxValue == minValue) {
      return;
    }
    int scale = (panelHeight - top - bottom) / (maxValue - minValue);
    stringHeight = panelHeight - labelFontMetrics.getDescent();
    g.setFont(labelFont);
    for (int j = 0; j < values.length; j++) {
      int valueP = j * barWidth + 1;
      int valueQ = top;
      int height = (int) (values[j] * scale);
      if (values[j] >= 0) {
        valueQ += (int) ((maxValue - values[j]) * scale);
      } else {
        valueQ += (int) (maxValue * scale);
        height = -height;
      }
 
      g.setColor(colors[j]);
      g.fillRect(valueP, valueQ, barWidth - 2, height);
      g.setColor(Color.black);
      g.drawRect(valueP, valueQ, barWidth - 2, height);
 
      int labelWidth = labelFontMetrics.stringWidth(labels[j]);
      stringWidth = j * barWidth + (barWidth - labelWidth) / 2;
      g.drawString(labels[j], stringWidth, stringHeight);
    }
  }

  
  public static void DisplayGraph(){

 JFrame Graph=new JFrame("Graphic");
   Graph.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Bar Chart Example");
     
    frame.setSize(350, 300);
 
    String title = "Nr of published books / country";
    
   if(ok==0){
     labels=new String[dom.keySet().size()];  
   
      
    int[] val=new int[dom.values().size()];
    int i=0;
   String du="du",rg="rg",ac="ac",ov="ov",om="om";
      for( Map.Entry<String, Integer> entry : dom.entrySet())									
      { 
         if(entry.getKey().equals(du)==false)
             if(entry.getKey().equals(rg)==false)
                 if(entry.getKey().equals(ac)==false)
                   if(entry.getKey().equals(ov)==false)
                        if(entry.getKey().equals(om)==false)
                            { val[i]=entry.getValue();
                              labels[i]=entry.getKey().toUpperCase()+"("+entry.getValue()+")";
                            }        
          i++;
        
      }
     int aux;
     String tmp;
     
     
      for( i=0;i<val.length;i++)
          for(int j=0;j<val.length-i-1;j++)
              if(val[j]<val[j+1])
              {aux=val[j];
              val[j]=val[j+1];
              val[j+1]=aux;
              
              tmp=labels[j];
              labels[j]=labels[j+1];
              labels[j+1]=tmp;
              
              
              }
   
      for(i=0;i<7;i++)
      { 
          values[i]=val[i]; 
         
      } 
      
      ok=1;    //already loaded
   }
   
   
    Color[] colors = new Color[]{
        Color.red,
        Color.orange,
        Color.yellow,
        Color.green,
        Color.blue,
        Color.CYAN,
        Color.BLACK
       
    };
    
    BarChart bc = new BarChart(values, labels, colors, title);
 
    frame.add(bc);
    frame.setVisible(true);        
    }//GEN-LAST:event_jButton6ActionPerformed

    
  
  
  
  }
  
  
  
 