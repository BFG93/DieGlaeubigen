/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opgave9;

import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author christianlammers
 */
public class Opgave9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        List<IJsje> ijsjes = new LinkedList<>();
        ijsjes.add(new VanilleIJs());
        ijsjes.add(new Slagroom(new YoghurtIJs()));
        ijsjes.add(new Spikkels( new Slagroom(new VanilleIJs())));
 
        
        for ( IJsje i: ijsjes){
            System.out.println(i.geefBeschrijving() + ", " + i.prijs() + " Cents");
        }
    }
    
}
