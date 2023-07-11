public class bookImpl implements book {
    public bookDao bookDao;
    public String bookName;
    public int bookId;

    public bookImpl() {
    }

    public bookImpl(bookDao bookDao, String bookName, int bookId){
        this.bookDao = bookDao;
        this.bookName = bookName;
        this.bookId = bookId;
    }
    public void saveBook(bookDao bookDao) {
        System.out.println("save book123..." + bookDao.toString());
        bookDao.save();
    }

    public void getBook() {
        System.out.println("get book...");
    }

    public void init(){
        System.out.println("init 方法");
    }

    public void destroy(){
        System.out.println("destroy 方法");
    }

    public void setBookDao(bookDao bookDao){
        this.bookDao = bookDao;
    }

    public bookDao getBookDao() {
        return bookDao;
    }

}
