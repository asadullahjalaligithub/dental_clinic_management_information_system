

package dental_clinic;

import CoreClassess.DatabaseConnection;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookForm extends javax.swing.JFrame {
    public Statement st;
   public ResultSet rs;
public DatabaseConnection db;
public static String patient_id;
public static String drug_id="";
public static String ward_id="";
public static String treatment_id="";
public static String docter_id="";
public static String test_id="";
DefaultTableModel TableObject ;
 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    public BookForm() {
        initComponents();
         
        db = new DatabaseConnection(); 
        clearAll();
    }
    public void clearAll(){
       this.idbox.setText("");
       this.teethcountbox.setText("");
      clearStaticVariables();
      this.clearJTable(this.drugTable);
      this.clearJTable(this.testTable);
      this.clearJTable(this.wardTable);
      this.clearJTable(this.treatmentTable);
    this.selectDocterLabel.setText("Select...");
    this.selectpatientlabel.setText("Select...");
   this.deleteButton.setEnabled(false);
   this.updateButton.setEnabled(false);
   this.insertButton.setEnabled(false);
   this.selectDate.setDate(null);
    }
    
    public boolean checkDubplicateValueInJtables(JTable TableName,String key){
         for(int i=0;i<TableName.getRowCount();i++)
        if(String.valueOf(TableName.getValueAt(i,0)).equals(key)==true)
             return true;
        return false;    
    }
    public void clearStaticVariables(){
        BookForm.ward_id="";
        BookForm.drug_id="";
        BookForm.test_id="";
        BookForm.treatment_id="";
        BookForm.patient_id="";
        BookForm.docter_id="";
    }
    public void loadWard(String key){
       TableObject = (DefaultTableModel) wardTable.getModel();
        try {
              String query = "select * from ward where ward_id='"+key+"'";
            st = db.con.createStatement();
             rs=st.executeQuery(query); 
             
       //     JOptionPane.showMessageDialog(null,query);
             if(rs.next())
             {
                 if(this.checkDubplicateValueInJtables(wardTable, key)==false)
                 {
                String name = rs.getString("ward_name");
                String description = rs.getString("ward_description");
             
                TableObject.addRow(new Object[]{key,name,description});
                this.wardTable.setModel(TableObject);
                 }
                 else 
                 {
                     JOptionPane.showMessageDialog(null,"The Drug is already selected");
                 }
       this.clearStaticVariables();
             }
         }
        catch(Exception ex)
        {
                JOptionPane.showMessageDialog(null,"Failed to select the record!"+ex.getMessage());
       
        }  
   
    }
    public void loadTest(String key){
        
       TableObject = (DefaultTableModel) testTable.getModel();
        try {
              String query = "select * from test where test_id='"+key+"'";
            st = db.con.createStatement();
             rs=st.executeQuery(query); 
             
       //     JOptionPane.showMessageDialog(null,query);
             if(rs.next())
             {
                 if(this.checkDubplicateValueInJtables(testTable, key)==false)
                 {
                String Name = rs.getString("test_name");
                String Fee = rs.getInt("test_fee")+"";
             
                TableObject.addRow(new Object[]{key,Name,Fee});
                this.testTable.setModel(TableObject);
                 }
                 else 
                 {
                     JOptionPane.showMessageDialog(null,"The Test is already selected");
                 }
       this.clearStaticVariables();
             }
         }
        catch(Exception ex)
        {
                JOptionPane.showMessageDialog(null,"Failed to select the record!"+ex.getMessage());
       
        }  
   
    }
    public void loadTreatment(String key){
   
       TableObject = (DefaultTableModel) treatmentTable.getModel();
        try {
              String query = "select * from treatment where treatment_id='"+key+"'";
            st = db.con.createStatement();
             rs=st.executeQuery(query); 
             
       //     JOptionPane.showMessageDialog(null,query);
             if(rs.next())
             {
                 if(this.checkDubplicateValueInJtables(treatmentTable, key)==false)
                 {
                String name = rs.getString("treatment_name");
                String description = rs.getString("treatment_description");
                String fee = rs.getInt("treatment_fee")+"";
             
                TableObject.addRow(new Object[]{key,name,description,fee});
                this.treatmentTable.setModel(TableObject);
                 }
                 else 
                 {
                     JOptionPane.showMessageDialog(null,"The treatment is already selected");
                 }
       this.clearStaticVariables();
             }
         }
        catch(Exception ex)
        {
                JOptionPane.showMessageDialog(null,"Failed to select the record!"+ex.getMessage());
       
        }  
   
    }
   public void loadDrug(String key) {
     
       TableObject = (DefaultTableModel) drugTable.getModel();
        try {
              String query = "select * from drug where drug_id='"+key+"'";
            st = db.con.createStatement();
             rs=st.executeQuery(query); 
             
       //     JOptionPane.showMessageDialog(null,query);
             if(rs.next())
             {
                 if(this.checkDubplicateValueInJtables(drugTable, key)==false)
                 {
                String name = rs.getString("drug_name");
                String description = rs.getString("drug_description");
                String fee = rs.getInt("drug_fee")+"";
             
                TableObject.addRow(new Object[]{key,name,description,fee});
                this.drugTable.setModel(TableObject);
                 }
                 else 
                 {
                     JOptionPane.showMessageDialog(null,"The drug is already selected");
                 }
       this.clearStaticVariables();
             }
         }
        catch(Exception ex)
        {
                JOptionPane.showMessageDialog(null,"Failed to select the record!"+ex.getMessage());
       
    }
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idbox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        selectDate = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        selectpatientlabel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        selectDocterLabel = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        teethcountbox = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        drugTable = new javax.swing.JTable();
        clearDrugTable = new javax.swing.JButton();
        selectDrugButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        wardTable = new javax.swing.JTable();
        clearWardTable = new javax.swing.JButton();
        selectWardButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        testTable = new javax.swing.JTable();
        clearTestTable = new javax.swing.JButton();
        selectTestButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        treatmentTable = new javax.swing.JTable();
        clearTreatmentTable = new javax.swing.JButton();
        selectTreatmentButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        insertButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        searchBox = new javax.swing.JTextField();
        newButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Patient");

        idbox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        idbox.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Date");

        selectDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Book ID");

        selectpatientlabel.setBackground(new java.awt.Color(0, 102, 102));
        selectpatientlabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        selectpatientlabel.setForeground(new java.awt.Color(255, 255, 255));
        selectpatientlabel.setText("Select...");
        selectpatientlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectpatientlabelMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Docter");

        selectDocterLabel.setBackground(new java.awt.Color(0, 102, 102));
        selectDocterLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        selectDocterLabel.setForeground(new java.awt.Color(255, 255, 255));
        selectDocterLabel.setText("Select...");
        selectDocterLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectDocterLabelMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Teeth Count");

        teethcountbox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idbox, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectDate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectpatientlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectDocterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(teethcountbox, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(selectDate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(idbox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(selectpatientlabel)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectDocterLabel)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(teethcountbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        drugTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Description", "Fee"
            }
        ));
        jScrollPane1.setViewportView(drugTable);

        clearDrugTable.setBackground(new java.awt.Color(0, 102, 102));
        clearDrugTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        clearDrugTable.setForeground(new java.awt.Color(255, 255, 255));
        clearDrugTable.setText("Clear");
        clearDrugTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearDrugTableMouseClicked(evt);
            }
        });
        clearDrugTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDrugTableActionPerformed(evt);
            }
        });

        selectDrugButton.setBackground(new java.awt.Color(0, 102, 102));
        selectDrugButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        selectDrugButton.setForeground(new java.awt.Color(255, 255, 255));
        selectDrugButton.setText("Select...");
        selectDrugButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDrugButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Selected Drugs");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(selectDrugButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(clearDrugTable, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearDrugTable)
                    .addComponent(selectDrugButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        wardTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(wardTable);

        clearWardTable.setBackground(new java.awt.Color(0, 102, 102));
        clearWardTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        clearWardTable.setForeground(new java.awt.Color(255, 255, 255));
        clearWardTable.setText("Clear");
        clearWardTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearWardTableActionPerformed(evt);
            }
        });

        selectWardButton.setBackground(new java.awt.Color(0, 102, 102));
        selectWardButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        selectWardButton.setForeground(new java.awt.Color(255, 255, 255));
        selectWardButton.setText("Select...");
        selectWardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectWardButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Selected Ward");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(selectWardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(clearWardTable, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearWardTable)
                    .addComponent(selectWardButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));

        testTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(testTable);

        clearTestTable.setBackground(new java.awt.Color(0, 102, 102));
        clearTestTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        clearTestTable.setForeground(new java.awt.Color(255, 255, 255));
        clearTestTable.setText("Clear");
        clearTestTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTestTableActionPerformed(evt);
            }
        });

        selectTestButton.setBackground(new java.awt.Color(0, 102, 102));
        selectTestButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        selectTestButton.setForeground(new java.awt.Color(255, 255, 255));
        selectTestButton.setText("Select...");
        selectTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectTestButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Selected Test");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(selectTestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(clearTestTable, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearTestTable)
                    .addComponent(selectTestButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));

        treatmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(treatmentTable);

        clearTreatmentTable.setBackground(new java.awt.Color(0, 102, 102));
        clearTreatmentTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        clearTreatmentTable.setForeground(new java.awt.Color(255, 255, 255));
        clearTreatmentTable.setText("Clear");
        clearTreatmentTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTreatmentTableActionPerformed(evt);
            }
        });

        selectTreatmentButton.setBackground(new java.awt.Color(0, 102, 102));
        selectTreatmentButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        selectTreatmentButton.setForeground(new java.awt.Color(255, 255, 255));
        selectTreatmentButton.setText("Select...");
        selectTreatmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectTreatmentButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Selected Treatment");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(selectTreatmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(clearTreatmentTable, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearTreatmentTable)
                    .addComponent(selectTreatmentButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));

        insertButton.setBackground(new java.awt.Color(0, 102, 102));
        insertButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        insertButton.setForeground(new java.awt.Color(255, 255, 255));
        insertButton.setText("Insert");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        updateButton.setBackground(new java.awt.Color(0, 102, 102));
        updateButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("Update");

        deleteButton.setBackground(new java.awt.Color(0, 102, 102));
        deleteButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete");

        clearButton.setBackground(new java.awt.Color(0, 102, 102));
        clearButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(0, 102, 102));
        searchButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Book ID Search");

        searchBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchBoxKeyPressed(evt);
            }
        });

        newButton.setBackground(new java.awt.Color(0, 102, 102));
        newButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        newButton.setForeground(new java.awt.Color(255, 255, 255));
        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(newButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insertButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(289, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1364, 740));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void selectpatientlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectpatientlabelMouseClicked
       new SelectPatientForm().setVisible(true);
    }//GEN-LAST:event_selectpatientlabelMouseClicked

    private void selectDocterLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectDocterLabelMouseClicked
     new SelectDocterForm().setVisible(true);
    }//GEN-LAST:event_selectDocterLabelMouseClicked

    private void selectDrugButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectDrugButtonActionPerformed
     new SelectDrugForm().setVisible(true);
    }//GEN-LAST:event_selectDrugButtonActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(BookForm.drug_id.equals("")==false)
        this.loadDrug(BookForm.drug_id);
        if(BookForm.ward_id.equals("")==false)
            this.loadWard(BookForm.ward_id);
        if(BookForm.test_id.equals("")==false)
            this.loadTest(BookForm.test_id);
        if(BookForm.treatment_id.equals("")==false)
            this.loadTreatment(BookForm.treatment_id);
        if(BookForm.docter_id.equals("")==false)
            selectDocterLabel.setText(BookForm.docter_id);
        if(BookForm.patient_id.equals("")==false)
            this.selectpatientlabel.setText(BookForm.patient_id);
    }//GEN-LAST:event_formWindowGainedFocus
    private void clearJTable(JTable tableName){
        this.TableObject = (DefaultTableModel) tableName.getModel();
        this.TableObject.setRowCount(0);
    }
    private void selectWardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectWardButtonActionPerformed
        new SelectWardForm().setVisible(true);
        
    }//GEN-LAST:event_selectWardButtonActionPerformed

    private void clearDrugTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDrugTableActionPerformed
          this.clearJTable(this.drugTable);
    }//GEN-LAST:event_clearDrugTableActionPerformed

    private void clearTestTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTestTableActionPerformed
        this.clearJTable(this.testTable);
    }//GEN-LAST:event_clearTestTableActionPerformed

    private void clearDrugTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearDrugTableMouseClicked
       
    }//GEN-LAST:event_clearDrugTableMouseClicked

    private void clearWardTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearWardTableActionPerformed
        this.clearJTable(this.wardTable);
    }//GEN-LAST:event_clearWardTableActionPerformed

    private void clearTreatmentTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTreatmentTableActionPerformed
        this.clearJTable(this.treatmentTable);
    }//GEN-LAST:event_clearTreatmentTableActionPerformed

    private void selectTreatmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectTreatmentButtonActionPerformed
       new SelectTreatmentForm().setVisible(true);
    }//GEN-LAST:event_selectTreatmentButtonActionPerformed

    private void selectTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectTestButtonActionPerformed
        new SelectTestForm().setVisible(true);
    }//GEN-LAST:event_selectTestButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
       String query = "select max(book_id)+1 as new_id from book";
      try {
            this.clearAll();
          st= db.con.createStatement();
          rs=st.executeQuery(query);
          rs.next();
          this.idbox.setText(rs.getInt("new_id")+"");
          st.close();
          rs.close();
          this.insertButton.setEnabled(true);
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null,"Failed to create new Id");
      }
    }//GEN-LAST:event_newButtonActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
                  
      if(this.drugTable.getRowCount()==0)
          JOptionPane.showMessageDialog(null,"You have not selected any Drug");
      else if(this.treatmentTable.getRowCount()==0)
          JOptionPane.showMessageDialog(null,"You have not selected any treatment");
      else if(this.testTable.getRowCount()==0)
          JOptionPane.showMessageDialog(null,"You have not selected any test");
      else if(this.wardTable.getRowCount()==0)
          JOptionPane.showMessageDialog(null,"You have not selected any ward");
      else if(this.idbox.getText().equals("")==true)
          JOptionPane.showMessageDialog(null,"You have not selected the ID");
      else if(this.selectDate.getDate()==null)
          JOptionPane.showMessageDialog(null,"You have not selected the Date");
      else if(this.selectDocterLabel.getText().equals("Select...")==true)
          JOptionPane.showMessageDialog(null,"You have not selected the Docter");
      else if(this.selectpatientlabel.getText().equals("Select...")==true)
          JOptionPane.showMessageDialog(null,"You have not selected the Patient");
      else if(this.teethcountbox.getText().equals("")==true)
          JOptionPane.showMessageDialog(null,"You have not set the Teeth Count for Treatment");
      else {
     String book_date = dateFormat.format(this.selectDate.getDate());
     String docter_id = this.selectDocterLabel.getText();
     String patient_id = this.selectpatientlabel.getText();
     String teethCount= this.teethcountbox.getText();
     String book_id = this.idbox.getText();
          String book_query="insert into book (book_id,book_date,patient_id,doctor_id) values ("+book_id+",'"+book_date+"',"+patient_id+","+docter_id+");";
          try {
              st = db.con.createStatement();
              st.execute(book_query);
              
                  int i;String id,q;
                  st = db.con.createStatement();
                  // insertion into drug_book
                  for(i=0;i<this.drugTable.getRowCount();i++)
                  {
                   id = this.drugTable.getValueAt(i,0).toString();
                   q = "insert into drug_book (drug_id,book_id) values ("+id+","+book_id+");";
                   st.addBatch(q);
                  }
                  
                  // insertion into ward_book
                  for(i=0;i<this.wardTable.getRowCount();i++)
                  {
                   id = this.wardTable.getValueAt(i,0).toString();
                   q = "insert into ward_book (ward_id,book_id) values ("+id+","+book_id+");";
                   st.addBatch(q);
                  }
                  
                  // insertion into test_book
                  for(i=0;i<this.testTable.getRowCount();i++)
                  {
                   id = this.testTable.getValueAt(i,0).toString();
                   q = "insert into test_book (test_id,book_id) values ("+id+","+book_id+");";
                   st.addBatch(q);
                  }
                  
                  // insertion into drug_book
                  for(i=0;i<this.treatmentTable.getRowCount();i++)
                  {
                   id = this.treatmentTable.getValueAt(i,0).toString();
                   q = "insert into treatment_book (treatment_id,book_id,teethCount) values ("+id+","+book_id+","+teethCount+");";
                   st.addBatch(q);
                  }
                st.executeBatch();
                JOptionPane.showMessageDialog(null,"Booking Successfully done!");
                this.clearAll();
              
          }
          catch(Exception ex)
          {
              JOptionPane.showMessageDialog(null,ex.getMessage().toString());
          }
      }
      
    }//GEN-LAST:event_insertButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
      this.clearAll();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void searchBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBoxKeyPressed
        String query="";  
        Statement st1;
        ResultSet rs1;
        String key=this.searchBox.getText();
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
        if(key.equals("")==false)
                {
                            query="select * from book where book_id='"+key+"'";
                            try {
                                st = db.con.createStatement();
                                rs = st.executeQuery(query);
                                if(rs.next())
                                {
                                    this.clearAll();// clearing all the form before loading the data
                                    // loading the book information records
                                    this.idbox.setText(rs.getInt("book_id")+"");
                                    this.selectpatientlabel.setText(rs.getInt("patient_id")+"");
                                    this.selectDocterLabel.setText(rs.getInt("doctor_id")+"");
                                    this.selectDate.setDate(rs.getDate("book_date"));

                                    // loading the drugs in book appointment

                                    query="select * from drug_book where book_id='"+key+"'";
                                    st1 = db.con.createStatement();
                                    rs1=st1.executeQuery(query);
                                        while(rs1.next())
                                        {
                                        this.loadDrug(rs1.getInt("drug_id")+"");   
                                        }
                                  st1.close();
                                  rs1.close();

                                    // loading the treatment in book appointment

                                    query =" select * from treatment_book where book_id='"+key+"'";
                                    st1 = db.con.createStatement();
                                    rs1 = st1.executeQuery(query);
                                    while(rs1.next())
                                    {
                                        this.loadTreatment(rs1.getInt("treatment_id")+"");
                                          this.teethcountbox.setText(rs1.getInt("teethCount")+"");
                                    }
                                  
                                  

                                    
                                    
                                    // loading the test in book appointment

                                    query =" select * from test_book where book_id='"+key+"'";
                                    st1 = db.con.createStatement();
                                    rs1 = st1.executeQuery(query);
                                    while(rs1.next())
                                    {
                                        this.loadTest(rs1.getInt("test_id")+"");
                                    }
                                    rs1.close();
                                    st1.close();

                                    
                                      // loading the Ward in book appointment

                                    query =" select * from ward_book where book_id='"+key+"'";
                                    st1 = db.con.createStatement();
                                    rs1 = st1.executeQuery(query);
                                    while(rs1.next())
                                    {
                                        this.loadWard(rs1.getInt("ward_id")+"");
                                    }

                                    st1.close();
                                    rs1.close();
                                    
                                    this.deleteButton.setEnabled(true);
                                    this.updateButton.setEnabled(true);
                                    
                    }
                    else {
                        this.clearAll();
                        JOptionPane.showMessageDialog(null,"No Records Found");
                    } 
                                st.close();
                                rs.close();
                            }
                    catch(Exception ex){
                                JOptionPane.showMessageDialog(null,ex.getMessage());
                            }
                
                }
        else {
            this.clearAll();
            }
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
            java.util.logging.Logger.getLogger(BookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JButton clearDrugTable;
    private javax.swing.JButton clearTestTable;
    private javax.swing.JButton clearTreatmentTable;
    private javax.swing.JButton clearWardTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTable drugTable;
    private javax.swing.JTextField idbox;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField searchBox;
    private javax.swing.JButton searchButton;
    private com.toedter.calendar.JDateChooser selectDate;
    private javax.swing.JButton selectDocterLabel;
    private javax.swing.JButton selectDrugButton;
    private javax.swing.JButton selectTestButton;
    private javax.swing.JButton selectTreatmentButton;
    private javax.swing.JButton selectWardButton;
    private javax.swing.JButton selectpatientlabel;
    private javax.swing.JTextField teethcountbox;
    private javax.swing.JTable testTable;
    private javax.swing.JTable treatmentTable;
    private javax.swing.JButton updateButton;
    private javax.swing.JTable wardTable;
    // End of variables declaration//GEN-END:variables
}
