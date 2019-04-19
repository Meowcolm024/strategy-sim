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

    int length() {
        Node tmp = content.next;
        int x = 0;
        while (tmp != null) {
            x++;
            tmp = tmp.next;
        }
        return x;
    }

    void push(T k) {
        Node t = content;
        while (t.next != null) {
            if (t.next.index.equals(k))
                return;
            t = t.next;
        }
        t.next = new Node(k);
    }

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

    boolean hasElem(T k) {
        for (Node tmp = content.next; tmp != null; tmp = tmp.next) {
            if (tmp.index == k)
                return true;
        }
        return false;
    }

    ArrayList<T> toArr() {
        Node tmp = content;
        ArrayList<T> arr = new ArrayList<>();
        while (tmp.next != null) {
            arr.add(tmp.index);
            tmp = tmp.next;
        }
        return arr;
    }

    public static void main(String[] args) {
        Sets<Integer> s = new Sets<>();
        s.push(1);
        s.push(2);
        System.out.println(s.hasElem(3));

    }
}
