/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Dashboard extends javax.swing.JInternalFrame {
    
    private Connection connection;

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        try {
            set_all();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void set_all() throws SQLException, ClassNotFoundException {
        
        DBCon dbc = new DBCon();
        String connectionUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=p@ssword13;" +
            "databaseName=ProjectDB1;";
            
        connection = DriverManager.getConnection(connectionUrl);
        
        Statement stmt = connection.createStatement();
        
        ResultSet rs = stmt.executeQuery("select count(bID) as tot_books from book");
        int totalBooks = 0;
        while(rs.next()) {
            totalBooks += rs.getInt("tot_books");
            totalBooksLabel.setText("Total Books: " + totalBooks);
        }
        
        rs = stmt.executeQuery("select count(eID) as tot_emp from Employee");
        int totalEmp = 0;
        while(rs.next()) {
            totalEmp += rs.getInt("tot_emp");
            totalEmployeeLabel.setText("Total Employee: " + totalEmp);
        }
        
        rs = stmt.executeQuery("select count(saleID) as tot_sales from Sales");
        int totalSales = 0;
        while(rs.next()) {
            totalSales += rs.getInt("tot_sales");
            totalSalesLabel.setText("Total Sales: " + totalSales);
        }
        
        rs = stmt.executeQuery("select sum(price) as tot_price from Sales");
        int totalPrice = 0;
        while(rs.next()) {
            totalPrice += rs.getInt("tot_price");
            revenueGeneratedLabel.setText("Revenue Generated: " + totalPrice + " (tk.)");
        }
        
        rs = stmt.executeQuery("select sum(profit) as tot_profit from Sales");
        int totalProfit = 0;
        while(rs.next()) {
            totalProfit += rs.getInt("tot_profit");
            profitGeneratedLabel.setText("Profit Generated: " + totalPrice + " (tk.)");
        }
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        totalSalesLabel = new javax.swing.JLabel();
        revenueGeneratedLabel = new javax.swing.JLabel();
        profitGeneratedLabel = new javax.swing.JLabel();
        totalEmployeeLabel = new javax.swing.JLabel();
        totalBooksLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        totalSalesLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        totalSalesLabel.setText("Total Sales");

        revenueGeneratedLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        revenueGeneratedLabel.setText("Revenue Generated");

        profitGeneratedLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        profitGeneratedLabel.setText("Profit Generated");

        totalEmployeeLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        totalEmployeeLabel.setText("Total Employee");

        totalBooksLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        totalBooksLabel.setText("Total Books");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totalBooksLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalEmployeeLabel)
                            .addComponent(totalSalesLabel))
                        .addGap(167, 167, 167)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(profitGeneratedLabel)
                    .addComponent(revenueGeneratedLabel))
                .addContainerGap(217, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalBooksLabel)
                    .addComponent(revenueGeneratedLabel))
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalSalesLabel)
                    .addComponent(profitGeneratedLabel))
                .addGap(78, 78, 78)
                .addComponent(totalEmployeeLabel)
                .addGap(89, 89, 89))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel profitGeneratedLabel;
    private javax.swing.JLabel revenueGeneratedLabel;
    private javax.swing.JLabel totalBooksLabel;
    private javax.swing.JLabel totalEmployeeLabel;
    private javax.swing.JLabel totalSalesLabel;
    // End of variables declaration//GEN-END:variables
}
