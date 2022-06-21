
package dental_clinic;

import CoreClassess.DatabaseConnection;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PatientForm extends javax.swing.JFrame {
 public Statement st;
   public ResultSet rs;
public DatabaseConnection db;
public String patient_id;
    public PatientForm() {
        initComponents();
        this.centeringTheForm();
        db = new DatabaseConnection();
        this.loadTable("");
        clearAll();
    }
    
    public void loadTable(String key) {
       String query;
        if(key.equals("")==true)
            query ="select * from patient";
        else
            query="SELECT  * from patient where patient_id like '%"+key+"%' or patient_name like '%"+key+"%' or patient_fname like '%"+key+"%' or patient_nic like '%"+key+"%' or patient_contact like '%"+key+"%' or patient_address like '%"+key+"%' or patient_dob like '%"+key+"%' ";
     
         int count,rowIndex=0;
            try {
             st = db.con.createStatement();
             rs=st.executeQuery(query);
            rs.next();
            rs.last();
            count=rs.getRow();// obtaining the number of rows in the table
            rs.beforeFirst();
             String Data[][] = new String[count][7];

             while(rs.next())
             {
                 Data[rowIndex][0] = String.valueOf(rs.getInt("patient_id"));
                 Data[rowIndex][1]=rs.getString("patient_name");
                 Data[rowIndex][2]=rs.getString("patient_fname");
                 Data[rowIndex][3]=rs.getString("patient_contact");
                 Data[rowIndex][4]=rs.getString("patient_address");
                 Data[rowIndex][5]=rs.getString("patient_nic");
                 Data[rowIndex][6]=rs.getDate("patient_dob").toString();
                 rowIndex++;
             }
            String cols[] = {"ID","Name","FatherName","Contact","Address","NIC","DOB"};
             DefaultTableModel table = new DefaultTableModel(Data,cols);
             this.jTable1.setModel(table);}
       catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null,"No Records Found!"+ex.getMessage());
       }  
    }

    
