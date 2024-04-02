package cn.pangchun.patterns.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用容器实现单例模式
 * 
 * @author pangchun
 * @since 2023/10/19
 */
public class SingletonManager {

    private static Map<String, Object> map = new HashMap<>();

    private SingletonManager() {
    }

    public static void registerService(String key, Object instance) {
        if (!map.containsKey(key)) {
            map.put(key, instance);
        }
    }

    public static Object getService(String key) {
        return map.get(key);
    }
}
