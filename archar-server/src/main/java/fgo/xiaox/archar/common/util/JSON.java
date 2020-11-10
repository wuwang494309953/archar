package fgo.xiaox.archar.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import fgo.xiaox.archar.entity.Demo;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JSON {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        // config
    }

    public static <T> String obj2String(T src) {
        if (src == null) {
            return null;
        }
        try {
            return src instanceof String ? (String) src : objectMapper.writeValueAsString(src);
        } catch (Exception e) {
            log.warn("parse object to String exception, error:{}", e);
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

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "saber");
        map.put("age", 18);
        log.info("转化结果: {}", JSON.obj2String(map));

        Map map1 = JSON.string2Obj(JSON.obj2String(map), Map.class);
        System.out.println(map1);

        Demo demo = JSON.string2Obj("{\"sex\":1}", Demo.class);
        System.out.println(demo);
    }

}
