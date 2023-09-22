package socketsenvioobjetoslist;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Usuari
 */
//import main.java.ioc.dam.m9.uf3.eac2.b2.*;
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
public class SoftCatalaClient {

 
  public Persona translate(String word) {
        Persona juan = new Persona("juan",50);
        Persona perico = new Persona("perico",50);
        Persona andres = new Persona("adnres",50);

        if(word.equalsIgnoreCase("juan")){
            return juan;
        }else if(word.equalsIgnoreCase("perico")){
            return perico;
        }else if(word.equalsIgnoreCase("andres")){
            return andres;
        }
        return null;
    }
  

  

}