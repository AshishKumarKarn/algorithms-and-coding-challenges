package com.karn.design.LLD;

import java.util.Arrays;

public class ConsistentHashingDemo {
    public static void main(String[] args) {
        ConsistentHashing hashing = new ConsistentHashing(12, 3);
        hashing.addServer("12.99.12.1");
        hashing.addServer("121.99.1.2");
        hashing.addServer("95.99.12.3");
        hashing.addServer("192.99.12.4");
//        hashing.addServer("192.99.12.5");
        System.out.println(Arrays.toString(hashing.ring));
    }
}
class ConsistentHashing{
    String[] ring;
    int size;
    int noOfVirtualNodes;
    int gap;

    public ConsistentHashing(int size, int noOfVirtualNodes) {
        this.ring = new String[size];
        this.size = size;
        this.noOfVirtualNodes = noOfVirtualNodes;
        this.gap = size/noOfVirtualNodes;//12 size/ 3+1 =3 0->3->6->9
    }
    public void addServer(String serverIP){
        int hashCode = serverIP.hashCode();
        if(hashCode<0){
            hashCode = -hashCode;
        }
        long pid = ProcessHandle.current().pid();
        System.out.println("Process Id is "+pid);
        ProcessHandle.current().children();
        int index = hashCode %size;
        System.out.println(index);
        int original = index;
        while(ring[index]!=null){
            index ++;
            index  %= size;
            if(index==original){
                throw new IllegalArgumentException("Ring if full to add more servers");
            }
        }
        int n = noOfVirtualNodes;
        while(n>=0){
            ring[index]=serverIP;
            index += gap;
            index %= size;
            n--;
        }
    }
    public void removeServer(String serverIP){
        int hashCode = serverIP.hashCode();
        if(hashCode<0){
            hashCode = -hashCode;
        }
        int index = hashCode %size;

        int original = index;
        if(ring[index]==null){
            throw new IllegalArgumentException("Server was never added.");
        }
        //todo
        while(ring[index]!=null){
            index ++;
            index  %= size;
            if(index==original){
                throw new IllegalArgumentException("Ring if full to add more servers");
            }
        }
        int n = noOfVirtualNodes;
        while(n>=0){
            ring[index]=serverIP;
            index += gap;
            index %= size;
            n--;
        }
    }
}
