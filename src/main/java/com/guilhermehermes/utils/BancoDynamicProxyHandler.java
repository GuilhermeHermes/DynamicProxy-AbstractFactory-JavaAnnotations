package com.guilhermehermes.utils;

import com.guilhermehermes.annotations.Load;
import com.guilhermehermes.annotations.Transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BancoDynamicProxyHandler implements InvocationHandler {

    private Object target;

    public BancoDynamicProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method targetMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());

        if(targetMethod.isAnnotationPresent(Transaction.class)){
            System.out.println("Iniciando execução do método" + method.getName());
            Object result = method.invoke(target, args);
            System.out.printf("%s finalizado com %s\n", method.getName(), result);
            return result;
        }

        if(targetMethod.isAnnotationPresent(Load.class)){
            System.out.printf("%s Carregando dados...\n", method.getName());
            Object result = method.invoke(target, args);
            System.out.printf("%s terminou o carregamento de dados!", method.getName());
            return result;
        }


        return method.invoke(target, args);
    }
}
