/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poletneznano;

/**
 *
 * @author anjabrelih
 */
public class Podatki {
    String namePass1;
    String surnamePass1;
    String potniList1;
    String address1;
    String zipCode1;
    String city1;
    String razred1;
    String meal1;
    //String lug20_1;
    //String lug30_1;
    //String lug40_1;
        
    String namePass2;
    String surnamePass2;
    String potniList2;
    String address2;
    String zipCode2;
    String city2;
    String razred2;
    String meal2;
    //String lug20_2;
    //String lug30_2;
    //String lug40_2;
    
    public Podatki (String namePass1, String namePass2, String surnamePass1, String surnamePass2, String potniList1, String potniList2, String address1, String address2, String zipCode1, String zipCode2, String city1, String city2, String razred1, String razred2, String meal1, String meal2){
        this.namePass1 = namePass1;
        this.namePass2 = namePass2;
        this.surnamePass1 = surnamePass1;
        this.surnamePass2 = surnamePass2;
        this.potniList1 = potniList1;
        this.potniList2 = potniList2;
        this.address1 = address1;
        this.address2 = address2;
        this.zipCode1 = zipCode1;
        this.zipCode2 = zipCode2;
        this.city1 = city1;
        this.city2 = city2;
        this.razred1 = razred1;
        this.razred2 = razred2;
        this.meal1 = meal1;
        this.meal2 = meal2;
    }
    
    public String getNamePass1(){
        return(namePass1);
    }
    
    public String getSurnamePass1(){
        return(surnamePass1);
    }
    
    public String getPotniList1(){
        return(potniList1);
    }
    
    public String getAddress1(){
        return(address1);
    }
    
    public String getZipCode1(){
        return(zipCode1);
    }
    
    public String getCity1(){
        return(city1);
    }
    
    public String getRazred1(){
        return(razred1);
    }
    
    public String getMeal1(){
        return(meal1);
    }
    
    public String getNamePass2(){
        return(namePass2);
    }
    
    public String getSurnamePass2(){
        return(surnamePass2);
    }
    
    public String getPotniList2(){
        return(potniList2);
    }
    
    public String getAddress2(){
        return(address2);
    }
    
    public String getZipCode2(){
        return(zipCode2);
    }
    
    public String getCity2(){
        return(city2);
    }
    
    public String getRazred2(){
        return(razred2);
    }
    
    public String getMeal2(){
        return(meal2);
    }
}
