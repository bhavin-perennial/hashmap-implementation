package org.example;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class HashMapImp {
    LinkedList<Entery>[] hashMap = new LinkedList[2];
    int size=0;

    public HashMapImp() {
    }
    public void put(Key key,Value value)
    {
        if(size>=hashMap.length)
        {
            resize();
        }
        int i = getIndex(key)%hashMap.length;
        if(hashMap[i]==null)
        {
            hashMap[i]=new LinkedList<>();
            hashMap[i].add(new Entery(key,value));
            size++;
            return;
        }
        else {
            for(Entery entery:hashMap[i])
            {
                if(entery.key.equals(key))
                {
                    entery.value=value;
                    size++;
                    return;
                }
            }
            hashMap[i].add(new Entery(key,value));
            size++;
            return;
        }

    }

    public  Value get(Key key)
    {
        int i=getIndex(key)%hashMap.length;
        if(hashMap[i]==null) return null;
        for(Entery entery:hashMap[i])
        {
            if(entery.key.equals(key))
            {
                return entery.value;
            }
        }
        return null;
    }

    public void  remove(Key key)
    {
        if(key==null) return;
        int i=getIndex(key)%hashMap.length;
        if(hashMap[i]==null) return;
        Entery toRemove = null;
        for(Entery entery:hashMap[i])
        {
            if(entery.key.equals(key))
            {
                toRemove=entery;
            }

        }
        if(toRemove==null) return;
        hashMap[i].remove(toRemove);
    }
    public boolean containsKey(Key key)
    {
        if(key==null) return false;
        int i=getIndex(key)%hashMap.length;
        if(hashMap[i]==null)
        {
            return false;
        }
        for(Entery entery:hashMap[i])
        {
            if(entery.key.equals(key))
            {
                return true;
            }
        }
        return false;
    }
    private int getIndex(Key key) {
        return key.hashCode();
    }

    private void resize() {
        LinkedList<Entery>[] oldHashMap = hashMap;
        hashMap=new LinkedList[size*2];
        size=0;
        for(int i=0;i<oldHashMap.length;i++)
        {
            if(oldHashMap[i]==null) continue;
            for(Entery entery:oldHashMap[i]){
                put(entery.key,entery.value);
            }
        }
    }
}
