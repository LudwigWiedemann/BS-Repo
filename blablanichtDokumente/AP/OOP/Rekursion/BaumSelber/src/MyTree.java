public class MyTree {
    Node root;

    public void add(Node toAdd){
        int layer = 0;
        if (root == null) {
            root = toAdd;
            root.upperNode = null;
            System.out.println("added as root in Layer "+ layer + "with the Upper node: null");
            return;
        }
        add(toAdd, root, layer++, root);
    }

    private void add(Node toAdd, Node currentNode, int layer, Node upperNode) {
        layer++;
        if (toAdd.compareTo(currentNode) < 0) {  // links
            if(currentNode.leftNode != null) {
                add(toAdd, currentNode.leftNode, layer, currentNode);
            } else {
                currentNode.leftNode = toAdd;
                currentNode.leftNode.upperNode = currentNode;
                System.out.println("added" +toAdd.value+ " left in Layer "+ layer);
                return;
            }
        }
        if (toAdd.compareTo(currentNode) > 0) {  // rechts
            if(currentNode.rightNode != null) {
                add(toAdd, currentNode.rightNode, layer, currentNode);
            } else {
                currentNode.rightNode = toAdd;
                currentNode.rightNode.upperNode = currentNode;

                System.out.println("added " +toAdd.value+ " right in Layer "+ layer);
                return;
            }
        }
        if (toAdd.compareTo(currentNode) == 0) System.out.println("Dieses Element gibt es bereits");
    }

    public Node searchNode(int toSearch) {
        if (root.value == toSearch) return root;
        return searchNode(toSearch, root);
    }

    private Node searchNode(int toSearch, Node currentNode) {
        if (toSearch < currentNode.value) {
            if (currentNode.leftNode != null) {
                return searchNode(toSearch, currentNode.leftNode);
            }
            System.out.println("gibt es nicht");
            return null;
        }

        if (toSearch > currentNode.value) {
            if (currentNode.rightNode != null) {
                return searchNode(toSearch, currentNode.rightNode);
            }
            System.out.println("gibt es nicht");
            return null;
        }
        return currentNode;
    }

    public Node deleteNode (int value) {
        if (root.compareTo(value) == 0) {
            System.out.println("Sie können die root nicht löschen");
            return null;
        }
        return deleteNode(value, root);
    }

    private Node deleteNode(int value, Node currentNode) {
        if (currentNode.compareTo(value) == 0) {
            Node temp = currentNode.upperNode;
            temp.leftNode = currentNode.leftNode.leftNode;
            return currentNode;
        }
        if (currentNode.compareTo(value)  > 0) { // links
            System.out.println(currentNode.leftNode.value);
            if (currentNode.leftNode != null) {
                return deleteNode(value, currentNode.leftNode);
            }
            System.out.println("diesen Knoten gibt es nicht");
            return null;
        }
        if (currentNode.rightNode != null) {
            return deleteNode(value, currentNode.rightNode.rightNode);
        }
        System.out.println("diesen Knoten gibt es nicht");
        return null;
    }
}
