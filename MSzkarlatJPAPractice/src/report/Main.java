package report;

import domain.Operation;
import model.Product;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;
import java.util.Scanner;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel =
                    session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }

        homework_from_I_to_VII();

    }

    public static void homework_from_I_to_VII() {
        Scanner inputScanner = new Scanner(System.in);
        Operation operation = new Operation(getSession());

        // zadanie II
//        System.out.print("First product name: ");
//        String firstProductName = inputScanner.nextLine();
//        System.out.print("Amount: ");
//        double firstProductAmount = Double.parseDouble(inputScanner.nextLine());
//        Product firstProduct =
//                operation.insertProduct(firstProductName, firstProductAmount);

        // zadanie III
//        System.out.print("New supplier name: ");
//        String firstSupplierName = inputScanner.nextLine();
//        System.out.print("city: ");
//        String firstSupplierCity = inputScanner.nextLine();
//        System.out.print("street: ");
//        String firstSupplierStreet = inputScanner.nextLine();
//        Supplier firstSupplier = operation
//                .insertSupplier(firstSupplierName, firstSupplierCity,
//                        firstSupplierStreet);
//        Product searchFirstProduct =
//                operation.getProductByName(firstProductName);
//        operation.updateProduct(searchFirstProduct, firstSupplier);

        // zadanie IV i zadanie V
//        System.out.print("Second product name: ");
//        String secondProductName = inputScanner.nextLine();
//        System.out.print("Amount: ");
//        double secondProductAmount =
//                Double.parseDouble(inputScanner.nextLine());
//        Product secondProduct =
//                operation.insertProduct(secondProductName, secondProductAmount);
//
//        System.out.print("Third product name: ");
//        String thirdProductName = inputScanner.nextLine();
//        System.out.print("Amount: ");
//        double thirdProductAmount = Double.parseDouble(inputScanner.nextLine());
//        Product thirdProduct =
//                operation.insertProduct(thirdProductName, thirdProductAmount);
//
//        System.out.print("New supplier name: ");
//        String secondSupplierName = inputScanner.nextLine();
//        System.out.print("city: ");
//        String secondSupplierCity = inputScanner.nextLine();
//        System.out.print("street: ");
//        String secondSupplierStreet = inputScanner.nextLine();
//        Supplier secondSupplier = operation
//                .insertSupplier(secondSupplierName, secondSupplierCity,
//                        secondSupplierStreet);
//
//        operation.updateSupplier(secondSupplier, secondProduct);
//        operation.updateSupplier(secondSupplier, thirdProduct);

        // zadanie VI
//        System.out.print("P1 name: ");
//        String p1Name = inputScanner.nextLine();
//        System.out.print("P1 amount: ");
//        double p1Amount = Double.parseDouble(inputScanner.nextLine());
//        System.out.print("P2 name: ");
//        String p2Name = inputScanner.nextLine();
//        System.out.print("P2 amount: ");
//        double p2Amount = Double.parseDouble(inputScanner.nextLine());
//        System.out.print("P3 name: ");
//        String p3Name = inputScanner.nextLine();
//        System.out.print("P3 amount: ");
//        double p3Amount = Double.parseDouble(inputScanner.nextLine());
//
//        System.out.println("Category name: ");
//        String c1Name = inputScanner.nextLine();
//
//        Product p1 = operation.insertProduct(p1Name, p1Amount);
//        Product p2 = operation.insertProduct(p2Name, p2Amount);
//        Product p3 = operation.insertProduct(p2Name, p3Amount);
//        Category c1 = operation.insertCategory(c1Name);
//        operation.addCategoryToProduct(p1, c1);
//        operation.addCategoryToProduct(p2, c1);
//        operation.addCategoryToProduct(p3, c1);
//
//        List<Product> result = operation.getProducts(c1);
//        System.out.println("Product list: ");
//        for (Product prod : result) {
//            System.out.println(prod);
//        }

        // zadanie VII
//        System.out.print("P1 name: ");
//        String p1Name = inputScanner.nextLine();
//        System.out.print("P1 amount: ");
//        double p1Amount = Double.parseDouble(inputScanner.nextLine());
//        System.out.print("P2 name: ");
//        String p2Name = inputScanner.nextLine();
//        System.out.print("P2 amount: ");
//        double p2Amount = Double.parseDouble(inputScanner.nextLine());
//        System.out.print("P3 name: ");
//        String p3Name = inputScanner.nextLine();
//        System.out.print("P3 amount: ");
//        double p3Amount = Double.parseDouble(inputScanner.nextLine());
//
//        Invoice inv1 = operation.insertInvoice(new Invoice());
//        Invoice inv2 = operation.insertInvoice(new Invoice());
//        Product p1 = operation.insertProduct(p1Name, p1Amount);
//        Product p2 = operation.insertProduct(p2Name, p2Amount);
//        Product p3 = operation.insertProduct(p2Name, p3Amount);
//
//        operation.addProductToInvoice(inv1, p1, 5);
//        operation.addProductToInvoice(inv1, p2, 4);
//        operation.addProductToInvoice(inv2, p3, 7);
//
//        System.out.println("Products for invoice inv1:");
//        for (Product prod : inv1.getProducts()) {
//            System.out.println(prod.getProductName());
//        }

        // zadanie XI
//        operation.insertSupplier("Zabka", "dluga", "Krakow");
//        operation.insertSupplier("Biedronka", "krotka", "Zielona Gora");

        // zadanie XII

    }
}