package org.example;

public class Main {
    public static void main(String[] args) {
        HashMapImp map = new HashMapImp();
        map.put(new Key(10),new Value(20));
        System.out.println("Value: "+map.get(new Key(10)).getValue());
        map.put(new Key(40),new Value(200));
        map.put(new Key(10),new Value(4000));
        map.remove(new Key(10));
        System.out.println(map.get(new Key(10)));
        System.out.println("Contains 10: "+map.containsKey(new Key(10)));
        System.out.println("Contains 40: "+map.containsKey(new Key(40)));
    }
}