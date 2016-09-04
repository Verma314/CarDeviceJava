/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rallydevice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.text.ParsePosition;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author A. Verma @ Salahacar
 */
public class Navigator extends javax.swing.JFrame    {
    
    public DriverScreen nextScreen;
    public int recommendedSpeed;
    public int minsRemaining;
    public int tulipNum;
    public int tulipDist;
    public int idealTime;
    public int distanceCoveredTillNow;
    public MyDocumentFilter documentFilter;
    public Navigator2 navig2;
     
    public Navigator() {
        initComponents();
        
        jToggleButton1.setVisible(false);
        jToggleButton2.setVisible(false);
        
        navig2 = new Navigator2(this);
        //toggle functionality
        jTextField2.getInputMap().put(KeyStroke.getKeyStroke('T'),"forward");
        jTextField2.getInputMap().put(KeyStroke.getKeyStroke('t'),"forward");    
        jTextField2.getActionMap().put("forward", new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e){
            altToggle();
        }  
        });
        jTextField3.getInputMap().put(KeyStroke.getKeyStroke('T'),"forward");
        jTextField3.getInputMap().put(KeyStroke.getKeyStroke('t'),"forward");    
        jTextField3.getActionMap().put("forward", new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e){
            altToggle();
        }  
        });
        jTextField4.getInputMap().put(KeyStroke.getKeyStroke('T'),"forward");
        jTextField4.getInputMap().put(KeyStroke.getKeyStroke('t'),"forward");    
        jTextField4.getActionMap().put("forward", new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e){
            altToggle();
        }  
        });
        jTextField5.getInputMap().put(KeyStroke.getKeyStroke('T'),"forward");
        jTextField5.getInputMap().put(KeyStroke.getKeyStroke('t'),"forward");    
        jTextField5.getActionMap().put("forward", new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e){
            altToggle();
        }  
        });
        jTextField6.getInputMap().put(KeyStroke.getKeyStroke('T'),"forward");
        jTextField6.getInputMap().put(KeyStroke.getKeyStroke('t'),"forward");    
        jTextField6.getActionMap().put("forward", new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e){
            altToggle();
        }  
        });
        
        JRootPane panel = this.getRootPane();
        panel.getInputMap().put(KeyStroke.getKeyStroke('T'),"forward");
        panel.getInputMap().put(KeyStroke.getKeyStroke('t'),"forward");    
        panel.getActionMap().put("forward", new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e){
            altToggle();
        }  
        });
    
               
        //trying to allow only numeric values;
        ((AbstractDocument)jTextField1.getDocument()).setDocumentFilter(new MyDocumentFilter());    
        ((AbstractDocument)jTextField2.getDocument()).setDocumentFilter(new MyDocumentFilter());        
        ((AbstractDocument)jTextField4.getDocument()).setDocumentFilter(new MyDocumentFilter());    
        ((AbstractDocument)jTextField5.getDocument()).setDocumentFilter(new MyDocumentFilter());    
        ((AbstractDocument)jTextField6.getDocument()).setDocumentFilter(new MyDocumentFilter());    

        
        
        this.getContentPane().setBackground( new Color(219, 238, 244) );
        tulipNum = 0;
        this.distanceCoveredTillNow = 0;
        
        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(0,0);
     
