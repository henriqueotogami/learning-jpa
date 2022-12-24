package infrastructure;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.List;

public class DataAccessObject<Entity> {

    private static String targetDatabaseName;
    private static EntityManagerFactory connectionFactory;

    private EntityManager connectionDatabase;
    private Class<Entity> entityClass;


    public static EntityManagerFactory getConnectionFactory() { return connectionFactory; }

    public static void setConnectionFactory(final EntityManagerFactory connectionFactory) {
        DataAccessObject.connectionFactory = connectionFactory;
    }

    public EntityManager getConnectionDatabase() { return connectionDatabase; }

    public void setConnectionDatabase(final EntityManager connectionDatabase) {
        this.connectionDatabase = connectionDatabase;
    }

    public static String getTargetDatabaseName() { return targetDatabaseName; }

    public static void setTargetDatabaseName(final String targetDatabaseName) {
        DataAccessObject.targetDatabaseName = targetDatabaseName;
    }

    public Class<Entity> getEntityClass() { return entityClass; }

    public void setEntityClass(final Class<Entity> entityClass) { this.entityClass = entityClass; }

    static {

        try{
            setTargetDatabaseName("course_java");
            setConnectionFactory(Persistence.createEntityManagerFactory(getTargetDatabaseName()));
            if(getConnectionFactory().isOpen()) {
                System.out.println("First database connection successfully.");
            }
        } catch (Exception exception) {
            // Fazer login -> log4j
        }

    }

    public DataAccessObject(){
        this(null);
    }

    public DataAccessObject(final Class<Entity> entityClass) {
        setEntityClass(entityClass);
        setConnectionDatabase(getConnectionFactory().createEntityManager());
    }

    public DataAccessObject<Entity> getClassDataAccessObject() {
        return this;
    }

    public DataAccessObject<Entity> openTransactionalDAO() {
        getConnectionDatabase().getTransaction().begin();
        return this;
    }

    public DataAccessObject<Entity> closeTransactionalDAO() {
        getConnectionDatabase().getTransaction().commit();
        return this;
    }

    public DataAccessObject<Entity> includeTransactionalDAO(final Entity entity) {
        getConnectionDatabase().persist(entity);
        return this;
    }

    public DataAccessObject<Entity> includeAtomicTransactionalDAO(final Entity entity) {
        getConnectionDatabase().persist(entity);
        return this;
    }

    public List<Entity> getAllStorageItems() {
        final int defaultQuantityItems = 10;
        final int defaultItemDisplacement = 0;
        return this.getAllStorageItems(defaultQuantityItems, defaultItemDisplacement);
    }

    public List<Entity> getAllStorageItems(final int quantityItems, final int indexItemDisplacement) {
        if(getEntityClass() == null){
            throw new UnsupportedOperationException("DataAccessObject - getAllStorageItems: Failed. Class is null.");
        }

        final String persistenceQuery = "SELECT entity FROM " + getEntityClass().getName() + " entity";
        TypedQuery<Entity> createdQuery = getConnectionDatabase().createQuery(persistenceQuery, getEntityClass());
        createdQuery.setMaxResults(quantityItems);
        createdQuery.setFirstResult(indexItemDisplacement);
        return createdQuery.getResultList();
    }

    public boolean createTable(final String tableName, final String sqlCommand, final Class classInstance){
        boolean isTableCreated = false;
        final String persistenceQuery = "SELECT entity FROM " + getEntityClass().getName() + " entity";
        try {
            isTableCreated = (getConnectionDatabase().createQuery(persistenceQuery, getEntityClass()).getResultList().size() > 0);
            System.out.println("DataAccessObject - createTable(): This entity already exists in the database.");
        } catch (final Exception exception) {
            System.out.println("DataAccessObject - createTable(): This entity doesn't exist in the database.");
            System.out.println("DataAccessObject - createTable(): Starting the attempt to create the entity in the database.");
//            includeTransactionalDAO();
            isTableCreated = true;
            getConnectionDatabase().createQuery(persistenceQuery, getEntityClass());
            if(isTableCreated) {
                System.out.println("DataAccessObject - createTable(): Creation of the entity in the database performed successfully.");
            }
        }
        System.out.println(tableName + " table created successfully.");
        return isTableCreated;
    }

    public void closeConnectionDatabase(){
        System.out.println("DataAccessObject - Closing connection database.");
        getConnectionDatabase().close();
    }
}
