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

class Card {
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

class Deck {
  private List<Card> cards;

  public Deck() {
    cards = new ArrayList<Card>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        cards.add(new Card(suit, rank));
      }
    }
  }

  public void Shuffle() {
    Collections.shuffle(cards);
  }

  public List<Card> getCards() {
    return cards;
  }

  public Card draw() {
    if (cards.isEmpty()) {
      throw new IllegalStateException("Deck is empty");
    }
    // top of this list
    return cards.remove(0);
  }
}

class Hand {
  private List<Card> cards;
  private Deck deck;

  public Hand(Deck deck) {
    this.cards = new ArrayList<Card>();
    this.deck = deck;
  }

  public void addCard() {
    Card card = deck.draw();
    cards.add(card);
  }

  public List<Card> getCards() {
    return cards;
  }
}

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.Shuffle();

        Hand hand = new Hand(deck);

        for (int i = 0; i < 5; i++) {
            hand.addCard();
        }


        System.out.println("Remaining deck:");
        for (Card card : deck.getCards()) {
            System.out.println(card.getRank() + " of " + card.getSuit());
        }
    }
}


  
