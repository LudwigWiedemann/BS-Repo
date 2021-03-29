public class Executer {
    public static void main(String[] args) {
        Executer exe = new Executer();
        exe.execute();
    }

    public void execute(){
        MyTree tree = new MyTree();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(51);
        tree.add(node1);
        tree.add(node2);
        tree.add(node3);
        tree.add(node4);
        tree.add(node5);
//        System.out.println(tree.searchNode(node3).upperNode.value);
//        System.out.println((tree.deleteNode(-4).value));
        System.out.println(tree.searchNode(3).upperNode.value);
        System.out.println(tree.deleteNode(2));
        System.out.println(tree.searchNode(3).upperNode.value);
    }

}
