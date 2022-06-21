
package dental_clinic;

import CoreClassess.DatabaseConnection;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SelectDrugForm extends javax.swing.JFrame {
 public Statement st;
   public ResultSet rs;
public DatabaseConnection db;
public String drug_id;
    public SelectDrugForm() {
        initComponents();
        this.centeringTheForm();
        db = new DatabaseConnection();
        this.loadTable("");
        clearAll();
    }
    
    public void loadTable(String key) {
       String query;
        if(key.equals("")==true)
            query ="select * from drug";
        else
         query="SELECT  * from drug where drug_id like '%"+key+"%' or drug_name like '%"+key+"%' or drug_description like '%"+key+"%' or drug_fee like '%"+key+"%' ";
     
         int count,rowIndex=0;
            try {
             st = db.con.createStatement();
             rs=st.executeQuery(query);
            rs.next();
            rs.last();
            count=rs.getRow();// obtaining the number of rows in the table
            rs.beforeFirst();
             String Data[][] = new String[count][4];

             while(rs.next())
             {
                 Data[rowIndex][0] = String.valueOf(rs.getInt("drug_id"));
                 Data[rowIndex][1]=rs.getString("drug_name");
                 Data[rowIndex][2]=rs.getString("drug_description");
                 Data[rowIndex][3]=rs.getString("drug_fee");
                 rowIndex++;
             }
            String cols[] = {"ID","Name","Description","Fee"};
             DefaultTableModel table = new DefaultTableModel(Data,cols);
             this.jTable1.setModel(table);}
       catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null,"No Records Found!"+ex.getMessage());
       }
    }

    
public void clearAll(){
   
     this.searchbox.setText("");
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

        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        searchbox = new javax.swing.JTextField();
        selectButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Select Drug Form");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setLayout(new java.awt.GridLayout(1, 10, 10, 10));

        jLabel8.setText("Search");
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel5.add(jLabel8);

        searchbox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchboxKeyPressed(evt);
            }
        });
        jPanel5.add(searchbox);

        selectButton.setBackground(new java.awt.Color(0, 102, 102));
        selectButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        selectButton.setForeground(new java.awt.Color(255, 255, 255));
        selectButton.setText("Select");
        selectButton.setEnabled(false);
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });
        jPanel5.add(selectButton);

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
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    this.drug_id = this.jTable1.getValueAt(this.jTable1.getSelectedRow(),0).toString();
    this.selectButton.setEnabled(true);
       
    }//GEN-LAST:event_jTable1MouseClicked

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

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        BookForm.drug_id=this.drug_id+"";
        this.dispose();
    }//GEN-LAST:event_selectButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SelectDrugForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectDrugForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectDrugForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectDrugForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectDrugForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchbox;
    private javax.swing.JButton selectButton;
    // End of variables declaration//GEN-END:variables
}
