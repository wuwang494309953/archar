package fgo.xiaox.archar.common.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import fgo.xiaox.archar.entity.Demo;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class JSON {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        // config
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

    }

    public static <T> String obj2String(T src) {
        if (src == null) {
            return null;
        }
        try {
            return src instanceof String ? (String) src : objectMapper.writeValueAsString(src);
        } catch (Exception e) {
            log.warn("parse object to String exception, error:", e);
            return null;
        }
    }

    public static <T> T string2Obj(String src, Class<T> clazz) {
        if (src == null || clazz == null) {
            return null;
        }
        try {
            return objectMapper.readValue(src, clazz);
        } catch (Exception e) {
            log.warn("parse String to Object exception, String:{}, TypeReference<T>:{}, error:{}", src, clazz, e);
            return null;
        }
    }

    public static <T> List<T> string2Arr(String src, Class<T> clazz) {
        if (src == null || clazz == null) {
            return null;
        }
        try {
            CollectionType type = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
            return objectMapper.readValue(src, type);
        } catch (Exception e) {
            log.warn("parse String to Object exception, String:{}, TypeReference<T>:{}, error:{}", src, clazz, e);
            return null;
        }
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "saber");
        map.put("age", 18);
        log.info("转化结果: {}", JSON.obj2String(map));

        Map map1 = JSON.string2Obj(JSON.obj2String(map), Map.class);
        System.out.println(map1);

        Demo demo = JSON.string2Obj("{\"sex\":1}", Demo.class);
        System.out.println(demo);

        List<Demo> demos = JSON.string2Arr("[{\"sex\":1}]", Demo.class);
        System.out.println(demos);
    }

}
