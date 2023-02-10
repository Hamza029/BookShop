/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author USER
 */
public class Test {
    
    public static void main(String[] args) {
        
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String s = formatter.format(date);
        
//        String s = dtf.format(now);
//        s = "Hello\\n";
        
        System.out.println(s);
        
    }
    
}
