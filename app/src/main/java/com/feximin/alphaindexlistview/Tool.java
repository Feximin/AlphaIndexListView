package com.feximin.alphaindexlistview;

import android.text.TextUtils;
import android.util.Log;

import com.github.promeg.pinyinhelper.Pinyin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Neo on 16/2/17.
 */
public class Tool {


    public static String getStringFirstAlpha(String s){
        if(TextUtils.isEmpty(s) || s.trim().length() == 0) return "";
        return getCharFirstAlpha(s.trim().toCharArray()[0]);
    }

    public static String getCharFirstAlpha(char ch){
        if(Pinyin.isChinese(ch)){
            String spell = Pinyin.toPinyin(ch);
            return spell.substring(0, 1);
        }
        return String.valueOf(ch).toUpperCase();
    }

    public static String getAbbr(String str){
        char[] chars = str.trim().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (Character ch : chars){
            sb.append(getCharFirstAlpha(ch));
        }
        return sb.toString().toUpperCase();
    }

    //根据map的特性去排序
    public static List<String> sort(List<String> ori){
        long start = System.currentTimeMillis();
        Map<String, String> sortMap = new TreeMap<>();
        for(String str : ori){
            String name = getAbbr(str);
            name = getSort1Key(name, sortMap);
            sortMap.put(name, str);
        }
        List<String> afterList = new ArrayList<>(sortMap.values());

        long end = System.currentTimeMillis();
        Log.e("sort", "耗时---》"+(end - start));
        return afterList;
    }

    //可能会出现名称一样的情况，用这个方法产生唯一的key
    private static String getSort1Key(String name, Map<String, String> sortMap){
        if(sortMap.get(name) != null){
            name += "!";   //!  ascii 32  是可显示字符中最前面的
            name = getSort1Key(name, sortMap);
        }
        return name;
    }
}