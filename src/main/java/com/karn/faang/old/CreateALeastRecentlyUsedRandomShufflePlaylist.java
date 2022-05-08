package com.karn.faang.old;

import java.util.*;

public class CreateALeastRecentlyUsedRandomShufflePlaylist {

    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();
        linkedList.add(new LinkedList.Node("A"));
        linkedList.add(new LinkedList.Node("B"));
        linkedList.add(new LinkedList.Node("C"));
        linkedList.add(new LinkedList.Node("D"));
        linkedList.add(new LinkedList.Node("E"));
        linkedList.add(new LinkedList.Node("F"));
        linkedList.add(new LinkedList.Node("G"));
        linkedList.add(new LinkedList.Node("H"));
        linkedList.add(new LinkedList.Node("I"));
        linkedList.add(new LinkedList.Node("J"));
        System.out.println(linkedList);
LinkedHashMap map=new LinkedHashMap();
        List<Object> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.remove(Integer.valueOf(2));
        System.out.println(list);
//    operate on index 3
        playSong(3, linkedList);
        System.out.println(linkedList);

        playSong(5, linkedList);
        System.out.println(linkedList);

        playSong(2, linkedList);
        System.out.println(linkedList);

        playSong(8, linkedList);
        System.out.println(linkedList);

        playSong(10, linkedList);
        System.out.println(linkedList);
    }
    private static void playSong(int position,LinkedList linkedList){
        if(position>linkedList.getSize()){
            System.out.println("Can't play");
            return;
        }
        if(position==1){
            LinkedList.Node byPosition = linkedList.getByPosition(position);
            System.out.println("Playing "+ byPosition.data+" at position "+position);
            linkedList.setFirst(byPosition.right);
            LinkedList.Node last = linkedList.getLast();
            last.right=byPosition;
            byPosition.left = last;
            byPosition.right = null;
            linkedList.setLast(byPosition);

            //update map
            linkedList.setValueInMap(1, linkedList.getFirst());
            linkedList.updateMap(1);
            return;
        }
        if(position==linkedList.getSize()){
            System.out.println("Playing "+ linkedList.getByPosition(position).data+" at position "+position);
            return;
        }
        LinkedList.Node byPosition = linkedList.getByPosition(position);
        System.out.println("Playing "+ byPosition.data+" at position "+position);

        LinkedList.Node left= byPosition.left;
        LinkedList.Node right = byPosition.right;
        left.right = right;
        right.left=left;
        LinkedList.Node last = linkedList.getLast();
        last.right=byPosition;
        byPosition.left = last;
        byPosition.right = null;
        linkedList.setLast(byPosition);

        //update map
        linkedList.updateMap(position-1);
    }
}

class LinkedList {
    private Node first;
    private Node last;
    private int size = 0;
    private final Map<Integer, Node> nodeMap=new HashMap<>();

    public Node getByPosition(int position){
        return nodeMap.get(position);
    }

    public void setValueInMap(Integer key, Node node){
        this.nodeMap.put(key,node);
    }
    public void updateMap(Integer position){
        Node node = nodeMap.get(position);
        while(node!=null){
            this.nodeMap.put(position,node);
            node=node.right;
            position++;
        }
    }

    public Node getFirst(){
        return this.first;
    }
    public Node getLast(){
        return this.last;
    }
    public void add(Node node) {
        if (first == null) {
            first = node;
            last = node;
            size++;
            nodeMap.put(size,node);
            return;
        } else if (size == 1) {
            last = node;
            first.right = last;
            last.left = first;
            size++;
            nodeMap.put(size,node);
            return;
        }
        last.right = node;
        node.left = last;
        last = node;
        size++;
        nodeMap.put(size,node);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("[");
        Node cursor=first;
        while(cursor!=null){
            stringBuilder.append(cursor.data);
            cursor=cursor.right;
            if(cursor!=null){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
        return "LinkedList{" +
                "first=" + first.data +
                ", last=" + last.data +
                ", size=" + size +
                '}';
    }

    public void setLast(Node last) {
        this.last=last;
    }

    public void setFirst(Node first) {
        this.first=first;
    }

    public int getSize() {
        return this.size;
    }

    static class Node {
        Node(String data){
            this.data=data;
        }
        String data;
        Node left;
        Node right;
    }
}
