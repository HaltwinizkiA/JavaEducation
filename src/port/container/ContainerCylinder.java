package port.container;

public class ContainerCylinder extends Container{

    @Override
    public double getVolume() {
        return (3.14*Math.pow((getDiagonal()/2),2)) / (4*getHeight());


    }
}
