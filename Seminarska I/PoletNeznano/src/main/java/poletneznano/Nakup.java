/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poletneznano;

/**
 *
 * @author anjabrelih
 */
public class Nakup {
    
    String cardName;
    String email;
    String cardNo;
    
    public Nakup (String cardName, String email, String cardNo){
        this.cardName = cardName;
        this.email = email;
        this.cardNo = cardNo;
    }
    
    public String getCardName(){
        return(cardName);
    }
    
    public String getEmail(){
        return(email);
    }
    
    public String getCardNo(){
        return(cardNo);
    }
}
