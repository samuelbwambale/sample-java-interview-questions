package algos.Heap;


public class App {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insertItem(5);
        heap.printAsDiagram();

        heap.insertItem(9);
        heap.printAsDiagram();

        heap.insertItem(12);
        heap.printAsDiagram();

        heap.insertItem(20);
        heap.printAsDiagram();

        heap.insertItem(10);
        heap.printAsDiagram();

        heap.insertItem(14);
        heap.printAsDiagram();

        heap.insertItem(18);
        heap.printAsDiagram();

        heap.insertItem(29);
        heap.printAsDiagram();

        heap.insertItem(30);
        heap.printAsDiagram();

        heap.insertItem(13);
        heap.printAsDiagram();

        System.out.println("going to remove mean ");
        heap.removeMin();
        System.out.println("mean removed");

//        heap.printAsDiagram();
       heap.deleteItem(14);
        heap.printAsDiagram();

    }
}
