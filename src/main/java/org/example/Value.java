package org.example;

public class Value {
    private int value;

    public Value(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null || getClass()!=obj.getClass())return false;
        Value value1=(Value) obj;
        return value==value1.value;
    }
}
