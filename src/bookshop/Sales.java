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
public class Sales {
    
    private int saleID;
    private String saleDate;
    private String username;
    private String saleInfo;
    private int price;
    private int profit;
    private String sellerName;

    public Sales(int saleID, String saleDate, String username, String saleInfo, int price, int profit) {
        this.saleID = saleID;
        this.saleDate = saleDate;
        this.username = username;
        this.saleInfo = saleInfo;
        this.price = price;
        this.profit = profit;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public int getSaleID() {
        return saleID;
    }

    public void setSaleID(int saleID) {
        this.saleID = saleID;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSaleInfo() {
        return saleInfo;
    }

    public void setSaleInfo(String saleInfo) {
        this.saleInfo = saleInfo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }
    
    
    
}
