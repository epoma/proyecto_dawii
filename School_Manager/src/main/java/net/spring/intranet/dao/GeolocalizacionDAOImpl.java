package net.spring.intranet.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.spring.intranet.entity.Geolocalizacion;

@Repository
public class GeolocalizacionDAOImpl implements GeolocalizacionDAO{
	@Autowired
	private SessionFactory factory;
	
	@Override
	@Transactional
	public void actualizar(Geolocalizacion bean) {
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
			Geolocalizacion bean = session.get(Geolocalizacion.class, cod);
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Geolocalizacion> listarGeolocalizaciones() {
		Session session = factory.getCurrentSession();
		Query query = null;
		try {
			String hql = "select p from Geolocalizacion p";
			query = session.createQuery(hql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public int validar(Geolocalizacion bean) {
		Session session = factory.getCurrentSession();
		Query query = null;
		int salida = 0;
		try {
			String hql = "select p from Postulante p where p.COR_GEO =:cor";
			query = session.createQuery(hql);
			query.setParameter("cor", bean.getCordenadaGeolocalizacion());
			if(query!=null)
				salida = 1;
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
	}

	@Override
	@Transactional
	public void insertar(Geolocalizacion bean) {
		Session session = factory.getCurrentSession();
		try {
			session.save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
