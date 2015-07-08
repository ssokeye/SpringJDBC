package com.demo.tutorial.SpringJDBC;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.tutorial.SpringJDBC.Dao.AccountDao;
import com.demo.tutorial.SpringJDBC.Model.Account;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	AnnotationConfigApplicationContext applicationContext = 
    			new AnnotationConfigApplicationContext(JdbcConfiguration.class);
    	DataSource dataSource =
    			applicationContext.getBean("dataSource", DataSource.class);
    	AccountDao accountDao = applicationContext.getBean("accountDao",AccountDao.class);

    	try{
        	Account account = accountDao.find(100);  
        	
            // System.out.println(account.getId());
             System.out.println("This is owner name " + account);
//             System.out.println(account.getBalance());
               System.out.println(account.getAccessTime());
//             System.out.println(account.isLocked());    		
    	}catch(NullPointerException e){
    		System.out.println("NullPointer");
    	}
    
    }     
}
