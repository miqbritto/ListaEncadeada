import java.util.NoSuchElementException;

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

    public boolean isEmpty(){
        if (firstNode == null){
            return true;
        } else {
            return false;
        }
    }

    public int size(){
        return totalElements;
    }

    public Node<T> search(T value) {
        Node<T> aux = firstNode;
        while (aux != null) {
            if (aux.getValue().equals(value) && aux.getNext() != null) {
                return aux;
            }
            aux = aux.getNext();
            break;
        }

        throw new NoSuchElementException("Elemento " + value + " não encontrado");
    }

    public void removeByKey(T key) {
        Node<T> aux = firstNode;
        while (aux != null) {
            if (aux.getValue().equals(key)) {
                aux.setNext(aux.getNext().getNext());
                totalElements--;
            }
            aux = aux.getNext();
        }

        throw new NoSuchElementException("Elemento " + key + " nao encontrado");
    }

    public void insertByIndex(T value, int index) {
        Node<T> aux = firstNode;
        try {
            for (int i = 0; i < index; i++) {
                aux = aux.getNext();
            }
            Node<T> newNode = new Node<>(value);
            newNode.setNext(aux.getNext());
            aux.setNext(newNode);
            totalElements++;
        } catch (NullPointerException e) {
            System.out.println("ERRO! Indice não encontrado");
            e.printStackTrace();
        }
    }

    public void removeByIndex(int index){
        Node<T> aux = firstNode;
        Node<T> anterior = null;

        for (int i = 0; i < index; i++) {
            anterior = aux;
            aux = aux.getNext();
        }
        anterior.setNext(aux.getNext());
        totalElements--;
    }

    public void alterElement(T value, int index){
        Node<T> aux = firstNode;
        Node<T> anterior = null;
        for (int i = 0; i < index ; i++) {
            anterior = aux;
            aux = aux.getNext();
        }

        Node<T> newNode = new Node<>(value);
        newNode.setNext(aux.getNext());

        anterior.setNext(newNode);
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