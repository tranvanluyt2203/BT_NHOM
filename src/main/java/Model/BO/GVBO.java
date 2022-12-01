package Model.BO;

import Model.BEAN.GV;
import Model.DAO.GVDAO;

public class GVBO 
{
	GVDAO gvDAO=new GVDAO();
	public GV getGV(String idgv)
	{
		return gvDAO.getGV(idgv);
	}
}
