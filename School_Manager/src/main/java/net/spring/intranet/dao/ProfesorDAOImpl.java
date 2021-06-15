package net.spring.intranet.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.spring.intranet.entity.Profesor;

@Repository
public class ProfesorDAOImpl implements ProfesorDAO{
	@Autowired
	private SessionFactory factory;
	
	@Override
	@Transactional
	public void actualizar(Profesor bean) {
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
			Profesor bean = session.get(Profesor.class, cod);
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Profesor> listarProfesores() {
		Session session = factory.getCurrentSession();
		Query query = null;
		try {
			String hql = "select p from Profesor p";
			query = session.createQuery(hql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor buscar(int cod) {
		Session session = factory.getCurrentSession();
		Profesor bean = null;
		try {
			bean = session.get(Profesor.class, cod);
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	@Transactional
	public void insertar(Profesor bean) {
		Session session = factory.getCurrentSession();
		try {
			session.save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Profesor iniciarSesion(String user, String pass, int codRol) {
		// TODO Auto-generated method stub
		return null;
	}

}
