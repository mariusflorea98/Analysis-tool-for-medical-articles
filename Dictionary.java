/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiectpi2;

import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static proiectpi2.Date.persoane;
import static proiectpi2.DictionaryFactory.mapCuvinte;

/**
 *
 * @author Marius
 */
public class Dictionary {
    
    
    public static void DisplayDictionar(){
    Dictionar();

 String[] linieTitlu = {"Nr","Cuvinte" }; 
	     DefaultTableModel tblModel = new DefaultTableModel(linieTitlu, 0);
	    
           
                                
         for(final Map.Entry<String, Integer> entry : mapCuvinte.entrySet())									//adds data to Jtable
	     tblModel.addRow(new Object[] {
	    		 entry.getValue(),entry.getKey()
	     });
                                
		     
	     JFrame frameTable = new JFrame("Dictionary");				
          
           frameTable.getContentPane().add(new JScrollPane(new JTable(tblModel)));
           frameTable.setSize(500, 250);
           frameTable.setVisible(true);

  
    

}
    
    
    
public static void Dictionar() {
            final DictionaryFactory dictFactory = new DictionaryFactory();
		dictFactory.WordCount(persoane);
				
	}    
    
    
}
