/**
 * 
 */
package com.demo.tutorial.SpringJDBC.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.demo.tutorial.SpringJDBC.Model.Account;

/**
 * @author Samuel Sokeye
 *
 */
public class AccountDaoJdbcImpl implements AccountDao {

	//Injection of JdbcTemplate
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	/* (non-Javadoc)
	 * @see com.demo.tutorial.SpringJDBC.Dao.AccountDao#insert(com.demo.tutorial.SpringJDBC.Model.Account)
	 */
	public void insert(Account account) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.demo.tutorial.SpringJDBC.Dao.AccountDao#update(com.demo.tutorial.SpringJDBC.Model.Account)
	 */
	public void update(Account account) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.demo.tutorial.SpringJDBC.Dao.AccountDao#update(java.util.List)
	 */
	public void update(List<Account> account) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.demo.tutorial.SpringJDBC.Dao.AccountDao#delete(long)
	 */
	public void delete(long accountId) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.demo.tutorial.SpringJDBC.Dao.AccountDao#find(long)
	 */
	public Account find(long accountId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select id, owner_name, balance, access_time, locked from account where id = ?", new RowMapper<Account>(){

			public Account mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				Account account = new Account();
				account.setId(rs.getLong("id"));
				account.setOwnerName(rs.getString("owner_name"));
				account.setBalance(rs.getDouble("balance"));
				account.setAccessTime(rs.getDate("access_time"));
				account.setLocked(rs.getBoolean("locked"));
				return  account;
			}
			
		}, accountId); 
	}

	/* (non-Javadoc)
	 * @see com.demo.tutorial.SpringJDBC.Dao.AccountDao#find(java.util.List)
	 */
	public List<Account> find(List<Long> accountIds) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.demo.tutorial.SpringJDBC.Dao.AccountDao#find(java.lang.String)
	 */
	public List<Account> find(String ownerName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.demo.tutorial.SpringJDBC.Dao.AccountDao#find(boolean)
	 */
	public List<Account> find(boolean locked) {
		// TODO Auto-generated method stub
		return null;
	}

}
