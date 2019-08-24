package com.imis.frame.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: 数组工具类
 * Author: zcx
 * Date: Created in 2019/8/18 18:27
 * Version: 1.0
 */
public class ArrayUtils {

    /**
     * Description: String数组转换为List
     * Author: zcx
     * Date: Created in 2019-08-18 18:30:43
     * Param: [arr]
     * Return: java.util.List<java.lang.String>
     * Version: 1.0
     */
    public static List<String> arrToList(String[] arr){
        List<String> list = new ArrayList<String>();
        for (String s:arr){
            list.add(s);
        }
        return list;
    }

    /**
     * Description: 数组转换为List
     * Author: zcx
     * Date: Created in 2019-08-18 18:42:44
     * Param: [arr]
     * Return: java.util.List<java.io.Serializable>
     * Version: 1.0
     */   
    public static List<Serializable> arrToList(Serializable[] arr){
        List<Serializable> list = new ArrayList<Serializable>();
        for(Serializable s:arr){
            list.add(s);
        }
        return list;
    }
    
}
