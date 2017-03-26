package main;

import polynomial.Polynomial;

/**
 *
 * @author Sjaak Smetsers
 */
public class Main {

    public static void main(String[] args) {
        Polynomial p1 = new Polynomial( "2 3 3 1" );
        Polynomial p2 = new Polynomial( "5 3 4 0" );
        Polynomial p3 = new Polynomial( "4 0 -5 3" );
        Polynomial p4 = new Polynomial( "6 1" );
        
        

        System.out.println( p1 );
        System.out.println( p2 );
        p1.minus(p2);
        System.out.println("sub: " + p1);
        System.out.println( p3 );
        
        System.out.println( p4 );
       Hallo
                
   }

}
