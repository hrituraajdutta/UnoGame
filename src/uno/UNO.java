package uno;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.Serializable;

public class UNO implements Serializable{
    static Color cardColor[]={Color.RED,Color.GREEN,Color.ORANGE,Color.BLUE};
    static String path="/uno/cards/";
    
        //ordered deck
    byte currentPlayer;
    byte nop;                //No. of players
    byte direction;          //Clockwise /Anticlockwisei
    byte cardToDraw;   
    byte currentCardType; 
    byte pid;
    
    Color currentColor;
    
    
    List<Byte> nCard;
    List <Byte> drawDeck;  
    List <Byte> dicardDeck;
    List <Byte> isSaidUno;
    List <Byte> isOnline;
   
    UNO() {
        currentPlayer=0;
        int total=108;
        List <Byte> unoDeck=new ArrayList<Byte>();
        nCard=new ArrayList<>();
        drawDeck=new ArrayList<>();
        dicardDeck=new ArrayList<>();
        isSaidUno=new ArrayList<>();
        isOnline=new ArrayList<>();
        
        for(byte i=0;i<total;++i)
            unoDeck.add(new Byte(i));//arranging deck
        
        //initialize drawdeck with random card numbers;
        Random random=new Random();
        for(int i=0;i<108;++i){
            
            byte cIndex=(byte)random.nextInt(total--);
            Byte cNumber=unoDeck.get(cIndex);
            unoDeck.remove(cIndex);
            
            drawDeck.add(cNumber);
            
        }
        
        Byte topCard;
        while(true){        //starting card cannot be wild
            topCard=getTopCard();
            if(topCard<100)
                break;
            drawDeck.add(topCard);
        }
        
        //DEFAULT
        direction=1; 
        cardToDraw=1;
        currentPlayer=0;
        
        if(getTypeCode(topCard)==10)//SKIP
            currentPlayer+=1;
        if(getTypeCode(topCard)==11)//REVERSE
            direction=-1;
        if(getTypeCode(topCard)==12)//+2
            cardToDraw=2;
        
        
        currentCardType=(byte)getTypeCode(topCard);     
        currentColor=getColor(topCard);
        
        dicardDeck.add(topCard);
        drawDeck.remove(topCard);
        total=108;
    }
    
   
    byte getTopCard(){
        byte cNumber=drawDeck.get(0);
        drawDeck.remove(new Byte(cNumber));
        if(drawDeck.isEmpty())
            reShuffle();
        return cNumber;
    }
   
    static Color getColor(int index){
        if(index<100)
            return cardColor[index/25];
        return Color.BLACK;
    }
    
    static String getPath(int index){
        return path + getTypeCode(index) + ".png";
    }
    
    static int getTypeCode(int index){
	if(index>=100)		//wild cards{13,14}
            return 13+(index-100)/4;
        if(index<0)     //flipped card
            return 15;
        int cNum=index%25;
            if(cNum>12)
		cNum-=12;
        return cNum;
    }
    
    
    void reShuffle(){
        int total = dicardDeck.size();
        int tempTotal=total-1;
        Random random=new Random();
        
        for(int i=0;i<total-1;++i){
            byte cIndex=(byte)random.nextInt(total--);
            Byte cNumber=dicardDeck.get(cIndex);
            
            dicardDeck.remove(cIndex);
            drawDeck.add(cNumber);
        }
        System.out.println("DRAW DECK REGENERATED");
    }
    
    
    
    
}


class MyTimer extends Thread{
    UNOarenaUI maze;
    public MyTimer(UNOarenaUI unoMaze) {
        maze=unoMaze;
    }
    @Override
    public void run(){
        try{
            for (int i = 30; i >=0 ; i--) {
                maze.timer.setText(i + "s");
                if(i<6)
                    Toolkit.getDefaultToolkit().beep();
                Thread.sleep(1000);
            }
            if(maze.drawCard.isEnabled()){        //player has not drawn yet
               maze.p.drawN(maze.uno,maze.uno.cardToDraw);
               maze.uno.nCard.set(maze.p.id,(byte)(maze.uno.nCard.get(maze.p.id)+maze.uno.cardToDraw));
               System.out.println("TIME OUT : " + maze.uno.cardToDraw + "CARD(S) DRAWN");
            }
            maze.uno.cardToDraw=1;
            maze.nextTurn();
        }
        catch(InterruptedException ie){}
        maze.timer.setText("");
        
    }
}