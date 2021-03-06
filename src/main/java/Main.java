import model.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Products products = new Products();
        products.setName("Sofa Arabica");
        products.setDescription("120x200");
        products.setImage("No image");
        products.setPrice(100);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(products);
        session.getTransaction().commit();
        session.close();

        products = null;

        session = sessionFactory.openSession();
        session.beginTransaction();
        products = session.get(Products.class, 0);
        System.out.println(products.getName());
        session.close();
        sessionFactory.close();

    }
}
