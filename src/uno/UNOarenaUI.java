/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.awt.Button;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JOptionPane;



/**
 * ::DEVELOPERS::
 * Hrituraaj 
 * Partha 
 * Raatvik
 */

public class UNOarenaUI extends javax.swing.JFrame implements Runnable{

    UNO uno;
    Player p; 
    MyTimer myTimer;
    boolean isTimerOn=false;
    
    
    private JButton card[]; //actual cards
    

    @Override
    public void run() {     //receive
        while(true){
            UNO tempUno=null;
            try{tempUno=client.acceptUNO();}catch(Exception e){
              JOptionPane.showMessageDialog(this,"Server Disconnected");
            }
            
            if(tempUno.equals(uno))continue;
            
            if(tempUno.currentPlayer==p.id && p.myDeck.isEmpty()){
                uno=tempUno;
                nextTurn();
            }
            
            
            if(!isTimerOn && p.id==tempUno.currentPlayer ){
                isTimerOn=true;
                myTimer=new MyTimer(this);
                myTimer.start();
            }
            
            if(!tempUno.nCard.get(p.id).equals(uno.nCard.get(p.id)) && uno.nCard.get(p.id)==1){  //caught you
                p.drawN(tempUno,2);    
                tempUno.nCard.set(p.id, (byte)3);
                client.sendUNO(tempUno);
                statusBar.setText("YOU ARE CAUGHT");
                btnUno.setBackground(Color.GRAY);
            }
            
            uno=tempUno;            
            showPlayerDeck(p);            
        }
    }
  
