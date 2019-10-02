package lesson1.part1;

public class DocumentEx2 {

    String title;
    String content;

    void printInfo() {
        System.out.println(title + System.lineSeparator() + content);
    }




    /* ---------------------------------- */
    public static void main(String[] args) {
        DocumentEx2 document1 = new DocumentEx2();
        document1.title = "document1";
        document1.content = "Content of document1";

        document1.printInfo();

        DocumentEx2 document2 = new DocumentEx2();
        document2.title = "document1";
        document2.content = "Content of document1";

        document2.printInfo();

//        System.out.println(document1 == document1);
//        System.out.println(document1 == document2);
//
//        document1 = document2;
//        System.out.println(document1 == document2);
    }
}


