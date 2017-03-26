package polynomial;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * A skeleton class for representing Polynomials
 *
 * @author Sjaak Smetsers
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
                while (ta.getExp() > tb.getExp()) {
                    ta = lita.next();
                }
                if (ta.getExp() == tb.getExp()) {
                    ta.plus(tb);
                    if (ta.getCoef() == 0) {
                        lita.remove();
                    }
                }

            }
        }
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
                while (ta.getExp() > tb.getExp()) {
                    if (lita.hasNext()){
                    ta = lita.next();
                    if (ta.getExp() == tb.getExp()) {
                        ta.minus(tb);
                        if (ta.getCoef() == 0) {
                            lita.remove();
                        }
                    }
                    }
                    else {
                        terms.add(tb);
                    }
                }
            } else { //ta.getExp < tb.getExp
                terms.add(0, tb);
            }

        }
    }

    public void times(Polynomial b) {
    }

    public void divide(Polynomial b) {
    }

    @Override
    public boolean equals(Object other_poly) {
        return false;
    }

}
