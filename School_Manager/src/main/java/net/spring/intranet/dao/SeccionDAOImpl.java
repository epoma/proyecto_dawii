package net.spring.intranet.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.spring.intranet.entity.Alumno;
import net.spring.intranet.entity.Asistencia;
import net.spring.intranet.entity.Seccion;

@Repository
public class SeccionDAOImpl implements SeccionDAO{
	@Autowired
	private SessionFactory factory;

	@Override
	@Transactional
	public void insertar(Seccion bean) {
		Session session = factory.getCurrentSession();
		try {
			session.save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void actualizar(Seccion bean) {
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
			Seccion bean = session.get(Seccion.class, cod);
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Seccion> listarSecciones() {
		Session session = factory.getCurrentSession();
		Query query = null;
		try {
			String hql = "select p from Seccion p";
			query = session.createQuery(hql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Seccion buscar(int cod) {
		Session session = factory.getCurrentSession();
		Seccion bean = null;
		try {
			bean = session.get(Seccion.class, cod);
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Seccion> consultarSeccionXProfesor(int codPro) {
		Session session = factory.getCurrentSession();
		Query query = null;
		try {
			String hql = "select p from Seccion p where profesor.codigoProfesor=?1";
			query = session.createQuery(hql);
			query.setParameter(1, codPro);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	
	

}
