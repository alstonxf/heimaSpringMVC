public class App {
    public static void main(String[] args) {
        bookImpl book = new bookImpl();
        bookDaoImpl bookDaoImpl = new bookDaoImpl();
        book.saveBook(bookDaoImpl);
    }
}
