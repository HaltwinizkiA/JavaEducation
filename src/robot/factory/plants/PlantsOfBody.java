package robot.factory.plants;


import robot.factory.Component.Component;
import robot.factory.type.Type;

public class PlantsOfBody implements Plants {
    Component component = new Component();



    @Override
    public Type getComponent(int i) {

        return switch (i) {
            case 1 -> component.getType(i);
            case 2 -> component.getType(i);
            case 3 -> component.getType(i);
            default -> null;
        };


    }
}

