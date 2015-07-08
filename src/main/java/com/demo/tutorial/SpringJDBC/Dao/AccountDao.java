package com.demo.tutorial.SpringJDBC.Dao;


import java.util.List;

import com.demo.tutorial.SpringJDBC.Model.Account;

public interface AccountDao {
	public void insert(Account account);
	public void update(Account account);
	public void update(List<Account> account);
	public void delete(long  accountId);
	public Account find(long  accountId);
	public List<Account> find(List<Long>  accountIds);
	public List<Account> find(String ownerName);
	public List<Account> find(boolean locked);
}
