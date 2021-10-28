package uno;

import java.util.ArrayList;
import java.util.List;


public class Player {
    int id;
    String name;
    List <Byte> myDeck;

    public int getId(){
        return id;
    }
    public Player(int id) {
        this.id=id;
        myDeck=new ArrayList<Byte>();
    }
    
    void drawN(UNO uno,int n){
        for(int i=0;i<n;++i){
            myDeck.add(uno.getTopCard());
        }
    }
   
    void putMyCard(byte b){
        myDeck.remove(new Byte(b));
    }
    
 
}
