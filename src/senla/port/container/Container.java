package senla.port.container;


public abstract class Container {



    public abstract double getVolume();

    public double getDiagonal() {
        int a = (int)Math.random()*1+1;
        switch (a) {
            case 1:
                return 10;

            default:
                return 20;
                        }
    }

    public int getWaterDesnity(){
        int i =(int)Math.random()*2+1;
        if(i==1){
            return 1000;
        }
        else {
            return 2000;
        }
    }

    public int getHeight(){
        return (int)Math.random()*10+10;
    }

    public double getMassOffContainer() {

        return getVolume() * getWaterDesnity();
    }




}
