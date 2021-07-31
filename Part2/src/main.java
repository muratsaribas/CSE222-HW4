import java.util.Random;

public class main {
    public static void main(String[] args){

        Random rand = new Random();
        int rand_int;
        int[] arr = new int[3000];
        BSTHeapTree<Integer> tree = new BSTHeapTree<>();

        System.out.println("### Insert the 3000 numbers into the tree ###");
        for (int i=0; i<3000; i++){
            rand_int = rand.nextInt(5000);
            arr[i] = rand_int;
            //System.out.println("--- ADDED "+ rand_int+ " ----");
            //System.out.println(tree.add(rand_int));
            tree.add(rand_int);
        }


        System.out.println("### Search for 100 numbers in the array ###");
        for (int i=0; i<100; i++){
            rand_int = rand.nextInt(2500);
            rand_int = arr[rand_int];
            System.out.println("--- SEARCH "+ rand_int+ " ----");
            System.out.println(tree.find(rand_int));
        }

        System.out.println("### Search for 10 numbers not in the array ###");
        for (int i=0; i<10; i++){
            rand_int = rand.nextInt(6000-5500 + 1) + 5500 ;
            System.out.println("--- SEARCH "+ rand_int+ " ----");
            System.out.println(tree.find(rand_int));
        }

        //System.out.println(tree.toString());
        System.out.println("### Find the mode of the BSTHeapTree ###");
        System.out.println(tree.find_mode().toString());

        System.out.println("### Remove 100 numbers in the array ###");
        for (int i=0; i<100; i++){
            rand_int = rand.nextInt(2500);
            rand_int = arr[rand_int];
            System.out.println("--- REMOVE "+ rand_int+ " ----");
            System.out.println(tree.remove(rand_int));
        }

        System.out.println("### Remove 10 numbers in not the array ###");
        for (int i=0; i<10; i++){
            rand_int = rand.nextInt(6000-5500 + 1) + 5500 ;
            System.out.println("--- REMOVE "+ rand_int+ " ----");
            System.out.println(tree.remove(rand_int));
        }

    }
}
