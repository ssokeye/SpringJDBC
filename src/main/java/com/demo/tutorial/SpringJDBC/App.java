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
        	
             System.out.println("Account Id: " + account.getId());
             System.out.println("Owner Name: "+ account.getOwnerName());
             System.out.println("Balance: " + account.getBalance());
             System.out.println("Access Time: " + account.getAccessTime());
             System.out.println("Is Account Locked: "+ account.isLocked());    		
 
    	}catch(NullPointerException e){
    		System.out.println("NullPointer");
    	}
    
    }     
}
