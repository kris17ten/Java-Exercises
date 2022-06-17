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
public class PokerCombo {
    private Combination combo;
    private int score;

    public PokerCombo(Combination combo, int score) {
        this.combo = combo;
        this.score = score;
    }
    
      /////////////////////////////
     //   GETTERS AND SETTERS   //
    /////////////////////////////
    
    public Combination getCombo() {
        return combo;
    }

    public int getScore() {
        return score;
    }

    private void setCombo(Combination combo) {
        this.combo = combo;
    }

    private void setScore(int score) {
        this.score = score;
    }
    
    //sort by rank and suit
    public void sortByRankAndSuit(List<Card> cards) {
        cards.sort(Comparator.comparing(Card::getNumericValue));
    }
    
    //sort by rank
    public void sortByRank(List<Card> cards) {
        cards.sort(Comparator.comparing(Card::getRankAsNumber));
    }
    
    //count number of cards based on their rank
    private int countIfRank(List<Card> cards, Rank rank) {
        int count = 0;

        for (Card card : cards) {
            if (card.getRank() == rank) {
                count++;
            }
        }

        return count;
    }
    
    //does the list of cards contain a Joker?
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
