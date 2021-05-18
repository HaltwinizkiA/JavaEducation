package port.ship;


import port.deck.Deck;

public class Ship {
private Deck[] decks;


    public Ship(Deck[] decks) {
        this.decks = decks;

    }




    public float getMassOffwaterOnShip(){
        float mass=0;

        int count=(int)Math.random()*2+1;
        for (int i=0;i<count;i++) {

            mass+=decks[i].getsMassOffDeck();
        }

        return mass;
    }
}



