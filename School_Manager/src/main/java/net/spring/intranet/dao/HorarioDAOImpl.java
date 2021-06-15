package net.spring.intranet.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.spring.intranet.entity.Horario;

@Repository
public class HorarioDAOImpl implements HorarioDAO{
	
	@Autowired
	private SessionFactory factory;

	@Override
	@Transactional
	public List<Horario> listarHorario() {
		Session session = factory.getCurrentSession();
		Query query = null;
		try {
			String hql = "select h from Horario h";
			query = session.createQuery(hql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

}
