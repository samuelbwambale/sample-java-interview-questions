package algos.Heap;
import java.util.*;

/**
 * Code shell for a MinHeap that support a deleteItem operation
 */
public class HeapInt {
    private Hashtable<Integer, Node> locator = new Hashtable<Integer, Node>();
    public Node root;
    private Node lastItem;
    private Node parentOfNextOpenPosition;
    private Queue<Node> queue = new LinkedList<Node>();
    private Stack<Node> stack = new Stack<Node>();

    public void insertItem(Integer key) {
        //create new Node n, insert key, and place as child
        //of parentOfNextOpenPosition
        //then perform upHeap(n)

        if (root == null) {
            root = new Node(key, null, null, null);
            locator.put(key, root);
            lastItem = root;
            parentOfNextOpenPosition = root;
            stack.push(root);
        } else {
            innerInsertItem(parentOfNextOpenPosition, key);
        }
    }

    private void innerInsertItem(Node parent, Integer key) {
        Node newNode = new Node(key, null, null, parent);
        if (parent.left == null) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
            Node freshNode = null;
            while (freshNode == null) {
                freshNode = queue.poll();
            }
            parentOfNextOpenPosition = freshNode;
        }
        locator.put(key, newNode);
        lastItem = newNode;
        queue.add(newNode);
        stack.push(newNode);
        upHeap(newNode);
    }


    public void deleteItem(Integer key) {
        //removes the first node found that contains this key
        Node nodeToDelete = locator.get(key);
        swapNodes(lastItem, nodeToDelete);
        //upHeap(nodeToDelete);
        Node pLast = stack.peek().parent;
        if (pLast.right == null) {
            pLast.left = null;
        } else {
            if (pLast.right.key == key) {
                pLast.right = null;
            } else {
                pLast.left = null;
            }
        }
        Node removedNode = stack.pop();
        removedNode.key = null;
        locator.remove(key);
        downHeapAfterDeleteItem(nodeToDelete);
    }

    public Integer removeMin() {
        //return key in root
        //copy key in lastItem into root
        //set one of the children of parent of lastItem to null
        //perform downHeap
        //set parentOfNextOpenPosition to be either parent of lastItem or
        //   or node that has replaced this parent during downHeap
        Integer min = root.key;
        //pop out lastItem so that we get new lastItem
        stack.pop();
        printAsDiagram();
        swapNodes(root, lastItem);
        Node pLast = lastItem.parent;
        if (pLast.right == null) {
            pLast.left = null;
        } else {
            if (pLast.right.key == lastItem.key) {
                lastItem.key = null;
                pLast.right = null;
            } else {
                pLast.left = null;
            }
        }
        lastItem = stack.peek();
        downHeap();
        lastItem = stack.peek();
        locator.remove(min);
        System.out.println(stack);
        System.out.println(queue);
        System.out.println(locator);
        return min;
    }

    private void upHeap(Node n) {
        //swap keys in nodes along upward path from n
        //till key in n is no longer smaller than key in parent
        lastItem = n;
        Node currentNode = n;
        while (currentNode.parent != null) {
            if (currentNode.key.compareTo(currentNode.parent.key) < 0) {
                swapNodes(currentNode, currentNode.parent);
            }
            currentNode = currentNode.parent;
        }
    }

    private void swapNodes(Node currentNode, Node parent) {
        Integer parentKey = parent.key;
        parent.key = currentNode.key;
        currentNode.key = parentKey;
        locator.put(currentNode.key, currentNode);
        locator.put(parent.key, parent);
    }

    private void downHeapAfterDeleteItem(Node d) {
        //starting from position where formerly last node was placed,
        // swap keys along a downward path from position where formerly last node was placed
        //until heap invariant property is obtained

        Node currentNode = d;
        while (currentNode.left != null || currentNode.right != null) {
            if (currentNode.right != null) {
                Node semiMin = null;
                if (currentNode.left.key < currentNode.right.key) semiMin = currentNode.left;
                else semiMin = currentNode.right;
                if (semiMin.key < currentNode.key) {
                    swapNodes(semiMin, currentNode);
                    currentNode = semiMin;
                } else break;
            } else {
                if (currentNode.left.key < currentNode.key) {
                    swapNodes(currentNode.left, currentNode);
                    currentNode = currentNode.left;
                } else break;
            }
        }

    }
    private void downHeap() {
        //starting from root, swap keys along a downward path from root
        //until value in root is no longer greater than key in child
        Node currentNode = root;
        while (currentNode.left != null || currentNode.right != null) {
            if (currentNode.right != null) {
                Node semiMin = null;
                if (currentNode.left.key < currentNode.right.key) semiMin = currentNode.left;
                else semiMin = currentNode.right;
                if (semiMin.key < currentNode.key) {
                    swapNodes(semiMin, currentNode);
                    currentNode = semiMin;
                } else break;
            } else {
                if (currentNode.left.key < currentNode.key) {
                    swapNodes(currentNode.left, currentNode);
                    currentNode = currentNode.left;
                } else break;
            }
        }

    }

    /**
     * Prints to the console a visual representation of this
     * tree, relying on the nested class BTreePrinter
     */
    public void printAsDiagram() {
        BTreePrinter.printNode(root);
    }

    /**
     * Specialized nested class to produce
     * a visual image of this tree. This is
     * third-party code. To access the functionality
     * of this class, make a call to the static method
     * printNode like this:  printNode(root)
     */
    static class BTreePrinter {
        public static void printNode(Node root) {
            int maxLevel = BTreePrinter.maxLevel(root);
            printNodeInternal(
                    Collections.singletonList(root), 1, maxLevel);
        }

        @SuppressWarnings({"rawtypes", "unchecked"})
        private static void printNodeInternal(List nodes,
                                              int level, int maxLevel) {
            if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
                return;
            int floor = maxLevel - level;
            int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
            int firstSpaces = (int) Math.pow(2, (floor)) - 1;
            int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
            BTreePrinter.printWhitespaces(firstSpaces);
            List newNodes = new ArrayList();
            for (Object node : nodes) {
                if (node != null) {
                    System.out.print(((Node) node).key);
                    newNodes.add(((Node) node).left);
                    newNodes.add(((Node) node).right);
                } else {
                    newNodes.add(null);
                    newNodes.add(null);
                    System.out.print(" ");
                }

                BTreePrinter.printWhitespaces(betweenSpaces);
            }
            System.out.println("");

            for (int i = 1; i <= endgeLines; i++) {
                for (int j = 0; j < nodes.size(); j++) {
                    BTreePrinter.printWhitespaces(firstSpaces - i);
                    if (nodes.get(j) == null) {
                        BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                        continue;
                    }

                    if (((Node) nodes.get(j)).left != null)
                        System.out.print("/");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(i + i - 1);

                    if (((Node) nodes.get(j)).right != null)
                        System.out.print("\\");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
                }

                System.out.println("");
            }

            printNodeInternal(newNodes, level + 1, maxLevel);
        }

        static void printWhitespaces(int count) {
            for (int i = 0; i < count; i++)
                System.out.print(" ");
        }

        static int maxLevel(Node node) {
            if (node == null)
                return 0;

            return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
        }

        @SuppressWarnings("rawtypes")
        static boolean isAllElementsNull(List list) {
            for (Object object : list) {
                if (object != null)
                    return false;
            }

            return true;
        }
    }

    class Node {
        Node left;
        Node right;
        Node parent;
        Integer key;

        public Node(Integer key, Node left, Node right, Node parent) {
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.key = key;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    '}';
        }
    }
}

