/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

/**
 *
 * @author cucus
 */
public class bob {
    public String a;
    public Integer b;
    bob(){
        this.a="test";
        b=1;
    }
    @Override
    public String toString(){
        return a+Integer.toString(b);
    }
}
