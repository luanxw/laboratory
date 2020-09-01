package com.app.luan.handler.byInterface;

import org.springframework.util.StringUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * 工厂模式
 * */

public class Factory {

    private static Map<String  , Handler> strategyMap = new HashMap<>();

    public static Handler getInvokeStrategy(String work){
        return strategyMap.get(work);
    }

    public static void register(String work , Handler handl){
        if (StringUtils.isEmpty(work) || handl == null){
            return;
        }
        strategyMap.put(work, handl);
    }
}
