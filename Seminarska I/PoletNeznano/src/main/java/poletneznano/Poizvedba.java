/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poletneznano;

/**
 *
 * @author anjabrelih
 */
public class Poizvedba {
    
    String airportA;
    String airportB;
    
    String dateA;
    String dateB;
    String dateA1;
    String dateB1;
    
    public Poizvedba (String airportA, String airportB, String dateA, String dateB, String dateA1, String dateB1){
        this.airportA = airportA;
        this.airportB = airportB;
        this.dateA = dateA;
        this.dateB = dateB;
        this.dateA1 = dateA1;
        this.dateB1 = dateB1;
        
    }
    
    public String getAirportA(){
        return(airportA);
    }
    
    public String getAirportB(){
        return(airportB);
    }
    
    public String getDateA(){
        return(dateA);
    }
    
    public String getDateB(){
        return(dateB);
    }
    
    public String getDateA1(){
        return(dateA1);
    }
    
    public String getDateB1(){
        return(dateB1);
    }
    
}
