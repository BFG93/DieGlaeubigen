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
public class Slagroom extends Topping {
    public Slagroom(IJsje ijsje){
        super(ijsje);
    }

    @Override
    public int prijs() {
        return super.prijs() + 50;
    }
    
}
