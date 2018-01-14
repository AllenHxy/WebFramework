package xy.he.helper;

import xy.he.utils.ConfigConstant;
import xy.he.utils.PropsUtil;

import java.util.Properties;

/**
 * Created by hexiuyu on 2018/1/13.But Nobody cares
 */
public final class ConfigHelper {
    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);
    public static String getJdbcDriver(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_DRIVER);
    }
    public static String getJdbcUrl(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_URL);
    }
    public static String getJdbcUsername(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_USERNAME);
    }
    public static String getJdbcPassword(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_PASSWORD);
    }
    public static String getBasePackage(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.BASE_PACKAGE);
    }
    /** 该属性为可选*/
    public static String getJspPath(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JSP_PATH,"/WEB-INF/view/");
    }
    /** 该属性为可选*/
    public static String getAssetPath(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.ASSET_PATH,"/asset/");
    }

    public static String getString(String key) {
        return PropsUtil.getString(CONFIG_PROPS,key);
    }

    public static boolean getBoolean(String key) {
        return PropsUtil.getBoolean(CONFIG_PROPS,key);
    }
}
