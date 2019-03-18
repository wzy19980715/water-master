package org.test.map;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class ProvinceMap {
    //locationName  ***id
    public static HashMap<String, String> provinceIdMap = new HashMap();

    static {
        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        //name  id
        Resource resource1 = patternResolver.getResource("classpath:province");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(resource1.getInputStream(), "UTF-8"));
            String str;
            // 按行读取字符串
            while ((str = br.readLine()) != null) {
                String[] split = StringUtils.trimAllWhitespace(str).split(",");
                provinceIdMap.put(split[1], split[0]);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
