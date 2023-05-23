import lombok.Data;

@Data
public class SimpleTree<T extends Comparable<T>> {
    private Node<T> root;

    @Data
    public static class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T value) {
            this.value = value;
        }
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (root == null) {
            root = newNode;
        } else {
            addRecursive(root, newNode);
        }
    }

    private void addRecursive(Node<T> currentNode, Node<T> newNode) {
        if (newNode.getValue().compareTo(currentNode.getValue()) < 0) {
            if (currentNode.getLeftChild() == null) {
                currentNode.setLeftChild(newNode);
            } else {
                addRecursive(currentNode.getLeftChild(), newNode);
            }
        } else {
            if (currentNode.getRightChild() == null) {
                currentNode.setRightChild(newNode);
            } else {
                addRecursive(currentNode.getRightChild(), newNode);
            }
        }
    }

    public void traverse() {
        traverseRecursive(root);
    }

    private void traverseRecursive(Node<T> currentNode) {
        if (currentNode != null) {
            traverseRecursive(currentNode.getLeftChild());
            System.out.println(currentNode.getValue());
            traverseRecursive(currentNode.getRightChild());
        }
    }
}
