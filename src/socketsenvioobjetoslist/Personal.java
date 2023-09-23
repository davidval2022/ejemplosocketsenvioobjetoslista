package socketsenvioobjetoslist;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author david
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * 
 */
public class Personal {
    List<Persona> personal = new ArrayList<Persona>();

    public Personal() {
        crearPersonal();
    }
     
    
  public void crearPersonal(){
        Persona juan = new Persona("juan",50);
        Persona juan2 = new Persona("juan",35);
        Persona perico = new Persona("perico",50);
        Persona andres = new Persona("andres",50);
        personal.add(juan);
        personal.add(juan2);
        personal.add(perico);
        personal.add(andres);
      
  }  

    
  public List<Persona> buscar(String word) {
       List<Persona> personas = new ArrayList<Persona>();
       Persona p = new Persona();
       for(int i=0; i<personal.size();i++){
           if(word.equalsIgnoreCase(personal.get(i).getNombre())){
               personas.add(personal.get(i));
           }        
       }

        return personas;
    }
  
    public List<Persona> todo() {
        return personal;
    }
  

  

}