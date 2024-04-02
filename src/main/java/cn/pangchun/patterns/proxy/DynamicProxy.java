package cn.pangchun.patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类
 *
 * @author pangchun
 * @since 2023/10/25
 */
public class DynamicProxy implements InvocationHandler {

    /**
     * 被代理的类引用
     */
    private Object obj;

    public DynamicProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 调用被代理对象的方法
        final Object result = method.invoke(obj, args);
        return result;
    }
}
