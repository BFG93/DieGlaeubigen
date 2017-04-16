/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opgave9;

/**
 * @author Christian Lammers 4578236
 * @author Clemens Beissel 4547330
 */
public abstract class Topping extends IJsje {

    protected final IJsje ijsje;

    public Topping(IJsje ijsje) {
        this.ijsje = ijsje;
    }

    public int prijs() {
        return ijsje.prijs();
    }

    public String geefBeschrijving() {
        return ijsje.geefBeschrijving();

    }
}
