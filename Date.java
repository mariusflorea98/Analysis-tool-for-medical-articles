/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiectpi2;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author Marius
 */
public class Date {
    public static String sPath="";
    public static Vector<Persoana> persoane=new Vector<Persoana>();
     public static Vector<String> emailStr=new Vector<String>();
     public static Vector<String> domeniu=new Vector<String>();
      public static Vector<String> tara=new Vector<String>();                      
     public static Map<String, Integer> dom = new HashMap<String, Integer> ();     //domenii si count
       public static Vector<String> verbe=new Vector<String>();                     // verbele cu terminatie reprenzentand tipul lor

       public static Vector<String> stems=new Vector<String>();                     //radacina
      
       public static Vector<String> verbeFaraTip=new Vector<String>();              // doar verbele

    
}
