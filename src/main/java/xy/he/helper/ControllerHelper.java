package xy.he.helper;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import xy.he.annotation.Action;
import xy.he.bean.Handler;
import xy.he.bean.Request;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by hexiuyu on 2018/1/14.But Nobody cares
 */
public class ControllerHelper {
    // 用于存放 请求 与 处理器的映射 关系
    private static final Map<Request,Handler> ACTION_MAP = new HashMap<>();
    static {
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if(CollectionUtils.isNotEmpty(controllerClassSet)){
            for (Class<?> cls : controllerClassSet) {
                Method[] methods = cls.getDeclaredMethods(); // 获取所有的 方法
                for (Method method : methods) {
                    if(method.isAnnotationPresent(Action.class)){ //找到action注解的方法
                        Action action = method.getAnnotation(Action.class);
                        String mapping = action.value();
                        // 验证URL 映射规则
                        if(mapping.matches("\\w+:\\w*")){
                            String[] array = mapping.split(":");
                            if(!ArrayUtils.isEmpty(array)){
                                String requestMethod = array[0];
                                String requestPath = array[1];
                                Request request = new Request(requestMethod, requestPath);
                                Handler handler = new Handler(cls, method);// hander保存的是, 对应的类  和 方法
                                ACTION_MAP.put(request,handler);  // 把 请求的方法 和路径封装成的request对象,和 处理 该路径的方法 所管理.到时候就能找得到执行谁了
                            }
                        }
                    }
                }
            }
        }
    }
    /**
     * 获取 Handler
     */
    public static Handler getHandler(String requestMethod, String requestPath){
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }
}
