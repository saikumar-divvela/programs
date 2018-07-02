package com.theatre.dao.impl;

import com.theatre.domain.Theatre;
import com.theatre.dao.TheatreDao;
import com.theatre.utils.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;


public class HibernateTheatreDaoImpl implements TheatreDao {
	private Session session;
	public HibTheatreDaoImpl(){
	}
	public boolean addTheatre(Theatre th){
		try
		{
			this.session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(th);
 			session.getTransaction().commit();
		}
		catch (Exception exp)
		{
			System.out.println("exception while adding  theatre details to  database:"+exp.getMessage());
			exp.printStackTrace();
			return false;
		}
		return true;
	}
}

