/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiectpi2;

import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static proiectpi2.Date.dom;
import static proiectpi2.Date.domeniu;
import static proiectpi2.Date.emailStr;
import static proiectpi2.Date.tara;

public class Email {
      public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    
  public static void DisplayEmail(){
         String[] linieTitlu = {"E-Mail" };
       DefaultTableModel tblModel = new DefaultTableModel(linieTitlu, 0);

            for(int i=0;i<emailStr.size();i++)
	     tblModel.addRow(new Object[] {
                           emailStr.get(i)
             });

           JFrame frameTable = new JFrame("E-Mail");				
           frameTable.getContentPane().add(new JScrollPane(new JTable(tblModel)));
           frameTable.setSize(500, 250);
           frameTable.setVisible(true);
    }    
    
    public static boolean validate(String emailStr) {
       Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
}

   public static void LoadCodesAndCount(){
       for(String s: emailStr){
            StringBuilder sb = new StringBuilder(s);
                              do {
                                sb.deleteCharAt(0);
                          if(sb.charAt(0)=='.'||sb.charAt(0)==';')
                              sb.deleteCharAt(0);
                        
                              }while(sb.charAt(0)!='.'&&sb.length()>2);
                       
                             if(sb.charAt(0)=='d'&&sb.charAt(1)=='u')
                            { 
                                  sb = null;
                                
                            }else
                              if(sb.charAt(0)=='r'&&sb.charAt(1)=='g')
                            {    sb = null;
                                   
                            }else
                             
                              if(sb.charAt(0)=='a'&&sb.charAt(1)=='c')
                            {    sb = null;
                                   
                            }else
                                  
                                    if(sb.charAt(0)=='o'&&sb.charAt(1)=='v')
                            {     sb = null;
                                   
                            }else
                                   if(sb.charAt(0)=='o'&&sb.charAt(1)=='m')
                            {     sb = null;
                                   
                            }
                                 
                             if(sb!=null) 
                              domeniu.add(sb.toString());
      
        }
    wordCount(domeniu);
   }
    
   public static void CodeToCountry() {
      
     for (String countryCode : domeniu) {

		Locale obj = new Locale("", countryCode);

            tara.add(obj.getDisplayCountry());    
            }  
       
 DisplayCountries();
 
    }

    
    
    private static void DisplayCountries() {
      
        String[] linieTitlu = {"Code","Country"}; 
       DefaultTableModel tblModel = new DefaultTableModel(linieTitlu, 0);
	    
           
            for(int i=0;i<domeniu.size();i++)
	     tblModel.addRow(new Object[] {
                          
                 domeniu.get(i),tara.get(i)
             });

  JFrame frameTable = new JFrame("Countries");				
          
           frameTable.getContentPane().add(new JScrollPane(new JTable(tblModel)));
           frameTable.setSize(500, 250);
           frameTable.setVisible(true);
        
        
    }

    
    
   public static void CountryCounter() {
     
        

        for (String countryCode : domeniu) {
Locale obj = new Locale("", countryCode);
	
            tara.add(obj.getDisplayCountry());    
            }
        
        
     String[] linieTitlu = {"NR","Country Code"}; 
       DefaultTableModel tblModel = new DefaultTableModel(linieTitlu, 0);
            
         for(final Map.Entry<String, Integer> entry : dom.entrySet())									
	     tblModel.addRow(new Object[] {
	    		 entry.getValue(),entry.getKey().toString().toUpperCase()
	     });
                                
		     
	     JFrame frameTable = new JFrame("Number of countries extracted from E-Mail");				
          
           frameTable.getContentPane().add(new JScrollPane(new JTable(tblModel)));
           frameTable.setSize(500, 250);
           frameTable.setVisible(true);

           
           
        
    }
    
  
    
    
    
 public static Map<String, Integer> wordCount(Vector<String> strings) {
  
  for (String s:strings) {
     
    if (!dom.containsKey(s)) { 
      dom.put(s, 1);
    }
    else {
      int count = dom.get(s);
      dom.put(s, count + 1);
    }
  }
  return dom;
}      
    
    
    
}
