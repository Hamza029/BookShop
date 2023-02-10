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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class DBCon {
    private Connection connection;
    
    public DBCon() {
        
    }
    
    public void connectToDB() throws SQLException, ClassNotFoundException {
        try {
//            System.out.println("hoitase...");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=p@ssword13;" +
            "databaseName=ProjectDB1;";
            
            connection = DriverManager.getConnection(connectionUrl);
            
//            System.out.println("Connected database successfully...");
            java.sql.Statement stmt=connection.createStatement();
        } catch(SQLException se) {
//            System.out.println("failed");
//            System.out.println(se.getMessage());
        }
    }
    
    public void disconnectFromDB() {
        try{
            if (connection != null) {
                connection.close();
//                System.out.println("disconnected");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean insertIntoDB(String query) {
//        System.out.println(query);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
//            JOptionPane.showMessageDialog(null, "Data insertion was successfull!");
            return true;
        } catch(Exception e) {
//            System.out.println("hoynai");
            e.printStackTrace();
            return false;
//            JOptionPane.showMessageDialog(null, "Failed to insert data!");
        }
    }
    
    public boolean deleteFromDB(String query) {
//        System.out.println("ashse");
        try {
            Statement stmt = connection.createStatement();
//            System.out.println(query);
            stmt.executeUpdate(query);
//            JOptionPane.showMessageDialog(null, "Data deletion was successfull!");
            return true;
        } catch(Exception e) {
//            System.out.println("hoynai");
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateDB(String query) {
//        System.out.println("ashse");
        try {
            Statement stmt = connection.createStatement();
//            System.out.println(query);
            stmt.executeUpdate(query);
//            JOptionPane.showMessageDialog(null, "Data updating was successfull!");
            return true;
        } catch(Exception e) {
//            System.out.println("hoynai");
            JOptionPane.showMessageDialog(null, "Failed to update data!");
            e.printStackTrace();
            return false;
        }
    }
    
    
    
    public ArrayList<Employee> getEmployeeList(String query) throws SQLException {
        ArrayList<Employee> list = new ArrayList<> ();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Employee em;
        while(rs.next()) {
            em = new Employee(rs.getInt("eID"), rs.getString("username"), rs.getString("pass"), rs.getString("eRole"), 
                                rs.getString("eName"), rs.getString("ePhone"), rs.getInt("salary"));
//            System.out.println(rs.getString("eRole") + ", " + rs.getString("pass"));
//            System.out.println(em.geteRole() + ", " + em.getPass());
//            System.out.println("-----------------------------------");
            em.setSales(rs.getInt("tot_sales"));
            em.setDeals(rs.getInt("tot_deals"));
            list.add(em);
        }
        return list;
    }
    
    public Employee getEmployeeInfo(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Employee em = new Employee();
        while(rs.next()) {
            em = new Employee(rs.getInt("eID"), rs.getString("username"), rs.getString("pass"), rs.getString("eRole"), 
                                rs.getString("eName"), rs.getString("ePhone"), rs.getInt("salary"));
        }
        return em;
    }
    
    
    
    
    // Book Methods
    
    public ArrayList<Book> getBookList(String query) throws SQLException {
        ArrayList<Book> list = new ArrayList<> ();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Book book;
        while(rs.next()) {
            book = new Book(rs.getInt("bID"), rs.getString("bName"), rs.getString("author"), rs.getString("category"), 
                                rs.getInt("buyingPrice"), rs.getInt("sellingPrice"), rs.getInt("copies"));
            list.add(book);
        }
        return list;
    }
    
    
    // Deals Methods
    
    public ArrayList<Deals> getDealsList(String query) throws SQLException {
        ArrayList<Deals> list = new ArrayList<> ();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Deals deal;
        while(rs.next()) {
            deal = new Deals(rs.getInt("dealID"), rs.getString("dealDate"), rs.getString("username"), rs.getString("dealInfo"));
            list.add(deal);
        }
        return list;
    }
    
    
    // Sales Methods
    
    public ArrayList<Sales> getSalesList(String query) throws SQLException {
        ArrayList<Sales> list = new ArrayList<> ();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Sales sale;
        while(rs.next()) {
            sale = new Sales(rs.getInt("saleID"), rs.getString("saleDate"), rs.getString("username"), 
                            rs.getString("saleInfo"), rs.getInt("price"), rs.getInt("profit"));
            sale.setSellerName(rs.getString("eName"));
            list.add(sale);
        }
        return list;
    }
    
    
    
    // Admin Methods
    
    public ArrayList<Admin> getAdminList(String query) throws SQLException {
        ArrayList<Admin> list = new ArrayList<> ();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Admin admin;
        while(rs.next()) {
            admin = new Admin(rs.getString("username"), rs.getString("pass"));
            list.add(admin);
        }
        return list;
    }
    
    public Admin getAdminInfo(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Admin ad = new Admin();
        while(rs.next()) {
            ad = new Admin(rs.getString("username"), rs.getString("pass"));
        }
        return ad;
    }
    
}
