package cou.dev.gibackend.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author sparkle6979l
 * @version 1.0
 * @data 2024/10/31 17:46
 */
public class UrlPathUtils {
    public static String concatGetPath(String path, String attribute){
        if(StringUtils.isBlank(attribute)){
            return path;
        }
        path = path.endsWith("/") ? path.substring(0, path.length() - 1) : path;
        attribute = attribute.startsWith("/") ? attribute.substring(1, attribute.length()) : attribute;
        return path + "/" + attribute;
    }
}
