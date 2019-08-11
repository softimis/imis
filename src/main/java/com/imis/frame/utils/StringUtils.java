package com.imis.frame.utils;

import java.util.UUID;

/**
 * Description：
 * Author: zcx
 * Date: Created in 2019/8/4 15:38
 * Version: 1.0
 */
public class StringUtils {

    /**
     * Description：判断字符串是否为空
     * Author: zcx
     * Date: Created in 2019-08-04 15:41:47
     * Version: 1.0
     */
    public static boolean isEmpty(Object str){
        return str==null || str.toString().isEmpty();
    }

    /**
     * Description：获取UUID
     * Author: zcx
     * Date: Created in 2019-08-04 15:43:17
     * Version: 1.0
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-","");
    }

}
