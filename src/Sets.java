public class Sets<T> {

    private class Node{
        Node next;
        T index;

        Node(T c) {
            next = null;
            index = c;
        }

        void link(Node n) {
            next = n;
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
        Node n = t.next;

        if (t == null)
            return;
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

    void show() {
        Node t = content.next;
        System.out.print("[");
        while (t != null) {
            System.out.print(t.index + ", ");
            t = t.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // Sets<Integer> s = new Sets<>();


    }
}
