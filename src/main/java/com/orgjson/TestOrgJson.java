package com.orgjson;

import com.orgjson.entity.WangXiaoEr;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TestOrgJson {

    private static void MyJSONObject() throws Exception {
        JSONObject wangxiaoer = new JSONObject();
        Object nullObj = null;//防止put方法直接放入null时，编译器会报错的情况
        wangxiaoer.put("name", "王小二");
        wangxiaoer.put("age", 25.2);
        wangxiaoer.put("birthday", "1990-01-01");
        wangxiaoer.put("school", "蓝翔");
        wangxiaoer.put("major", new String[]{"理发", "挖掘机"});
        wangxiaoer.put("has_g", false);
        wangxiaoer.put("car", nullObj);
        wangxiaoer.put("house", nullObj);
        wangxiaoer.put("comment", "这是一个注释");
        System.out.println(wangxiaoer.toString());
    }

    private static void CreateJSONByMap() throws Exception {
        Map<String, Object> wangxiaoer = new HashMap<>();
        wangxiaoer.put("name", "王小二");
        wangxiaoer.put("age", 25.2);
        wangxiaoer.put("birthday", "1990-01-01");
        wangxiaoer.put("school", "蓝翔");
        wangxiaoer.put("major", new String[]{"理发", "挖掘机"});
        wangxiaoer.put("has_g", false);
        wangxiaoer.put("car", null);
        wangxiaoer.put("house", null);
        wangxiaoer.put("comment", "这是一个注释");
        System.out.println(new JSONObject(wangxiaoer));
    }

    private static void CreateJSONByJavaBean() throws Exception {
        WangXiaoEr wangXiaoEr = new WangXiaoEr();
        wangXiaoEr.setName("王小二");
        wangXiaoEr.setAge(25.2);
        wangXiaoEr.setBirthday("1990-01-01");
        wangXiaoEr.setSchool("蓝翔");
        wangXiaoEr.setHas_g(false);
        wangXiaoEr.setMajor(new String[]{"理发", "挖掘机"});
        wangXiaoEr.setCar(null);
        wangXiaoEr.setHouse(null);
        wangXiaoEr.setComment("这是一个注释");
        wangXiaoEr.setIgrone("显不显示");
        System.out.println(new JSONObject(wangXiaoEr));
    }

    private static void readJSONFile() throws Exception {
        File file = new File("src/main/resources/wangxiaoer.json");
        String content = FileUtils.readFileToString(file);
        JSONObject js = new JSONObject(content);
        System.out.println(js);
        if (!js.isNull("major")) {
            JSONArray major = js.getJSONArray("major");
            for (int i = 0; i < major.length(); i++) {
                System.out.println(major.get(i));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        MyJSONObject();
        CreateJSONByMap();
        CreateJSONByJavaBean();
        readJSONFile();
    }

}
