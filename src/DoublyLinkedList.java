import java.util.Arrays;

public class DoublyLinkedList implements List {
    private int sizeOfDoublyLinkedList = 0;
    private DoublyLinkedList.Node firstElement = null;
    private DoublyLinkedList.Node lastElement = null;

    public DoublyLinkedList() {
    }

    public int size() {
        return this.sizeOfDoublyLinkedList;
    }

    public boolean isEmpty() {
        return this.sizeOfDoublyLinkedList == 0;
    }

    public boolean contains(int number) {
        for(DoublyLinkedList.Node node = this.firstElement; node != null; node = node.nextElement) {
            if (node.number == number) {
                return true;
            }
        }

        return false;
    }

    public int[] toArray() {
        int[] array = new int[this.sizeOfDoublyLinkedList];
        DoublyLinkedList.Node node = this.firstElement;

        for(int i = 0; i < this.sizeOfDoublyLinkedList; ++i) {
            array[i] = node.number;
            node = node.nextElement;
        }

        return array;
    }

    public void add(int element) {
        DoublyLinkedList.Node node = new DoublyLinkedList.Node(element);
        if (this.firstElement == null) {
            this.firstElement = node;
        } else {
            this.lastElement.nextElement = node;
            node.previousElement = this.lastElement;
        }

        this.lastElement = node;
        ++this.sizeOfDoublyLinkedList;
    }

    public void add(int index, int element) {
        if (index == this.sizeOfDoublyLinkedList) {
            this.add(element);
            --this.sizeOfDoublyLinkedList;
        }

        if (index < this.sizeOfDoublyLinkedList) {
            DoublyLinkedList.Node newNode = new DoublyLinkedList.Node(element);
            DoublyLinkedList.Node node = this.firstElement;

            for(int i = 0; i < index; ++i) {
                node = node.nextElement;
            }

            newNode.previousElement = node.previousElement;
            newNode.nextElement = node;
            if (index == 0) {
                node.previousElement = newNode;
                this.firstElement = newNode;
            } else {
                node.previousElement.nextElement = newNode;
                node.previousElement = newNode;
            }
        }

        ++this.sizeOfDoublyLinkedList;
    }

    public void clear() {
        for(DoublyLinkedList.Node node = this.firstElement; node != null; node = node.nextElement) {
            node.number = 0;
            node.nextElement = null;
            node.previousElement = null;
        }

        this.firstElement = null;
        this.lastElement = null;
        this.sizeOfDoublyLinkedList = 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else {
            List secondList = (List)obj;
            int[] first = this.toArray();
            int[] second = secondList.toArray();
            return Arrays.equals(first, second);
        }
    }

    public String toString() {
        int[] result = this.toArray();
        StringBuffer str = new StringBuffer("[");

        for(int i = 0; i < result.length; ++i) {
            str.append(result[i]);
            str.append(",");
        }

        str.delete(str.length() - 1, str.length());
        if (str.length() != 0) {
            str.append("]");
        }

        return str.toString();
    }

    public int get(int index) {
        if (index >= this.sizeOfDoublyLinkedList) {
            return 0;
        } else {
            DoublyLinkedList.Node node = this.firstElement;

            for(int i = 0; i < index; ++i) {
                node = node.nextElement;
            }

            return node.number;
        }
    }

    public int remove(int index) {
        if (index >= this.sizeOfDoublyLinkedList) {
            return 0;
        } else {
            DoublyLinkedList.Node node = this.firstElement;

            for(int i = 0; i < index; ++i) {
                node = node.nextElement;
            }

            DoublyLinkedList.Node previousNode = node.previousElement;
            DoublyLinkedList.Node nextNode = node.nextElement;
            if (previousNode != null) {
                node.previousElement.nextElement = nextNode;
            } else {
                this.firstElement = node.nextElement;
            }

            if (nextNode != null) {
                node.nextElement.previousElement = previousNode;
            } else {
                this.lastElement = node.previousElement;
            }

            --this.sizeOfDoublyLinkedList;
            return node.number;
        }
    }

    public int indexOf(int number) {
        int k = 0;

        for(DoublyLinkedList.Node node = this.firstElement; node != null; node = node.nextElement) {
            if (node.number == number) {
                return k;
            }

            ++k;
        }

        return -1;
    }

    public static class Node {
        int number;
        DoublyLinkedList.Node previousElement;
        DoublyLinkedList.Node nextElement;

        public Node(int number) {
            this.number = number;
            this.previousElement = null;
            this.nextElement = null;
        }
    }
}
