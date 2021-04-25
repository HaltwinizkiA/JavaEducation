package senla.port.container;

public class ContainerCone extends Container {


    @Override
    public double getVolume() {
        return getHeight()/3*3.14*Math.pow((getDiagonal()/2),2);
    }

}
