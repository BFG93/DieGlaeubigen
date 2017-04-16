/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opgave9;

/**
 *
 * @author Christian Lammers 4578236
 * @author Clemens Beissel 4547330
 */
public abstract class IJsje {
    
    protected String beschrijving;

    

    public IJsje() {
        beschrijving = "onbekend ijsje";
    }

    public String geefBeschrijving() {
        return beschrijving;

    }
    
    public abstract int prijs();
}
