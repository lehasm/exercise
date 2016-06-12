
public class ReverseLinkedListEx {

    private static Node reverse(Node node) {
        Node i = node.next;
        node.next = null;

        while (i != null) {
            Node tmp = i.next;
            i.next = node;
            node = i;
            i = tmp;
        }

        return node;
    }

    private static Node reverseIdem(Node node) {
        Node newNode = null;

        while (node != null) {
            newNode = new Node(node.value, newNode);
            node = node.next;
        }

        return newNode;
    }


    public static void main(String[] args) {
        Node node = new Node("A", new Node("B", new Node("C", new Node("D", new Node("E", new Node("F", null))))));

        System.out.println(node);
        System.out.println(reverse(node.clone()));
        System.out.println(reverseIdem(node));

    }

    private static class Node implements Cloneable {

        private final String value;

        private Node next;

        private Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        private boolean hasNext() {
            return next != null;
        }

        @Override
        public Node clone() {
            Node newNode = new Node(this.value, null);
            Node j = newNode;
            Node i = this;
            while (i.hasNext()) {
                j.next = new Node(i.next.value, null);
                j = j.next;
                i = i.next;
            }

            return newNode;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            Node i = this;
            while (i.hasNext()) {
                builder.append(i.value).append(" -> ");
                i = i.next;
            }

            return builder.append(i.value).toString();
        }

    }

}
