package robot.factory.plants;

import robot.factory.Component.Component;
import robot.factory.type.Type;


public class PlantsOfHead implements Plants {
Component component=new Component();



    @Override
    public Type getComponent(int i) {

        return   component.getType(i);


    }
}
