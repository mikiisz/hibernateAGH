package domain;

import model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class Operation {

    private Session mainSession;

    public Operation(Session mainSession) {
        this.mainSession = mainSession;
    }

    public Product insertProduct(String productName, double inStock) {
        Session session = mainSession.getSession();
        Transaction tx = session.beginTransaction();

        Product product = new Product(productName, inStock);

        session.save(product);
        tx.commit();
        return product;
    }

    public Supplier insertSupplier(String supplierName, String city,
                                   String street) {
        Session session = mainSession.getSession();
        Transaction tx = session.beginTransaction();

        // zadanie XI
        Address address = new Address(city, street);

        Supplier supplier = new Supplier(supplierName, city, street);
        session.save(supplier);

        tx.commit();
        return supplier;
    }

    public Product getProductByName(String name) {
        CriteriaBuilder builder = mainSession.getSession().getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);

        Root<Product> root = query.from(Product.class);
        Predicate pWhereName = builder.equal(root.get("productName"), name);

        TypedQuery<Product> typedQuery = mainSession.getSession().createQuery(
                query.select(root).where(pWhereName)
        );
        return typedQuery.getSingleResult();
    }

    // zadanie III
    public Product updateProduct(Product product, Supplier supplier) {
        Session session = mainSession.getSession();
        Transaction tx = session.beginTransaction();

        product.setSuppliedBy(supplier);

        session.save(product);
        tx.commit();
        return product;
    }

    // zadanie IV
    public Supplier updateSupplier(Supplier supplier, Product product) {
        Session session = mainSession.getSession();
        Transaction tx = session.beginTransaction();

        supplier.addSuppliedProduct(product);

        session.save(supplier);
        tx.commit();
        return supplier;
    }

    public Category insertCategory(String name) {
        Session session = mainSession.getSession();
        Transaction tx = session.beginTransaction();

        Category category = new Category(name);

        session.save(category);
        tx.commit();
        return category;
    }

    public Product addCategoryToProduct(Product product, Category category) {
        Session session = mainSession.getSession();
        Transaction tx = session.beginTransaction();

        product.setCategory(category);

        session.save(product);
        tx.commit();
        return product;
    }

    public List<Product> getProducts(Category category) {
        CriteriaBuilder builder = mainSession.getSession().getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);

        Root<Product> root = query.from(Product.class);
        Predicate pWhereCategory =
                builder.equal(root.get("category"), category);

        TypedQuery<Product> typedQuery = mainSession.getSession().createQuery(
                query.select(root).where(pWhereCategory)
        );
        return typedQuery.getResultList();
    }

    public Invoice insertInvoice(Invoice inv) {
        Session session = mainSession.getSession();
        Transaction tx = session.beginTransaction();

        session.save(inv);
        tx.commit();
        return inv;
    }

    public void addProductToInvoice(Invoice inv, Product product,
                                    int quantity) {
        Session session = mainSession.getSession();
        Transaction tx = session.beginTransaction();

        inv.addProduct(product, quantity);

        session.save(inv);
        tx.commit();
    }
}
