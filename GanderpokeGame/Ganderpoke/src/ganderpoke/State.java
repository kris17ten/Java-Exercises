/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ganderpoke;

/**
 *
 * @author Kristen
 */
public enum State {
    IN_HAND("IN_HAND"), FACE_UP("FACE_UP"), FACE_DOWN("FACE_DOWN");
    
    private final String name;
    
    State(String name) {
        this.name = name;
    }
    
    //to string
    @Override
    public String toString() {
        return this.name;
    }
}
