package study.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;

public class FastJsonUtils {
    /**
     *
     * @param jsonString json字符串
     * @param key
     * @return
     */
    public static String fromString(String jsonString, String key){
        try{
            if (jsonString != null &&jsonString.length() > 0){
                JSONObject jsonObject = JSONObject.parseObject(jsonString);
                return jsonObject.getString(key);
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void testFromString(){
        JsonObject jsonContainer = new JsonObject();
        //为当前的json对象添加键值对
        jsonContainer.addProperty("k1", "v1");
        jsonContainer.addProperty("k2", "v2");
        jsonContainer.addProperty("k3", "v3");
        System.out.println(fromString(String.valueOf(jsonContainer), "k1"));
    }
}
