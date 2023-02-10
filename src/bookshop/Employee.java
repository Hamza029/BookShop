/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

/**
 *
 * @author USER
 */
public class Employee {
    private int eID;
    private String username;
    private String eRole;
    private String pass;
    private String eName;
    private String ePhone;
    private int Salary;
    private int sales;
    private int deals;
    
    public Employee() {
        this.username = "";
        this.pass = "";
    }

    public Employee(int eID, String username, String pass, String eRole, String eName, String ePhone, int Salary) {
        this.eID = eID;
        this.username = username;
        this.eRole = eRole;
        this.pass = pass;
        this.eName = eName;
        this.ePhone = ePhone;
        this.Salary = Salary;
    }

    public int geteID() {
        return eID;
    }

    public void seteID(int eID) {
        this.eID = eID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getDeals() {
        return deals;
    }

    public void setDeals(int deals) {
        this.deals = deals;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getePhone() {
        return ePhone;
    }

    public void setePhone(String ePhone) {
        this.ePhone = ePhone;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public String geteRole() {
        return eRole;
    }

    public void seteRole(String eRole) {
        this.eRole = eRole;
    }
    
    
}