public void clearAll(){
    this.namebox.setText("");
    this.fathernamebox.setText("");
    this.contactbox.setText(""); 
   this.deleteButton.setEnabled(false);
   this.updatebutton.setEnabled(false);
  this.addressbox.setText("");
  this.nicbox.setText("");
     this.searchbox.setText("");
     this.dobbox.setDateToToday();
     
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
        fathernamebox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nicbox = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        contactbox = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        addressbox = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dobbox = new com.github.lgooddatepicker.components.DatePicker();
        jPanel4 = new javax.swing.JPanel();
        addbutton = new javax.swing.JButton();
        updatebutton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        searchbox = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Patient");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1090, 600));
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

        idbox.setEnabled(false);
        idbox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel3.add(idbox);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Name");
        jPanel3.add(jLabel2);

        namebox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel3.add(namebox);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Father Name");
        jPanel3.add(jLabel3);

        fathernamebox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel3.add(fathernamebox);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("NIC Number");
        jPanel3.add(jLabel4);

        nicbox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel3.add(nicbox);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Contact");
        jPanel3.add(jLabel5);

        contactbox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel3.add(contactbox);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Address");
        jPanel3.add(jLabel6);

        addressbox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel3.add(addressbox);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Date of Birth");
        jPanel3.add(jLabel7);
        jPanel3.add(dobbox);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 360, 310));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        addbutton.setText("Add");
        addbutton.setBackground(new java.awt.Color(255, 255, 255));
        addbutton.setBorderPainted(false);
        addbutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbuttonActionPerformed(evt);
            }
        });
        jPanel4.add(addbutton);

        updatebutton.setText("Update");
        updatebutton.setBackground(new java.awt.Color(255, 255, 255));
        updatebutton.setBorderPainted(false);
        updatebutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updatebutton.setMaximumSize(new java.awt.Dimension(120, 31));
        updatebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatebuttonMouseClicked(evt);
            }
        });
        jPanel4.add(updatebutton);

        deleteButton.setText("Delete");
        deleteButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteButton.setBorderPainted(false);
        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
        });
        jPanel4.add(deleteButton);

        newButton.setText("New");
        newButton.setBackground(new java.awt.Color(255, 255, 255));
        newButton.setBorderPainted(false);
        newButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });
        jPanel4.add(newButton);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 390, 60));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Search");
        jPanel5.add(jLabel8);

        searchbox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchboxKeyPressed(evt);
            }
        });
        jPanel5.add(searchbox);

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

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        this.clearAll();
        String newId="undefined";
        String query="select max(patient_id+1) as id from patient";
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
    }//GEN-LAST:event_newButtonActionPerformed

    private void addbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbuttonActionPerformed
      String patient_id = this.idbox.getText();
       String name = this.namebox.getText();
       String fathername =this.fathernamebox.getText();
       String contact = this.contactbox.getText();
       String address =this.addressbox.getText();
       String nic =this.nicbox.getText();
       String dob =this.dobbox.getDate().toString();
       if(patient_id.equals("")==true || name.equals("")==true|| fathername.equals("")==true|| contact.equals("")==true|| address.equals("")==true|| nic.equals("")==true|| dob.equals("")==true)
       {
           JOptionPane.showMessageDialog(null,"Incomplete Form");
       }
       else {
        try {
        String query ="insert into patient values ('"+patient_id+"','"+name+"','"+fathername+"','"+nic+"','"+contact+"','"+address+"','"+dob+"')";
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
    }//GEN-LAST:event_addbuttonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    String  patient_id = this.jTable1.getValueAt(this.jTable1.getSelectedRow(),0).toString();
        String query ="select * from patient where patient_id="+patient_id;
        try {
            st = db.con.createStatement();
            rs =st.executeQuery(query);
            rs.next();
            this.idbox.setText(rs.getInt("patient_id")+"");
            this.namebox.setText(rs.getString("patient_name"));
            this.fathernamebox.setText(rs.getString("patient_fname"));
            this.contactbox.setText(rs.getString("patient_contact"));
            this.addressbox.setText(rs.getString("patient_address"));      
            this.nicbox.setText(rs.getString("patient_nic"));
            this.dobbox.setDate(rs.getDate("patient_dob").toLocalDate());
          
            st.close();
            rs.close();
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        this.deleteButton.setEnabled(true);
        this.updatebutton.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void updatebuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebuttonMouseClicked
       
      String patient_id = this.idbox.getText();
       String name = this.namebox.getText();
       String fathername =this.fathernamebox.getText();
       String contact = this.contactbox.getText();
       String address =this.addressbox.getText();
       String nic =this.nicbox.getText();
       String dob =this.dobbox.getDate().toString();
       if(patient_id.equals("")==true || name.equals("")==true|| fathername.equals("")==true|| contact.equals("")==true|| address.equals("")==true|| nic.equals("")==true|| dob.equals("")==true)
       {
           JOptionPane.showMessageDialog(null,"Incomplete Form");
       }
       else {
        try {
        String query ="update  patient set patient_name='"+name+"', patient_fname='"+fathername+"', patient_nic='"+nic+"', patient_contact='"+contact+"',patient_address='"+address+"',patient_dob='"+dob+"' where patient_id='"+patient_id+"'";
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
    }//GEN-LAST:event_updatebuttonMouseClicked

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
      String patient_id=this.idbox.getText();
       if(patient_id.equals("")==false)
       {
          String query = "delete from patient where patient_id='"+patient_id+"'";
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
    }//GEN-LAST:event_deleteButtonMouseClicked

    private void searchboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyPressed
          String key=this.searchbox.getText();
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
           this.loadTable(key);
        }
        else if(key.compareTo("")==0)
                {
                 this.loadTable("");
                }
    }//GEN-LAST:event_searchboxKeyPressed

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
            java.util.logging.Logger.getLogger(PatientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbutton;
    private javax.swing.JTextField addressbox;
    private javax.swing.JTextField contactbox;
    private javax.swing.JButton deleteButton;
    private com.github.lgooddatepicker.components.DatePicker dobbox;
    private javax.swing.JTextField fathernamebox;
    private javax.swing.JTextField idbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField namebox;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField nicbox;
    private javax.swing.JTextField searchbox;
    private javax.swing.JButton updatebutton;
    // End of variables declaration//GEN-END:variables
}
