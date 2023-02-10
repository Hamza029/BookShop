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
public class PassED {
    
    static String encrypt(String s) {
        String ret = "";
        for(int i = 0; i < s.length(); i++) {
//            System.out.println((i%2)*5+5);
            char c = (char) (s.charAt(i) + (i%2+1)*5);
            ret += c;
        }
        return ret;
    }
    
    static String decrypt(String s) {
        String ret = "";
        for(int i = 0; i < s.length(); i++) {
            char c = (char) (s.charAt(i) - (i%2+1)*5);
            ret += c;
        }
        return ret;
    }
    
//    public static void main(String[] args) {
//        String s = "hello";
//        String enc = encrypt(s);
//        String dec = decrypt(enc);
//        System.out.println(enc + " " + dec);
//    }
    
}
