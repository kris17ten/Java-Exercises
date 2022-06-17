/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ganderpoke;

import java.util.*;
/**
 *
 * @author Kristen
 */
public class Game {
    private int rounds;
    private int currentRound;
    private Square square;
    private Pack pack;
    private List<Player> players = new ArrayList<>();

    public Game() {
        this.pack = new Pack();
    }
    
      /////////////////////////////
     //   GETTERS AND SETTERS   //
    /////////////////////////////
    
    public int getRounds() {
        return rounds;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public Square getSquare() {
        return square;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setSquare(Square square) {
        this.square = square;
    }
    
    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }
    
    
    //start game
    public void startGame(List<Player> players) {
        this.players = players;
        
        //get number of rounds from user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rounds:  ");
        this.rounds = input.nextInt();
        
        //set current round to one
        this.currentRound = 1;
        
        //for the number of rounds, play a round
        for (int i = 0; i < rounds; i++) {
            this.playARound();
        }
        
        //draw
        if(this.players.get(0).getScore() == this.players.get(1).getScore()) {
            System.out.print("This game has ended in a draw!");
        }
        //player1 wins
        else if(this.players.get(0).getScore() > this.players.get(1).getScore()) {
            System.out.print("Player1 wins!");
            System.out.print("Player1 score:" + this.players.get(0).getScore());
            System.out.print("Player2 score:" + this.players.get(1).getScore());
        }
        //player2 wins
        else {
            System.out.print("Player2 wins!");
            System.out.print("Player1 score:" + this.players.get(0).getScore());
            System.out.print("Player2 score:" + this.players.get(1).getScore());
        }
        
    }
    
    //Play round
    //shuffle, play, announce winner
    
    public void playARound() {
        this.dealCards();
        
        // Get both players
        Player currentPlayer = this.players.get(0);
        Player otherPlayer = this.players.get(1);
        
        while (this.square.notAllFaceUpCards()) {
            this.playATurn(currentPlayer, otherPlayer);
            //switch players
            currentPlayer = this.players.get(1);
            otherPlayer = this.players.get(0);
        }
        
        PokerCombo playerOneHighCombo = this.players.get(0).getHand().makeHighCombo(this.players.get(0).getHand().getCards());
        PokerCombo playerTwoHighCombo = this.players.get(0).getHand().makeHighCombo(this.players.get(1).getHand().getCards());
        PokerCombo playerOneLowCombo = this.players.get(0).getHand().makeLowCombo(this.players.get(0).getHand().getCards());
        PokerCombo playerTwoLowCombo = this.players.get(0).getHand().makeLowCombo(this.players.get(1).getHand().getCards());
        
        int scoreHP1 = playerOneHighCombo.getScore();
        int scoreHP2 = playerTwoHighCombo.getScore();
        int scoreLP1 = playerOneLowCombo.getScore();
        int scoreLP2 = playerTwoLowCombo.getScore();
        
        this.square.breakDownSquare();
        
        int squareValue = this.square.getValue();
        
        //assign score to players
        //the highest PokerCombo
        if(scoreHP1 > scoreHP2) {
            this.players.get(0).setScore(2 * squareValue);
        }
        else {
            this.players.get(1).setScore(2 * squareValue);
        }
        
        //set score
        if(scoreHP1 < scoreHP2) {
            this.players.get(0).setScore(squareValue);
        }
        else {
            this.players.get(1).setScore(squareValue);
        }
    }
    
    //deal cards to square and player
    private void dealCards() {
        //re-shuffle the pack
        this.pack.shuffle();

        //deal cards to the square
        this.square.setCards(this.pack.getCardsForSquare());

        //deal cards to both players
        this.players.get(0).getHand().setCards(this.pack.getCardsForPlayerOne());
        this.players.get(1).getHand().setCards(this.pack.getCardsForPlayerTwo());
    }

    //play turn
    private void playATurn(Player currentPlayer, Player otherPlayer) {
        
        //display square
        this.displaySquare();
        
        //retrieve card from user
        String confirm;
        int rowNumber;
        int colNumber;
        do {
        Scanner input = new Scanner(System.in);
        System.out.print("\n\nSelect card from square.\n Enter row number(1-5):  ");
        rowNumber =  input.nextInt();
        
        System.out.print("\n\nSelect card from square.\n Enter column number(1-5):  ");
        colNumber = input.nextInt();
        
        this.selectCardFromSquare(rowNumber, colNumber);
        
        //confirm card selection
        System.out.print("\n\nSAre you sure you would like to select this card? (Y/N)  ");
        confirm = input.next();
        }
        while(confirm.equals("N") || confirm.equals("n"));
        
        //addCard to currentPlayer hand
        currentPlayer.getHand().addCard(this.getCardFromSquare(rowNumber, colNumber));
        //change state
        this.getCardFromSquare(rowNumber, colNumber).setState(State.IN_HAND);

        //removeCard from square
        this.square.removeCard(this.getCardFromSquare(rowNumber, colNumber));
        
        
        //display player's hand
        System.out.println("Player's Hand");
        currentPlayer.displayHand();
        
        //ask currentPlayer to select card from hand
        int index;
        do {
        Scanner input = new Scanner(System.in);
        System.out.print("\n\nSelect card from hand.\n Enter index(1-9):  ");
        index =  input.nextInt() - 1;
        
        //display hand
        currentPlayer.displayHand();
        
        //confirm card selection
        System.out.print("\n\nSAre you sure you would like to select this card? (Y/N)  ");
        confirm = input.next();
        }
        while(confirm.equals("N") || confirm.equals("n"));
        
        //placeCard on Square
        this.square.placeCard(currentPlayer.getCardFromHand(index));
        
        //removeCard from Hand
        currentPlayer.getHand().removeCard(currentPlayer.getHand().getCards().get(index));
        
        
        //switch players
        System.out.println("\n\n Next Player's Turn");
        
        
    }
    
    public void displaySquare() {
        for(int i=0; i < this.square.getCards().size(); i++) {
            System.out.print("  " + this.square.getCards().get(i).toString() + "  ");
            if(i % 5 == 4) {
                System.out.print("\n");
            }
        }
    }
    
    //select card from square
    public void selectCardFromSquare(int rowNo, int colNo) {
        int index = ((rowNo * 5) + colNo) - 6;
        
        for(int i=0; i < this.square.getCards().size(); i++) {
            if(i == index) {
                if(colNo == 5) {
                    System.out.print(" >" + this.square.getCards().get(i).toString() + "< \n");
                    break;
                }
                else {
                    System.out.print(" >" + this.square.getCards().get(i).toString() + "< ");
                }
            }
            else {
            System.out.print("  " + this.square.getCards().get(i).toString() + "  ");
            }
            if(i % 5 == 4) {
                System.out.print("\n");
            }
        }
    }
    
    
    //select card from square
    public Card getCardFromSquare(int rowNo, int colNo) {
        int index = ((rowNo * 5) + colNo) - 6;
        return this.square.getCards().get(index);
    }
}