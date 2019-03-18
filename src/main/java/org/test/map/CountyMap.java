package org.test.map;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class CountyMap {
    //locationName  ***id
    public static HashMap<String, String> countyIdMap = new HashMap();

    static {
        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        //name  id
        Resource resource3 = patternResolver.getResource("classpath:county");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(resource3.getInputStream(), "UTF-8"));
            String str;
            // 按行读取字符串
            while ((str = br.readLine()) != null) {
                String[] split = StringUtils.trimAllWhitespace(str).split(",");
                countyIdMap.put(split[2], split[1]);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
