package peaksoft.config;

import jakarta.persistence.EntityManager;
import org.hibernate.cfg.Configuration;
import peaksoft.model.Address;
import peaksoft.model.Country;
import peaksoft.model.Programmer;
import peaksoft.model.Project;

import static org.hibernate.cfg.AvailableSettings.*;
import static org.hibernate.cfg.AvailableSettings.DIALECT;

/**
 * The golden boy
 */
public class HibernateConfiguration {
    public static EntityManager getEntityManager() {
        Configuration configuration = new Configuration();
        configuration.setProperty(DRIVER, "org.postgresql.Driver");
        configuration.setProperty(URL, "jdbc:postgresql://localhost:5432/peaksoft");
        configuration.setProperty(USER, "postgres");
        configuration.setProperty(PASS, "altynbek695");
        configuration.setProperty(HBM2DDL_AUTO, "create");
        configuration.setProperty(DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");

        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Programmer.class);
        configuration.addAnnotatedClass(Project.class);
        configuration.addAnnotatedClass(Country.class);
        return configuration.buildSessionFactory().createEntityManager();
    }

}
