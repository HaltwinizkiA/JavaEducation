package senla.port.deck;


import senla.port.container.Container;

public class Deck {
    Container[] containers;
    int count=0;
    float mass;



    public Deck(Container[] containers) {
        this.containers = containers;
    }
    public float getsMassOffDeck(){

        for (int i=0;i<containers.length;i++) {
            if (count < 4) {
                if (containers[i].getDiagonal()== 10) {
                    count++;
                    mass+=containers[i].getMassOffContainer();
                } else if(count<3) {
                    count += 2;
                    mass+=containers[i].getMassOffContainer();
                }
             }

        }
        return mass;
    }




}