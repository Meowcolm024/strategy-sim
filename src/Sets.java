import java.util.ArrayList;

public class Sets<T> {

    private class Node{
        Node next;
        T index;

        Node(T c) {
            next = null;
            index = c;
        }
    }

    private Node content;

    Sets() {
        content = new Node(null);
    }

    Sets(T[] xs) {
        content = new Node(null);
        Node tmp = content;
        for (T x : xs) {
            tmp.next = new Node(x);
            tmp = tmp.next;
        }
    }

    // the count of elements in the set
    int length() {
        Node tmp = content.next;
        int x = 0;
        while (tmp != null) {
            x++;
            tmp = tmp.next;
        }
        return x;
    }

    // add element to the set
    void push(T k) {
        Node t = content;
        while (t.next != null) {
            if (t.next.index.equals(k))
                return;
            t = t.next;
        }
        t.next = new Node(k);
    }

    // delete element from the set
    void pop(T k) {
        Node t = content.next;

        if (t == null)
            return;

        Node n = t.next;

        if (t.index.equals(k))
            content.next = t.next;
        while (n != null) {
            if (n.index.equals(k)) {
                t.next = n.next;
                break;
            }
            t = t.next;
            n = n.next;
        }
    }

    // check whether an element is in the set
    boolean hasElem(T k) {
        for (Node tmp = content.next; tmp != null; tmp = tmp.next) {
            if (tmp.index == k)
                return true;
        }
        return false;
    }

    // convert the set to an ArrayList
    ArrayList<T> toArr() {
        Node tmp = content;
        ArrayList<T> arr = new ArrayList<>();
        while (tmp != null) {
            arr.add(tmp.index);
            tmp = tmp.next;
        }
        return arr;
    }

    @Override
    public String toString() {
        return String.valueOf(toArr());
    }

    public static void main(String[] args) {
        Integer[] x = {1,2,3,4,5,6,7,8,9,10};
        Sets<Integer> s = new Sets<>(x);
        System.out.println(s);
        System.out.println(s.length());

    }
}
