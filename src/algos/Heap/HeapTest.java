package algos.Heap;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {
    Heap heap = new Heap();

    @org.junit.jupiter.api.Test
    void insertItem() {
        heap.insertItem(4);
        assertNotNull(heap.root);
        assertEquals(4, heap.root.key);
    }

    @org.junit.jupiter.api.Test
    void deleteItem() {
        heap.insertItem(4);
        heap.insertItem(14);
        assertNotNull(heap.root);
        heap.deleteItem(4);
        assertEquals(14, heap.root.key);
    }

    @org.junit.jupiter.api.Test
    void removeMin() {
        heap.insertItem(12);
        heap.insertItem(2);
        heap.insertItem(3);
        assertEquals(2, heap.removeMin());
        assertEquals(3, heap.removeMin());
    }
}