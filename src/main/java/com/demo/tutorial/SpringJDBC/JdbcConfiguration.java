package com.demo.tutorial.SpringJDBC;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.demo.tutorial.SpringJDBC.Dao.AccountDao;
import com.demo.tutorial.SpringJDBC.Dao.AccountDaoJdbcImpl;

@Configuration
public class JdbcConfiguration {

		@Bean
		public DataSource dataSource(){
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
			dataSource.setUsername("sa");
			dataSource.setPassword("");
			return dataSource;
		}
		
		//The jdbcTemplate bean that satisfies its datasource dependency
		@Bean
		public JdbcTemplate jdbcTemplate(){
			JdbcTemplate jdbcTemplate = new JdbcTemplate();
			jdbcTemplate.setDataSource(dataSource());
			return jdbcTemplate;
		}
		//accountDao bean using the AccountDaoJdbcimpl class and inject the
		//JdbcTemplate bean into it using setter dependency injection
		@Bean
		public AccountDao accountDao(){
			AccountDaoJdbcImpl accountDao = new AccountDaoJdbcImpl();
			accountDao.setJdbcTemplate(jdbcTemplate());
			return accountDao;
		}
		
}
