/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsenvioobjetoslist;



/**
 *
 * @author david
 */
public class info {
    /*
        Este ejercicio funciona bien, es basico de sockets basado en un eac de m09, pero modificado para que en lugar de una traduccion de palabra que son solo texto, me envie 
        un objeto.También esta basada en el programa en el paquete pruebasSocketsServer02.  Esto lo hago modificando 
        BufferedReader lector = new BufferedReader(new InputStreamReader(client.getInputStream()));
        por 
        ObjectOutputStream outObjeto = new ObjectOutputStream( client.getOutputStream());
        en el momento de enviar los datos del server al cliente, cambio el texto por envio de objetos, y eso sí, en el cliente también.
        En un principio el cliente recibe del servidor texto preguntandole por la palabra a enviar:
        BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));//flujo lectura del server
        y luego lo que hace ya es cambiar el modo de recibir de texto a ojbetos:
        BObjectInputStream perEnt = new ObjectInputStream(socket.getInputStream());
    
    */
    
}
