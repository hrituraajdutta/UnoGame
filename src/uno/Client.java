/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import javax.swing.JOptionPane;

class Client extends Thread{
    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;
    ServerSocket server;
    Socket client ;
    
    boolean isConnected=false;

    public Client(String ip) {
        
        //while(!isConnected){
            try{
            
                System.out.println("SEARCHING FOR SERVER");
                client = new Socket(ip, 7787);
                System.out.println("CONEECTED TTO SERVER");
            
                objectInputStream=new ObjectInputStream(client.getInputStream());
                objectOutputStream = new ObjectOutputStream(client.getOutputStream());

                System.err.println("STREAMS CREATED");
                isConnected=true;
            }catch(Exception e){System.out.println(e);}
        //}
        
        System.out.println("Client Constructed");
    }
    
    UNO acceptUNO()throws  Exception{
        UNO uno=null;
        uno=(UNO)objectInputStream.readObject();
        return uno;
        
    }
    

    void sendUNO(UNO uno){ 
        try{objectOutputStream.writeObject(uno);}catch(Exception e){System.err.println(e);}
    }
  
}