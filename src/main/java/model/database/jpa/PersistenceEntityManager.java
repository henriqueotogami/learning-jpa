package model.database.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceEntityManager {

    final String mysqlDatabase = "course_java";
    EntityManagerFactory persistenceManager = null;
    EntityManager connectionDatabase = null;

    private String getMysqlDatabase() { return mysqlDatabase; }

    private EntityManagerFactory getPersistenceManager() { return persistenceManager; }

    private void setPersistenceManager(final EntityManagerFactory persistenceManager) {
        this.persistenceManager = persistenceManager;
    }

    public EntityManager getConnectionDatabase() { return connectionDatabase; }

    private void setConnectionDatabase(final EntityManager connectionDatabase) {
        this.connectionDatabase = connectionDatabase;
    }

    public void createConnection() {
        System.out.println("PersistenceEntityManager - createConnection(): BEGIN");
        setPersistenceManager(Persistence.createEntityManagerFactory(getMysqlDatabase()));
        setConnectionDatabase(persistenceManager.createEntityManager());
        System.out.println("PersistenceEntityManager - createConnection(): END");
    }

    public void closeConnection(){
        System.out.println("PersistenceEntityManager - closeConnection(): BEGIN");
        getConnectionDatabase().close();
        getPersistenceManager().close();
        System.out.println("PersistenceEntityManager - closeConnection(): END");
    }
}
