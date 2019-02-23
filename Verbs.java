/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiectpi2;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static proiectpi2.Date.persoane;
import static proiectpi2.Date.verbe;
import static proiectpi2.Date.verbeFaraTip;
import static proiectpi2.DictionaryFactory.mapCuvinte;

/**
 *
 * @author Marius
 */
public class Verbs {
  
    
    public static void afisareVerbe(){
        String[] linieTitlu = {"Verbe"}; 
       DefaultTableModel tblModel = new DefaultTableModel(linieTitlu, 0);
	    
           
            for(int i=0;i<verbe.size();i++)
	     tblModel.addRow(new Object[] {
                          
                 verbe.get(i)
             });

  JFrame frameTable = new JFrame("Verbe");				
          
           frameTable.getContentPane().add(new JScrollPane(new JTable(tblModel)));
           frameTable.setSize(500, 250);
           frameTable.setVisible(true);
        
        
    }
   
    
    public static void extragereVerbe(){
        final MaxentTagger tagger=new MaxentTagger("C:\\Users\\Marius\\Desktop\\all sorts of pi\\stanford-postagger-2018-10-16\\stanford-postagger-2018-10-16\\models\\english-left3words-distsim.tagger");
      
        for(Map.Entry<String, Integer> entry : mapCuvinte.entrySet())	
        {
            String a= entry.getKey();
        String tagged= tagger.tagString(a);
       
        if(tagged.contains("VBP")||tagged.contains("VBG")||tagged.contains("VB")||tagged.contains("VBD")||tagged.contains("VBN")||tagged.contains("VBZ"))    
        {verbe.add(tagged);
         verbeFaraTip.add(a);
        }  
        
        }
     //  if(verbe.size()!=0)
      //     afisareVerbe();
     
    } 
    
    
}
