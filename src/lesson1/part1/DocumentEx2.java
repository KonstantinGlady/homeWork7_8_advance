package lesson1.part1;

public class DocumentEx2 {

    String title;
    String content;

    void printInfo() {
        System.out.println(title + System.lineSeparator() + content);
    }



    /* ---------------------------------- */
    public static void main(String[] args) {
        test();
        DocumentEx2 document1 = new DocumentEx2();//001 [112]
        document1.title = "document1";
        document1.content = "Content of document1";

        document1.printInfo();

        DocumentEx2 document2 = new DocumentEx2();//002 [555]
        document2.title = "document2";
        document2.content = "Content of document2";

        document2.printInfo();
        int a = 5;
        int b = 7;
        System.out.println(a == b);

        System.out.println(document1 == document1);
        System.out.println(document1 == document2);
//
        document1 = document2;//001 [555]
        System.out.println(document1 == document2);

        document1.title = "new title";
        System.out.println(document2.title);
//
    }

    private static void test() {
        int a = 5;
        int b = 7;
    }
}


