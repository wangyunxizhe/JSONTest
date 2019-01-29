package com.mygson;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orgjson.entity.WangXiaoEr;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.lang.reflect.Field;

public class TestGson {

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
        Gson gson = new Gson();
        System.out.println(gson.toJson(wangXiaoEr));
    }

    private static void transformJSON() throws Exception {
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

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();//将json格式化打印
        //将key为school的key转为大写
        gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
            @Override
            public String translateName(Field f) {
                if ("school".equals(f.getName())) {
                    return "SCHOOL";
                }
                return f.getName();
            }
        });
        Gson gson = gsonBuilder.create();
        System.out.println(gson.toJson(wangXiaoEr));
    }

    //将json数组中的数据反解析到JavaBean中
    private static void readJSONFile() throws Exception {
        File file = new File("src/main/resources/wangxiaoer.json");
        String content = FileUtils.readFileToString(file);
//        Gson gson = new Gson();
        //在解析时可以将格式为"yyyy-MM-dd"自动解析成Date类型，以便直接放入JavaBean中的Date类型属性中
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        WangXiaoEr wangXiaoEr = gson.fromJson(content, WangXiaoEr.class);
        System.out.println(wangXiaoEr);
    }

    public static void main(String[] args) throws Exception {
        CreateJSONByJavaBean();
        transformJSON();
        readJSONFile();
    }

}
