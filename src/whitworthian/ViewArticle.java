/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whitworthian;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ccolegrove17
 */
public class ViewArticle extends javax.swing.JFrame {

    /**
     * Creates new form ViewArticle
     */
    public ViewArticle() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        contentArea = new javax.swing.JTextArea();
        authorLabel = new javax.swing.JLabel();
        positionLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        tagsLabel = new javax.swing.JLabel();
        categoriesLabel = new javax.swing.JLabel();
        categoriesPane = new javax.swing.JScrollPane();
        categoriesList = new javax.swing.JList();
        tagsPane = new javax.swing.JScrollPane();
        tagsList = new javax.swing.JList();
        OkButton = new javax.swing.JButton();
        contentLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View Article");

        contentArea.setColumns(20);
        contentArea.setLineWrap(true);
        contentArea.setRows(5);
        contentArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(contentArea);

        authorLabel.setText("Author:");

        positionLabel.setText("Position:");

        dateLabel.setText("Date Published:");

        tagsLabel.setText("Tags:");

        categoriesLabel.setText("Categories:");

        categoriesPane.setViewportView(categoriesList);

        tagsPane.setViewportView(tagsList);

        OkButton.setText("OK");
        OkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkButtonActionPerformed(evt);
            }
        });

        contentLabel.setText("Content:");

        titleLabel.setText("Title:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(OkButton)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleLabel)
                            .addComponent(authorLabel)
                            .addComponent(dateLabel)
                            .addComponent(positionLabel)
                            .addComponent(contentLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                        .addComponent(tagsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tagsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(categoriesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoriesPane, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(authorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(positionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(contentLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tagsLabel)
                            .addComponent(categoriesPane, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoriesLabel)
                            .addComponent(tagsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OkButton)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Disposes the frame when the OK button is pressed.
     * @param evt 
     */
    private void OkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkButtonActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_OkButtonActionPerformed

    /**
     * Populates the jFrame with the article information
     * @param args the command line arguments
     */
    public static void runWindow(ResultSet results, int index) {
        try {
            results.absolute(index);
            titleLabel.setText("Title: " + results.getString(2));
            authorLabel.setText("Author: " + results.getString(8) + " " + results.getString(9));
            String position = results.getString(6);
            if (position == null) {
                position = "Unknown";
            }
            positionLabel.setText("Position: " + position);
            contentArea.append(results.getString(5));
            contentArea.setCaretPosition(0);
            dateLabel.setText("Date Published: " + results.getDate(4));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                //new ViewArticle().setVisible(true);
//
//
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OkButton;
    private static javax.swing.JLabel authorLabel;
    private javax.swing.JLabel categoriesLabel;
    private javax.swing.JList categoriesList;
    private javax.swing.JScrollPane categoriesPane;
    private static javax.swing.JTextArea contentArea;
    private javax.swing.JLabel contentLabel;
    private static javax.swing.JLabel dateLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel positionLabel;
    private javax.swing.JLabel tagsLabel;
    private javax.swing.JList tagsList;
    private javax.swing.JScrollPane tagsPane;
    private static javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
