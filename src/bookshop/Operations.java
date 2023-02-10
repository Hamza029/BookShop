/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Operations {
    
    private DBCon dbc;
    private ResultSet rs;

    public Operations() {
        
    }
    
    public void insertEmployee(Employee em) {
        boolean f1 = false, f2 = false;
        try {
            dbc = new DBCon();
            dbc.connectToDB();
            String query = "INSERT INTO Employee (eID,username,pass,eRole,eName,ePhone,salary) " + 
                "VALUES (" + em.geteID() + ", '" + em.getUsername()+ "', '" + em.getPass()+ "', '" + em.geteRole()
                    + "', '" + em.geteName() + "', '" + em.getePhone() + "', " + em.getSalary()
                    + ")";
//            System.out.println(query);
            f1 = dbc.insertIntoDB(query);
            String query2 = "INSERT INTO " + em.geteRole() + " " + 
                    "VALUES (" + em.geteID() + ")";
            f2 = dbc.insertIntoDB(query2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.disconnectFromDB();
        }
        
        if(f1 && f2) {
            JOptionPane.showMessageDialog(null, "Data insertion was successfull!");
        }
        else {
            JOptionPane.showMessageDialog(null, "Data insertion failed!");
        }
    }
    
    public void deleteEmployee(int eID, String eRole) {
        boolean f1 = false, f2 = false;
        try {
            dbc = new DBCon();
            dbc.connectToDB();
            String query = "Delete from " + eRole + " Where eID = " + eID;
//            System.out.println(query);
            f1 = dbc.deleteFromDB(query);
            String query2 = "Delete from Employee where eID = " + eID;
            f2 = dbc.deleteFromDB(query2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.disconnectFromDB();
        }
        
        if(f1 && f2) {
            JOptionPane.showMessageDialog(null, "Data deletion was successfull!");
        }
        else {
            JOptionPane.showMessageDialog(null, "Data deletion failed!");
        }
    }
    
    public void updateEmployee(Employee em) {
        try {
            dbc = new DBCon();
            dbc.connectToDB();
            String query = "update Employee " +
                            "set username = '" + em.getUsername()+ "', " +
                            "pass = '" + em.getPass()+ "', " +
//                            "eRole = '" + em.geteRole()+ "', " +
                            "eName = '" + em.geteName()+ "', " +
                            "ePhone = '" + em.getePhone()+ "', " +
                            "salary = " + em.getSalary()+ " " +
                            "where eID = " + em.geteID();
//            System.out.println(query);
            dbc.updateDB(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.disconnectFromDB();
        }
    }
    
    
    public ArrayList<Employee> show(String searchType, String search) {
        ArrayList<Employee> list = new ArrayList<> ();
        try {
            dbc = new DBCon();
            dbc.connectToDB();
            if(!searchType.equals("eID")) {
                search = "'%" + search + "%'";
            }
//            String query = "SELECT * FROM Employee\n" +
//                    "Where "+ searchType + " like " + search;
            String query = "select eID,Employee.username,pass,eRole,eName,ePhone,salary,COUNT(Sales.username) as 'tot_sales',COUNT(Deals.username) as 'tot_deals'\n" +
                            "from Employee\n" +
                            "left join Sales\n" +
                            "on Employee.username = Sales.username\n" +
                            "left join Deals\n" +
                            "on Employee.username = Deals.username\n" +
                            "group by Employee.username,Employee.eID,pass,eRole,eName,ePhone,salary\n" +
                            "Having Employee."+ searchType + " like " + search;
//            System.out.println(query);
            list = dbc.getEmployeeList(query);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbc.disconnectFromDB();
        }
        return list;
    }
    
    public ArrayList<Employee> show() {
        ArrayList<Employee> list = new ArrayList<> ();
        try {
            dbc = new DBCon();
            dbc.connectToDB();
//            String query = "SELECT * FROM Employee order by eID";
            String query = "select eID,Employee.username,pass,eRole,eName,ePhone,salary,COUNT(Sales.username) as 'tot_sales',COUNT(Deals.username) as 'tot_deals'\n" +
                            "from Employee\n" +
                            "left join Sales\n" +
                            "on Employee.username = Sales.username\n" +
                            "left join Deals\n" +
                            "on Employee.username = Deals.username\n" +
                            "group by Employee.username,Employee.eID,pass,eRole,eName,ePhone,salary\n";
            list = dbc.getEmployeeList(query);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbc.disconnectFromDB();
        }
        return list;
    }
    
    public Employee getEmployeeInfo(String username, String password) {
        Employee em = new Employee();
        try {
            dbc = new DBCon();
            dbc.connectToDB();
            String query = "Select * From Employee " + 
                    "Where username = '" + username + "'";
//            System.out.println(query);
            em = dbc.getEmployeeInfo(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.disconnectFromDB();
        }
        return em;
    }
    
    
    
    
    // Methods for Book Table
    
    public void insertBook(Book book) {
        boolean f = false;
        try {
            dbc = new DBCon();
            dbc.connectToDB();
            String query = "INSERT INTO Book (bID,bName,author,category,buyingPrice,sellingPrice,copies) " + 
                "VALUES (" + book.getbID() + ", '" + book.getbName()+ "', '" + book.getAuthor()+ "', '" + book.getCategory()
                    + "', " + book.getBuyingPrice() + ", " + book.getSellingPrice()+ ", " + book.getCopies()
                    + ")";
//            System.out.println(query);
            f = dbc.insertIntoDB(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.disconnectFromDB();
            CurrentUser.successfulOperation = f;
        }
        
        if(f) {
            JOptionPane.showMessageDialog(null, "Data insertion was successfull!");
        }
        else {
            JOptionPane.showMessageDialog(null, "Failed to insert data!");
        }
    }
    
    public void updateBook(Book book) {
        boolean f = false;
        try {
            dbc = new DBCon();
            dbc.connectToDB();
            String query = "update Book " +
                            "set bName = '" + book.getbName()+ "', " +
                            "author = '" + book.getAuthor()+ "', " +
                            "category = '" + book.getCategory()+ "', " +
                            "buyingPrice = " + book.getBuyingPrice()+ ", " +
                            "sellingPrice = " + book.getSellingPrice()+ ", " +
                            "copies = " + book.getCopies()+ " " +
                            "where bID = " + book.getbID();
//            System.out.println(query);
            f = dbc.updateDB(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.disconnectFromDB();
            CurrentUser.successfulOperation = f;
        }
    }
    
    public void deleteBook(int bID) {
        boolean f = false;
        try {
            dbc = new DBCon();
            dbc.connectToDB();
            String query = "Delete from Book Where bID = " + bID;
//            System.out.println(query);
            f = dbc.deleteFromDB(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.disconnectFromDB();
            CurrentUser.successfulOperation = f;
        }
        if(f) {
            JOptionPane.showMessageDialog(null, "Data deletion was successfull!");
        }
        else {
            JOptionPane.showMessageDialog(null, "Failed to delete data!");
        }
    }
    
    
    
    
    public ArrayList<Book> showBook(String searchType, String search) {
        ArrayList<Book> list = new ArrayList<> ();
        try {
            dbc = new DBCon();
            dbc.connectToDB();
            if(!searchType.equals("bID")) {
                search = "'%" + search + "%'";
            }
            String query = "SELECT * FROM Book Where " + searchType + " like " + search + " order by bID";
//            System.out.println(query);
            list = dbc.getBookList(query);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbc.disconnectFromDB();
        }
        return list;
    }
    
    
    public ArrayList<Book> showBook() {
        ArrayList<Book> list = new ArrayList<> ();
        try {
            dbc = new DBCon();
            dbc.connectToDB();
            String query = "SELECT * FROM Book order by bID";
            list = dbc.getBookList(query);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbc.disconnectFromDB();
        }
        return list;
    }
    
    
    
    
    // Deals Methods
    public ArrayList<Deals> showDeals() {
        ArrayList<Deals> list = new ArrayList<> ();
        try {
            dbc = new DBCon();
            dbc.connectToDB();
            String query = "SELECT * FROM Deals order by dealID";
            list = dbc.getDealsList(query);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbc.disconnectFromDB();
        }
        return list;
    }
    
    public ArrayList<Sales> showSales() {
        ArrayList<Sales> list = new ArrayList<> ();
        try {
            dbc = new DBCon();
            dbc.connectToDB();
            String query = "select Employee.username, Employee.eName, Sales.saleID, Sales.saleDate, Sales.price, Sales.profit, Sales.saleinfo\n" +
                            "from Employee\n" +
                            "right join Sales\n" +
                            "on Employee.username = Sales.username";
            list = dbc.getSalesList(query);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbc.disconnectFromDB();
        }
        return list;
    }
    
    
    
    // Admin Methods
    
    public void insertAdmin(Admin ad) {
        boolean f = false;
        try {
            dbc = new DBCon();
            dbc.connectToDB();
            String query = "INSERT INTO Admin (username, pass) " + 
                "VALUES ('" + ad.getUsername()+ "', '" + ad.getPassword() + "')";
//            System.out.println(query);
            f = dbc.insertIntoDB(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.disconnectFromDB();
            CurrentUser.successfulOperation = f;
        }
        
        if(f) {
            JOptionPane.showMessageDialog(null, "Data insertion was successfull!");
        }
        else {
            JOptionPane.showMessageDialog(null, "Failed to insert data!");
        }
    }
    
    public void deleteAdmin(String username) {
        boolean f = false;
        try {
            dbc = new DBCon();
            dbc.connectToDB();
            String query = "Delete from Admin Where username = '" + username +"'";
//            System.out.println(query);
            f = dbc.deleteFromDB(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.disconnectFromDB();
            CurrentUser.successfulOperation = f;
        }
        if(f) {
            JOptionPane.showMessageDialog(null, "Data deletion was successfull!");
        }
        else {
            JOptionPane.showMessageDialog(null, "Failed to delete data!");
        }
    }
    
    public void updateAdmin(Admin ad) {
        boolean f = false;
        try {
            dbc = new DBCon();
            dbc.connectToDB();
            String query = "update Admin " +
                            "set pass = '" + ad.getPassword()+ "' " +
                            "where username = '" + ad.getUsername() + "'";
//            System.out.println(query);
            f = dbc.updateDB(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.disconnectFromDB();
            CurrentUser.successfulOperation = f;
        }
    }
    
    
    public ArrayList<Admin> showAdmin() {
        ArrayList<Admin> list = new ArrayList<> ();
        try {
            dbc = new DBCon();
            dbc.connectToDB();
            String query = "SELECT * FROM Admin";
            list = dbc.getAdminList(query);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbc.disconnectFromDB();
        }
        return list;
    }
    
    public Admin getAdminInfo(String username, String password) {
        Admin ad = new Admin();
        try {
            dbc = new DBCon();
            dbc.connectToDB();
            String query = "Select * From Admin " + 
                    "Where username = '" + username + "'";
//            System.out.println(query);
            ad = dbc.getAdminInfo(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.disconnectFromDB();
        }
        return ad;
    }
    
}
