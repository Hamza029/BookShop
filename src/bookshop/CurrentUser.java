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
public class CurrentUser {
    
    public static String username;
    public static boolean successfulOperation;
    public static String type;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        CurrentUser.username = username;
    }

    public static boolean isSuccessfulOperation() {
        return successfulOperation;
    }

    public static void setSuccessfulOperation(boolean successfulOperation) {
        CurrentUser.successfulOperation = successfulOperation;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        CurrentUser.type = type;
    }
    
    
    
}
