
package dental_clinic;
import CoreClassess.DatabaseConnection;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import  java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class DocterForm extends javax.swing.JFrame {
public DatabaseConnection db;
   public Statement st;
   public ResultSet rs;
   public PreparedStatement pst;
    public DocterForm() {
        
        initComponents();
    this.centeringTheForm();
        db = new DatabaseConnection();
        this.loadTable("");
        clearAll();
    }
public void loadTable(String key) {
       String query;
        if(key.equals("")==true)
            query ="select * from docter";
        else
         query="SELECT  * from docter where docter_id like '%"+key+"%' or docter_name like '%"+key+"%' or docter_surname like '%"+key+"%' or docter_contact like '%"+key+"%' ";
     
         int count,rowIndex=0;
            try {
             st = db.con.createStatement();
             rs=st.executeQuery(query);
            rs.next();
            rs.last();
            count=rs.getRow();// obtaining the number of rows in the table
            rs.beforeFirst();
             String Data[][] = new String[count][6];

             while(rs.next())
             {
                 Data[rowIndex][0] = String.valueOf(rs.getInt("docter_id"));
                 Data[rowIndex][1]=rs.getString("docter_name");
                 Data[rowIndex][2]=rs.getString("docter_surname");
                 Data[rowIndex][3]=rs.getString("docter_gender");
                 Data[rowIndex][4]=rs.getString("docter_contact");
                 Data[rowIndex][5]=rs.getString("docter_address");
                 rowIndex++;
             }
            String cols[] = {"ID","Name","Surname","Gender","Phone","Address"};
             DefaultTableModel table = new DefaultTableModel(Data,cols);
             this.jTable1.setModel(table);}
       catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null,"No Records Found!"+ex.getMessage());
       }  
    }
