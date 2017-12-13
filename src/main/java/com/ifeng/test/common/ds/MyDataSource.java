package com.ifeng.test.common.ds;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by whling on 2017/12/12.
 */
public class MyDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDs.getKey();
    }
}
