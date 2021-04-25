package senla.robot.factory.plants;

import senla.robot.factory.Component.Component;
import senla.robot.factory.type.Type;


public class PlantsOfHead implements Plants {
Component component=new Component();



    @Override
    public Type getComponent(int i) {

        return   component.getType(i);


    }
}
