package peaksoft;

import peaksoft.config.HibernateConfiguration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        HibernateConfiguration.getEntityManager();
    }
}
