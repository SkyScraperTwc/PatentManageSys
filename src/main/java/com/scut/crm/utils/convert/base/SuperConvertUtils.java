package com.scut.crm.utils.convert.base;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class SuperConvertUtils {
    /**
     * getUnmodifiableMap
     * @param map
     * @return
     */
    public static Map<String,Object> getUnmodifiableMap(Map<String,Object> map){
        return Collections.unmodifiableMap(map);
    }

    public static String getKeyByValue(Map<String,Object> map, String value){
        Set<String> kSet = map.keySet();
        for (String key : kSet) {
            if(value.equals(map.get(key))){
                return key;
            }
        }
        return null;
    }

    public static Object getValue(Map<String,Object> map, String key){
        return map.get(key);
    }
}
