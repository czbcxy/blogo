package com.example.blogo.myblogo.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: abs
 * @description: Json 转换类
 * @author: LX
 * @create: 2018-03-28 09:39
 **/
public class JsonUtils {

    /**
     * <p>Bean对象转JSON.采用Jackson工具</p>
     * <p>如果有时间日期格式需要转换，请传入时间日期格式。建议"yyyy-MM-dd HH:mm:ss"。当dataFormatString==null或者""时,对日期时间不做处理,解析时请保持一致</p>
     * @param object
     * @param dataFormatString
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonGenerationException
     * @author: LX
     * @create: 2018-03-28 09:39
     */
    public static String beanToJsonByJackson(Object object,String dataFormatString) throws JsonGenerationException, JsonMappingException, IOException {
        if(object != null){
            ObjectMapper mapper = new ObjectMapper();
            if(StringUtils.isNotBlank(dataFormatString)){
                mapper.setDateFormat(new SimpleDateFormat(dataFormatString));
            }
            return mapper.writeValueAsString(object);
        }else{
            return null;
        }
    }
    /**
     * <p>Bean对象转JSON.采用Fastjson工具</p>
     * <p>当dataFormatString==null或者""时,对日期时间不做处理。建议"yyyy-MM-dd HH:mm:ss"。</p>
     * @param object
     * @param dataFormatString
     * @return
     * @author: LX
     * @create: 2018-03-28 09:39
     */
    public static String beanToJsonByFastjson(Object object,String dataFormatString){
        if(object != null){
            if(StringUtils.isBlank(dataFormatString)){
                return JSONObject.toJSONString(object);
            }
            return JSON.toJSONStringWithDateFormat(object,dataFormatString);
        }else{
            return null;
        }
    }
    /**
     * <p>String转JSON字符串.采用Jackson工具</p>
     * <p>key value都是必传值,否则返回null</p>
     * @param key 变量名
     * @param value string值
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonGenerationException
     * @author: LX
     * @create: 2018-03-28 09:39

     */
    public static String stringToJsonByJackson(String key,String value) throws JsonGenerationException, JsonMappingException, IOException{
        if(StringUtils.isBlank(key) || StringUtils.isBlank(value)){
            return null;
        }
        Map<String,String> map = new HashMap<String,String>();
        map.put(key, value);
        return beanToJsonByJackson(map,null);
    }
    /**
     * <p>String转JSON字符串.采用Fastjson工具</p>
     * <p>key value都是必传值,否则返回null</p>
     * @param key 变量名
     * @param value string值
     * @return
     * @author: LX
     * @create: 2018-03-28 09:39
     */
    public static String stringToJsonByFastjson(String key,String value){
        if(StringUtils.isBlank(key) || StringUtils.isBlank(value)){
            return null;
        }
        Map<String,String> map = new HashMap<String,String>();
        map.put(key, value);
        return beanToJsonByFastjson(map,null);
    }

    /**
     * <p>将json字符串转换成对象.采用Jackson工具.具有时间格式转换</p>
     * <p>当dataFormatString==null或者""时,对日期时间不做处理,解析时请保持一致。建议"yyyy-MM-dd HH:mm:ss"</p>
     * @param json json字符串
     * @param clazz 源对象
     * @param dataFormatString 日期时间格式必传
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     * @author: LX
     * @create: 2018-03-28 09:39
     */
    public static Object jsonToBeanByJackson(String json,Object clazz,String dataFormatString) throws JsonParseException, JsonMappingException, IOException{
        if(StringUtils.isBlank(json) || clazz == null){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        if(StringUtils.isNotBlank(dataFormatString)){
            mapper.setDateFormat(new SimpleDateFormat(dataFormatString));
        }
        return mapper.readValue(json, clazz.getClass());
    }

    /**
     * <p>将json字符串转换成对象.采用Fastjson工具---自动识别日期时间类型转换</p>
     * @param json json字符串
     * @param clazz 源对象
     * @return
     * @autho 董杨炀
     * @time 2017-4-10 下午4:20:50
     */
    public static Object jsonToBeanByFastjson(String json,Object clazz){
        if(StringUtils.isBlank(json) || clazz == null){
            return null;
        }
        return JSON.parseObject(json, clazz.getClass());
    }

}
