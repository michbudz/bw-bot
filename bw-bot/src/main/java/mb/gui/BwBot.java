/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BwBot.java
 *
 * Created on 2012-10-27, 12:03:17
 */
package mb.gui;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import mb.AccountConfig;
import mb.AccountConfigFactory;
import mb.Login;
import mb.Quest;
import mb.exception.BWException;
import mb.exception.LoginException;
import mb.exception.NoQuestException;
import mb.queue.Queue;
import mb.queue.QueueElement;
import mb.queue.QueueThread;
//import objectexplorer.ObjectGraphMeasurer;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author xxx
 */
public class BwBot extends javax.swing.JFrame {

    
    
    /** Creates new form BwBot */
    public BwBot() {
        queue = new mb.queue.Queue();
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupaTyp = new javax.swing.ButtonGroup();
        grupaWyprawa = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        rWyprawa = new javax.swing.JRadioButton();
        rAtak = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        rWyprawaLatwa = new javax.swing.JRadioButton();
        rWyprawaSrednia = new javax.swing.JRadioButton();
        rWyprawaTrudna = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaZadan = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        ileRazy = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        login = new javax.swing.JTextField();
        haslo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        serwer = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jKrew = new javax.swing.JTextField();
        jPieniadze = new javax.swing.JTextField();
        jLudzie = new javax.swing.JTextField();
        textWyprawy = new javax.swing.JLabel();
        jWyprawy = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jAtaki = new javax.swing.JTextField();

        grupaTyp.add(rWyprawa);
        grupaTyp.add(rAtak);

        grupaWyprawa.add(rWyprawaLatwa);
        grupaWyprawa.add(rWyprawaSrednia);
        grupaWyprawa.add(rWyprawaTrudna);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Typ");

        rWyprawa.setSelected(true);
        rWyprawa.setText("Wyprawa");
        rWyprawa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rWyprawaActionPerformed(evt);
            }
        });

        rAtak.setText("Atak");
        rAtak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rAtakActionPerformed(evt);
            }
        });

        jLabel2.setText("Wyprawa");

        rWyprawaLatwa.setSelected(true);
        rWyprawaLatwa.setText("Latwa");
        rWyprawaLatwa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rWyprawaLatwaActionPerformed(evt);
            }
        });

        rWyprawaSrednia.setText("Normalna");

        rWyprawaTrudna.setText("Trudna");

        jScrollPane1.setViewportView(listaZadan);

        jLabel3.setText("Lista zadan");

        ileRazy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ileRazyActionPerformed(evt);
            }
        });

        jLabel4.setText("Ile");

        jToggleButton1.setText("Dodaj");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Start");
        jToggleButton2.setPreferredSize(new java.awt.Dimension(60, 22));
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("Usun");
        jToggleButton3.setPreferredSize(new java.awt.Dimension(60, 22));
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setText("Zamknij");
        jToggleButton4.setPreferredSize(new java.awt.Dimension(69, 22));
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jLabel5.setText("Login:");

        jLabel6.setText("Haslo:");

        haslo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hasloActionPerformed(evt);
            }
        });

        jLabel7.setText("Serwer:");

        serwer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "7", "11", "16" }));
        serwer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serwerActionPerformed(evt);
            }
        });

        jLabel8.setText("Status:");

        status.setText(null);

        jLabel9.setText("Krew:");

        jLabel10.setText("Pieniadze:");

        jLabel11.setText("Ludzie:");

        jKrew.setMinimumSize(null);
        jKrew.setName(""); // NOI18N
        jKrew.setPreferredSize(null);

        textWyprawy.setText("Wypraw:");

        jLabel12.setText("Atakow:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(10, 10, 10)
                                        .addComponent(serwer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(haslo)))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textWyprawy)
                                    .addComponent(jLabel9)))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rAtak)
                                    .addComponent(rWyprawa)))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rWyprawaSrednia)
                                    .addComponent(rWyprawaLatwa)
                                    .addComponent(rWyprawaTrudna)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ileRazy, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                        .addComponent(jToggleButton1))
                                    .addComponent(jLabel2))
                                .addGap(178, 178, 178))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jKrew, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPieniadze, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLudzie, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jWyprawy, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jAtaki, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(314, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(status)
                        .addContainerGap(482, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLudzie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jPieniadze, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jKrew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(haslo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textWyprawy)
                    .addComponent(jWyprawy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAtaki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serwer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rWyprawa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rAtak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rWyprawaLatwa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rWyprawaSrednia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rWyprawaTrudna)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ileRazy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(status))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rWyprawaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rWyprawaActionPerformed
         typeChange(evt);
    }//GEN-LAST:event_rWyprawaActionPerformed

    private void rAtakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rAtakActionPerformed
        typeChange(evt);
    }//GEN-LAST:event_rAtakActionPerformed

    private void ileRazyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ileRazyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ileRazyActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void rWyprawaLatwaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rWyprawaLatwaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rWyprawaLatwaActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
            try{
           ile =  Integer.parseInt( ileRazy.getText());
           for(int i = 0 ; i < ile; i++){
               if(rWyprawa.isSelected())
                   addQuest();
               else if(rAtak.isSelected())
                   addAttact();
               
           }
           System.out.println("quest added : " + queue.toString());
           setList(); 
       }catch(NumberFormatException e){
            
       } 
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed

           queue.setHeader(new Thread(){
                 long tmp=0;
                  public void run() {
                   try {
                       Thread.sleep(2000);
                       for( tmp = queue.getTime() ; tmp >=0 ; tmp -=1000){
                                   sleep(1000);
                                   status.setText(String.format("%d min, %d sec", 
                                            TimeUnit.MILLISECONDS.toMinutes(tmp),
                                            TimeUnit.MILLISECONDS.toSeconds(tmp) - 
                                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(tmp))
                                            ));      
                       }
                       Thread.sleep(8000);
                       System.out.println(" ---- wykonano : " + queue.toList().length);
                       setList();
                       loadProperty();
                    } catch (InterruptedException ex) {
                           Logger.getLogger(BwBot.class.getName()).log(Level.SEVERE, null, ex);
                       }
                     }
                 });
           
            executeQueue =  new Thread(){
                       public void run() {
                        try {
                            if(logined==false){
                                synchronized(Thread.currentThread()){
                                    System.out.println("wait");  
                                    Thread.currentThread().wait();
                                }
                            }
                            queue.execute();
                        } catch (NoQuestException ex) {
                             status.setText("Nie mozna wykonac wyprawy");
                        } catch (BWException ex) {
                            Logger.getLogger(BwBot.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(BwBot.class.getName()).log(Level.SEVERE, null, ex);
                        }
                          }
                      };
            
            login(); 
             
        executeQueue.start();
        
        
    }//GEN-LAST:event_jToggleButton2ActionPerformed
       
    public void loadProperty()
    {
        jKrew.setText(AccountConfigFactory.getInstance().getBlood().toString());
        jPieniadze.setText(AccountConfigFactory.getInstance().getMoney().toString());
        jLudzie.setText(AccountConfigFactory.getInstance().getPeople().toString());
        jWyprawy.setText(AccountConfigFactory.getInstance().getQuest().toString());
        jAtaki.setText(AccountConfigFactory.getInstance().getAttack().toString());
        
    }
    
     public void generateLoginLabel(){
      new Thread(){
              int i =0;
               public void run() {
                try {
                  
                   while(logined!=true){
                                sleep(500);
                                if(i % 3 ==0){
                                    status.setText("Trwa logowanie .");  
                                }else if(i % 3 ==1){
                                     status.setText("Trwa logowanie . ."); 
                                }else if(i % 3 ==2){
                                      status.setText("Trwa logowanie . . ."); 
                                }i++;
                    }
                 } catch (InterruptedException ex) {
                        Logger.getLogger(BwBot.class.getName()).log(Level.SEVERE, null, ex);
                    }
          }
      }.start();
    }   
  
    
    private void login()
    {
     generateLoginLabel();
     logging =  new Thread(){    
       public void run() {
         try {
            if(logined==false) {    
             
            LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
            AccountConfigFactory.createInstance("user.properties");
            //System.out.println(ObjectGraphMeasurer.measure("2 : "+AccountConfigFactory.getInstance()));
            AccountConfig conf= AccountConfigFactory.getInstance();
            System.out.println(" test :" + conf.getLogin() +  ":" + conf.getPass()+":"+conf.getServ());
            //Login log = new Login(conf.getLogin(), conf.getPass(), conf.getServ());
            if(login.getText().equals("") || haslo.getText().equals("")){
                status.setText("Nie prawidlowe dane logowanie"); return;
             }
            
            Login log = new Login(login.getText(), haslo.getText(), Integer.valueOf((String)serwer.getSelectedItem()));
            log.login();
            AccountConfigFactory.getInstance().loadWebProperty();
            //System.out.println(ObjectGraphMeasurer.measure("4: "+AccountConfigFactory.getInstance()));
            logined= true; 
            
            loadProperty(); 
            synchronized(executeQueue){
            System.out.println("notify");   
            executeQueue.notify();
            }
            }
            
        } catch (LoginException ex) {
            Logger.getLogger(BwBot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FailingHttpStatusCodeException ex) {
            Logger.getLogger(BwBot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(BwBot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BwBot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(BwBot.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
       };    
     logging.start();

    }
    
    private void hasloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hasloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hasloActionPerformed

    private void serwerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serwerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serwerActionPerformed

    private void setList(){
        listaZadan.setListData(queue.toList());
        
    }
    private void addQuest(){
        if(rWyprawaLatwa.isSelected())
        queue.add(new QueueElement(new Quest(Quest.STOPIEN.LATWY)));
        else if(rWyprawaSrednia.isSelected())
             queue.add(new QueueElement(new Quest(Quest.STOPIEN.NORMALNY)));
        else if(rWyprawaTrudna.isSelected())
            queue.add(new QueueElement(new Quest(Quest.STOPIEN.TRUDNY)));
    }
    
    private void addAttact(){
        
    }
    
    private void typeChange(java.awt.event.ActionEvent evt) {
        if(rAtak.isSelected()){
            rWyprawaLatwa.setEnabled(false);
            rWyprawaSrednia.setEnabled(false);
            rWyprawaTrudna.setEnabled(false);
        }else{
            rWyprawaLatwa.setEnabled(true);
            rWyprawaSrednia.setEnabled(true);
            rWyprawaTrudna.setEnabled(true);
        }
        if(rWyprawa.isSelected()){
            
        }else{
            
        }
            
    }
    
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
            java.util.logging.Logger.getLogger(BwBot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BwBot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BwBot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BwBot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new BwBot().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grupaTyp;
    private javax.swing.ButtonGroup grupaWyprawa;
    private javax.swing.JTextField haslo;
    private javax.swing.JTextField ileRazy;
    private javax.swing.JTextField jAtaki;
    private javax.swing.JTextField jKrew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLudzie;
    private javax.swing.JTextField jPieniadze;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JTextField jWyprawy;
    private javax.swing.JList listaZadan;
    private javax.swing.JTextField login;
    private javax.swing.JRadioButton rAtak;
    private javax.swing.JRadioButton rWyprawa;
    private javax.swing.JRadioButton rWyprawaLatwa;
    private javax.swing.JRadioButton rWyprawaSrednia;
    private javax.swing.JRadioButton rWyprawaTrudna;
    private javax.swing.JComboBox serwer;
    private javax.swing.JLabel status;
    private javax.swing.JLabel textWyprawy;
    // End of variables declaration//GEN-END:variables
    private Queue queue;
    private Integer ile;
    private boolean logined=false;


    Thread generateLabel;
    Thread logging;
    Thread executeQueue;
}
