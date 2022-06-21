package dental_clinic;

import CoreClassess.DatabaseConnection;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TestForm extends javax.swing.JFrame {
     public Statement st;
   public ResultSet rs;
public DatabaseConnection db;
    public TestForm() {
        initComponents();
        this.centeringTheForm();
        db = new DatabaseConnection();
        this.loadTable("");
        clearAll();
    }

      public void loadTable(String key) {
       String query;
        if(key.equals("")==true)
            query ="select * from test";
        else
            query="SELECT  * from test where test_id like '%"+key+"%' or test_name like '%"+key+"%' or test_fee like '%"+key+"%'";
     
         int count,rowIndex=0;
            try {
             st = db.con.createStatement();
             rs=st.executeQuery(query);
            rs.next();
            rs.last();
            count=rs.getRow();// obtaining the number of rows in the table
            rs.beforeFirst();
             String Data[][] = new String[count][3];

             while(rs.next())
             {
                 Data[rowIndex][0] = String.valueOf(rs.getInt("test_id"));
                 Data[rowIndex][1]=rs.getString("test_name");
                 Data[rowIndex][2]=String.valueOf(rs.getInt("test_fee"));
                 rowIndex++;
             }
            String cols[] = {"ID","Name","Fee"};
             DefaultTableModel table = new DefaultTableModel(Data,cols);
             this.jTable1.setModel(table);}
       catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null,"No Records Found!"+ex.getMessage());
       }  
    }

    
public void clearAll(){
    this.idbox.setText("");
    this.namebox.setText("");
    this.feebox.setText(""); 
   this.deleteButton.setEnabled(false);
   this.updateButton.setEnabled(false);
  
     this.searchBox.setText("");
    this.loadTable("");
}
public  void centeringTheForm(){
    Dimension screenSize,frameSize;
            int x,y;
            screenSize=Toolkit.getDefaultToolkit().getScreenSize();
            frameSize=getSize();
            x=(screenSize.width-frameSize.width)/2;
            y=(screenSize.height-frameSize.height)/2;
            setLocation(x, y);
}

    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idbox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        namebox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        feebox = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        newbutton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        searchBox = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Tests");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridLayout(7, 2, 5, 5));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("ID");
        jPanel3.add(jLabel1);

        idbox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        idbox.setEnabled(false);
        jPanel3.add(idbox);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Test Name");
        jPanel3.add(jLabel2);

        namebox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel3.add(namebox);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Test Fee");
        jPanel3.add(jLabel3);

        feebox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel3.add(feebox);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 370, 290));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addButton.setText("Add");
        addButton.setBorderPainted(false);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel4.add(addButton);

        updateButton.setBackground(new java.awt.Color(255, 255, 255));
        updateButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateButton.setText("Update");
        updateButton.setBorderPainted(false);
        updateButton.setMaximumSize(new java.awt.Dimension(120, 31));
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        jPanel4.add(updateButton);

        deleteButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.setBorderPainted(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel4.add(deleteButton);

        newbutton.setBackground(new java.awt.Color(255, 255, 255));
        newbutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        newbutton.setText("New");
        newbutton.setBorderPainted(false);
        newbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newbuttonActionPerformed(evt);
            }
        });
        jPanel4.add(newbutton);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 390, 60));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Search");
        jPanel5.add(jLabel8);

        searchBox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        searchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchBoxKeyPressed(evt);
            }
        });
        jPanel5.add(searchBox);

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 380, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 610, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newbuttonActionPerformed
      this.clearAll();
        String newId="undefined";
        String query="select max(test_id+1) as id from test";
        try {
          st = db.con.createStatement();
         rs=st.executeQuery(query);
         if(rs.next())
         {
             newId = String.valueOf(rs.getInt("id"));
         }
         this.idbox.setText(newId);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Failed to retrieve new ID : "+ex);
        }
    }//GEN-LAST:event_newbuttonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    String test_id = this.idbox.getText();
       String name = this.namebox.getText();
       String fee =this.feebox.getText();
      
       if(test_id.equals("")==true || name.equals("")==true|| fee.equals("")==true)
       {
           JOptionPane.showMessageDialog(null,"Incomplete Form");
       }
       else {
        try {
        String query ="insert into test values ('"+test_id+"','"+name+"','"+fee+"')";
         st= db.con.createStatement();
         st.execute(query);
          JOptionPane.showMessageDialog(null,"Record Inserted successfully");
          clearAll();
          this.loadTable("");
          st.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Failed to insert the record"+ex.getMessage());
        }
          
       }
    }//GEN-LAST:event_addButtonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       String  patient_id = this.jTable1.getValueAt(this.jTable1.getSelectedRow(),0).toString();
        String query ="select * from test where test_id="+patient_id;
        try {
            st = db.con.createStatement();
            rs =st.executeQuery(query);
            rs.next();
            this.idbox.setText(rs.getInt("test_id")+"");
            this.namebox.setText(rs.getString("test_name"));
            this.feebox.setText(String.valueOf(rs.getInt("test_fee")));
          
            st.close();
            rs.close();
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        this.deleteButton.setEnabled(true);
        this.updateButton.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
     String id = this.idbox.getText();
       String name = this.namebox.getText();
       String fee =this.feebox.getText();
       if(id.equals("")==true || name.equals("")==true|| fee.equals("")==true)
       {
           JOptionPane.showMessageDialog(null,"Incomplete Form");
       }
       else {
        try {
        String query ="update  test set test_name='"+name+"', test_fee='"+fee+"' where test_id='"+id+"'";
         st= db.con.createStatement();
         st.execute(query);
          JOptionPane.showMessageDialog(null,"Record Updated successfully");
          clearAll();
          this.loadTable("");
          st.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Failed to Update  the record"+ex.getMessage());
        }
         
       }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
       String id=this.idbox.getText();
       if(id.equals("")==false)
       {
          String query = "delete from test where test_id='"+id+"'";
          try {
          st = db.con.createStatement();
          st.execute(query);
         JOptionPane.showMessageDialog(null,"Record deleted ");
         clearAll();
         this.loadTable("");
         st.close();
          }
          catch(Exception ex)
          {
          JOptionPane.showMessageDialog(null,"Counldn't delete the record");    
          }
          }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void searchBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBoxKeyPressed
            
          String key=this.searchBox.getText();
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
           this.loadTable(key);
        }
        else if(key.compareTo("")==0)
                {
                 this.loadTable("");
                }
    }//GEN-LAST:event_searchBoxKeyPressed

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
            java.util.logging.Logger.getLogger(TestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField feebox;
    private javax.swing.JTextField idbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField namebox;
    private javax.swing.JButton newbutton;
    private javax.swing.JTextField searchBox;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
