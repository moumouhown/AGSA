package VIEWS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class VisiteMedicaleFram extends javax.swing.JPanel {

    Connection connection;
    mainFram mainFram;

    public VisiteMedicaleFram(mainFram mainFram, Connection connection) {
        initComponents();
       
        this.mainFram = mainFram;
        this.connection = connection;

    }

    public void initAffichageListeVisiteSansDate() {
        try {
          
            Statement statement = this.connection.createStatement();
            
            String request = "from MAX_VISITE";
            ResultSet rs = statement.executeQuery("select count(*) " + request);

            int nbApprenti = 0;
            if (rs.next()) {
                nbApprenti = rs.getInt(1);

            }
            rs = statement.executeQuery("select idAS,nom,prenom "+ request);

            String[][] data = new String[nbApprenti][5];
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                data[i][3] = null;
                data[i][4] = null;

                i++;
            }

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    data,
                    new String[]{
                        "ID Apprenti", "Nom Apprenti", "Prénom Apprenti", "Date Visite", "Avis"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void initAffichageListeVisiteAvecDate() {
        try {
            Statement statement = this.connection.createStatement();
            String request1 = "from ApprentiStagiaire A inner join VisiteMedicale V on (a.idas=v.idas) "
                    + "where a.type_as='A' and dateVisite is not null and avis is null";
            ResultSet rs = statement.executeQuery("select count(*) " + request1);

            int nbApprenti = 0;
            if (rs.next()) {
                nbApprenti = rs.getInt(1);

            }
            rs = statement.executeQuery("select a.idAS,a.nom,a.prenom,V.DATEVISITE,v.avis " + request1);

            String[][] data = new String[nbApprenti][5];
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                data[i][3] = rs.getString(4).substring(0, 10);
                data[i][4] = rs.getString(5);

                i++;
            }

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    data,
                    new String[]{
                        "ID Apprenti", "Nom Apprenti", "Prénom Apprenti", "Date Visite", "Avis"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void initAffichageListeVisiteAvecDateEtAvis() {
        try {
            Statement statement = this.connection.createStatement();
            String request2 = "from ApprentiStagiaire A inner join VisiteMedicale V on (a.idas=v.idas) "
                    + "where a.type_as='A' and avis is not null";
            ResultSet rs = statement.executeQuery("select count(*)" + request2);

            int nbApprenti = 0;
            if (rs.next()) {
                nbApprenti = rs.getInt(1);

            }
            rs = statement.executeQuery("select a.idAS,a.nom,a.prenom,V.DATEVISITE,v.avis "
                    + request2);

            String[][] data = new String[nbApprenti][5];
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                data[i][3] = rs.getString(4).substring(0, 10);
                data[i][4] = rs.getString(5);

                i++;
            }
            
    
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    data,
                    new String[]{
                        "ID Apprenti", "Nom Apprenti", "Prénom Apprenti", "Date Visite", "Avis"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }



    public void AfficherVisite(String dateVisite, int index) {

        try {

            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery("select a.idAS,a.nom,a.prenom,V.DATEVISITE,v.avis "
                    + "from ApprentiStagiaire A left outer join VisiteMedicale V on (a.idas=v.idas) "
                    + "where a.type_as='A' and V.dateVisite= '" + dateVisite + "'");

            int nbApprentis = 0;
            while (rs.next()) {
                nbApprentis++;
            }

            rs = statement.executeQuery("select a.idAS,a.nom,a.prenom,V.DATEVISITE,v.avis "
                    + "from ApprentiStagiaire A left outer join VisiteMedicale V on (a.idas=v.idas) "
                    + "where a.type_as='A' and V.dateVisite= '" + dateVisite + "'");

            String[][] data = new String[nbApprentis][6];

            int i = 0;

            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                data[i][3] = rs.getString(4).substring(0, 10);
                data[i][4] = rs.getString(5);

                i++;
            }

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    data,
                    new String[]{
                        "ID Apprenti", "Nom Apprenti", "Prénom Apprenti", "Date Visite", "Avis"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void PlannifierVisite(int index) {
        String idApprenti = this.jTable1.getValueAt(index, 0).toString();
        String nom = this.jTable1.getValueAt(index, 1).toString();
        String prenom = this.jTable1.getValueAt(index, 2).toString();

        PlanifierVisite planifierVisite = new PlanifierVisite(mainFram, true, this, connection, idApprenti, nom, prenom);
    }

    public void AjouterAvis(int index) {
        String idApprenti = this.jTable1.getValueAt(index, 0).toString();
        String nom = this.jTable1.getValueAt(index, 1).toString();
        String prenom = this.jTable1.getValueAt(index, 2).toString();

        AjouterAvis ajouterAvis = new AjouterAvis(mainFram, true, this, connection, idApprenti, nom, prenom);
    }
   
    public void ModifierDate(int index) {
        String idApprenti = this.jTable1.getValueAt(index, 0).toString();
        String nom = this.jTable1.getValueAt(index, 1).toString();
        String prenom = this.jTable1.getValueAt(index, 2).toString();

        ModifierDate modifierDate=new ModifierDate(mainFram, true,this,connection,idApprenti, nom, prenom);
    }
    
     public void supprimerVisite(int index)
    {
        String idApprenti = this.jTable1.getValueAt(index, 0).toString();
        String nom = this.jTable1.getValueAt(index, 1).toString();
        String prenom = this.jTable1.getValueAt(index, 2).toString();
        String ID_VISITE="";
        
          try
                {


            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery("select idVisite  from VisiteMedicale where idas='"+idApprenti+"'");
            
            if (rs.next())
            {
                 ID_VISITE=rs.getString(1);
  
            }
 
            }

        catch(Exception ex)
         {
           ex.printStackTrace();
         }
        
        
        if (JOptionPane.showConfirmDialog(null,"voulez-vous vraiment supprimer la Visite Medicale ID : "+ID_VISITE+" "+nom+" "+prenom,"WARNING",
                JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION)
        {
            //yes option 
             try
        {
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery("delete from VisiteMedicale where idVisite = '"+ID_VISITE+"'");
   
            this.initAffichageListeVisiteSansDate();
            JOptionPane.showMessageDialog(this,"Visite a été bein supprimé de la BD","information",JOptionPane.INFORMATION_MESSAGE);
            
            
        }
        catch(Exception ex)
         {
           JOptionPane.showConfirmDialog(this,"Erreur: Veuillez contacter votre administrateur\n"+ex.toString(),"Erreur", JOptionPane.ERROR_MESSAGE);
           
         }
       
            
            
            
        }
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESSOURCES/1814113_add_more_plus_icon.png"))); // NOI18N
        jMenuItem1.setText("Ajouter Avis");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESSOURCES/5402373_write_modify_tool_edit_pen_icon.png"))); // NOI18N
        jMenuItem2.setText("Modifier Date");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESSOURCES/1814090_delete_garbage_trash_icon.png"))); // NOI18N
        jMenuItem3.setText("Supprimer Visite");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RESSOURCES/1290990_doctor_drug_healthcare_medical_medicine_icon.png"))); // NOI18N
        jLabel1.setText("Visite Médicale");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Apprenti", "Nom Apprenti", "Prénom Apprenti", "Date Visite", "Avis"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Date :");

        jFormattedTextField1.setEditable(false);
        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.LONG))));
        jFormattedTextField1.setToolTipText("");
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("chercher");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Plannifier Date Visite");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("(DD/MM/YYYY)");

        jToggleButton1.setText("Actualiser la liste");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sans Date\t", "Avec Date ", "Avec Date+Avis" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Liste Apprentis :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton1)
                        .addGap(0, 225, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel3)
                    .addComponent(jButton2)
                    .addComponent(jToggleButton1))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Visite Médicale", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("jfz!");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        // TODO add your handling code here:
        int index = this.jTable1.getSelectedRow();
        if (index != -1) {
            this.PlannifierVisite(index);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        this.initAffichageListeVisiteSansDate();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int index = this.jTable1.getSelectedRow();
        if (index != -1) {
            this.AjouterAvis(index);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int index = this.jTable1.getSelectedRow();
        if (index != -1) {
            String id = this.jTable1.getValueAt(index, 0).toString();

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String dateVisite = this.jFormattedTextField1.getText();
        int index = this.jComboBox1.getSelectedIndex();
        this.AfficherVisite(dateVisite,index);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        int index = this.jTable1.getSelectedRow();
        if (index != -1) {
           this.supprimerVisite(index);
        }
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
         int index = this.jTable1.getSelectedRow();
        if (index != -1) {
            this.ModifierDate(index);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        int index = this.jComboBox1.getSelectedIndex();
        if(index == 0)
        {
            this.initAffichageListeVisiteSansDate();
        }
        else if(index == 1)
            {
              this.initAffichageListeVisiteAvecDate();
              this.jFormattedTextField1.setEditable(true);
              this.jButton1.setEnabled(true);
              
            }
        else if(index == 2)
        {
            this.initAffichageListeVisiteAvecDateEtAvis();
            this.jFormattedTextField1.setEditable(true);
            this.jButton1.setEnabled(true);
              
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
