package robot.factory.robot;


import robot.factory.type.Type;

public class Robot {
    RobotName name;
    Type body;
    Type head;

    public RobotName getName() {
        return name;
    }

    public Type getBody() {
        return body;
    }

    public Type getHead() {
        return head;
    }

    public Robot(RobotName name, Type body, Type head) {
        this.name = name;
        this.body = body;
        this.head = head;
    }
}




//         if(name<=9){
//            switch (name) {
//                case 1:
//                    name++;
//                    return RobotName.DASHA.toString();
//                case 2:
//                    name++;
//                    return RobotName.DIMA.toString();
//                case 3:
//                    name++;
//                    return RobotName.LESHA.toString();
//                case 4:
//                    name++;
//                    return RobotName.MAXIM.toString();
//                case 5:
//                    name++;
//                    return RobotName.NATASHA.toString();
//                case 6:
//                    name++;
//                    return RobotName.OLYA.toString();
//                case 7:
//                    name++;
//                    return RobotName.PIDOR.toString();
//                case 8:
//                    name++;
//                    return RobotName.SASHA.toString();
//                case 9:
//                    name++;
//                    return RobotName.TANYA.toString();
//            }
//
//        }
//         else {name=1;}
