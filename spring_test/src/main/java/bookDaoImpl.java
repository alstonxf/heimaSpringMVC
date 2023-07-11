public class bookDaoImpl implements bookDao{

    public void save() {
        System.out.println(bookDaoImpl.class.getSimpleName()+"执行save方法");
    }

}
