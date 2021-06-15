package net.spring.intranet.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.spring.intranet.entity.QR;

@Repository
public class QRDAOImpl implements QRDAO{
	@Autowired
	private SessionFactory factory;

	@Override
	@Transactional(readOnly = true)
	public QR buscar(int cod) {
		Session session = factory.getCurrentSession();
		QR bean = null;
		try {
			bean = session.get(QR.class, cod);
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public int validar(QR bean) {
		Session session = factory.getCurrentSession();
		Query query = null;
		int salida = 0;
		try {
			String hql = "select p from QR p where p.DES_QR =:des";
			query = session.createQuery(hql);
			query.setParameter("des", bean.getDesQR());
			if(query!=null)
				salida = 1;
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
	}


}
