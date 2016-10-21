/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.administration;

/**
 *
 * @author SI-MJLDH
 */
public enum EnumGenre {
    M("Masculin"),
    F("Féminin");
   
    private final String label;

    private EnumGenre(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
