package com.ifeng.test.common.ds;

/**
 * Created by whling on 2017/12/12.
 */
public class DynamicDs {

    private static final ThreadLocal<String> dataSourceHolder
            = new ThreadLocal<String>();

    public static void setKey(String key) {
        dataSourceHolder.set(key);
    }

    public static String getKey() {
        return dataSourceHolder.get();
    }

    public static void remove() {
        dataSourceHolder.remove();
    }
}
