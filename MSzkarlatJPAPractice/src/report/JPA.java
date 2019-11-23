package report;

import model.Category;
import model.Customer;
import model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


public class JPA {

    public static EntityManagerFactory entityManagerFactory;

    public static void main(String... args) {
        EntityManager manager = getEntityManager();

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Product p1 = new Product("Ziemniaki", 100);
        Product p2 = new Product("Pietruszka", 200);
        Product p3 = new Product("Daktyle", 213);
        Product p4 = new Product("Gruszka", 7);

        Category c1 = new Category("Warzywa");
        Category c2 = new Category("Owoce");

        Customer cus1 = new Customer("Zaczek", "Budryka", "Krakow", 12);
        Customer cus2 = new Customer("Krakus", "Rondo", "Krakow", 4);
        Customer cus3 = new Customer("Olimp", "Aleje", "Krakow", 6);
        manager.persist(cus1);
        manager.persist(cus2);
        manager.persist(cus3);

        c1.addProduct(p1);
        c1.addProduct(p2);
        c2.addProduct(p3);
        c2.addProduct(p4);

        manager.persist(p1);
        manager.persist(p2);
        manager.persist(p3);
        manager.persist(p4);
        manager.persist(c1);
        manager.persist(c2);
        transaction.commit();

//        transaction = manager.getTransaction();
//        transaction.begin();
//
//        System.out.println("Categories: ");
//        for (Category category : manager
//                .createQuery("from Category", Category.class)
//                .getResultList()) {
//            System.out.println(
//                    " " + category.getCategoryId() + " " + category.getName());
//            for (Product product : category.getProducts()) {
//                System.out.println(" " + product.getProductName());
//            }
//        }
//
//        System.out.println("Products: ");
//        for (Product p :
//                (List<Product>) manager.createQuery(
//                        "SELECT p from Product p LEFT JOIN FETCH p" +
//                                ".category").getResultList()) {
//
//            if (p.getCategory() != null) {
//                System.out.println(String.format("Product %s is in category %s",
//                        p.getProductName(),
//                        p.getCategory().getName()));
//            } else {
//                System.out.println(
//                        String.format("Product %s has no category assigned",
//                                p.getProductName()));
//            }
//        }
//        transaction.commit();

        transaction = manager.getTransaction();
        transaction.begin();

        List<Customer> customers =
                (List<Customer>) manager.createQuery("SELECT s FROM Customer s")
                        .getResultList();
        System.out.println("Customers: ");
        for (Customer customer : customers) {
            System.out.println(customer.getCompanyName());
        }
        transaction.commit();

        manager.close();
        entityManagerFactory.close();
    }

    private static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory =
                    Persistence.createEntityManagerFactory("derby");
        }
        return entityManagerFactory.createEntityManager();
    }
}
