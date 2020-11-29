package datastructures.linkedlist;

public class DLLRunner {

    public static void main(String[] args) {
        DLL d = new DLL();

        d.insertFirst(5);
        d.insertFirst(4);
        d.insertFirst(7);
        d.insertFirst(10);

        d.insertEnd(11);
        d.insertFirst(20);
        d.insertEnd(12);

        d.printDll();
        System.out.println();
        d.insertAfter(d.head.next, 6);
        d.printDll();
        System.out.println();
        d.insertBefore(d.head.next, 15);
        d.printDll();
        System.out.println();
        d.deleteFirst();
        d.deleteFirst();
        d.printDll();
        System.out.println();
        d.deleteLast();
        d.printDll();
        System.out.println();
        d.deleteBefore(d.head.next.next);
        d.printDll();

    }
}
