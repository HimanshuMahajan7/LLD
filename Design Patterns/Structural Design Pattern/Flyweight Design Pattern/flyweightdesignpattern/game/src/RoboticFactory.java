package flyweightdesignpattern.game.src;

import java.util.HashMap;
import java.util.Map;

public class RoboticFactory {
    private static Map<String, IRobot> roboticObjectCache = new HashMap<>();

    public static IRobot createRobot(String robotType) {
        if (roboticObjectCache.containsKey(robotType)) {
            return roboticObjectCache.get(robotType);
        } else {
            if(robotType.equals("HUMANOID")) {
                Spirit humanoidSpirit = new Spirit();
                IRobot humanoidObject = new HumaniodRobot(robotType, humanoidSpirit);
                roboticObjectCache.put(robotType, humanoidObject);
                return humanoidObject;
            } else if(robotType.equals("ROBOTICDOG")) {
                Spirit roboticDogSpirit = new Spirit();
                IRobot roboticDogObject = new RoboticDog(robotType, roboticDogSpirit);
                roboticObjectCache.put(robotType, roboticDogObject);
                return roboticDogObject;
            }
        }
        return null;
    }
}
