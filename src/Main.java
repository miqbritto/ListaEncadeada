

public class Main {
    public static void main(String[] args) {
        UniBHList<Integer> myList = new UniBHList<>();

        for (int i = 0; i < 10; i++) {
            myList.insertAtEnd(i + 1);
            System.out.println(myList);
        }

        System.out.println("TAMANHO DA LISTA = " + myList.size());

        System.out.println(myList);

        System.out.println("A LISTA ESTÁ VAZIA? " + myList.isEmpty());

        myList.removeByIndex(3);

        System.out.println(myList);

        myList.alterElement(5,1);

        System.out.println(myList);

        for (int i = 0; i < 10; i++) {
            myList.removeAtEnd();

        }

        System.out.println();
    }
}