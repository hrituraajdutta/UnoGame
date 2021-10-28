package uno;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    
    UNO baseUno;
    int currentId=0;
    final int firstPlayer;
    Server(){
        baseUno=new UNO();
        firstPlayer=baseUno.currentPlayer;
        System.err.println(baseUno.drawDeck +"\n" + baseUno.dicardDeck + "\n" +baseUno.nCard);
    }

    void startServer()throws  IOException{
        
        ServerSocket server=new ServerSocket(7787);
        for(byte i=0;i<8;++i){
        
            Socket client=null;
            try{
                System.out.println("Waiting for connection...");
                client=server.accept();
                System.out.println("Connected");
                
                ObjectOutputStream out= new ObjectOutputStream(client.getOutputStream());
                ObjectInputStream in= new ObjectInputStream(client.getInputStream());

                baseUno.nCard.add((byte)7);
                baseUno.nop=(byte)(i+1);
                baseUno.isSaidUno.add((byte)0);
                baseUno.isOnline.add((byte)1);
                baseUno.pid=i;
                
                out.writeObject(baseUno);out.flush();
                baseUno=(UNO)in.readObject();
                
                baseUno.currentPlayer=(byte)((firstPlayer+baseUno.nop)%baseUno.nop);
                
                System.err.println(baseUno.drawDeck +"\n" + baseUno.dicardDeck + "\n" +baseUno.nCard + "\n" +baseUno.isSaidUno);
                System.out.println("CURRENT ID : " +baseUno.currentPlayer +"/" + baseUno.nop);
                
                
                ClientHandler cHandler=new ClientHandler(client,out,in,i);
               
                cHandler.read.start();
                cHandler.write.start();
                
            }catch(Exception e){System.err.println(e);server.close();}
        }
    }
    
    class ClientHandler extends Thread{
        final ObjectOutputStream out;
        final ObjectInputStream in ;
        final Socket client;
        final byte id;
        public ClientHandler(Socket client,ObjectOutputStream out,ObjectInputStream in,byte id) {
           
            this.out=out;
            this.in=in;
            this.client=client;         
            this.id=id;
        }
        
        Thread read=new Thread(){
        public void run(){
            while(true)
                try{
                    UNO tempUno=(UNO)in.readObject();
                    if(baseUno.equals(tempUno))continue;
                    baseUno=tempUno;
                    baseUno.isOnline.set(id,(byte)1);
                    System.out.println(baseUno.drawDeck.size()+"/"+baseUno.dicardDeck.size() + " : " + baseUno);
                    System.err.println(baseUno.drawDeck +"\n" + baseUno.dicardDeck + "\n" +baseUno.nCard + "\n" +baseUno.isSaidUno + "\n" + baseUno.isOnline);
                    System.out.println("CURRENT ID : " +baseUno.currentPlayer +"/" + baseUno.nop);
                }catch(Exception e){
                    baseUno.isOnline.set(id,(byte)0);
                //System.err.println(baseUno.drawDeck +"\n" + baseUno.dicardDeck + "\n" +baseUno.nCard + "\n" +baseUno.isSaidUno + "\n" + baseUno.isOnline);
                }
            }
        };
        
        Thread write=new Thread(){
            public void run(){
                while(true)
                try{    
                    while(baseUno.isOnline.get(baseUno.currentPlayer)==0){
                        System.out.println(baseUno.currentPlayer + " OFFLINE");
                        baseUno.currentPlayer=(byte)(baseUno.currentPlayer+baseUno.direction+baseUno.nop);
                        baseUno.currentPlayer=(byte)(baseUno.currentPlayer%baseUno.nop);
                        System.out.println("CURRENT ID : " +baseUno.currentPlayer +"/" + baseUno.nop);
                    }
                    out.writeObject(baseUno);   
                    out.flush();
                }catch(Exception e){
                    baseUno.isOnline.set(id,(byte)0);  
                    //System.err.println(baseUno.drawDeck +"\n" + baseUno.dicardDeck + "\n" +baseUno.nCard + "\n" +baseUno.isSaidUno + "\n" + baseUno.isOnline);
                }
            }
     
        };
    }
    
    public static void main(String[] args) {
       Server server=new Server();
       try{server.startServer();}catch(Exception e){System.out.println(e);}
    }

        
}

