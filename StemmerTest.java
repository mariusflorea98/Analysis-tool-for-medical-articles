/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiectpi2;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.tartarus.snowball.ext.PorterStemmer;
import static proiectpi2.Date.domeniu;
import static proiectpi2.Date.stems;
import static proiectpi2.Date.verbe;
import static proiectpi2.Date.verbeFaraTip;

/**
 *
 * @author Marius
 */
public class StemmerTest {
    
      public static void StemGetter(String word){
        PorterStemmer porterStemmer = new PorterStemmer();
        porterStemmer.setCurrent(word);
	porterStemmer.stem();
	  stems.add(porterStemmer.getCurrent());

      }
    
      
 public static void StemsDisplay(){
      String[] linieTitlu = {"Word","Stem"}; 
       DefaultTableModel tblModel = new DefaultTableModel(linieTitlu, 0);
	    
           
            for(int i=0;i<domeniu.size();i++)
	     tblModel.addRow(new Object[] {
                          
                verbeFaraTip.get(i),stems.get(i)
             });

  JFrame frameTable = new JFrame("Stems");				
          
           frameTable.getContentPane().add(new JScrollPane(new JTable(tblModel)));
           frameTable.setSize(500, 250);
           frameTable.setVisible(true);
 }     
      
 public static void AllStems(){
 for(int i=0;i<verbeFaraTip.size();i++)
     StemGetter(verbeFaraTip.get(i));
 
 }
 
 
}
