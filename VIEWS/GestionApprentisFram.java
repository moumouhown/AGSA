
package VIEWS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GestionApprentisFram extends javax.swing.JPanel {

    Connection connection;
    mainFram mainFram;
    
    
    public GestionApprentisFram(mainFram mainFram, Connection connection) {
        initComponents();
        this.mainFram = mainFram;
        this.connection = connection;
        
        
        initAffichage();
    }
    
    public void initAffichage()
    {
        this.initAffichageListeApprenti();
    }
    
    public void initAffichageListeApprenti()
    {
        try
        {
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from ApprentiStagiaire where type_as='A'");
            int nbApprenti = 0;
            while (rs.next())
            {
                nbApprenti++;
            }
            rs = statement.executeQuery("select * from ApprentiStagiaire where type_as='A'");
            
            String [][] data = new String [nbApprenti][4];
            int i =0;
            while(rs.next())
            {
                data[i][0]= rs.getString(1);
                data[i][1]= rs.getString(2);
                data[i][2]= rs.getString(3);
                data[i][3]= rs.getString(6);
                i++;
            }
              jTable1.setModel(new javax.swing.table.DefaultTableModel(
            data,
            new String [] {
                "ID Apprenti", "Nom", "Prénom", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
            
        }
        catch(Exception ex)
         {
           ex.printStackTrace();
         }
        
        
    }
    
    
    public void supprimerApprenti(int index)
    {
        String idApprenti = this.jTable1.getValueAt(index, 0).toString();
        String nom = this.jTable1.getValueAt(index, 1).toString();
        String prenom = this.jTable1.getValueAt(index, 2).toString();
        
        
        if (JOptionPane.showConfirmDialog(null,"voulez-vous vraiment supprimer l'apprenti ID : "+idApprenti+" "+nom+" "+prenom,"WARNING",
                JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION)
        {
            //yes option 
             try
        {
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery("delete from ApprentiStagiaire where IDAS = '"+idApprenti+"'");
        
            
            this.initAffichageListeApprenti();
            JOptionPane.showMessageDialog(this,"Apprenti a été bein supprimé de la BD","information",JOptionPane.INFORMATION_MESSAGE);
            
            
        }
        catch(Exception ex)
         {
           JOptionPane.showConfirmDialog(this,"Erreur: Veuillez contacter votre administrateur\n"+ex.toString(),"Erreur", JOptionPane.ERROR_MESSAGE);
           
         }
       
            
            
            
        }
    }
    
    public void modifierApprenti(int index)
    {
        String idApprenti = this.jTable1.getValueAt(index, 0).toString();
      
        ModifierApprentiFram modifierapprenti = new ModifierApprentiFram(mainFram, true, this, connection, idApprenti);
    }
    
    public void detailsApprenti(int index)
    {
       String idApprenti = this.jTable1.getValueAt(index, 0).toString();
       ConsulterDetailsApprentiFram consulterapprenti = new ConsulterDetailsApprentiFram(mainFram, true, this, connection, idApprenti);
       
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESSOURCES/24335_details_information_icon.png"))); // NOI18N
        jMenuItem2.setText("Consulter");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem2);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESSOURCES/5402373_write_modify_tool_edit_pen_icon.png"))); // NOI18N
        jMenuItem1.setText("Modifier");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem1);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESSOURCES/49612_delete_male_icon.png"))); // NOI18N
        jMenuItem3.setText("Supprimer");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem3);

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        jLabel2.setBackground(new java.awt.Color(0, 153, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESSOURCES/3533401_company_cooperation_group_partnership_team_icon.png"))); // NOI18N
        jLabel2.setText("Gestion des apprentis");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESSOURCES/1814113_add_more_plus_icon.png"))); // NOI18N
        jButton1.setText("Ajouter apprenti");
        jButton1.setFocusable(false);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESSOURCES/1814075_find_magnifier_magnifying glass_search_icon.png"))); // NOI18N
        jButton2.setText("Chercher apprenti");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESSOURCES/5402417_refresh_rotate_sync_update_reload_icon.png"))); // NOI18N
        jButton3.setText("Actualiser la liste des apprentis");
        jButton3.setFocusable(false);
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Apprenti", "Nom", "Prénom", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setComponentPopupMenu(jPopupMenu2);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Liste des Apprentis", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AjouterApprentiFram ajoutApprentiFram = new AjouterApprentiFram(this.mainFram, true, this,this.connection);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int index= this.jTable1.getSelectedRow();
        if(index != -1)
        {
            String id = this.jTable1.getValueAt(index,0).toString();
            
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.initAffichageListeApprenti();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         RechercherApprentiFram rechercherapprenti = new RechercherApprentiFram(mainFram, true, connection);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int index = this.jTable1.getSelectedRow();
        if(index != -1)
        {
            this.modifierApprenti(index);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        int index = this.jTable1.getSelectedRow();
        if(index != -1)
        {
            this.supprimerApprenti(index);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        int index = this.jTable1.getSelectedRow();
        if(index != -1)
        {
            this.detailsApprenti(index);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
