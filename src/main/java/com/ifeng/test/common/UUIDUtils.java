package com.ifeng.test.common;

import java.util.UUID;

/**
 * Created by whling on 2017/12/12.
 */
public class UUIDUtils {

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
