package polynomial;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * A skeleton class for representing Polynomials
 *
 * @author Clemens Beißel 4547330
 * @author Christian Lammers 4578236
 * @date 19-04-2016
 */
public class Polynomial {

    /**
     * A polynomial is a sequence of terms here kept in an List
     */
    List<Term> terms;

    /**
     * A constructor for creating the zero Polynomial zero is presented as an
     * empty list of terms and not as a single term with 0 as a coefficient
     */
    public Polynomial() {
        terms = new LinkedList<>();
    }

    /**
     * A Constructor creating a polynomial from the argument string.
     *
     * @param s a String representing a list of terms which is converted to a
     * scanner and passed to scanTerm for reading each individual term
     */
    public Polynomial(String s) {
        terms = new LinkedList<>();
        Scanner scan = new Scanner(s);

        for (Term t = Term.scanTerm(scan); t != null; t = Term.scanTerm(scan)) {
            terms.add(t);
        }
    }

    /**
     * The copy constructor for making a deep copy
     *
     * @param p the copied polynomial
     *
     */
    public Polynomial(Polynomial p) {
        terms = new LinkedList<>();
        for (Term t : p.terms) {
            terms.add(new Term(t));
        }
    }

    /**
     * A straightforward conversion of a Polynomial into a string based on the
     * toString for terms
     *
     * @return a readable string representation of this
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < terms.size(); i++) {
            if (i == 0) {
                s += terms.get(i).toString();
            } else if (terms.get(i).getCoef() > 0) {
                s += " + " + terms.get(i).toString();
            } else {
                s += " " + terms.get(i).toString() + " ";
            }
        }
        return s;
    }
    
    public Double apply(Double x){
        Double result = 0.0;
        for (Term t: terms){
            result += t.getCoef()*x;
        }
        return result;
    }

    public void plus(Polynomial b) {
        ListIterator<Term> lita = terms.listIterator(),
                litb = b.terms.listIterator();
        while (lita.hasNext() && litb.hasNext()) {
            Term ta = lita.next(), tb = litb.next();
            if (ta.getExp() == tb.getExp()) {
                ta.plus(tb);
                if (ta.getCoef() == 0) {
                    lita.remove();
                }
            } else if (ta.getExp() > tb.getExp()) {
                tb = litb.previous();
                if (!lita.hasNext())
                    while(litb.hasNext()){
                        tb = litb.next();
                        lita.add(new Term(tb.getCoef(), tb.getExp()));
                    }
                //System.out.println("litb: " + litb.previous());

            } else {//ta.getExp < tb.getExp
                ta = lita.previous();
                lita.add(tb);
                //System.out.println("lita: " + lita.previous());
            }

        }
        //clean up
//        lita = terms.listIterator();
//        while (lita.hasNext()) {
//            if (lita.next().getCoef() == 0) {
//                lita.remove();
//            }
//        }
    }

    public void minus(Polynomial b) {
        ListIterator<Term> lita = terms.listIterator(),
                litb = b.terms.listIterator();
        while (lita.hasNext() && litb.hasNext()) {
            Term ta = lita.next(), tb = litb.next();
            if (ta.getExp() == tb.getExp()) {
                ta.minus(tb);
                if (ta.getCoef() == 0) {
                    lita.remove();
                }
            } else if (ta.getExp() > tb.getExp()) {
                tb = litb.previous();
                if (!lita.hasNext())
                    while(litb.hasNext()){
                        tb = litb.next();
                        lita.add(new Term(-tb.getCoef(), tb.getExp()));
                    }
                //System.out.println("litb: " + litb.previous());

            } else { //ta.getExp < tb.getExp
                ta = lita.previous();
                lita.add(new Term(-tb.getCoef(), tb.getExp()));
                //System.out.println("lita: " + lita.previous());
            }

        }
    }

    public void times(Polynomial b) {
        ListIterator<Term> lita = terms.listIterator(),
                litb = b.terms.listIterator();
        Polynomial copy = new Polynomial("0 0");
//        for (Term t : terms) {
//            copy.terms.add(new Term(0, 0));
//        }
        while (lita.hasNext()) {
            Term ta = lita.next();
            Term temp = new Term(ta.getCoef(), ta.getExp());
            Polynomial step = new Polynomial();
            for (int i = 0; i < b.terms.size(); i++) {
                ta.times(b.terms.get(i));
                step.terms.add(ta);
                ta = new Term(temp.getCoef(), temp.getExp());
            }
            copy.plus(step);
        }

        //deepCopy
        terms = new LinkedList<>();
        for (Term t : copy.terms) {
            terms.add(t);
        }

    }

    public void divide(Polynomial b) {
    }

    @Override
    public boolean equals(Object other_poly) {
        return false;
    }

}
