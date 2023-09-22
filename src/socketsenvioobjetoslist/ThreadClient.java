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
//import main.java.ioc.dam.m9.uf3.eac2.b2.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class ThreadClient extends Thread {
    private Socket client;
    private Scanner in;
    private PrintWriter out;
    

    public ThreadClient(Socket client) {
        try {
            this.client = client;
            this.in = new Scanner(client.getInputStream());
            this.out = new PrintWriter(client.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }
    

    
    @Override
    public void run() {
        String msg;
        Personal personal = new Personal();
        List<Persona> listaPersonas = new ArrayList<Persona>();
        
        boolean salir = false;
        try {
            
            //IMPLEMENTA
            BufferedWriter escriptor = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            BufferedReader lector = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            //NUEVO OBJETO
            // Se prepara un flujo de salida para objetos
            //ObjectOutputStream outObjeto = new ObjectOutputStream( client2.getOutputStream());
            ObjectOutputStream outObjeto;
            
            
            while(!salir){
                //enviamos al cliente la pregunta y el mensaje de bienvenida
                msg = "Escribe los datos de la persona e enviar!  Finalice con Exit";
                escriptor.write(msg);//enviamos
                escriptor.newLine();
                escriptor.flush();
                //leemos la respuesta con la palabra a buscar
                String palabra = lector.readLine(); //recibimos
                if(palabra.equalsIgnoreCase("exit")){
                    System.out.println("Ciente desconectado");
                    salir = true;
                    escriptor.close();
                    //outObjeto.close();
                    lector.close();
                    client.close();
                    
                }else{
                    System.out.println("Persona  a enviar: "+palabra);   
                    if(palabra.equalsIgnoreCase("todos")){
                        listaPersonas = personal.todo();
                    }else{
                        listaPersonas = personal.buscar(palabra);
                    }
                    
                    /*
                    Persona juan = new Persona("juan",50);
                    Persona perico = new Persona("perico",25);
                    Persona andres = new Persona("andres",35);
                    Persona p = new Persona();

                    if(palabra.equalsIgnoreCase("juan")){
                        p =  juan;
                    }else if(palabra.equalsIgnoreCase("perico")){
                        p =  perico;
                    }else if(palabra.equalsIgnoreCase("andres")){
                        p =  andres;
                    }
                    */
                    //ystem.out.println("Enviamos: " + p.getNombre() + "*" + p.getEdad());
                    //devolvemos la respueta
                    outObjeto = new ObjectOutputStream( client.getOutputStream());
                    outObjeto.writeObject(listaPersonas);
                    //escriptor.write(msg);
                    //escriptor.newLine();
                    //escriptor.flush();
                }
                
                

            }
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}