package main;

import polynomial.Polynomial;

/**
 *
 * @author Sjaak Smetsers
 */
public class Main {

    public static void main(String[] args) {
        Polynomial p1 = new Polynomial( "3 3 2 2 5 1 4 0" );
        Polynomial p2 = new Polynomial( "4 2 3 1 7 0" );
        Polynomial p3 = new Polynomial( "4 0 -5 3" );
        Polynomial p4 = new Polynomial( "6 1" );
        
        

        System.out.println( p1 );
        System.out.println( p2 );
        p1.minus(p2);
        System.out.println("sub: " + p1);
        System.out.println( p3 );
        
        System.out.println( p4 );
       
                
   }

}
