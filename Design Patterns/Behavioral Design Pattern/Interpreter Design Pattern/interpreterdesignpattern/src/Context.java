package interpreterdesignpattern.src;

import java.util.HashMap;
import java.util.Map;

public class Context {

    Map<String, Integer> contextMap = new HashMap<>();

    public void put(String stringValue, int intValue) {
        contextMap.put(stringValue, intValue);
    }

    public int get(String stringValue) {
        return contextMap.get(stringValue);
    }
}
