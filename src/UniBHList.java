public class UniBHList<T> {
    // Hold the reference to the first node of this List.
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int totalElements;

    public void insertAtBeginning(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(firstNode);
        firstNode = newNode;
        totalElements++;
    }

    public void insertAtEnd(T value){
        Node<T> newNode = new Node<>(value);
        if (firstNode == null){
            firstNode = newNode;
            lastNode = newNode;
        }else {
            lastNode.setNext(newNode);
            lastNode = newNode;
        }
        totalElements ++;
    }

    public Node<T> removeAtBeginning() {
        Node<T> aux = firstNode;
        firstNode = firstNode.getNext();
        totalElements--;
        return aux;
    }

    public Node<T> removeAtEnd() {
        if (firstNode == null) {
            return null;
        }

        if (firstNode == lastNode) {
            Node<T> aux = firstNode;
            firstNode = null;
            lastNode = null;
            totalElements--;
            return aux;
        }


        Node<T> current = firstNode;
        while (current.getNext() != lastNode) {
            current = current.getNext();
        }

        Node<T> aux = lastNode;
        lastNode = current;
        lastNode.setNext(null);
        totalElements--;

        return aux;
    }


    @Override
    public String toString() {
        if(this.totalElements == 0) {
            return "[ ]";
        }

        Node<T> currentNode = firstNode;
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < totalElements; i++) {
            builder.append(currentNode.getValue());
            builder.append(", ");

            currentNode = currentNode.getNext();

        }

        builder.append("]");

        return  builder.toString();
    }

    // Design the other list methods.
//    Insert at the end, in order, remove at the end,
//    remove elements by value, search an element.
}