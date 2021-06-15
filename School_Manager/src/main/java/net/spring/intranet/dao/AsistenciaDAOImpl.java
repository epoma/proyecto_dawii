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

@Repository
public class AsistenciaDAOImpl implements AsistenciaDAO{
	@Autowired
	private SessionFactory factory;
	
	@Override
	@Transactional
	public void actualizar(Asistencia bean) {
		Session session = factory.getCurrentSession();
		try {
			session.update(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Asistencia> listarAsistenciasxAlumnos(int codAlu) {
		Session session = factory.getCurrentSession();
		Query query = null;
		try {
			String hql = "select p from Asistencia p where alumno.codigoAlumno=?1";
			query = session.createQuery(hql);
			query.setParameter(1, codAlu);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Asistencia> listarAsistencias() {
		Session session = factory.getCurrentSession();
		Query query = null;
		try {
			String hql = "select p from Asistencia p";
			query = session.createQuery(hql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}


	
	
	
	
	
	
}
