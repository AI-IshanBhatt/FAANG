package datastructures.linkedlist;

public class DLL {

    public Node head;

    public static class Node {
        public int data;
        public Node prev;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void insertFirst(int data) {

        Node newNode = new Node(data);
        if(head != null)
        {
            newNode.next = head;
            newNode.prev = null;

            head.prev = newNode;
        }
        head = newNode;
    }

    public void insertEnd(int data) {
        Node newNode = new Node(data);

        if(head ==null) {
            head = newNode;
        }
        else {
            Node current = head;
            while(current.next != null)
                current = current.next;
            newNode.prev = current;
            current.next = newNode;
        }
    }

    public void insertAfter(Node node, int data) {
        Node newNode = new Node(data);

        newNode.prev = node;
        newNode.next = node.next;
        node.next = newNode;
        if(newNode.next != null) newNode.next.prev = newNode;
    }

    public void insertBefore(Node node, int data) {
        Node newNode = new Node(data);

        newNode.next = node;
        newNode.prev = node.prev;
        node.prev = newNode;
        if(newNode.prev != null) newNode.prev.next = newNode;
    }

    public void deleteFirst() {
        if(head.next == null) {
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteLast() {
        Node currentNode = head;
        while (currentNode.next != null)
            currentNode = currentNode.next;
        currentNode.prev.next = null;
        currentNode = null;
    }

    public void deleteBefore(Node node) {
        if(node.prev == null) System.out.println("Are you trying to delete before head ??");
        else {
            if(node.prev == head) {
                node.prev = null;
                head = node;
            } else {
                node.prev = node.prev.prev;
                node.prev.next = node;
            }
        }

    }

    public void printDll() {
        Node currentNode = this.head;
        while(currentNode != null) {
            System.out.print(currentNode.data+" ");
            currentNode = currentNode.next;
        }
    }
}
