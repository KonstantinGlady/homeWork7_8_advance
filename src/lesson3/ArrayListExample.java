package lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {
//        arrayExample();
        arrayListExample();
//        arrayListToArray();
    }

    private static void arrayExample() {
//        int[] arr = new int[4];
        int[] arr = {1, 2, 3, 4};// +5
        int[] arrNew = new int[10];
        System.arraycopy(arr, 0, arrNew, 0, arr.length);
//        int[] arrNew = Arrays.copyOf(arr, 10);
        arr = arrNew;
        arrNew = null;
    }

    private static void arrayListToArray() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.addAll(List.of(1, 2));
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);
        List<Integer> arr2 = Arrays.asList(arr);
//        List<Integer> arr3 = new ArrayList(arr);
//        arr = list.toArray(new Integer[0]);
    }

    private static void arrayListExample() {
        List<String> newDataName = new ArrayList<>();
        newDataName.add("A");
        newDataName.add("B");
        newDataName.add("C");
        newDataName.add("D");
        newDataName.add("E");
//        newDataName.trimToSize();
        System.out.println(newDataName);
        newDataName.add(1, "А0");
        System.out.println(newDataName);
        newDataName.remove("E");
        newDataName.remove(2);
        System.out.println(newDataName);
        System.out.println("contains C? " + newDataName.contains("C1"));

        for (int i = 0; i < newDataName.size(); i++) {
            System.out.println(newDataName.get(i));
        }

        Iterator<String> iterator = newDataName.iterator();
        while(iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
//            iterator.remove();
        }

        for (String next : newDataName) {
            System.out.println(next);
        }

//        List<String> anotherData = new ArrayList<>(newDataName);
        List<String> anotherData = new ArrayList<>(5);
    }

}
