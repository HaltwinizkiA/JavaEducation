package senla.port.container;

public class ContainerSquare extends Container {




    @Override
    public double getVolume() {
        return Math.pow(getDiagonal(),2)/2*getHeight();
    }


}
