package Model.BO;

import java.util.ArrayList;

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
	
}