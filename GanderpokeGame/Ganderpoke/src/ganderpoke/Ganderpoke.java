/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ganderpoke;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kristen
 */
public class Ganderpoke {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Game game = new Game();
        
        //create players
        List<Player> players = new ArrayList<>();
        players.add(new Player(PlayerNumber.PLAYER1, 0, new Hand()));
        players.add(new Player(PlayerNumber.PLAYER2, 0, new Hand()));
        
        game.setPlayers(players);
        
        //set square
        game.setSquare(new Square());
        
        //turn
        Turn turn1 = new Turn(game.getPlayers().get(0));
        
        game.startGame(players);
    }
    
}

