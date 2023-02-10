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
public class Deals {
    
    private int dealID;
    private String dealDate;
    private String username;
    private String dealInfo;

    public Deals() {
        
    }

    public Deals(int dealID, String dealDate, String username, String dealInfo) {
        this.dealID = dealID;
        this.dealDate = dealDate;
        this.username = username;
        this.dealInfo = dealInfo;
    }

    public int getDealID() {
        return dealID;
    }

    public void setDealID(int dealID) {
        this.dealID = dealID;
    }

    public String getDealDate() {
        return dealDate;
    }

    public void setDealDate(String dealDate) {
        this.dealDate = dealDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDealInfo() {
        return dealInfo;
    }

    public void setDealInfo(String dealInfo) {
        this.dealInfo = dealInfo;
    }
    
    
    
}
