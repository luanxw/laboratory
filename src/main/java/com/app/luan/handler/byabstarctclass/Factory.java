package com.app.luan.handler.byabstarctclass;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class Factory {

    private static Map<String , Handler> handlerMap = new HashMap<>();

    public static Handler getstarteHandler(String worker){
        return handlerMap.get(worker);
    }

    public static void register(String woker, Handler handler){
        if (StringUtils.isEmpty(woker) || null == handler){
            return;
        }
        handlerMap.put(woker, handler);
    }

}
