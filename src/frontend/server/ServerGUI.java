/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.server;

import backend.server.Server;
import java.io.PrintStream;

/**
 *
 * @author hfran
 */
public class ServerGUI extends javax.swing.JFrame {
    
    private Server s;
    public PrintStream print;

    /**
     * Creates new form ServerGUI
     */
    public ServerGUI() {
        super("Server Application");
        initComponents();
        myInit();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        introPanel = new javax.swing.JPanel();
        startServerButton = new javax.swing.JButton();
        isHasPassword = new javax.swing.JCheckBox();
        passwordInput = new javax.swing.JTextField();
        passwordError = new javax.swing.JLabel();
        serverPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        serverLog = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startServerButton.setText("Start Server");
        startServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startServerButtonActionPerformed(evt);
            }
        });

        isHasPassword.setText("Protect server with password");
        isHasPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isHasPasswordActionPerformed(evt);
            }
        });

        passwordError.setForeground(new java.awt.Color(255, 0, 0));
        passwordError.setText("Password hasn't been set");

        javax.swing.GroupLayout introPanelLayout = new javax.swing.GroupLayout(introPanel);
        introPanel.setLayout(introPanelLayout);
        introPanelLayout.setHorizontalGroup(
            introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(introPanelLayout.createSequentialGroup()
                .addGroup(introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(introPanelLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(isHasPassword)
                            .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordError)))
                    .addGroup(introPanelLayout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(startServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(209, Short.MAX_VALUE))
        );
        introPanelLayout.setVerticalGroup(
            introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, introPanelLayout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(isHasPassword)
                .addGap(18, 18, 18)
                .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordError)
                .addGap(38, 38, 38)
                .addComponent(startServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        serverLog.setColumns(20);
        serverLog.setRows(5);
        jScrollPane2.setViewportView(serverLog);

        javax.swing.GroupLayout serverPanelLayout = new javax.swing.GroupLayout(serverPanel);
        serverPanel.setLayout(serverPanelLayout);
        serverPanelLayout.setHorizontalGroup(
            serverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serverPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        serverPanelLayout.setVerticalGroup(
            serverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serverPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(introPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(serverPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(introPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(serverPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void isHasPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isHasPasswordActionPerformed
        if(isHasPassword.isSelected()){
            passwordInput.setEnabled(true);
        } else {
            passwordError.setVisible(false);
            passwordInput.setEnabled(false);
        }
    }//GEN-LAST:event_isHasPasswordActionPerformed

    private void startServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startServerButtonActionPerformed
        if(isHasPassword.isSelected()){
            if(passwordInput.getText().trim().equals("")){
                passwordError.setVisible(true);
            } else {
                passwordError.setVisible(false);
            }
        } 
        if(passwordError.isVisible()){
            // Do nothing
        } else {
            s = new Server(passwordInput.getText(), print);
            startServer();
            introPanel.setVisible(false);
            serverLog.setVisible(true);
        }
    }//GEN-LAST:event_startServerButtonActionPerformed

    private void startServer(){
        introPanel.setVisible(false);
        serverPanel.setVisible(true);
        s.startServer();
    }
    
    /**
     * @param args the command line arguments
     */
    private void myInit(){
        serverPanel.setVisible(false);
        introPanel.setVisible(true);
        passwordError.setVisible(false);
        passwordInput.setEnabled(false);
        serverLog.setEditable(false);
        print = new PrintStream(new CustomOutputStream(serverLog));
    }
    
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
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel introPanel;
    private javax.swing.JCheckBox isHasPassword;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel passwordError;
    private javax.swing.JTextField passwordInput;
    private javax.swing.JTextArea serverLog;
    private javax.swing.JPanel serverPanel;
    private javax.swing.JButton startServerButton;
    // End of variables declaration//GEN-END:variables
}
