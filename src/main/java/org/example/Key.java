package org.example;

import java.util.Objects;

public class Key {
    private int key;

    @Override
    public int hashCode() {
        return Objects.hashCode(key);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==null) return true;
        if(obj==null || getClass()!=obj.getClass()) return false;
        Key key1 = (Key) obj;
        return Objects.equals(key,key1.key);
    }

    public Key(int key) {
        this.key = key;
    }
}
