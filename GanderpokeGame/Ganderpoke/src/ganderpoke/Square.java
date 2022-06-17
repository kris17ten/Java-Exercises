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
public class Square {
    private int value;
    private List<Card> cards = new ArrayList<>();

    //blank constructor
    public Square() {
    }
    
    //arg constructor
    public Square(int value, List<Card> cards) {
        this.value = value;
        this.cards = cards;
    }
    
      /////////////////////////////
     //   GETTERS AND SETTERS   //
    /////////////////////////////
    
    public int getValue() {
        return value;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
    
    
    //remove card from square
    public void removeCard(Card c) {
        // in the square find the index of c
        for (int i = 0; i < this.cards.size(); i++) {
            if (this.cards.get(i) == c) {
                //set it to null
                this.cards.set(i, null);
                
                return;
            }
        }
        
    }
    
    public void placeCard(Card c) {
        //initialize null space
        int nullIndex;
        
        //find the null space
        for (int i = 0; i < this.cards.size(); i++) {
            if (this.cards.get(i) == null) {
                nullIndex = i;
                //place the card in the null space
                this.cards.add(nullIndex, c);
                //set the state of the card to face up
                c.setState(State.FACE_UP);
                
                return;
            }
        }
        
    }
    
    //are all the cards in the square face up?
    public boolean notAllFaceUpCards() {
        for (Card card : this.getCards()) {
            if (card.getState() == State.FACE_DOWN) {
                return true;
            }
        }
        return false;
    }
    
    //break down the square for scoring the value
    public void breakDownSquare() {
        // reset the value
        this.value = 0;
        
        //break down
        for (int i = 0; i < 5; i++) {
            //row and column
            List<Card> row = new ArrayList<>();
            List<Card> column = new ArrayList<>();
            
            //get the cards
            for (int j = 0; j < 5; j++) {
                row.add(this.cards.get((i * 5) + j));
                column.add(this.cards.get((j * 5) + i));
            }
            
            //set the value by adding
            this.value += this.makeHighCombo(row).getScore();
            this.value += this.makeHighCombo(column).getScore();
        }
    }
    
    //find the highest Poker combination
    public PokerCombo makeHighCombo(List<Card> cards) {
        if(hasStraightFlush(cards)) {
            return new PokerCombo(Combination.STRAIGHT_FLUSH, 10);
        }
        else if(this.hasFourOfAKind(cards)) {
            return new PokerCombo(Combination.FOUR_OF_A_KIND, 8);
        }
        else if(this.hasFlush(cards)) {
            return new PokerCombo(Combination.FLUSH, 5);
        }
        else if(this.hasStraight(cards)) {
            return new PokerCombo(Combination.STRAIGHT, 5);
        }
        else if(this.hasFullHouse(cards)) {
            return new PokerCombo(Combination.FULL_HOUSE, 5);
        }
        else if(this.hasTriplet(cards)) {
            return new PokerCombo(Combination.TRIPLET, 3);
        }
        else if(this.hasTwoPairs(cards)) {
            return new PokerCombo(Combination.TWO_PAIR, 2);
        }
        else if(this.hasOnePair(cards)) {
            return new PokerCombo(Combination.ONE_PAIR, 1);
        }
        else {
            return new PokerCombo(Combination.HIGH_CARD, 0);
        }
    }
    
    //sort cards by rank and suit
    public void sortByRankAndSuit(List<Card> cards) {
        cards.sort(Comparator.comparing(Card::getNumericValue));
    }
    
    //sort cards by rank
    public void sortByRank(List<Card> cards) {
        cards.sort(Comparator.comparing(Card::getRankAsNumber));
    }
    
    //count the number of cards by rank
    private int countIfRank(List<Card> cards, Rank rank) {
        int count = 0;

        for (Card card : cards) {
            if (card.getRank() == rank) {
                count++;
            }
        }

        return count;
    }
    
    //does the list of cards contain the Joker?
    private boolean containsJoker(List<Card> cards) {
        for (Card card : cards) {
            if (card.getCardType() == CardType.JOKER) {
                return true;
            }
        }

        return false;
    }
    
      /////////////////////////////////////////
     //   all possible PokerCombo methods   //
    /////////////////////////////////////////
    
    public boolean hasStraightFlush(List<Card> cards) {
        return this.hasStraight(cards) && this.hasFlush(cards);
    }
    
    public boolean hasFourOfAKind(List<Card> cards) {
        boolean containsJoker = this.containsJoker(cards);

        for (Card card : cards) {
            //get the count of cards with the current rank
            int countCardsOfRank = this.countIfRank(cards, card.getRank());

            //if the count is 4, return true
            if ((countCardsOfRank == 4 || countCardsOfRank == 3 && containsJoker)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasFlush(List<Card> cards) {
        Suit suit = null;
        int counter = 0;
        boolean containsJoker = this.containsJoker(cards);
        
        //if card doesnt match, set counter to 0
        for (Card card : cards) {
            if (card.getSuit() != suit) {
                counter = 0;
                suit = card.getSuit();

                continue;
            }

            //if correct card, increment the counter
            counter++;

            if ((counter == 4) || ((counter == 3) && containsJoker)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasStraight(List<Card> cards) {
        int previousCardValue = 0;
        int counter = 0;
        boolean containsJoker = ! this.containsJoker(cards);

        for (Card card : cards) {
            //if the value of the card is not the initial value + 1, reset
            if ((previousCardValue > 0) && (card.getRank().getNumericValue() != (previousCardValue + 1))) {
                if (containsJoker) {
                    counter = 0;
                    containsJoker = ! this.containsJoker(cards);
                    previousCardValue = card.getRank().getNumericValue();

                    continue;
                } else {
                    containsJoker = true;
                }
            }

            //if it is a correct card, increment the counter
            previousCardValue = card.getRank().getNumericValue();
            counter++;

            if ((counter == 4) || ((counter == 3) && ! containsJoker)) {
                return true;
            }
        }

        return false;
    }
    
    public boolean hasFullHouse(List<Card> cards) {
        Rank checkIfTripletValue = null;
        boolean containsJoker = this.containsJoker(cards);

        //find a triplet
        for (Card card : cards) {
            //get the count of cards with the current rank
            int countCardsOfRank = this.countIfRank(cards, card.getRank());

            //if the count is three or two with a joker, set the triplet
            if ((countCardsOfRank == 3) || ((countCardsOfRank == 2) && containsJoker)) {
                checkIfTripletValue = card.getRank();

                break;
            }
        }

        if (checkIfTripletValue == null) {
            return false;
        }

        //find a pair
        for (Card card : cards) {
            //get the count of cards with the current rank
            int countCardsOfRank = this.countIfRank(cards, card.getRank());

            //if the count is three or two with a joker...
            if ((countCardsOfRank == 2) && (card.getRank() != checkIfTripletValue)) {
                return true;
            }
        }

        return false;
    }
    
    public boolean hasTriplet(List<Card> cards) {
        boolean containsJoker = this.containsJoker(cards);

        for (Card card : cards) {
            //get the count of cards with the current rank
            int countCardsOfRank = this.countIfRank(cards, card.getRank());

            //if the count is 3, return true
            if (countCardsOfRank == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean hasTwoPairs(List<Card> cards) {
        Rank checkIfFirstPairValue = null;
        boolean containsJoker = this.containsJoker(cards);

        //find a pair
        for (Card card : cards) {
            //get the count of cards with the current rank
            int countCardsOfRank = this.countIfRank(cards, card.getRank());

            //if the count is two or one with a joker, set...
            if ((countCardsOfRank == 2) || ((countCardsOfRank == 1) && containsJoker)) {
                checkIfFirstPairValue = card.getRank();

                break;
            }
        }

        if (checkIfFirstPairValue == null) {
            return false;
        }

        //find another pair
        for (Card card : cards) {
            //get the count of cards with the current rank
            int countCardsOfRank = this.countIfRank(cards, card.getRank());

            //if the count is two or one with a joker, return true
            if ((countCardsOfRank == 2) && (card.getRank() != checkIfFirstPairValue)) {
                return true;
            }
        }

        return false;
    }
    
    public boolean hasOnePair(List<Card> cards) {
        boolean containsJoker = this.containsJoker(cards);

        for (Card card : cards) {
            //get the count of cards with the current rank
            int countCardsOfRank = this.countIfRank(cards, card.getRank());

            //if the count is the 2, return true
            if (countCardsOfRank == 2) {
                return true;
            }
        }
        return false;
    }
}
