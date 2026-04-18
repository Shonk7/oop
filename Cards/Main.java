package Cards;

import java.util.*;

enum Suit {
    HEARTS, DIAMONDS, CLUBS, SPADES
}

enum Rank {
    A(1), TWO(2), THREE(3), FOUR(4), FIVE(5),
    SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    J(10), Q(10), K(10);

    private final int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class Card {
  private Suit suit;
  private Rank rank;

  public Card(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
  }


  public Suit getSuit() {
      return suit;
  }

  public Rank getRank() {
      return rank;
  }

  public int getVal() {
      return rank.getValue();
  }

}

public class Deck {
  List<Card> cards;

  public Deck() {
    this.cards = new ArrayList<Card>();
    for s in suit:
  }

  public
}

public class Main {
  public static void main(String[] args) {
    Deck deck = new Deck();
  }
  
}
