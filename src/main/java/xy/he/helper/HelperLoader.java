package xy.he.helper;

import xy.he.utils.ClassUtil;

/**
 * Created by hexiuyu on 2018/1/14.But Nobody cares
 *
 * 集中加载对应的Helper，主要是其中的静态代码块 要执行。这样才能 由本框架 管理bean
 */
public class HelperLoader {
    public static void init(){
        Class<?>[] list ={
                ClassHelper.class,
                BeanHelper.class,
//                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };

        for (Class<?> cls : list) {
            ClassUtil.loadClass(cls.getName(),true);
//            ClassUtil.loadClass(cls.getName(),false);
        }
    }

}
