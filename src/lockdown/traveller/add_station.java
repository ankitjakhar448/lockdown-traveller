/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lockdown.traveller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static lockdown.traveller.jdbc.getConnection;

/**
 *
 * @author Lenovo
 */
public class add_station extends javax.swing.JFrame {

    /**
     * Creates new form add_station
     */
    public add_station() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        add_station = new javax.swing.JButton();
        show_station = new javax.swing.JButton();
        first = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        add_path = new javax.swing.JButton();
        second = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        distance = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        time = new javax.swing.JTextField();
        logout = new javax.swing.JButton();
        add_train = new javax.swing.JButton();
        find_train = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Add Stations");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Name");

        name.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add_station.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        add_station.setText("Add");
        add_station.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_stationActionPerformed(evt);
            }
        });

        show_station.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        show_station.setText("show");
        show_station.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_stationActionPerformed(evt);
            }
        });

        first.setEditable(false);
        first.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("To");

        add_path.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        add_path.setText("Add path");
        add_path.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_pathActionPerformed(evt);
            }
        });

        second.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        second.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Distance(in KM)");

        distance.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Time(in minutes)");

        time.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        logout.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        add_train.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        add_train.setText("Add Train");
        add_train.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_trainActionPerformed(evt);
            }
        });

        find_train.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        find_train.setText("Find Train");
        find_train.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                find_trainActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(add_station))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(show_station))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(add_path))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(first, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(second, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(time))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(distance, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(add_train, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(find_train, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(show_station)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addComponent(add_station)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(first, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(second, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(add_path))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(distance, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_train, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(find_train, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_stationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_stationActionPerformed
        // TODO add your handling code here:
        String Name=name.getText().toString();
        try {
            Connection con=station_db.getConnection();
            station_db.createTable();
            station_db.post(Name);
            
             ArrayList<String> array=new ArrayList<String>();
        jTable1.setModel(new DefaultTableModel(null,new String[]{"id","station name"}));
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        




        try{
            
            PreparedStatement statement=con.prepareStatement("SELECT * FROM station");
            ResultSet result=statement.executeQuery();
            
            
            while(result.next())
            {
                
                array.add(result.getString("id"));
                array.add(result.getString("name"));
                model.addRow(array.toArray());

               
                
                array.clear();
                
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
            
            
        } catch (Exception ex) {
            Logger.getLogger(train_reg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_add_stationActionPerformed

    private void show_stationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_stationActionPerformed
        // TODO add your handling code here:
        ArrayList<String> array=new ArrayList<String>();
        jTable1.setModel(new DefaultTableModel(null,new String[]{"id","station name"}));
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        




        try{
            Connection con=jdbc.getConnection();
            PreparedStatement statement=con.prepareStatement("SELECT * FROM station");
            ResultSet result=statement.executeQuery();
            
            
            while(result.next())
            {
                
                array.add(result.getString("id"));
                array.add(result.getString("name"));
                model.addRow(array.toArray());

               
                
                array.clear();
                
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_show_stationActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        int i=jTable1.getSelectedRow();
        TableModel model=jTable1.getModel();
        first.setText(model.getValueAt(i, 1).toString());
        
        
        ArrayList<String> array=new ArrayList<String>();
        jTable1.setModel(new DefaultTableModel(null,new String[]{"first","second","distance","time"}));
        DefaultTableModel model1 = (DefaultTableModel)jTable1.getModel();
        




        try{
            Connection con=getConnection();
            PreparedStatement statement=con.prepareStatement("SELECT * FROM path WHERE first='"+first.getText().toString()+"' or second='"+first.getText().toString()+"'");
            ResultSet result=statement.executeQuery();
            
            
            while(result.next())
            {
                
                array.add(result.getString("first"));
                array.add(result.getString("second"));
                array.add(result.getString("distance"));
                array.add(result.getString("time"));
                model1.addRow(array.toArray());

               
                
                array.clear();
                
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        
        try{
            Connection con=getConnection();
            PreparedStatement statement=con.prepareStatement("SELECT * FROM station WHERE name !='"+first.getText().toString()+"'");
            ResultSet result=statement.executeQuery();
            
            second.removeAllItems();
           second.addItem("select");
            while(result.next())
            {
                
                
                second.addItem(result.getString("name"));
               
                
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void add_pathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_pathActionPerformed
        // TODO add your handling code here:
        if(second.getSelectedItem().toString()=="select")
        {
            
        }
        else
        {
            
            try {
                Connection con=getConnection();
                station_db.createPathTable();
                PreparedStatement statement1=con.prepareStatement("SELECT * FROM path WHERE first='"+first.getText().toString()+"' AND second='"+second.getSelectedItem().toString()+"'");
                PreparedStatement statement2=con.prepareStatement("SELECT * FROM path WHERE second='"+first.getText().toString()+"' AND first='"+second.getSelectedItem().toString()+"'");
                ResultSet result1=statement1.executeQuery();
                ResultSet result2=statement2.executeQuery();
                if(result1.next()&&!distance.getText().toString().trim().equals("")&&!time.getText().toString().trim().equals(""))
                {
                    
                }
                else if(result2.next())
                {
                    
                }
                else
                {
                    station_db.pathpost(first.getText().toString(),second.getSelectedItem().toString(),Integer.parseInt(distance.getText().toString()),Integer.parseInt(time.getText().toString()));
                }
            
                
                
                
                
                
            } catch (Exception ex) {
                Logger.getLogger(add_station.class.getName()).log(Level.SEVERE, null, ex);
            }
            ArrayList<String> array=new ArrayList<String>();
        jTable1.setModel(new DefaultTableModel(null,new String[]{"first","second","distance","time"}));
        DefaultTableModel model1 = (DefaultTableModel)jTable1.getModel();
        




        try{
            Connection con=getConnection();
            PreparedStatement statement=con.prepareStatement("SELECT * FROM path WHERE first='"+first.getText().toString()+"' or second='"+first.getText().toString()+"'");
            ResultSet result=statement.executeQuery();
            
            
            while(result.next())
            {
                
                array.add(result.getString("first"));
                array.add(result.getString("second"));
                array.add(result.getString("distance"));
                array.add(result.getString("time"));
                model1.addRow(array.toArray());

               
                
                array.clear();
                
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        }
    }//GEN-LAST:event_add_pathActionPerformed

    private void add_trainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_trainActionPerformed
        // TODO add your handling code here:
        
                add_train newdisplay=new add_train();
                newdisplay.setVisible(true);
                newdisplay.pack();
                newdisplay.setLocationRelativeTo(null);
                this.dispose();
    }//GEN-LAST:event_add_trainActionPerformed

    private void find_trainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_find_trainActionPerformed
        // TODO add your handling code here:
        find_train newdisplay=new find_train();
                newdisplay.setVisible(true);
                newdisplay.pack();
                newdisplay.setLocationRelativeTo(null);
                this.dispose();
    }//GEN-LAST:event_find_trainActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        login reg=new login();
                reg.setVisible(true);
                reg.pack();
                reg.setLocationRelativeTo(null);
                this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

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
            java.util.logging.Logger.getLogger(add_station.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_station.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_station.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_station.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_station().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_path;
    private javax.swing.JButton add_station;
    private javax.swing.JButton add_train;
    private javax.swing.JTextField distance;
    private javax.swing.JButton find_train;
    private javax.swing.JTextField first;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logout;
    private javax.swing.JTextField name;
    private javax.swing.JComboBox<String> second;
    private javax.swing.JButton show_station;
    private javax.swing.JTextField time;
    // End of variables declaration//GEN-END:variables
}
