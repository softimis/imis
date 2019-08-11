package com.imis.frame.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description: 日期工具类
 * Author: zcx
 * Date: Created in 2019/8/4 22:13
 * Version: 1.0
 */
public class DateUtils {

    /**
     * Description: 格式化日期（格式为：yyyy-MM-dd）
     * Author: zcx
     * Date: Created in 2019-08-04 22:17:09
     * Version: 1.0
     */
    public static String formaterDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * Description: 格式化时间（格式为：HH:mm:ss）
     * Author: zcx
     * Date: Created in 2019-08-04 22:20:06
     * Version: 1.0
     */
    public static String formaterTime(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * Description:  格式化日期时间（格式为：yyyy-MM-dd HH:mm:ss）
     * Author: zcx
     * Date: Created in 2019-08-04 22:22:30
     * Version: 1.0
     */
    public static String formaterDateTime(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /***
     * Description:  获取当前日期（yyyy-MM-dd）
     * Author: zcx
     * Date: Created in 2019-08-04 22:23:32
     * Version: 1.0
     */
    public static String getCurrentDate(){
        return formaterDate(new Date());
    }

    /**
     * Description:  获取当前时间（HH:mm:ss）
     * Author: zcx
     * Date: Created in 2019-08-04 22:24:29
     * Version: 1.0
     */
    public static String getCurrentTime(){
        return formaterTime(new Date());
    }

    /**
     * Description: 获取当前日期时间（yyyy-MM-dd HH:mm:ss）
     * Author: zcx
     * Date: Created in 2019-08-04 22:25:17
     * Version: 1.0
     */
    public static String getCurrentDateTime(){
        return formaterDateTime(new Date());
    }
}
