package com.scut.crm.constant;

import java.util.HashMap;
import java.util.Map;

public final class PropertyMapConst {

    /**专利类型*/
    public final static Map<String,Object> PATENT_TYPE_MAP = new HashMap();
    /**专利状态*/
    public final static Map<String,Object> PATENT_STATE_MAP = new HashMap();

    /**静态代码块*/
    static {
        PATENT_TYPE_MAP.put(EntityNumberConst.ONE,"发明专利");
        PATENT_TYPE_MAP.put(EntityNumberConst.TWO,"实用新型专利");
        PATENT_TYPE_MAP.put(EntityNumberConst.THREE,"外观设计专利");

        PATENT_STATE_MAP.put(EntityNumberConst.ONE,"专利申请尚未授权");
        PATENT_STATE_MAP.put(EntityNumberConst.TWO,"专利申请撤回");
        PATENT_STATE_MAP.put(EntityNumberConst.THREE,"专利权有效");
    }
}
