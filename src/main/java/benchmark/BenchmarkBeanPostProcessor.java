package benchmark;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BenchmarkBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {

        final List<String> methods = new ArrayList<>();

        for (Method method : bean.getClass().getDeclaredMethods()) {
            if(method.isAnnotationPresent(Benchmark.class)) {
                methods.add(method.getName());
            }
        }

        return Proxy.newProxyInstance(
                bean.getClass().getClassLoader(),
                bean.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if(methods.contains(method.getName())) {
                            System.out.println("Start");
                            long startTime = System.nanoTime();
                            Object invoke = method.invoke(bean, args);
                            System.out.println("Finished: " + (System.nanoTime() - startTime));
                            return invoke;
                        } else {
                            return method.invoke(bean,args);
                        }
                    }
                }
        );
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
