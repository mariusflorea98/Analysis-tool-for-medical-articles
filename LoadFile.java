/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiectpi2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import static proiectpi2.Date.emailStr;
import static proiectpi2.Date.persoane;
import static proiectpi2.Date.sPath;
import static proiectpi2.Date.verbe;
import static proiectpi2.MainThing.jButton2;
import static proiectpi2.MainThing.jButton3;
import static proiectpi2.MainThing.jButton4;
import static proiectpi2.MainThing.jButton5;
import static proiectpi2.MainThing.jButton6;
import static proiectpi2.MainThing.jButton7;
import static proiectpi2.MainThing.jButton9;



import static proiectpi2.MainThing.jLabel2;

import static proiectpi2.MainThing.jTable1;


/**
 *
 * @author Marius
 */
public class LoadFile {
 
    
    public static void LoadFile(){
     JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	 FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "CSV Files", "csv");	
       jfc.setFileFilter(filter);
       int returnValue = jfc.showOpenDialog(null);					
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
                        sPath=(selectedFile.getAbsolutePath());
                    
                              
                }
        
        System.out.println(sPath);
       
        
        
        if(sPath!=null)
        { 
         ReadFile();
         
        
         TableDisplay();
         Email.LoadCodesAndCount();
         Dictionary.Dictionar();
        
         
       
         jButton2.setEnabled(true);
         jButton3.setEnabled(true);
         jButton4.setEnabled(true);
         jButton5.setEnabled(true);
         jButton6.setEnabled(true);
         jButton7.setEnabled(true); 
         jButton9.setEnabled(true);
         
         Verbs.extragereVerbe(); 
         StemmerTest.AllStems();
    
    }
  } 
    
    
    
   
    
    public static void ReadFile(){
          try (final Reader in = new FileReader(sPath)) {
		jLabel2.setText("Loading...");
           
                    final Iterable<CSVRecord> records = CSVFormat
					.RFC4180
					.withFirstRecordAsHeader()
					
					.parse(in);
			
			
			for (final CSVRecord record : records) {
				
			    String sEMail = record.get("eMail");
			    	if(sEMail==""||sEMail.isEmpty())
			    		sEMail="-";
			    final String sAutori = record.get("Autori");
			    final String sTitle = record.get("Title");
                            String sAfiliere=record.get("Affiliation");
                            if(sAfiliere==""||sAfiliere.isEmpty())
			    		sAfiliere="-";
                            
			    persoane.add(new Persoana(sEMail,sAutori,sTitle,sAfiliere));				
			  if(Email.validate(sEMail)==true){
                              StringBuilder sb = new StringBuilder(sEMail);
                              do {
                                  sb.deleteCharAt(0);
                          
                              }while(sb.charAt(0)!='@');
                              sb.deleteCharAt(0);
                         
                              
                              if(emailStr.contains(sb.toString())==false)
                              emailStr.add(sb.toString());
                          }
                          
          
                          
                          
			}
			
	 
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        
    }    
    
    
   public static void TableDisplay(){
       
       jLabel2.setText("Loaded!");
          String[] linieTitlu = {"Autori", "Titlu","Email","Afiliere" }; 
       DefaultTableModel tblModel = new DefaultTableModel(linieTitlu, 0);
	    jTable1.setModel(tblModel);
	     for(Persoana p: persoane)									
	     tblModel.addRow(new Object[] {
	    		 p.getAutori(),p.getTitlu(), p.getEmail(), p.getAfiliere()
	     });
		     
	 
          
          jTable1.add(new JScrollPane(new JTable(tblModel)));
            jTable1.setSize(1000, 500);
            jTable1.setVisible(true);
        
   } 
    
    
    
}
