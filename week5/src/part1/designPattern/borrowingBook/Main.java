package part1.designPattern.borrowingBook;

public class Main {
    public static void main(String[] args) {
        BookBorrower bookBorrower1 = new BookBorrower();
        BookBorrower bookBorrower2 = new BookBorrower();

        bookBorrower1.borrowBook();
        System.out.println("BookBorrower1 asked to borrow the book: " + bookBorrower1.getAuthorAndTitle());

        bookBorrower2.borrowBook();
        System.out.println("BookBorrower2 asked to borrow the book: " + bookBorrower2.getAuthorAndTitle());

        bookBorrower1.returnBook();
        System.out.println("BookBorrower1 returned the book");

        bookBorrower2.borrowBook();
        System.out.println(bookBorrower2.getAuthorAndTitle());
        System.out.println(bookBorrower1.getAuthorAndTitle());
    }
}
