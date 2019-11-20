import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class reflection = Reflection.class;

        // task 1
        /*
Import "Reflection.java" to your "src" folder in your project. Try to use reflection and print some information about
this class. Print everything on new line:
This class type
Super class type
All interfaces that are implemented by this class
Instantiate object using reflection and print it too
Don’t change anything in "Reflection class"!

         */
//        System.out.println(reflection);
////        System.out.println(reflection.getSuperclass());
////        for (Class anInterface : reflection.getInterfaces()) {
////            System.out.println(anInterface);
////        }
////        Object reflectionObj = reflection.getDeclaredConstructor().newInstance();
////        System.out.println(reflectionObj);

        // task 2
        /*
Using reflection to get all Reflection methods. Then prepare an algorithm that will recognize, which methods are getters
and setters. Sort each collection alphabetically by methods names. Print to console each getter on new line in format:
"{name} will return class {Return Type}"
Then print all setters in format:
"{name} and will set field of class {Parameter Type}"
Do this without changing anything in "Reflection.java"

         */
//        Method[] declaredMethods = reflection.getDeclaredMethods();
//
//        declaredMethods = Arrays.stream(declaredMethods).sorted(Comparator.comparing(Method::getName)).toArray(Method[]::new);
//
//        for (Method declaredMethod : declaredMethods) {
//            String name = declaredMethod.getName();
//
//            if (name.contains("get")) {
//                System.out.println(String.format("%s will return class %s", name, declaredMethod.getReturnType().getName()));
//            }
//
//        }
//        for (Method declaredMethod : declaredMethods) {
//            String name = declaredMethod.getName();
//
//            if (name.contains("set")) {
//
//                System.out.print(String.format("%s and will set field of class ", name));
//
//                Parameter[] parameterTypes = declaredMethod.getParameters();
//
//                for (int i = 0; i < parameterTypes.length; i++) {
//                    System.out.print(parameterTypes[i].getType().getName() + " ");
//                }
//                System.out.println();
//            }
//
//        }


        // task 3

        /*
You are already expert of High Quality Code, so you know what kind of access modifiers must be set to members of class.
Time for revenge has come. Now you have to check code produced by your "Beautiful and Smart" trainers in class
Reflection. Check all fields and methods access modifiers. Sort each category of members alphabetically. Print on
console all mistakes in format:
Fields
{fieldName} must be private!
Getters
{methodName} have to be public!
Setters
{methodName} have to be private!

         */
        Field[] declaredFields = reflection.getDeclaredFields();

        Arrays.stream(declaredFields).filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(e -> System.out.println(String.format("%s must be private!", e.getName())));

        Method[] declaredMethods = reflection.getDeclaredMethods();

        Arrays.stream(declaredMethods).filter(method -> method.getName().contains("get"))
                .filter(method -> !Modifier.isPublic(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(String.format("%s have to be public!", m.getName())));

        Arrays.stream(declaredMethods).filter(method -> method.getName().contains("set"))
                .filter(method -> !Modifier.isPrivate(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(String.format("%s have to be private!", m.getName())));

    }
}
