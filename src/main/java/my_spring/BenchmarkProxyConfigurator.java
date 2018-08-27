package my_spring;

import org.reflections.ReflectionUtils;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Evgeny Borisov
 */
public class BenchmarkProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object wrapWithProxy(Object t, Class type) {
        boolean methodNeedsBenchmark = ReflectionUtils.getAllMethods(type).stream().anyMatch(method -> method.isAnnotationPresent(Benchmark.class));
        if (type.isAnnotationPresent(Benchmark.class)||methodNeedsBenchmark) {
            if (type.getInterfaces().length == 0) {
                return Enhancer.create(type, (org.springframework.cglib.proxy.InvocationHandler) (o, method, args) -> invoke(t, type, method, args));
            }
            else {
                return  Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), (proxy, method, args) -> invoke(t, type, method, args));
            }

        }
        return t;


    }

    private Object invoke(Object t, Class type, Method method, Object[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method classMethod = type.getMethod(method.getName(), method.getParameterTypes());
        if (classMethod.isAnnotationPresent(Benchmark.class)||type.isAnnotationPresent(Benchmark.class)) {
            System.out.println("********** benchmark for method " + method.getName() + " was started ***********");
            long start = System.nanoTime();
            Object retVal = method.invoke(t, args);
            long end = System.nanoTime();
            System.out.println(end-start);
            System.out.println("********** benchmark for method " + method.getName() + " was ended ***********");
            return retVal;
        }else {
            return method.invoke(t, args);
        }
    }
}
