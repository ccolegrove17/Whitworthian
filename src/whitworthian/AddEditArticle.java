/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whitworthian;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author ccolegrove17
 */
public class AddEditArticle extends javax.swing.JFrame {

    static ResultSet results;
    static DatabaseConnection db = new DatabaseConnection();
    private final Vector<File> imageFiles = new Vector<File>();
    private final DefaultListModel model = new DefaultListModel();

    /**
     * Creates new form ViewPage
     */
    public AddEditArticle() {
        initComponents();
        imageList.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        authorLabel = new javax.swing.JLabel();
        fNameField = new javax.swing.JTextField();
        categoriesPane = new javax.swing.JScrollPane();
        categoriesTextArea = new javax.swing.JTextArea();
        categoriesLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        dateField = new javax.swing.JTextField();
        imagesLabel = new javax.swing.JLabel();
        imagesPane = new javax.swing.JScrollPane();
        imageList = new javax.swing.JList();
        contentPane = new javax.swing.JScrollPane();
        contentArea = new javax.swing.JTextArea();
        contentLabel = new javax.swing.JLabel();
        uploadButton = new javax.swing.JButton();
        positionLabel = new javax.swing.JLabel();
        positionBox = new javax.swing.JComboBox();
        tagsLabel = new javax.swing.JLabel();
        tagsField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lNameField = new javax.swing.JTextField();

        fileChooser.setName("fileChooser"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add/Edit Article");

        authorLabel.setText("Author");

        categoriesTextArea.setColumns(10);
        categoriesTextArea.setRows(3);
        categoriesPane.setViewportView(categoriesTextArea);

        categoriesLabel.setText("Categories:");

        dateLabel.setText("Date:");

        imagesLabel.setText("Images:");

        imagesPane.setViewportView(imageList);

        contentArea.setColumns(20);
        contentArea.setLineWrap(true);
        contentArea.setRows(5);
        contentArea.setWrapStyleWord(true);
        contentPane.setViewportView(contentArea);

        contentLabel.setText("Content:");

        uploadButton.setText("Upload");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        positionLabel.setText("Position:");

        tagsLabel.setText("Tags:");

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Title:");

        titleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("First Name:");

        jLabel3.setText("Last Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contentPane)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contentLabel)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(authorLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(positionLabel)
                                .addGap(18, 18, 18)
                                .addComponent(positionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(dateLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lNameField)
                                    .addComponent(fNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                    .addComponent(dateField))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(categoriesLabel)
                            .addComponent(categoriesPane, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(imagesLabel)
                            .addComponent(imagesPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(uploadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tagsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tagsField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitButton)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateLabel)
                            .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(lNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(positionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(positionLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(contentLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imagesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imagesPane, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(uploadButton)
                        .addGap(18, 18, 18)
                        .addComponent(categoriesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(categoriesPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tagsLabel)
                    .addComponent(tagsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        // TODO add your handling code here:
        fileChooser.showOpenDialog(uploadButton);
        File f = fileChooser.getSelectedFile();
        imageFiles.add(f);
        model.addElement(f.getName());
        imageList.setModel(model);
    }//GEN-LAST:event_uploadButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        //This will send an INSERT query to the database
        String title, date, content, fName, lName, authorPosition;
        int employee = 0;
        fName = fNameField.getText();
        lName = lNameField.getText();
        ResultSet rs = db.executeQuery("SELECT ID FROM Employees WHERE Fname LIKE \"%" + fName + "%\" AND Lname LIKE \"%" + lName + "%\";");
        authorPosition = positionBox.getSelectedItem().toString();
        String stSQL = "";
        title = titleField.getText();
        date = dateField.getText();
        content = contentArea.getText();
        try {
            if (rs.next() == true) {
                employee = rs.getInt(1);
            } else {
                stSQL = "INSERT INTO Employees (Fname, Lname) VALUES(\"" + fName + "\", \"" + lName + "\");";
                employee = db.executeUpdate(stSQL);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddEditArticle.class.getName()).log(Level.SEVERE, null, ex);
        }

        //FIGURE OUT HOW TO CHECK IF IT DIDN'T RETURN ANY RESULTS
        if (submitButton.getText().equals("Submit")) {
            try {
                rs.next();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            stSQL = "INSERT INTO Articles (Title, Employee_ID, Date_Pub, Content, AuthorPosition) VALUES (\""
                    + title + "\",\"" + employee + "\",\"" + date + "\",\"" + content + "\", \"" + authorPosition + "\");";
            db.executeUpdate(stSQL);
        } else if (submitButton.getText().equals("Edit")) {
            try {
                stSQL = "UPDATE Articles SET Title = \"" + title + "\", Employee_ID = " + employee
                        + ", Date_Pub = \"" + date + "\", Content = \"" + content + "\", AuthorPosition = \"" + authorPosition + "\" WHERE ID = " + results.getString(1) + ";";
                db.executeUpdate(stSQL);
                SearchPage.searchButton.doClick();
            } catch (SQLException ex) {
                Logger.getLogger(AddEditArticle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //send stSQL to the database
        dispose();
    }//GEN-LAST:event_submitButtonActionPerformed

    private void titleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleFieldActionPerformed

    public static void addNewArticle() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date todaysDate = new Date();
        dateField.setText(dateFormat.format(todaysDate));
        DefaultComboBoxModel listModel = new DefaultComboBoxModel();
        ResultSet rs = db.executeQuery("SELECT Pos_Name FROM positions");
        try {
            while (rs.next()) {
                listModel.addElement(rs.getString(1));
            }
            positionBox.setModel(listModel);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void runWindow(ResultSet results, int index) {
        AddEditArticle.results = results;
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        DefaultComboBoxModel listModel = new DefaultComboBoxModel();
        ResultSet rs = db.executeQuery("SELECT Pos_Name FROM positions");
        try {
            while (rs.next()) {
                listModel.addElement(rs.getString(1));
            }
            positionBox.setModel(listModel);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            submitButton.setText("Edit");
            results.absolute(index);
            titleField.setText(results.getString(2));
            fNameField.setText(results.getString(8));
            lNameField.setText(results.getString(9));
            contentArea.append(results.getString(5));
            contentArea.setCaretPosition(0);
            dateField.setText(results.getDate(4).toString());
            //System.out.println(results.getString(6));
            positionBox.setSelectedItem(results.getString(6));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddEditArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEditArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEditArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEditArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AddEditArticle().setVisible(true);
//                try {
//                    SearchPage.results.absolute(SearchPage.index);
//                    titleField.setText(SearchPage.results.getString(2));
//                } catch (SQLException ex) {
//                    Logger.getLogger(AddEditArticle.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorLabel;
    private javax.swing.JLabel categoriesLabel;
    private javax.swing.JScrollPane categoriesPane;
    private javax.swing.JTextArea categoriesTextArea;
    private static javax.swing.JTextArea contentArea;
    private javax.swing.JLabel contentLabel;
    private javax.swing.JScrollPane contentPane;
    private static javax.swing.JTextField dateField;
    private javax.swing.JLabel dateLabel;
    private static javax.swing.JTextField fNameField;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JList imageList;
    private javax.swing.JLabel imagesLabel;
    private javax.swing.JScrollPane imagesPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private static javax.swing.JTextField lNameField;
    private static javax.swing.JComboBox positionBox;
    private javax.swing.JLabel positionLabel;
    protected static javax.swing.JButton submitButton;
    private javax.swing.JTextField tagsField;
    private javax.swing.JLabel tagsLabel;
    private static javax.swing.JTextField titleField;
    private javax.swing.JButton uploadButton;
    // End of variables declaration//GEN-END:variables

}
