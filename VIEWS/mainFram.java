

package VIEWS;

import MODELS.Utilisateur;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;


public class mainFram extends javax.swing.JFrame {


    Connection connection;
    Utilisateur user;
    GestionApprentisFram gestionApprentisFram;
    GestionStagiaireFram gestionStagiaireFram;
    VisiteMedicaleFram visiteMedicale;
    GestionComptesFram gestionComptesFram;
    GestionStages gestionStages;
    
    public mainFram() {
        initComponents();
        
    }
    
    public mainFram(Connection connection, Utilisateur user) {
        initComponents();
        this.connection = connection;
        this.user = user;
        this.initAffichage();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
      
    }  
    
    public void initAffichage(){
        this.jLabel2.setText(this.user.getUserID());
        this.jLabel4.setText(this.user.getTypeUtilisateur());
        
       /* if(this.user.getTypeUtilisateur().equals("Agent Direction"))
        {
            this.jToggleButton1.setVisible(false);
            this.jToggleButton2.setVisible(false);
            this.jToggleButton3.setVisible(false);
            this.jToggleButton6.setVisible(false);
            this.jToggleButton7.setVisible(false);
        }
        */
        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        this.jLabel7.setText(dtf.format(date).toString());
    }
    
      public void deconnecter()
    {
        this.dispose();
        Authentification userAuthentification = new Authentification (this.connection);
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jToggleButton7 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MAIN MENU");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESSOURCES/gtp.png"))); // NOI18N
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("BIENVENUE");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 255));
        jLabel12.setText("Dans l'application Gestion des stagiaires et apprentis");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(342, 342, 342)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(237, 237, 237))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel12))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 204));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("MENU PRINCIPALE");

        jToggleButton1.setBackground(new java.awt.Color(153, 204, 255));
        jToggleButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESSOURCES/apprenti_icon.png"))); // NOI18N
        jToggleButton1.setText("Gestion des Apprentis");
        jToggleButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToggleButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setBackground(new java.awt.Color(153, 204, 255));
        jToggleButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jToggleButton2.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESSOURCES/stagiaire_icon.png"))); // NOI18N
        jToggleButton2.setText("Gestion des Stagiaires");
        jToggleButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToggleButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setBackground(new java.awt.Color(153, 204, 255));
        jToggleButton3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jToggleButton3.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESSOURCES/9016848_doctor_examination_covid-19_virus_pandemic_icon.png"))); // NOI18N
        jToggleButton3.setText("Visite Médicale");
        jToggleButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToggleButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setBackground(new java.awt.Color(153, 204, 255));
        jToggleButton4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jToggleButton4.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESSOURCES/2142684_bullet_item_line_list_menu_icon.png"))); // NOI18N
        jToggleButton4.setText("Liste Apprentis Et Stagiaires");
        jToggleButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToggleButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jToggleButton6.setBackground(new java.awt.Color(153, 204, 255));
        jToggleButton6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jToggleButton6.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESSOURCES/2428662_account_agenda_app_contacts_online_icon.png"))); // NOI18N
        jToggleButton6.setText("Gestion des Comptes");
        jToggleButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToggleButton6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });

        jToggleButton7.setBackground(new java.awt.Color(153, 204, 255));
        jToggleButton7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jToggleButton7.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESSOURCES/2377635_business_chart_graph_marketing_report_icon.png"))); // NOI18N
        jToggleButton7.setText("Statistique");
        jToggleButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToggleButton7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jToggleButton5.setBackground(new java.awt.Color(153, 204, 255));
        jToggleButton5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jToggleButton5.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESSOURCES/2064489_certificate_education_learn_school_student_icon.png"))); // NOI18N
        jToggleButton5.setText("Gestion des Stages");
        jToggleButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToggleButton5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jToggleButton1, jToggleButton2, jToggleButton3, jToggleButton4, jToggleButton5, jToggleButton6, jToggleButton7});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jToggleButton1, jToggleButton2, jToggleButton3, jToggleButton4});

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        jToolBar1.setBackground(new java.awt.Color(0, 153, 204));
        jToolBar1.setRollover(true);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Id Utilisateur : ");
        jToolBar1.add(jLabel13);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("----------------   ");
        jToolBar1.add(jLabel2);
        jToolBar1.add(jSeparator1);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("  Type de compte : ");
        jToolBar1.add(jLabel3);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("-------------------");
        jToolBar1.add(jLabel4);

        jPanel4.setBackground(new java.awt.Color(0, 153, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jToolBar1.add(jPanel4);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(" Date d'authentification :");
        jToolBar1.add(jLabel5);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("-------------");
        jToolBar1.add(jLabel7);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setText("Deconnecter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.deconnecter();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        if(this.gestionApprentisFram==null)
        {
            gestionApprentisFram = new GestionApprentisFram(this,this.connection);
        }
        this.jPanel3.removeAll();
        this.jPanel3.setLayout(new BorderLayout());
        this.jPanel3.add(this.gestionApprentisFram, BorderLayout.CENTER);
        this.jPanel3.repaint();      
        this.jPanel3.validate();
        this.jToggleButton1.setSelected(true);
        this.jToggleButton2.setSelected(false);
        this.jToggleButton3.setSelected(false);
        this.jToggleButton4.setSelected(false);
        this.jToggleButton5.setSelected(false);
        this.jToggleButton6.setSelected(false);
        this.jToggleButton7.setSelected(false);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
         if(this.gestionStagiaireFram==null)
        {
            gestionStagiaireFram = new GestionStagiaireFram(this,this.connection);
        }
        this.jPanel3.removeAll();
        this.jPanel3.setLayout(new BorderLayout());
        this.jPanel3.add(this.gestionStagiaireFram, BorderLayout.CENTER);
        this.jPanel3.repaint();      
        this.jPanel3.validate();
        this.jToggleButton1.setSelected(false);
        this.jToggleButton2.setSelected(true);
        this.jToggleButton3.setSelected(false);
        this.jToggleButton4.setSelected(false);
        this.jToggleButton5.setSelected(false);
        this.jToggleButton6.setSelected(false);
        this.jToggleButton7.setSelected(false);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
         if(this.visiteMedicale==null)
        {
           visiteMedicale = new VisiteMedicaleFram(this,this.connection);
    

        }
     
        this.jPanel3.removeAll();
        this.jPanel3.setLayout(new BorderLayout());
        this.jPanel3.add(this.visiteMedicale, BorderLayout.CENTER);
        this.jPanel3.repaint();      
        this.jPanel3.validate();
        this.jToggleButton1.setSelected(false);
        this.jToggleButton2.setSelected(false);
        this.jToggleButton3.setSelected(true);
        this.jToggleButton4.setSelected(false);
        this.jToggleButton5.setSelected(false);
        this.jToggleButton6.setSelected(false);
        this.jToggleButton7.setSelected(false); 
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
        // TODO add your handling code here:
        if(this.gestionComptesFram==null)
        {
           gestionComptesFram = new GestionComptesFram(this,this.connection);
    

        }
     
        this.jPanel3.removeAll();
        this.jPanel3.setLayout(new BorderLayout());
        this.jPanel3.add(this.gestionComptesFram, BorderLayout.CENTER);
        this.jPanel3.repaint();      
        this.jPanel3.validate();
        this.jToggleButton1.setSelected(false);
        this.jToggleButton2.setSelected(false);
        this.jToggleButton3.setSelected(false);
        this.jToggleButton4.setSelected(false);
        this.jToggleButton5.setSelected(false);
        this.jToggleButton6.setSelected(true);
        this.jToggleButton7.setSelected(false); 
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        // TODO add your handling code here:
         if(this.gestionStages==null)
        {
          gestionStages=new GestionStages(this, this.connection);
    

        }
     
        this.jPanel3.removeAll();
        this.jPanel3.setLayout(new BorderLayout());
        this.jPanel3.add(this.gestionStages, BorderLayout.CENTER);
        this.jPanel3.repaint();      
        this.jPanel3.validate();
        this.jToggleButton1.setSelected(false);
        this.jToggleButton2.setSelected(false);
        this.jToggleButton3.setSelected(false);
        this.jToggleButton4.setSelected(false);
        this.jToggleButton5.setSelected(true);
        this.jToggleButton6.setSelected(false);
        this.jToggleButton7.setSelected(false); 
    }//GEN-LAST:event_jToggleButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(mainFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFram().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
