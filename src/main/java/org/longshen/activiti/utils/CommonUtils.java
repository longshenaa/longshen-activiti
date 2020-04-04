package org.longshen.activiti.utils;

import java.util.UUID;

/**
 * 公用方法
 */
public class CommonUtils {
    /**
     * 生成UUID
     * @return
     */
    public static String getUuid(){
        String uuid = UUID.randomUUID().toString();
        return "a" + uuid.replace("-", "");
    }
}
