import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List first = new DoublyLinkedList();
        for (int i = 0; i < n; i++) {
            first.add(scanner.nextInt());
        }
        System.out.println("Size: " + first.size());
        System.out.println("ToString: " + first);

        System.out.println("Get: " + first.get(scanner.nextInt()));
        System.out.println("Remove: " + first.remove(scanner.nextInt()));
        System.out.println("Size: " + first.size());
        System.out.println("ToString: " + first);
        System.out.println("Get: " + first.get(scanner.nextInt()));

        first.add(scanner.nextInt(), scanner.nextInt());
        System.out.println("Size: " + first.size());
        System.out.println("ToString: " + first);

        first.add(scanner.nextInt(), scanner.nextInt());
        System.out.println("Size: " + first.size());
        System.out.println("ToString: " + first);

        System.out.println("Contains: " + first.contains(scanner.nextInt()));
        System.out.println("Contains: " + first.contains(scanner.nextInt()));

        System.out.println("IndexOf: " + first.indexOf(scanner.nextInt()));
        System.out.println("IndexOf: " + first.indexOf(scanner.nextInt()));
        System.out.println("Size: " + first.size());
        System.out.println("ToString: " + first);

        System.out.print("ToArray:");
        for (int element : first.toArray()) {
            System.out.print(" " + element);
        }
        System.out.println();

        first.clear();
        System.out.println(first.isEmpty());
        System.out.println("Size: " + first.size());
        System.out.println("Empty: " + first.isEmpty());
        System.out.println("ToString: " + first);

        first.add(scanner.nextInt());
        first.add(scanner.nextInt());
        first.add(scanner.nextInt());

        List second = new MyArrayList();
        second.add(scanner.nextInt());
        second.add(scanner.nextInt());
        second.add(scanner.nextInt());

        System.out.println("Equals: " + first.equals(second));
        second.add(scanner.nextInt());
        System.out.println("Equals: " + first.equals(second));
    }
}