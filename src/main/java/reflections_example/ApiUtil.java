package reflections_example;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Evgeny Borisov
 */
public class ApiUtil {

    @SneakyThrows
    public static void runAllRunMethods(String className) {
        Class<?> clazz = Class.forName(className);
        runAllRunMethods(clazz);
    }

    @SneakyThrows
    public static void runAllRunMethods(Class clazz) {

        Object o = null;
        try {
            o = clazz.newInstance();
        } catch (Exception e) {
            o = clazz.getConstructor(String.class).newInstance("Vasya");
            //todo refactor this, NEVER use try/catch as flow control
        }
        runAllRunMethods(o);
    }

    @SneakyThrows
    public static void runAllRunMethods(Object o) {
        Method[] methods = o.getClass().getMethods();

        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getType().equals(int.class)) {
                field.setAccessible(true);
                field.set(o, 2);
            }
        }

        for (Method method : methods) {
            if (method.getName().startsWith("run") || method.isAnnotationPresent(RunThisMethod.class)) {
                method.invoke(o);
                RunThisMethod annotation = method.getAnnotation(RunThisMethod.class);
                if (annotation != null) {
                    int repeat = annotation.repeat();
                    for (int i = 0; i < repeat; i++) {
                        method.invoke(o);
                    }
                }
            }
        }
    }


    public static void printApi(Object o) {
        Class<?> clazz = o.getClass();
        Method[] methods = clazz.getMethods();
        Field[] fields = clazz.getDeclaredFields();
        int modifiers = clazz.getModifiers();
        for (Field field : fields) {
            String fieldName = field.getName();
            System.out.println("fieldName = " + fieldName);
            Class<?> fieldType = field.getType();
            System.out.println(fieldType);
        }
        for (Method method : methods) {
            String methodName = method.getName();
            System.out.println("methodName = " + methodName);
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
