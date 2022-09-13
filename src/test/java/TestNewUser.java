import model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestNewUser {

    public static void main(String[] args) {

        final String mysqlDatabase = "course_java";
        EntityManagerFactory persistenceManager = Persistence.createEntityManagerFactory(mysqlDatabase);
        EntityManager factoryConnectionDatabase = persistenceManager.createEntityManager();

        User newUser = new User("Henrique Otogami", "h-otogami@icloud.com");
        newUser.setId(1L);

        factoryConnectionDatabase.getTransaction().begin();
        factoryConnectionDatabase.persist(newUser);
        factoryConnectionDatabase.getTransaction().commit();

        factoryConnectionDatabase.close();
        persistenceManager.close();
    }
}
