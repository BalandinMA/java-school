package my_spring;

import heroes.RandomFactory;
import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private Reflections scanner = new Reflections("my_spring");
    private Set<ObjectConfigurator> configurators = new HashSet<>();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
        Set<Class<? extends ObjectConfigurator>> objectConfiguratorClasses = scanner.getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> clazz : objectConfiguratorClasses) {
            if (!Modifier.isAbstract(clazz.getModifiers())) {
                configurators.add(clazz.newInstance());
            }
        }
    }


    @SneakyThrows
    public <T> T createObject(Class<T> type){
        type = resolveImpl(type);

        T t = type.newInstance();

        configure(t);

        invokeInitMethods(type, t);

        if (type.isAnnotationPresent(Benchmark.class)) {
            return (T) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("********** benchmark for method " + method.getName() + " was started ***********");
                    long start = System.nanoTime();
                    Object retVal = method.invoke(t, args);
                    long end = System.nanoTime();
                    System.out.println(end-start);
                    System.out.println("********** benchmark for method " + method.getName() + " was ended ***********");
                    return retVal;
                }
            });
        } else {

        if (ReflectionUtils.getAllMethods(type).stream().anyMatch(method -> method.isAnnotationPresent(Benchmark.class))) {
            Class<T> finalType = type;
            return (T) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Method classMethod = finalType.getMethod(method.getName(), method.getParameterTypes());
                    if (classMethod.isAnnotationPresent(Benchmark.class)) {
                        System.out.println("********** benchmark for method " + method.getName() + " was started ***********");
                        long start = System.nanoTime();
                        Object retVal = method.invoke(t, args);
                        long end = System.nanoTime();
                        System.out.println(end - start);
                        System.out.println("********** benchmark for method " + method.getName() + " was ended ***********");
                        return retVal;
                    }
                    return method.invoke(t, args);
                }
            });
        }



        return t;
        }
    }





    private <T> void invokeInitMethods(Class<T> type, T t) throws IllegalAccessException, InvocationTargetException {
        Set<Method> methods = ReflectionUtils.getAllMethods(type);
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.setAccessible(true);
                method.invoke(t);
            }
        }
    }


    private <T> void configure(T t) throws Exception {
        for (ObjectConfigurator configurator : configurators) {
            configurator.configure(t);
        }
    }

    private <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()) {
            Class<T> implClass = config.getImplClass(type);
            if (implClass == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new IllegalStateException(type + "has 0 or more than one impl, please update your config");
                }
                implClass = (Class<T>) classes.iterator().next();
            }
            type = implClass;
        }
        return type;
    }


}
