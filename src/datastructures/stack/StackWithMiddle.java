package datastructures.stack;

// https://www.geeksforgeeks.org/design-a-stack-with-find-middle-operation/
// This is stack using Doubly LinkedList.
// YOU CAN ALSO DO queue using Doubly LinkedList, and if there is middle CHUTIYAPA, you need 3 pointers

import datastructures.linkedlist.DLL.Node;

public class StackWithMiddle {

//  You have to manipulate it's head to be the top element.
    Node head;
    Node middleNode;
    int count;

    public void push(int ele) {
        Node newNode = new Node(ele);
        if (head != null) {
            head.next = newNode;
            newNode.prev = head;
        }
        head = newNode;
        if(count == 0) middleNode = head;
        else {
            if(count % 2 == 0) middleNode = middleNode.next;
        }
        count++;
    }

    public int pop() {
        int data = head.data;
        head = head.prev;

        if(count %2 != 0) middleNode = middleNode.prev;
        count --;
        return data;
    }

    public int findMiddle() {
        return middleNode.data;
    }

    public void deleteMiddle() {
        middleNode.prev.next = middleNode.next;
        middleNode.next.prev = middleNode.prev;

        if(count % 2 == 0) middleNode = middleNode.next;
        else middleNode = middleNode.prev;
        count --;
    }

    public void printStack() {

    }

    public static void main(String[] args) {
//        StackWithMiddle s = new StackWithMiddle();
//        s.push(10);
//        s.push(20);
//        s.push(30);
//
//        System.out.println(s.findMiddle());
//        s.pop();
//        System.out.println(s.findMiddle());
//        s.push(40);
//        System.out.println(s.findMiddle());
//        s.push(50);
//        s.push(60);
//        s.push(70);
//        s.push(80);
//        System.out.println(s.findMiddle());
//        s.pop();
//        System.out.println(s.findMiddle());
//        s.deleteMiddle();
//        System.out.println(s.findMiddle());
//        s.pop();
//        System.out.println(s.findMiddle());
        StackWithMiddle ms = new StackWithMiddle();
        ms.push(11);
        ms.push(22);
        ms.push(33);
        ms.push(44);
        ms.push(55);
        ms.push(66);
        ms.push(77);

        System.out.println("Item popped is " + ms.pop());
        System.out.println("Item popped is " + ms.pop());
        System.out.println("Middle Element is " + ms.findMiddle());
    }
}
