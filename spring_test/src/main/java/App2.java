import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-register.xml");

//        bookImpl bookImpl2 = (bookImpl)classPathXmlApplicationContext.getBean("bookImpl2");
//        bookImpl bookImpl2Prototype = (bookImpl)classPathXmlApplicationContext.getBean("bookImpl2");
//        bookDaoImpl bookDaoImpl = (bookDaoImpl)classPathXmlApplicationContext.getBean("bookDaoImpl");
////        classPathXmlApplicationContext.close(); //`destroy`只有在容器关闭的时候，才会执行, 容器运行在JVM中，而main方法运行完成后直接退出，这时容器还没来的及执行其中的destroy方法。所以如果要执行destroy方法，就要手动通知容器关闭
//        System.out.println(bookImpl2);
//        System.out.println(bookImpl2Prototype);
//        bookImpl2.saveBook(bookDaoImpl);

        bookImpl bookImplAutoWire1 = (bookImpl)classPathXmlApplicationContext.getBean("bookImplAutoWire1");
        System.out.println(bookImplAutoWire1);
    }
}