//this.setLocation(100,100);
        
        //making the driver screen visible
        nextScreen = new DriverScreen(this,1,1,1);
        nextScreen.setVisible(true);
        
      	LineBorder line = new LineBorder(new Color(85,128,184), 2, true);
        ////////////////display settings////////////////////////////////
        jLabel1.setBorder(line);
        jLabel1.setOpaque(true);
        jLabel1.setForeground(Color.white);
        jLabel1.setBackground( new Color(85,128,184));
         jLabel1.setBorder(line);
       
        jLabel2.setOpaque(true);
        jLabel2.setForeground(Color.white);
        jLabel2.setBackground( new Color(85,128,184));
        jLabel2.setBorder(line);
       
        jLabel3.setOpaque(true);
        jLabel3.setForeground(Color.white);
        jLabel3.setBackground( new Color(85,128,184));
        jLabel3.setBorder(line);
       
        jLabel4.setOpaque(true);
        jLabel4.setForeground(Color.white);
        jLabel4.setBackground( new Color(85,128,184));
        jLabel4.setBorder(line);
       
        jLabel5.setOpaque(true);
        jLabel5.setForeground(Color.white);
        jLabel5.setBackground( new Color(85,128,184));
        jLabel5.setBorder(line);
       
        jLabel6.setOpaque(true);
        jLabel6.setForeground(Color.white);
        jLabel6.setBackground( new Color(85,128,184));
        jLabel6.setBorder(line);
        
        this.updateTulip();
    }    
        
    
    public void checkAndUpdate() {
        /**this function is used to check whether 
         * the text fields are filled with some values, if they are we update 
         *  the driver screen from here.
         *  What all text fields to check for?
         *  If it is a free zone ( ie jTextField3 is F ) then
         *  EVERYTHING has to be fILLED! 
         *  if it is not a free zone jTextField4 can be left empty
         * */
        //Free zone
        if ( jTextField3.getText().startsWith("F") ||jTextField3.getText().startsWith("f") ) {
            if ( jTextField1.getText().equals("")  ||
                 jTextField2.getText().equals("")  || 
                 jTextField3.getText().equals("") ||
                 jTextField4.getText().equals("")  ||
                 jTextField5.getText().equals("")  ||
                 jTextField6.getText().equals("") )  {
                //if any of this is empty we can't update OR
            }
            else {
                alternateButton();
            }
        }
        else {
             if ( jTextField1.getText().equals("")  ||
                  jTextField2.getText().equals("")  || 
                  jTextField3.getText().equals("") ||
                  jTextField5.getText().equals("")  ||
                  jTextField6.getText().equals("") )  {
                //if any of this is empty we can't update OR
            }
             else {
                 alternateButton();
             }
        }
    }
        
        
    public void altToggle( ) {
        navig2.setVisible(true);
        this.setVisible(false);
    }

    
    public void updateTulip() {
        String s = Integer.toString(this.tulipNum+1);
        this.distanceCoveredTillNow += this.tulipDist;
        jLabel8.setText(s);
        jTextField1.setText(Integer.toString(this.distanceCoveredTillNow));
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
         //nextScreen.update(1,1,1);
    }     
    
    //DO NOT MODIFY jFrame Swing Code.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Start Distance ");
        jLabel1.setBorder(null);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("End Distance");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Average Speed");

        jTextField1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Toggle");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Tulip Distance");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("TC Time");

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel6.setText("Ideal Time");

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        jToggleButton2.setText("Calculate");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Tulip number:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("num");

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel9.setText("minutes");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("km/h");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("m");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setText("m");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel13.setText("m");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel8)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jToggleButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jToggleButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jToggleButton2)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jToggleButton1)))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 63, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        checkAndUpdate();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed

        checkAndUpdate();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        checkAndUpdate();    
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        new Navigator2(this).setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        checkAndUpdate();
        if ( jTextField3.getText().startsWith("F") || 
                jTextField3.getText().startsWith("f") )
           jTextField4.setEditable(true);    
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        checkAndUpdate();        
    }//GEN-LAST:event_jTextField2ActionPerformed

    
    
    private void alternateButton() {
        
        //add stuff to navigator2
        
        
        
        
        if ( jTextField3.getText().startsWith("F" ) || 
            jTextField3.getText().startsWith("f") ) {
              
            this.tulipDist = Integer.parseInt(jTextField5.getText());
            this.idealTime = Integer.parseInt(jTextField4.getText());
            this.recommendedSpeed = this.tulipDist/this.idealTime;
                 
            System.out.println(this.recommendedSpeed);
            
            this.tulipNum++;
            navig2.addData();
            nextScreen.update(this.recommendedSpeed, this.idealTime ,this.tulipDist);
            nextScreen.setVisible(true);
        }    
        else {
            //means ideal time needs to be calculated
            this.tulipDist = Integer.parseInt(jTextField5.getText());
            this.recommendedSpeed = Integer.parseInt(jTextField3.getText());
            this.idealTime = this.tulipDist / this.recommendedSpeed;
            
            
            this.tulipNum++;
            navig2.addData();
                                                                                                     
            nextScreen.update(this.recommendedSpeed, this.idealTime, this.tulipDist);
            nextScreen.setVisible(true);
        }
    }
    
    
    
    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        
        alternateButton();        
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        //doesn't work
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        //doesn't work
    }//GEN-LAST:event_formKeyReleased

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Navigator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Navigator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Navigator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Navigator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new Navigator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}
