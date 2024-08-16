import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        printMethodsAndFields(new Pai());

//        printMethodsAndFields(new Pai(), true);
//        printMethods(new Pai(), true);
//        printMethods(new Filho(), false);
//        printMethods(new Avo());
//
//        printMethodsAndFields(new Pai(), false);
//        printFields(new Pai(), true);
//        printFields(new Filho(), false);
//        printFields(new Avo());

    }

    public static void printMethodsAndFields(Object obj) {
        printMethodsAndFields(obj, true);
    }

    public static void printMethodsAndFields(Object obj, Boolean withSuperClasses) {
        printFields(obj, withSuperClasses);
        printMethods(obj, withSuperClasses);
    }

    public static void printMethods(Object obj) {
        printMethods(obj, true);
    }

    public static void printMethods(Object obj, Boolean withSuperClasses) {
        System.out.println("==============================\n");
        System.out.println("Printando metodos da classe " + obj.getClass().getSimpleName() + "\n");

        int i = 1;

        List<Method> methods = listMethods(obj, withSuperClasses);

        for (Method method : methods) {

            System.out.print("Método " + i++ + ": " + method.getName() + "(");
            for (Class<?> param : method.getParameterTypes()) {
                System.out.print(param.getSimpleName());
            }
            System.out.println(")" + ": " + method.getReturnType().getSimpleName());
        }

        System.out.println("\n==============================");
    }

    public static void printFields(Object obj) {
        printFields(obj, true);
    }

    public static void printFields(Object obj, Boolean withSuperClasses) {
        System.out.println("==============================\n");
        System.out.println("Printando campos da classe " + obj.getClass().getSimpleName() + "\n");

        int i = 1;

        List<Field> fields = listFields(obj, withSuperClasses);

        for (Field field : fields) {
            System.out.println("Campo " + i++ + ": " + field.getName() + " | Tipo: " + field.getType().getSimpleName());
        }

        System.out.println("\n==============================");
    }


    public static List<Method> listMethods(Object obj, Boolean withSuperClasses) {
        List<Method> methodList = new ArrayList<>();
        if (obj == null) {
            return methodList;
        }

        Class<?> clazz = obj.getClass();

        methodList.addAll(Arrays.stream(clazz.getDeclaredMethods()).toList());

        if (withSuperClasses) {
            clazz = clazz.getSuperclass();

            while (clazz != null) {
                Method[] methods = clazz.getDeclaredMethods();
                methodList.addAll(Arrays.asList(methods));

                clazz = clazz.getSuperclass();

                if (clazz == Object.class) break;
            }
        }

        return methodList;
    }

    public static List<Field> listFields(Object obj, Boolean withSuperClasses) {
        List<Field> fieldsList = new ArrayList<>();
        if (obj == null) {
            return fieldsList;
        }

        Class<?> clazz = obj.getClass();

        fieldsList.addAll(Arrays.stream(clazz.getDeclaredFields()).toList());

        if (withSuperClasses) {
            clazz = clazz.getSuperclass();

            while (clazz != null) {
                Field[] fields = clazz.getDeclaredFields();
                fieldsList.addAll(Arrays.asList(fields));

                clazz = clazz.getSuperclass();

                if (clazz == Object.class) break;
            }
        }

        return fieldsList;
    }
}