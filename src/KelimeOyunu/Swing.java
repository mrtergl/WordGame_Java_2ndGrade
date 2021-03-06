/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KelimeOyunu;

import KelimeOyunu.GecmisOyunlar;
import KelimeOyunu.Kurallar;
import KelimeOyunu.OyunaBasla;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Murat <your.name at your.org>
 */
public class Swing extends javax.swing.JFrame {

    /**
     * Creates new form Swing
     */
    public Swing() {
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        OyunaBasla = new javax.swing.JButton();
        SoruEkle = new javax.swing.JButton();
        KurallarB = new javax.swing.JButton();
        Gecmis = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        CikisTusu = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        SoruEklemeMenu = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kelime Oyunu");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(540, 270));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Elephant", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("KEL??ME OYUNU");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        OyunaBasla.setBackground(new java.awt.Color(204, 0, 0));
        OyunaBasla.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        OyunaBasla.setForeground(new java.awt.Color(255, 255, 255));
        OyunaBasla.setText("Oyuna Ba??la");
        OyunaBasla.setFocusable(false);
        OyunaBasla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OyunaBaslaMouseClicked(evt);
            }
        });
        OyunaBasla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OyunaBaslaActionPerformed(evt);
            }
        });

        SoruEkle.setBackground(new java.awt.Color(204, 0, 0));
        SoruEkle.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        SoruEkle.setForeground(new java.awt.Color(255, 255, 255));
        SoruEkle.setText("Soru Ekle");
        SoruEkle.setFocusable(false);
        SoruEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SoruEkleActionPerformed(evt);
            }
        });

        KurallarB.setBackground(new java.awt.Color(204, 0, 0));
        KurallarB.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        KurallarB.setForeground(new java.awt.Color(255, 255, 255));
        KurallarB.setText("Oyun Kurallar??");
        KurallarB.setFocusable(false);
        KurallarB.setPreferredSize(new java.awt.Dimension(179, 40));
        KurallarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KurallarBActionPerformed(evt);
            }
        });

        Gecmis.setBackground(new java.awt.Color(204, 0, 0));
        Gecmis.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        Gecmis.setForeground(new java.awt.Color(255, 255, 255));
        Gecmis.setText("Ge??mi?? Oyuncular");
        Gecmis.setFocusable(false);
        Gecmis.setPreferredSize(new java.awt.Dimension(217, 40));
        Gecmis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GecmisActionPerformed(evt);
            }
        });

        jSeparator1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(367, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Gecmis, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SoruEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(124, 124, 124))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(KurallarB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OyunaBasla, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(OyunaBasla, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SoruEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(KurallarB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(Gecmis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/KelimeOyunu/documents.png"))); // NOI18N
        jMenu1.setText("Dosya");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        CikisTusu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CikisTusu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/KelimeOyunu/delete.png"))); // NOI18N
        CikisTusu.setText("????k????");
        CikisTusu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CikisTusuActionPerformed(evt);
            }
        });
        jMenu1.add(CikisTusu);

        jMenuBar1.add(jMenu1);

        jMenu6.setContentAreaFilled(false);
        jMenu6.setEnabled(false);
        jMenu6.setFocusable(false);
        jMenuBar1.add(jMenu6);

        SoruEklemeMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/KelimeOyunu/add.png"))); // NOI18N
        SoruEklemeMenu.setText("Soru Ekle");
        SoruEklemeMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SoruEklemeMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SoruEklemeMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(SoruEklemeMenu);

        jMenu7.setContentAreaFilled(false);
        jMenu7.setEnabled(false);
        jMenu7.setFocusable(false);
        jMenuBar1.add(jMenu7);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/KelimeOyunu/kurallar.png"))); // NOI18N
        jMenu4.setText("Oyun Kurallar??");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu8.setContentAreaFilled(false);
        jMenu8.setEnabled(false);
        jMenu8.setFocusable(false);
        jMenuBar1.add(jMenu8);

        jMenu5.setBackground(new java.awt.Color(204, 204, 204));
        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/KelimeOyunu/trophy.png"))); // NOI18N
        jMenu5.setText("Ge??mi?? Oyuncular");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenu5.setIconTextGap(6);
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CikisTusuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CikisTusuActionPerformed
       System.exit(0);
    }//GEN-LAST:event_CikisTusuActionPerformed

    private void GecmisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GecmisActionPerformed
        try {
            new GecmisOyunlar().setVisible(true);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Swing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Swing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_GecmisActionPerformed

    private void KurallarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KurallarBActionPerformed
        new Kurallar().setVisible(true);

    }//GEN-LAST:event_KurallarBActionPerformed

    private void SoruEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoruEkleActionPerformed
        try {
            new SoruEkle().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Swing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SoruEkleActionPerformed

    private void OyunaBaslaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OyunaBaslaActionPerformed
        try {
            new OyunaBasla().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Swing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_OyunaBaslaActionPerformed

    private void OyunaBaslaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OyunaBaslaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_OyunaBaslaMouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
         new Kurallar().setVisible(true);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        try {
            new GecmisOyunlar().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Swing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void SoruEklemeMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SoruEklemeMenuMouseClicked
        try {
            new SoruEkle().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Swing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SoruEklemeMenuMouseClicked

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
            java.util.logging.Logger.getLogger(Swing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Swing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Swing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Swing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Swing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CikisTusu;
    private javax.swing.JButton Gecmis;
    private javax.swing.JButton KurallarB;
    private javax.swing.JButton OyunaBasla;
    private javax.swing.JButton SoruEkle;
    private javax.swing.JMenu SoruEklemeMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
