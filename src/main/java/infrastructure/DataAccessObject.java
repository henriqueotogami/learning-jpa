package infrastructure;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

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

    public List<Entity> getAllUsers() {
        final int defaultQuantityUsers = 10;
        final int defaultUserDisplacement = 0;
        return this.getAllUsers(defaultQuantityUsers, defaultUserDisplacement);
    }

    public List<Entity> getAllUsers(final int quantityUsers, final int indexUserDisplacement) {
        if(getEntityClass() == null){
            throw new UnsupportedOperationException("DataAccessObject - getAllUsers: Failed. Class is null.");
        }

        final String persistenceQuery = "SELECT entity FROM " + getEntityClass().getName() + " entity";
        TypedQuery<Entity> createdQuery = getConnectionDatabase().createQuery(persistenceQuery, getEntityClass());
        createdQuery.setMaxResults(quantityUsers);
        createdQuery.setFirstResult(indexUserDisplacement);
        return createdQuery.getResultList();
    }

    public void closeConnectionDatabase(){
        System.out.println("DataAccessObject - Closing connection database.");
        getConnectionDatabase().close();
    }
}
