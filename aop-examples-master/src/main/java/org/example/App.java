package org.example;

import org.example.config.AppConfig;
import org.example.dao.AccountDAO;
import org.example.model.Library;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Library library = context.getBean("libraryBean", Library.class);
        library.getBook();

        AccountDAO accountDAO = context.getBean(AccountDAO.class);
        accountDAO.addAccount();

        context.close();
    }
}
