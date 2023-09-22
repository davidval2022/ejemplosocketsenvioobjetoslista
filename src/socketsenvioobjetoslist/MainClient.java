/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsenvioobjetoslist;

/**
 *
 * @author tomas
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainClient {
    public static void main(String[] args) throws ClassNotFoundException {
        boolean salir = false;
        try {
            //IMPLEMENTA
            Socket socket = new Socket("localhost", 8888);
            Scanner lectorPalabra = new Scanner(System.in);
            BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));//flujo lectura del server
            BufferedWriter escriptor = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//flujo envio al server
            
            //nuevo
            //Flujo de entrada para objetos
            //ObjectInputStream perEnt = new ObjectInputStream(socket2.getInputStream());
            //ObjectInputStream perEnt;
            while(!salir){
                ///Llegeix del servidor el mensaje de bienvenida, y la pregunta que nos hace ///           
                
                String mensajeServer = lector.readLine();           
                System.out.println(mensajeServer);
                ///**escriu al servidor**///
                //primero leemos la palabra a buscar del teclado y luego la enviamos
                //llegeix del teclat
                //System.out.println("Escribe la palabra a traducir: ");
                String palabra = lectorPalabra.next();
                lectorPalabra.nextLine();
                //ahora escribimos en servidor , enviandole la palabra a buscar 
               
                escriptor.write(palabra);
                escriptor.newLine();
                escriptor.flush();
                if(palabra.equalsIgnoreCase("exit")){ 
                    salir = true;
                    lector.close();
                    escriptor.close();
                    socket.close();
                                      
                }else{
                    //recibimos la respuesta
                    //ensajeServer = lector.readLine(); 
                    //String mensajeFormateado = formatearMensaje(mensajeServer);//formateamos el mensaje para no verlo en una sola linea
                    //System.out.println("\nTraduccion requerida:");
                    //System.out.println(mensajeFormateado.trim()+"\n");  
                                //Se recibe un objeto
                    //lector.close();
                    List<Persona> listaPersonas = new ArrayList<>();
                    ObjectInputStream perEnt = new ObjectInputStream(socket.getInputStream());
                    //Persona dato = (Persona) perEnt.readObject();
                    listaPersonas = (ArrayList) perEnt.readObject();;
                    //recibo objeto
                    for(int i =0; i< listaPersonas.size();i++){
                        System.out.println("Nombre: " + listaPersonas.get(i).getNombre() + " Edad: " + listaPersonas.get(i).getEdad());                   
 
                    }
                    
                    
                                       
                }
           
            }
            socket.close();

            
        } catch (UnknownHostException ex) {
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //creo este metodo para formatear la frase y que no esté en una sola linea
    public static String formatearMensaje(String mensaje) {
        /*ej de frase:
        "Català: poma - fruit del tipus pom de la pomera Espanyol: manzana - fruto comestible del manzano ...etc
        y la idea es que la frase quede así, con uns salto de linea por frase:
        Català: poma - fruit del tipus pom de la pomera
        Espanyol: manzana - fruto comestible del manzano
        ..etc
        */
        String m = "";//cadena de retorno
        String[] cadena = mensaje.split(":");//creo el array con la division
        String inicioFrase="\n";
        
        for(int i=0;i<cadena.length;i++){
            cadena[i]=cadena[i]+":";//como le hemos quitado antes los : se los volvemos a poner
            String[] div =cadena[i].split(" "); //ahora dividemos cada divison anterior por espacios           
            for(int j=0;j<div.length;j++){               
                if(div[j].endsWith(":")){//si acaba en : es que es el principio de una frase
                   //System.out.println(inicioFrase);
                   m = m+inicioFrase+"\n";//añadimos la frase al string de retorno.. esto ha de venir aquí.. justo aquí
                   inicioFrase = div[j];//es el comienzo de la frase
                }else{
                    inicioFrase = inicioFrase+" " +div[j];//al comienzo de la frase le sumamos los siguiente hasta el siguiente comienzo
                }                              
            }          
        }  
        return m;
    }
}