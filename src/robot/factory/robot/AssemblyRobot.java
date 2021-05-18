package robot.factory.robot;

import robot.factory.plants.PlantsOfBody;
import robot.factory.plants.PlantsOfHead;

public class AssemblyRobot {

    ;
    PlantsOfBody body=new PlantsOfBody();
    PlantsOfHead head=new PlantsOfHead();



    public Robot[] assemble(int count) {
        int numOfRobot=0;
        Robot[] robot=new Robot[count];
        for (int i=1;i<=3;i++){
            for (int j=1;j<=3;j++){
                robot[numOfRobot]=new Robot(getname(numOfRobot),body.getComponent(i),head.getComponent(j));
                numOfRobot++;
        }

        }
       return robot;
    }
    public RobotName getname(int i) {

        return switch (i) {
            case 0 -> RobotName.TANYA;
            case 1 -> RobotName.SASHA;
            case 2 -> RobotName.PIDOR;
            case 3 -> RobotName.OLYA;
            case 4 -> RobotName.NATASHA;
            case 5 -> RobotName.MAXIM;
            case 6 -> RobotName.LESHA;
            case 7 -> RobotName.DIMA;
            case 8 -> RobotName.DASHA;
            default -> null;
        };
    }
}