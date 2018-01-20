package com.wtu.spring.aop.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 中间类, 相当于JDK动态代理中的Proxy
 * @Author menglanyingfei
 * @Created on 2018.01.17 16:51
 */
public class Middle {
    private UserDao userDao = new UserDaoImpl();
    // 定义切面
    private MyLog myLog = new MyLog();

    public Object getObject() {
        /*
        第一个参数: 当前类的类加载器
        第二个参数: 代理对象实现的接口类型
        第三个参数: 是个接口, 在这个接口中具体去处理如何调用切面以及目标对象
            匿名内部类
         */
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                userDao.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     *
                     * @param proxy 目标对象
                     * @param method 需要执行目标对象的方法对应的Method对象
                     * @param args 执行目标对象业务方法是 需要的参数
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 定义返回值, 目标对象方法执行以后的返回值
                        Object result = "";
                        // 获取目标对象的方法名
                        String methodName = method.getName();
                        if ("addUser".equals(methodName)) {
                            myLog.writeConsole();
                            result = method.invoke(userDao, args);
                            myLog.writeConsole();
                        } else {
                            result = method.invoke(userDao, args);
                        }
                        return result;
                    }
                }
        );
    }

}
