package net.spring.intranet.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.spring.intranet.entity.Rol;

@Repository
public class RolDAOImpl implements RolDAO{
	@Autowired
	private SessionFactory factory;

	@Override
	@Transactional
	public List<Rol> listarRol() {
		Session session = factory.getCurrentSession();
		Query query = null;
		try {
			String hql = "select r from Rol r";
			query = session.createQuery(hql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}
	

}
