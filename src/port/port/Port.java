package port.port;


import port.ship.Ship;

public class Port  {
    Ship[] ship;
    public Port(Ship[] ship) {
        this.ship = ship;
    }

public void MassOfallShip(){
        float mass=0;
        for (int i=0;i<ship.length;i++){
            mass+=ship[i].getMassOffwaterOnShip();
            System.out.println("Ship num :"+(i+1)+" mass: "+ship[i].getMassOffwaterOnShip());
        }
    System.out.println("Water mass off all ships : "+mass);
}

}






