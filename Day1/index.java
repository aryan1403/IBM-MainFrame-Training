package Day1;

import java.util.Iterator;
import java.util.List;

class Sample extends index {
    static {
        System.out.println("Sample class static block executed");
    }

    public int summation() {
        return index.sum(0, 0);
    }
}

public class index {
    static int sum(int a, int b) {
        return a + b;
    }

    static {
        System.out.println("Static block executed");
    }
    public static void main(String[] args) {
        index obj = new index();
        int result = sum(5, 10);
        System.out.println("Sum is: " + result);    
        int a = 5;
        int b = 10;
        float pi = 3.14f;
        double e = 2.71828;
        String name;
        name = "John Doe";
        char ch = 'A';
        int sum = a + b;
        boolean isActive = true;

        e = a; // Implicit casting from int to double
        a = (int) pi; // Explicit casting from float to int

        List<Integer> list = List.of(1, 2, 3, 4, 5);

        // % 2 == 0 -> even
        // % 2 != 0 -> odd

        for(int liste : list) {
            if(liste % 2 == 0) {
                System.out.println(liste + " is even");
            } else {
                System.out.println(liste + " is odd");
            }
        }

        list.stream().filter(t -> t % 2 == 0).forEach(System.out::println);

        // for (int i = 1; i <= arr.length; i++) { // 0 - 4 | 1 - 5
        //     System.out.println(list.get(i));
        // }

        // for (int i : arr) {
        //     System.out.println(i);
        // }

        // int index = 0;
        // while (index < list.size()) {
        //     System.out.println(list.get(index));
        //     index++;
        // }

        // Iterator<Integer> it = list.iterator();
        // while(it.hasNext()) {
        //     System.out.println(it.next());
        // }

        // list.forEach(element -> System.out.println(element));

        // list.forEach(System.out::println);


        // System.out.println(list.get(list.size() - 1)); // Accessing the last element of the list





        // System.out.println("After casting operations:" + a);
        // System.out.println("Sum of a and b is: " + sum);
        // System.out.println("Name is: " + name);
        // System.out.println("Is Active: " + !isActive);
        // System.out.println("Character is: " + ch);
        // System.out.println("Value of pi: " + pi);
        // System.out.println("Value of e: " + e);
    }
}
