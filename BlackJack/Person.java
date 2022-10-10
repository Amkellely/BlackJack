package BlackJack;

public abstract class Person {

    //hand holds the Persons active playing cards
    private Hand hand;
    //their name will be either Player or Dealer, this String just holds that info
    private String name;

    public Person(){
        //Give them a Hand and a name
        this.hand = new Hand();
        this.name = "";
    }

    public Hand getHand(){
        return this.hand;
    }
    public void setHand(Hand hand){
        this.hand = hand;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public void printHand(){
        System.out.println(this.name + "'s hand looks like this:");
        System.out.println(this.hand + " Valued at: " + this.hand.calculatedValue());
    }

    public void hit(Deck deck, Deck discard){

        //If there's no cards left in the deck
        if (!deck.hasCards()) {
            //reload the deck from the discard pile
            deck.reloadDeckFromDiscard(discard);
        }
        //take a card from the deck
        this.hand.takeCardFromDeck(deck);
        System.out.println(this.name + " gets a card");
        //print out the hand
        this.printHand();
        //pause for a moment
        Game.pause();

    }
    public boolean hasBlackjack(){
        if(this.getHand().calculatedValue() == 21){
            return true;
        }
        else{
            return false;
        }
    }
}
