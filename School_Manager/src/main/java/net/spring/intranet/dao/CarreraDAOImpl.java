package net.spring.intranet.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.spring.intranet.entity.Carrera;

@Repository
public class CarreraDAOImpl implements CarreraDAO{
	@Autowired
	private SessionFactory factory;
	
	@Override
	@Transactional
	public void actualizar(Carrera bean) {
		Session session = factory.getCurrentSession();
		try {
			session.update(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void eliminar(int cod) {
		Session session = factory.getCurrentSession();
		try {
			Carrera bean = session.get(Carrera.class, cod);
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Carrera> listarCarreras() {
		Session session = factory.getCurrentSession();
		Query query = null;
		try {
			String hql = "select p from Carrera p";
			query = session.createQuery(hql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Carrera buscar(int cod) {
		Session session = factory.getCurrentSession();
		Carrera bean = null;
		try {
			bean = session.get(Carrera.class, cod);
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	@Transactional
	public void insertar(Carrera bean) {
		Session session = factory.getCurrentSession();
		try {
			session.save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
