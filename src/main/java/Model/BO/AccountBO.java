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
	public void Add(Account account,String type)
	{
		String id;
		if (type.equals("admin"))
		{
			account.settype(type);
			if (Num_next_GV()<10) account.setid("AD0"+Num_next_GV());
			else 
			{
				account.setid("AD"+Num_next_GV());
			}
		}
		else if (type.equals("user"))
		{
			account.settype(type);
			if (Num_next_SV()<10) account.setid("U0"+Num_next_SV());
			else 
			{
				account.setid("U"+Num_next_SV());
			}
		}
		accountDAO.Add(account);
	}
	
}