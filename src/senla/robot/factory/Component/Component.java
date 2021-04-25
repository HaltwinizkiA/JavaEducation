package senla.robot.factory.Component;


import senla.robot.factory.type.Type;

public class Component {


    public Type getType(int i){
        return switch (i) {
            case 1 -> Type.METAL;
            case 2 -> Type.PLASTIC;
            case 3 -> Type.WOOD;
            default -> null;
        };

    }


}
