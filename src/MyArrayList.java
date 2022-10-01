import java.util.Arrays;
import java.util.Objects;

public class MyArrayList implements List {
    private static final int DEFUALT_SIZE = 2;
    private int[] elements = new int[2];
    private int size = 0;

    public MyArrayList() {
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(int element) {
        for(int i = 0; i < this.size; ++i) {
            if (element == this.elements[i]) {
                return true;
            }
        }

        return false;
    }

    public int[] toArray() {
        return Arrays.copyOf(this.elements, this.size);
    }

    public void add(int element) {
        if (this.size == this.elements.length) {
            this.elements = this.grow();
        }

        this.elements[this.size] = element;
        ++this.size;
    }

    public void add(int index, int element) {
        this.rengeCheckForAdd(index);
        if (this.size == this.elements.length) {
            this.elements = this.grow();
        }

        System.arraycopy(this.elements, index, this.elements, index + 1, this.size - index);
        this.elements[index] = element;
        ++this.size;
    }

    public void clear() {
        this.elements = new int[2];
        this.size = 0;
    }

    public int get(int index) {
        this.rengeCheckForGet(index);
        return this.elements[index];
    }

    public int remove(int index) {
        Objects.checkIndex(index, this.size);
        int oldValue = this.elements[index];
        if (index < this.size - 1) {
            System.arraycopy(this.elements, index + 1, this.elements, index, this.size - 1 - index);
        }

        --this.size;
        return oldValue;
    }

    public int indexOf(int element) {
        for(int i = 0; i < this.size; ++i) {
            if (element == this.elements[i]) {
                return i;
            }
        }

        return -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof List)) {
            return false;
        } else {
            List list = (List)obj;
            if (list.size() != this.size) {
                return false;
            } else {
                for(int i = 0; i < this.size; ++i) {
                    if (list.get(i) != this.get(i)) {
                        return false;
                    }
                }

                return true;
            }
        }
    }

    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("[");

        for(int i = 0; i < this.size; ++i) {
            str.append(this.elements[i]).append(",");
        }

        str.delete(str.length() - 1, str.length());
        if (str.length() != 0) {
            str.append("]");
        }

        return str.toString();
    }

    private int[] grow() {
        int oldCapacity = this.elements.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        return Arrays.copyOf(this.elements, newCapacity);
    }

    private void rengeCheckForAdd(int index) {
        if (index < 0 || index > this.size) {
            String massage = String.format("Index: %d, Size: %d", index, this.size);
            throw new IndexOutOfBoundsException(massage);
        }
    }

    private void rengeCheckForGet(int index) {
        if (index < 0 || index >= this.size) {
            String massage = String.format("Index: %d, Size: %d", index, this.size);
            throw new IndexOutOfBoundsException(massage);
        }
    }
}
