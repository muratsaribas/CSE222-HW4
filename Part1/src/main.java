public class main {
    public static void main(String[] args){
        System.out.println("------------------------------");
        System.out.println("Create a new heap");
        HeapStruct<Integer> heap = new HeapStruct<>();
        System.out.println("The heap was created");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());

        System.out.println("------------------------------");
        System.out.println("Adding items");
        System.out.println("Before adding the item to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
        heap.add(10);
        System.out.println("After adding the '10' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());

        System.out.println("------------------------------");
        System.out.println("Before adding the '11' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
        heap.add(11);
        System.out.println("After adding the '11' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());

        System.out.println("------------------------------");
        System.out.println("Before adding the '78' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
        heap.add(78);
        System.out.println("After adding the '78' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());

        System.out.println("------------------------------");
        System.out.println("Before adding the '5' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
        heap.add(5);
        System.out.println("After adding the '5' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());

        System.out.println("------------------------------");
        System.out.println("Before adding the '25' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
        heap.add(25);
        System.out.println("After adding the '25' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());

        System.out.println("------------------------------");
        System.out.println("Before adding the '18' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
        heap.add(18);
        System.out.println("After adding the '18' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());

        System.out.println("------------------------------");
        System.out.println("Before adding the '33' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
        heap.add(33);
        System.out.println("After adding the '33' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());

        System.out.println("------------------------------");
        System.out.println("Before adding the '0' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
        heap.add(0);
        System.out.println("After adding the '0' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());

        System.out.println("------------------------------");
        System.out.println("Before adding the '-3' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
        heap.add(-3);
        System.out.println("After adding the '-3' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Adding the item existing in the heap to the heap");
        System.out.println("Before adding the '10' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
        heap.add(10);
        System.out.println("After adding the '10' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());

        System.out.println("------------------------------");
        System.out.println("Adding the item existing in the heap to the heap");
        System.out.println("Before adding the '0' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
        heap.add(0);
        System.out.println("After adding the '0' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());



        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Removing items");
        System.out.println("Before removing the smallest item to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
        heap.remove();
        System.out.println("After removing the smallest item to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());

        System.out.println("-------------------------------");
        System.out.println("Before removing the '18' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
        heap.remove(18);
        System.out.println("After removing the '18' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Deleting an item that is not in the stack");
        System.out.println("Before removing the '100' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
        heap.remove(100);
        System.out.println("After removing the '100' to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());

        HeapStruct<Integer> heap2 = new HeapStruct<>();
        heap2.add(7);
        heap2.add(-5);
        heap2.add(78);
        heap2.add(50);
        heap2.add(19);
        heap2.add(21);
        heap2.add(330);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Merge two heaps");
        System.out.println("Before merging");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
        System.out.println("Heap2: ");
        System.out.println(heap2.toString());
        heap.merge(heap2);
        System.out.println("After merging");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Removing ith largest element in the heap");
        System.out.println("Before removing the 1th largest element to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
        Integer integer = heap.removeLargestElement(1);
        System.out.println("Removed: " + integer);
        System.out.println("After removing the 1th largest element to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());

        System.out.println("-------------------------------");
        System.out.println("Removing ith largest element in the heap");
        System.out.println("Before removing the 4th largest element to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
        integer = heap.removeLargestElement(4);
        System.out.println("Removed: " + integer);
        System.out.println("After removing the 4th largest element to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());

        System.out.println("-------------------------------");
        System.out.println("Removing ith largest element in the heap");
        System.out.println("Before removing the -3th largest element to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
        integer = heap.removeLargestElement(-3);
        System.out.println("Removed: " + integer);
        System.out.println("After removing the -3th largest element to the heap");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Searching an item in the heap");
        System.out.println("Searching '-5'");
        int index = heap.search(-5);
        System.out.println("Expected: 0 , Result: " + index);
        System.out.println("----------------------------");
        System.out.println("Searching '-50'");
        index = heap.search(-50);
        System.out.println("Expected: -1 , Result: " + index);
        System.out.println("----------------------------");
        System.out.println("Searching '7'");
        index = heap.search(7);
        System.out.println("Expected: 3 , Result: " + index);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Setting items");
        System.out.println("Before setting the first item to 39");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
        HeapIterator<Integer> iter = heap.iterator();
        iter.next();
        iter.set(39);
        System.out.println("Before setting the first item to 39");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());

        System.out.println("------------------------");
        System.out.println("Before setting the third item to -10");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
        iter = heap.iterator();
        iter.next();
        iter.next();
        iter.next();
        iter.set(-10);
        System.out.println("Before setting the first item to -10");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Setting the item existing in the heap to the heap");
        System.out.println("Before setting the first item to 10");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
        iter = heap.iterator();
        iter.next();
        iter.set(10);
        System.out.println("Before setting the first item to 10");
        System.out.println("Heap1: ");
        System.out.println(heap.toString());
    }
}
