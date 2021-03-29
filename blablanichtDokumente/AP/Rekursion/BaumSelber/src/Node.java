public class Node {
    int value;
    Node rightNode;
    Node leftNode;
    Node upperNode;
    public Node(int value) {
        this.value = value;
    }

    public int compareTo(Node toCompare) {
        return Integer.compare(this.value, toCompare.value);
    }
    public int compareTo(int value) { return Integer.compare(this.value, value); }
}
