package part1.designPattern.borrowingBook;

public class BookBorrower {
    private BookSingleton borrowedBook;
    private boolean haveBook = false;

    public void borrowBook() {
        borrowedBook = BookSingleton.borrowBook();

        if(borrowedBook != null) {
            haveBook = true;
        }
        else {
            haveBook = false;
        }
    }

    public String getAuthorAndTitle(){
        if (haveBook){
            return borrowedBook.getAuthorAndTitle();
        }
        return "Book not available";
    }

    public void returnBook(){
        borrowedBook.returnBook(borrowedBook);
    }
}