    public UNOarenaUI() {
        
        initComponents();  
        
        startUNO();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        discardCard = new javax.swing.JButton();
        drawCard = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        myDeck = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        playerNo = new javax.swing.JLabel();
        timer = new javax.swing.JLabel();
        jButtonNext = new javax.swing.JButton();
        colorPanel = new javax.swing.JPanel();
        color1 = new javax.swing.JButton();
        color2 = new javax.swing.JButton();
        color3 = new javax.swing.JButton();
        color4 = new javax.swing.JButton();
        btnUno = new javax.swing.JButton();
        statusBar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        deck1 = new javax.swing.JPanel();
        opp1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        deck2 = new javax.swing.JPanel();
        opp2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        deck7 = new javax.swing.JPanel();
        opp7 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        deck3 = new javax.swing.JPanel();
        opp3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        deck5 = new javax.swing.JPanel();
        opp5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        deck6 = new javax.swing.JPanel();
        opp6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        deck4 = new javax.swing.JPanel();
        opp4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Unorena");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(1145, 650));
        getContentPane().setLayout(null);

        discardCard.setBackground(new java.awt.Color(0, 0, 0));
        discardCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/cards/15.png"))); // NOI18N
        discardCard.setMaximumSize(new java.awt.Dimension(100, 150));
        discardCard.setMinimumSize(new java.awt.Dimension(100, 150));
        discardCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardCardActionPerformed(evt);
            }
        });
        getContentPane().add(discardCard);
        discardCard.setBounds(730, 210, 100, 150);

        drawCard.setBackground(new java.awt.Color(0, 0, 0));
        drawCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/cards/15.png"))); // NOI18N
        drawCard.setMaximumSize(new java.awt.Dimension(100, 150));
        drawCard.setMinimumSize(new java.awt.Dimension(100, 150));
        drawCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawCardActionPerformed(evt);
            }
        });
        getContentPane().add(drawCard);
        drawCard.setBounds(10, 210, 100, 157);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setAutoscrolls(true);

        myDeck.setMaximumSize(new java.awt.Dimension(10000, 200));
        myDeck.setMinimumSize(new java.awt.Dimension(10000, 150));

        javax.swing.GroupLayout myDeckLayout = new javax.swing.GroupLayout(myDeck);
        myDeck.setLayout(myDeckLayout);
        myDeckLayout.setHorizontalGroup(
            myDeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10000, Short.MAX_VALUE)
        );
        myDeckLayout.setVerticalGroup(
            myDeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(myDeck);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 390, 820, 200);

        playerNo.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        playerNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerNo.setText("PLAYER NO ");

        timer.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        timer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timer.setText("Countdown");

        jButtonNext.setText("NEXT");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        color1.setBackground(new java.awt.Color(255, 0, 0));
        color1.setText(" ");
        color1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                color1ActionPerformed(evt);
            }
        });

        color2.setBackground(new java.awt.Color(0, 255, 0));
        color2.setText(" ");
        color2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                color2ActionPerformed(evt);
            }
        });

        color3.setBackground(new java.awt.Color(255, 153, 0));
        color3.setText(" ");
        color3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                color3ActionPerformed(evt);
            }
        });

        color4.setBackground(new java.awt.Color(0, 0, 255));
        color4.setText(" ");
        color4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                color4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout colorPanelLayout = new javax.swing.GroupLayout(colorPanel);
        colorPanel.setLayout(colorPanelLayout);
        colorPanelLayout.setHorizontalGroup(
            colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, colorPanelLayout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(color1)
                .addGap(0, 0, 0)
                .addComponent(color2)
                .addGap(0, 0, 0)
                .addComponent(color3)
                .addGap(0, 0, 0)
                .addComponent(color4))
        );

        colorPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {color1, color2, color3, color4});

        colorPanelLayout.setVerticalGroup(
            colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(color4)
                    .addComponent(color3)
                    .addComponent(color2)
                    .addComponent(color1))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        colorPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {color1, color2, color3, color4});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerNo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(colorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {colorPanel, jButtonNext, playerNo, timer});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(timer)
                .addGap(6, 6, 6)
                .addComponent(playerNo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(colorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonNext, timer});

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jDesktopPane1);
        jDesktopPane1.setBounds(300, 210, 160, 150);

        btnUno.setText("Say UNO");
        btnUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnoActionPerformed(evt);
            }
        });
        getContentPane().add(btnUno);
        btnUno.setBounds(60, 590, 110, 25);

        statusBar.setForeground(new java.awt.Color(255, 255, 255));
        statusBar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        statusBar.setText("UNO welcomes you");
        getContentPane().add(statusBar);
        statusBar.setBounds(60, 590, 760, 20);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(-20, 380, 890, 10);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(-30, 200, 890, 10);

        opp1.setBackground(new java.awt.Color(0, 0, 0));
        opp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/cards/15.png"))); // NOI18N
        opp1.setMaximumSize(new java.awt.Dimension(100, 150));
        opp1.setMinimumSize(new java.awt.Dimension(100, 150));
        opp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opp1ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout deck1Layout = new javax.swing.GroupLayout(deck1);
        deck1.setLayout(deck1Layout);
        deck1Layout.setHorizontalGroup(
            deck1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deck1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(opp1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        deck1Layout.setVerticalGroup(
            deck1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deck1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(opp1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(deck1);
        deck1.setBounds(10, 0, 100, 190);

        opp2.setBackground(new java.awt.Color(0, 0, 0));
        opp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/cards/15.png"))); // NOI18N
        opp2.setMaximumSize(new java.awt.Dimension(100, 150));
        opp2.setMinimumSize(new java.awt.Dimension(100, 150));
        opp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opp2ActionPerformed(evt);
            }
        });

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout deck2Layout = new javax.swing.GroupLayout(deck2);
        deck2.setLayout(deck2Layout);
        deck2Layout.setHorizontalGroup(
            deck2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deck2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(deck2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opp2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        deck2Layout.setVerticalGroup(
            deck2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deck2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(opp2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(deck2);
        deck2.setBounds(130, 0, 100, 190);

        opp7.setBackground(new java.awt.Color(0, 0, 0));
        opp7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/cards/15.png"))); // NOI18N
        opp7.setMaximumSize(new java.awt.Dimension(100, 150));
        opp7.setMinimumSize(new java.awt.Dimension(100, 150));
        opp7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opp7ActionPerformed(evt);
            }
        });

        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout deck7Layout = new javax.swing.GroupLayout(deck7);
        deck7.setLayout(deck7Layout);
        deck7Layout.setHorizontalGroup(
            deck7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deck7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(deck7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opp7, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        deck7Layout.setVerticalGroup(
            deck7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deck7Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(opp7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(deck7);
        deck7.setBounds(730, 0, 100, 190);

        opp3.setBackground(new java.awt.Color(0, 0, 0));
        opp3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/cards/15.png"))); // NOI18N
        opp3.setMaximumSize(new java.awt.Dimension(100, 150));
        opp3.setMinimumSize(new java.awt.Dimension(100, 150));
        opp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opp3ActionPerformed(evt);
            }
        });

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout deck3Layout = new javax.swing.GroupLayout(deck3);
        deck3.setLayout(deck3Layout);
        deck3Layout.setHorizontalGroup(
            deck3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deck3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(deck3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opp3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        deck3Layout.setVerticalGroup(
            deck3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deck3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(opp3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(deck3);
        deck3.setBounds(250, 0, 100, 190);

        opp5.setBackground(new java.awt.Color(0, 0, 0));
        opp5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/cards/15.png"))); // NOI18N
        opp5.setMaximumSize(new java.awt.Dimension(100, 150));
        opp5.setMinimumSize(new java.awt.Dimension(100, 150));
        opp5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opp5ActionPerformed(evt);
            }
        });

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout deck5Layout = new javax.swing.GroupLayout(deck5);
        deck5.setLayout(deck5Layout);
        deck5Layout.setHorizontalGroup(
            deck5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deck5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(deck5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opp5, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        deck5Layout.setVerticalGroup(
            deck5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deck5Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(opp5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(deck5);
        deck5.setBounds(490, 0, 100, 190);

        opp6.setBackground(new java.awt.Color(0, 0, 0));
        opp6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/cards/15.png"))); // NOI18N
        opp6.setMaximumSize(new java.awt.Dimension(100, 150));
        opp6.setMinimumSize(new java.awt.Dimension(100, 150));
        opp6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opp6ActionPerformed(evt);
            }
        });

        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout deck6Layout = new javax.swing.GroupLayout(deck6);
        deck6.setLayout(deck6Layout);
        deck6Layout.setHorizontalGroup(
            deck6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deck6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(deck6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opp6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        deck6Layout.setVerticalGroup(
            deck6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deck6Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(opp6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(deck6);
        deck6.setBounds(610, 0, 100, 190);

        opp4.setBackground(new java.awt.Color(0, 0, 0));
        opp4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/cards/15.png"))); // NOI18N
        opp4.setMaximumSize(new java.awt.Dimension(100, 150));
        opp4.setMinimumSize(new java.awt.Dimension(100, 150));
        opp4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opp4ActionPerformed(evt);
            }
        });

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout deck4Layout = new javax.swing.GroupLayout(deck4);
        deck4.setLayout(deck4Layout);
        deck4Layout.setHorizontalGroup(
            deck4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deck4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(deck4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opp4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        deck4Layout.setVerticalGroup(
            deck4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deck4Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(opp4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(deck4);
        deck4.setBounds(370, 0, 100, 190);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backnew.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(-110, 0, 1000, 630);

        setSize(new java.awt.Dimension(908, 677));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void discardCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardCardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discardCardActionPerformed

    private void drawCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawCardActionPerformed
        if(uno.currentPlayer!=p.id){
            statusBar.setText("NOT YOUR TURN");
            Toolkit.getDefaultToolkit().beep();
            return;
        }
              
        uno.nCard.set(uno.currentPlayer, (byte)(uno.nCard.get(uno.currentPlayer)+uno.cardToDraw));
               
        p.drawN(uno,uno.cardToDraw);
        showPlayerDeck(p);       
       
        if(uno.cardToDraw>1){   //No choice except drawing a card
            statusBar.setText("MOVE : " + uno.cardToDraw + "CARDS DRAWN AND MOVE SKIPPED");
            uno.cardToDraw=1;
            nextTurn();
        }
        else{               //Card drawn
            statusBar.setText("MOVE : " + uno.cardToDraw + "CARDS DRAWN");
            jButtonNext.setEnabled(true);
            drawCard.setEnabled(false);
        }                  
    }//GEN-LAST:event_drawCardActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        statusBar.setText("MOVE : NONE");
        nextTurn();
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void color3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_color3ActionPerformed
        uno.currentColor=Color.ORANGE;
        nextTurn();
    }//GEN-LAST:event_color3ActionPerformed

    private void color2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_color2ActionPerformed
        uno.currentColor=Color.GREEN;
        nextTurn();
    }//GEN-LAST:event_color2ActionPerformed

    private void color1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_color1ActionPerformed
        uno.currentColor=Color.RED;
        nextTurn();
    }//GEN-LAST:event_color1ActionPerformed

    private void color4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_color4ActionPerformed
        uno.currentColor=Color.BLUE;
        nextTurn();
    }//GEN-LAST:event_color4ActionPerformed

    private void opp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opp1ActionPerformed
        // TODO add your handling code here:
        caughtYou(1);
    }//GEN-LAST:event_opp1ActionPerformed

    private void btnUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnoActionPerformed
        // TODO add your handling code here:
        if(p.myDeck.size()==1){
            uno.isSaidUno.set(p.id,(byte)1);
            client.sendUNO(uno);
            btnUno.setBackground(Color.GREEN);
        }
    }//GEN-LAST:event_btnUnoActionPerformed

    private void opp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opp2ActionPerformed
       
        caughtYou(2); // TODO add your handling code here:
    }//GEN-LAST:event_opp2ActionPerformed

    private void opp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opp3ActionPerformed

        caughtYou(3);        // TODO add your handling code here:
    }//GEN-LAST:event_opp3ActionPerformed

    private void opp4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opp4ActionPerformed
        // TODO add your handling code here:
        caughtYou(4);
    }//GEN-LAST:event_opp4ActionPerformed

    private void opp5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opp5ActionPerformed
        
        caughtYou(5);// TODO add your handling code here:
    }//GEN-LAST:event_opp5ActionPerformed

    private void opp6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opp6ActionPerformed
       
        caughtYou(6); // TODO add your handling code here:
    }//GEN-LAST:event_opp6ActionPerformed

    private void opp7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opp7ActionPerformed
       
        caughtYou(7); // TODO add your handling code here:
    }//GEN-LAST:event_opp7ActionPerformed

    /** This function initializes all the 108 cards(JButton with there color, type & behavior<listener>) **/
    void startUNO(){      
        for(int i=0;i<7;++i){
            jBtn[i]=new JButton();
            jBtn[i].setBackground(Color.DARK_GRAY);
            jBtn[i].setBounds(0,20, 100, 150);
        }            
        card=new JButton[108];                
     
        for(int i=0;i<108;++i){
            final byte j=(byte)i;
            
            card[j]=new JButton(new ImageIcon(getClass().getResource(UNO.getPath(j))));
            card[j].setBackground(UNO.getColor(j)); 
            card[j].addActionListener((ActionEvent e) -> {                
                //Prevalidation
            if(validateMove(j)==false)
                return;
               
            if(j>=100){
                statusBar.setText("CHOOSE COLOR");
                askForColor();
            }
            else{
                nextTurn();
            }
                
            showPlayerDeck(p);     
                
            if(p.myDeck.isEmpty()){
                JOptionPane.showMessageDialog(this,"Congratulations & Celebrations!");
            }
            
            });
                 
        }

    }
    
    Client client=null;
        
        
    void newGame(String ip){
        
        btnUno.setBackground(Color.GRAY);
        setSize(860, 650);        
        setVisible(true); 
        
        colorPanel.setVisible(false);     
        jButtonNext.setEnabled(false);
        client=new Client(ip);   
       
        try{uno=client.acceptUNO();}catch(Exception e){}  
        
        
        
        jPanel1.setBackground(uno.currentColor);
        
        p=new Player(uno.pid);        
        
        p.drawN(uno,7); 
        
        client.sendUNO(uno);
        
        Thread t=new Thread(this);t.start();   
        
        showPlayerDeck(p); 
        
    }
    
    
    
    void nextTurn(){  
        isTimerOn=false;  
        myTimer.interrupt();
        colorPanel.setVisible(false); 
        
        
        if(uno.isSaidUno.get(p.id)==1 && p.myDeck.size()>1){    //deactivate say uno
            btnUno.setBackground(Color.GRAY);
            uno.isSaidUno.set(p.id, (byte)0);
            client.sendUNO(uno);
        }                
     
        uno.currentPlayer=(byte)(uno.currentPlayer+uno.direction+uno.nop);
        uno.currentPlayer=(byte)(uno.currentPlayer%uno.nop);
     
        client.sendUNO(uno);
        
        jButtonNext.setEnabled(false);
        drawCard.setEnabled(true);  
    }
    
    int askForColor(){
        statusBar.setText("COLOR CHANGED");
        drawCard.setEnabled(false);
        jButtonNext.setEnabled(false);
        colorPanel.setVisible(true);
        return 1;
    }
    
    
    boolean validateMove(byte x){ 
        boolean flag=false;
        
        if(uno.currentPlayer!=p.id)
            statusBar.setText("NOT YOUR TURN");        
        else{
            byte y = uno.dicardDeck.get(uno.dicardDeck.size()-1);
            
            //basic criteria
            if(y<=103 && x>=100)
                flag=true;
            if(UNO.getColor(x).equals(uno.currentColor))
                flag=true;
            else if(uno.getTypeCode(x)==uno.currentCardType)
                flag=true;
        
        
            //EXCEPTIONAL criteria
            if(uno.currentCardType==12 && uno.getTypeCode(x)!=12 && uno.cardToDraw>1){        //+2 is on top
                    flag=false; 
            } 
            else if(uno.currentCardType==14 && uno.cardToDraw>1){        //+4 is on top                
                    flag=false;
            }
            
        }
        
        if(flag==false)
                Toolkit.getDefaultToolkit().beep();
        
        if(flag==true){
            
            uno.nCard.set(uno.currentPlayer, (byte)(uno.nCard.get(uno.currentPlayer)-1));

            if(UNO.getTypeCode(x)==10)      //SKIP
                uno.currentPlayer+=uno.direction;
            else if(UNO.getTypeCode(x)==11) //REVERSE
                uno.direction*=-1;
            else if(UNO.getTypeCode(x)==12){ //+2
                if(uno.cardToDraw==1)uno.cardToDraw=2;
                else uno.cardToDraw+=2;
            }
            else if(UNO.getTypeCode(x)==14) //+4
                uno.cardToDraw=4;
            
            uno.currentCardType=(byte)UNO.getTypeCode(x);
            if(x<100)uno.currentColor=UNO.getColor(x);
                        
            uno.dicardDeck.add(x);
            p.myDeck.remove(new Byte(x));
                     
        }
        
        return flag;
        
    }
    
    void showPlayerDeck(Player pp){
        
        jPanel1.setBackground(uno.currentColor);
        
        if(p.id==uno.currentPlayer)
            playerNo.setText("MY TURN");
        else{
            playerNo.setText("Player #" + uno.currentPlayer + " Turn");
        }
        
        myDeck.removeAll();
        
        int j;
        int len=pp.myDeck.size();
        byte b=uno.dicardDeck.get(uno.dicardDeck.size()-1);        
        
        for(int i=0;i<len;++i){
            j=pp.myDeck.get(i);
            card[j].setBounds(i*70, 0, 100,150);
          myDeck.add(card[j]);
        }  
        myDeck.repaint();                           
        
        discardCard.setIcon(new ImageIcon(getClass().getResource(uno.getPath(b))));
        discardCard.setBackground(uno.getColor(b));                
        
        othersDeck();
    }
    
    JButton jBtn[]=new JButton[7];
    
    void othersDeck(){
        
        if(1<uno.nop)if(nOfCards(1)>1)deck1.add(jBtn[0]);else deck1.remove(jBtn[0]);
        if(2<uno.nop)if(nOfCards(1)>1)deck2.add(jBtn[1]);else deck2.remove(jBtn[1]);
        if(3<uno.nop)if(nOfCards(1)>1)deck1.add(jBtn[2]);else deck1.remove(jBtn[2]);
        if(4<uno.nop)if(nOfCards(1)>1)deck2.add(jBtn[3]);else deck2.remove(jBtn[3]);
        if(5<uno.nop)if(nOfCards(1)>1)deck1.add(jBtn[4]);else deck1.remove(jBtn[4]);
        if(6<uno.nop)if(nOfCards(1)>1)deck2.add(jBtn[5]);else deck2.remove(jBtn[5]);
        if(7<uno.nop)if(nOfCards(1)>1)deck1.add(jBtn[6]);else deck1.remove(jBtn[6]);
                
        opp1.setToolTipText(String.valueOf(nOfCards(1)));
        opp2.setToolTipText(String.valueOf(nOfCards(2)));
        opp3.setToolTipText(String.valueOf(nOfCards(3)));
        opp4.setToolTipText(String.valueOf(nOfCards(4)));
        opp5.setToolTipText(String.valueOf(nOfCards(5)));
        opp6.setToolTipText(String.valueOf(nOfCards(6)));
        opp7.setToolTipText(String.valueOf(nOfCards(7)));        
        
        jLabel1.setText(1<uno.nop?"Player #" + (p.id+1)%uno.nop:"");
        jLabel2.setText(2<uno.nop?"Player #" + (p.id+2)%uno.nop:"");
        jLabel3.setText(3<uno.nop?"Player #" + (p.id+3)%uno.nop:"");
        jLabel4.setText(4<uno.nop?"Player #" + (p.id+4)%uno.nop:"");
        jLabel5.setText(5<uno.nop?"Player #" + (p.id+5)%uno.nop:"");
        jLabel6.setText(6<uno.nop?"Player #" + (p.id+6)%uno.nop:"");
        jLabel7.setText(7<uno.nop?"Player #" + (p.id+7)%uno.nop:"");
        
        repaint();
       
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {}

        UNOarenaUI unoMaze=new UNOarenaUI();   
        String ic="/uno/cards/";
        Image icon = Toolkit.getDefaultToolkit().getImage(ic+ "uno.jpg");  
        unoMaze.setIconImage(icon);  
        unoMaze.newGame("localhost");      
        
    }

    int nOfCards(int i){
        if(i>=uno.nop)return 0;
        int next=(p.id+i)%uno.nop;
        return uno.nCard.get(next);
    }
    
    void caughtYou(int i){
        if(i>=uno.nop)return;
        
        int next=(p.id+i)%uno.nop;
        if(uno.nCard.get(next)==1 && uno.isSaidUno.get(next)==0){
            
            uno.nCard.set(next,(byte)3);//2 cards should be drawn by that player
            client.sendUNO(uno);
            
            JOptionPane.showMessageDialog(this,"YOU CAUGHT PLAYER NO. : " + next);

            statusBar.setText("YOU CAUGHT P#" + next);
        }
        else if(uno.nCard.get(next)==1){
             JOptionPane.showMessageDialog(this,"ALREADY DECLARED UNO");
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUno;
    private javax.swing.JButton color1;
    private javax.swing.JButton color2;
    private javax.swing.JButton color3;
    private javax.swing.JButton color4;
    private javax.swing.JPanel colorPanel;
    private javax.swing.JPanel deck1;
    private javax.swing.JPanel deck2;
    private javax.swing.JPanel deck3;
    private javax.swing.JPanel deck4;
    private javax.swing.JPanel deck5;
    private javax.swing.JPanel deck6;
    private javax.swing.JPanel deck7;
    private javax.swing.JButton discardCard;
    javax.swing.JButton drawCard;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel myDeck;
    private javax.swing.JButton opp1;
    private javax.swing.JButton opp2;
    private javax.swing.JButton opp3;
    private javax.swing.JButton opp4;
    private javax.swing.JButton opp5;
    private javax.swing.JButton opp6;
    private javax.swing.JButton opp7;
    private javax.swing.JLabel playerNo;
    private javax.swing.JLabel statusBar;
    javax.swing.JLabel timer;
    // End of variables declaration//GEN-END:variables
}
