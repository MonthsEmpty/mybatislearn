package com.vincent.plugin;

import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.sql.Connection;
import java.util.Properties;

/**
 *
 * Created by renwu on 2017/7/19.
 */
@Intercepts({@Signature(method = "prepare", type = StatementHandler.class,args = {Connection.class})})
public class MyInterceptor1 implements Interceptor{
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    @Override
    public Object plugin(Object target) {
        if(target instanceof RoutingStatementHandler){
            System.out.println("MyInterceptor1");
        }
        return target;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