public void clearAll(){
    this.namebox.setText("");
    this.surenamebox.setText("");
    this.phonebox.setText("");
    this.picturebox.setIcon(null); 
   this.deletebutton.setEnabled(false);
   this.updatebutton.setEnabled(false);
  this.addressbox.setText("");
  this.idbox.setText("");
     this.searchbox.setText("");
    this.loadTable("");
    this.docter_image=null;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idbox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        namebox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        surenamebox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        phonebox = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        addressbox = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        malebox = new javax.swing.JRadioButton();
        femalebox = new javax.swing.JRadioButton();
        picturebox = new javax.swing.JLabel();
        addbutton = new javax.swing.JButton();
        updatebutton = new javax.swing.JButton();
        deletebutton = new javax.swing.JButton();
        clearbutton = new javax.swing.JButton();
        newbutton = new javax.swing.JButton();
        attachbutton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        searchbox = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Docter ID");

        idbox.setEnabled(false);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Name");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Surname");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Phone Number");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Address");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Gender");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Image");

        buttonGroup1.add(malebox);
        malebox.setSelected(true);
        malebox.setText("Male");

        buttonGroup1.add(femalebox);
        femalebox.setText("Female");

        picturebox.setBackground(new java.awt.Color(255, 255, 255));
        picturebox.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        picturebox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dental_clinic/empty.jpg"))); // NOI18N

        addbutton.setBackground(new java.awt.Color(255, 255, 255));
        addbutton.setText("ADD");
        addbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbuttonActionPerformed(evt);
            }
        });

        updatebutton.setBackground(new java.awt.Color(255, 255, 255));
        updatebutton.setText("Update");
        updatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebuttonActionPerformed(evt);
            }
        });

        deletebutton.setBackground(new java.awt.Color(255, 255, 255));
        deletebutton.setText("Delete");
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });

        clearbutton.setBackground(new java.awt.Color(255, 255, 255));
        clearbutton.setText("Clear");

        newbutton.setBackground(new java.awt.Color(255, 255, 255));
        newbutton.setText("New");
        newbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newbuttonActionPerformed(evt);
            }
        });

        attachbutton.setBackground(new java.awt.Color(255, 255, 255));
        attachbutton.setText("Attach");
        attachbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newbutton)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addbutton)
                        .addGap(37, 37, 37)
                        .addComponent(updatebutton)
                        .addGap(31, 31, 31)
                        .addComponent(deletebutton)
                        .addGap(26, 26, 26)
                        .addComponent(clearbutton))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(75, 75, 75)
                            .addComponent(phonebox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(surenamebox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(namebox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(idbox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(picturebox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(malebox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(femalebox))
                            .addComponent(addressbox))
                        .addGap(18, 18, 18)
                        .addComponent(attachbutton)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idbox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namebox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surenamebox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phonebox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressbox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(malebox)
                    .addComponent(femalebox))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(picturebox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(attachbutton)
                        .addGap(52, 52, 52)))
                .addComponent(newbutton)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addbutton)
                    .addComponent(updatebutton)
                    .addComponent(deletebutton)
                    .addComponent(clearbutton))
                .addGap(32, 32, 32))
        );

        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchboxKeyPressed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Search");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newbuttonActionPerformed
        this.clearAll();
        String newId="undefined";
        String query="select max(docter_id+1) as id from docter";
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

    private void addbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbuttonActionPerformed
       String docter_id = this.idbox.getText();
       String doctername = this.namebox.getText();
       String doctersurname =this.surenamebox.getText();
       String doctercontact = this.phonebox.getText();
       String docteraddress =this.addressbox.getText();
       String gender = (malebox.isSelected()==true)?"Male":"Female";
       if(docter_id.equals("")==true || doctername.equals("")==true|| doctersurname.equals("")==true|| doctercontact.equals("")==true|| docteraddress.equals("")==true|| gender.equals("")==true|| docter_image.equals("")==true)
       {
           JOptionPane.showMessageDialog(null,"Incomplete Form");
       }
       else {
        try {
              String query ="insert into docter values (?,?,?,?,?,?,?);";
          pst = db.con.prepareStatement(query);
          pst.setInt(1,Integer.parseInt(docter_id));
          pst.setString(2,doctername);
          pst.setString(3,doctersurname);
          pst.setString(4,doctercontact);
          pst.setString(6,docteraddress);
          pst.setString(7,gender);
          pst.setBytes(5,docter_image);
          pst.execute();
          JOptionPane.showMessageDialog(null,"Record Inserted successfully");
          clearAll();
          this.loadTable("");
          pst.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Failed to insert the record");
        }
          
       }
    }//GEN-LAST:event_addbuttonActionPerformed

    private void attachbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachbuttonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f  = chooser.getSelectedFile();
        if(f!=null)
        {
         filename = f.getAbsolutePath();
         ImageIcon myimage = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(this.picturebox.getWidth(),this.picturebox.getHeight(),Image.SCALE_DEFAULT));
         this.picturebox.setIcon(myimage);
        }
        try {
            File image = new File(filename);
             FileInputStream fix = new FileInputStream(image);
             ByteArrayOutputStream bos = new ByteArrayOutputStream();
             byte []   buf = new byte[2048];
             for(int number; (number=fix.read(buf))!=-1;){
                 bos.write(buf,0,number);
             }
             this.docter_image = bos.toByteArray();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"failed to convert the image "+ex);
        }
        
    }//GEN-LAST:event_attachbuttonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        docter_id = this.jTable1.getValueAt(this.jTable1.getSelectedRow(),0).toString();
        String query ="select * from docter where docter_id="+docter_id;
        try {
            st = db.con.createStatement();
            rs =st.executeQuery(query);
            rs.next();
            this.idbox.setText(rs.getInt("docter_id")+"");
            this.namebox.setText(rs.getString("docter_name"));
            this.surenamebox.setText(rs.getString("docter_surname"));
            this.phonebox.setText(rs.getString("docter_contact"));
            this.addressbox.setText(rs.getString("docter_address"));
            if(rs.getString("docter_gender").equals("Male"))
                this.malebox.setSelected(true);
            else
                this.femalebox.setSelected(true);
            byte [] myimage = rs.getBytes("docter_image");
            docter_image=myimage;
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(myimage).getImage().getScaledInstance(this.picturebox.getWidth(),this.picturebox.getHeight(),Image.SCALE_DEFAULT));
            this.picturebox.setIcon(imageIcon);
            st.close();
            rs.close();
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        this.deletebutton.setEnabled(true);
        this.updatebutton.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed
       String docter_id = this.idbox.getText();
       String doctername = this.namebox.getText();
       String doctersurname =this.surenamebox.getText();
       String doctercontact = this.phonebox.getText();
       String docteraddress =this.addressbox.getText();
       String gender = (malebox.isSelected()==true)?"Male":"Female";
       if(docter_id.equals("")==true || doctername.equals("")==true|| doctersurname.equals("")==true|| doctercontact.equals("")==true|| docteraddress.equals("")==true|| gender.equals("")==true|| docter_image.equals("")==true)
       {
           JOptionPane.showMessageDialog(null,"Incomplete Form");
       }
       else {
        try {
              String query ="update docter set docter_name=?,docter_surname=?,docter_contact=?,docter_image=?,docter_address=?,docter_gender=? where docter_id="+docter_id;
          pst = db.con.prepareStatement(query);
          pst.setString(1,doctername);
          pst.setString(2,doctersurname);
          pst.setString(3,doctercontact);
          pst.setString(5,docteraddress);
          pst.setString(6,gender);
          pst.setBytes(4,docter_image);
          pst.execute();
          JOptionPane.showMessageDialog(null,"Record Updated successfully");
          clearAll();
          this.loadTable("");
          pst.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Failed to Update the record the record");
        }
          
       }
    }//GEN-LAST:event_updatebuttonActionPerformed

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
        docter_id=this.idbox.getText();
       if(docter_id.equals("")==false)
       {
          String query = "delete from docter where docter_id='"+docter_id+"'";
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
    }//GEN-LAST:event_deletebuttonActionPerformed

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
            java.util.logging.Logger.getLogger(DocterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DocterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DocterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DocterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DocterForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbutton;
    private javax.swing.JTextField addressbox;
    private javax.swing.JButton attachbutton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clearbutton;
    private javax.swing.JButton deletebutton;
    private javax.swing.JRadioButton femalebox;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton malebox;
    private javax.swing.JTextField namebox;
    private javax.swing.JButton newbutton;
    private javax.swing.JTextField phonebox;
    private javax.swing.JLabel picturebox;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTextField surenamebox;
    private javax.swing.JButton updatebutton;
    // End of variables declaration//GEN-END:variables
    private String filename=null;
    byte[] docter_image=null;
    private ImageIcon format = null;
    private String docter_id=null;
}
