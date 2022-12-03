package Model.BO;

import java.util.ArrayList;

import Model.BEAN.Account;
import Model.DAO.AccountDAO;

public class AccountBO
{
	AccountDAO accountDAO=new AccountDAO();
	public boolean isAccountExist(String username,String password)
	{
		return accountDAO.isExistAccount(username, password);
	}
	public String getTypeAccount(String username,String password)
	{
		return accountDAO.getTypeAccount(username, password);
	}
	public int Num_next_SV()
	{
		return accountDAO.Num_SV()+1;
	}
	public int Num_next_GV()
	{
		return accountDAO.Num_GV()+1;
	}
	public void Add(Account account)
	{
		
		accountDAO.Add(account);
	}
	public String GetidByUsername(String username)
	{
		return accountDAO.GetidByUsername(username);
	}
	public String GettypeByUsername(String username)
	{
		return accountDAO.GettypeByUsername(username);
	}
	public void DelAccount(String id)
	{
		accountDAO.DelAccount(id);
	}
}