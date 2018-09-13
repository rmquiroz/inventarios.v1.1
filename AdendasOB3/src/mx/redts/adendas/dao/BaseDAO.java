package mx.redts.adendas.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.transform.AliasToBeanResultTransformer;

public class BaseDAO {

	private SessionFactory sessionFactory;

	public List<?> createQuery(String hql) {
		org.hibernate.Session session = this.getSession();
		List<?> list = session.createQuery(hql).list();
		session.close();
		return list;

	}

	public Object createQuery(String hql, List<?> parametros) {
		int cpara = 0;
		Object rObj = null;
		org.hibernate.Session session = this.getSession();
		Query oquey = session.createQuery(hql);

		for (Object parametro : parametros) {
			System.out
					.println(Messages.getString("BaseDAO.5") + parametro.getClass().toString()); //$NON-NLS-1$
			if (parametro instanceof String)
				oquey.setString(cpara, (String) parametro);
			else if (parametro instanceof Long)
				oquey.setLong(cpara, (Long) parametro);
			else if (parametro instanceof Integer) {
				System.out.println(Messages.getString("BaseDAO.6") + cpara); //$NON-NLS-1$

				oquey.setInteger(cpara, (Integer) parametro);
			} else if (parametro instanceof Double)
				oquey.setDouble(cpara, (Double) parametro);
			else if (parametro instanceof java.sql.Date)
				oquey.setDate(cpara, (java.sql.Date) parametro);

			cpara++;
		}

		rObj = oquey.uniqueResult();
		session.close();

		return rObj;
	}

	public List<?> createQueryList(String hql, List<?> parametros) {
		int cpara = 0;
		List<?> rObj = null;
		org.hibernate.Session session = this.getSession();
		System.out.println(Messages.getString("BaseDAO.7") + hql); //$NON-NLS-1$
		Query oquey = session.createQuery(hql);

		for (Object parametro : parametros) {
			System.out
					.println(Messages.getString("BaseDAO.8") + parametro.getClass().toString()); //$NON-NLS-1$
			if (parametro instanceof String)
				oquey.setString(cpara, (String) parametro);
			else if (parametro instanceof Long)
				oquey.setLong(cpara, (Long) parametro);
			else if (parametro instanceof Integer) {
				System.out.println(Messages.getString("BaseDAO.9") + cpara); //$NON-NLS-1$

				oquey.setInteger(cpara, (Integer) parametro);
			} else if (parametro instanceof Double)
				oquey.setDouble(cpara, (Double) parametro);
			else if (parametro instanceof java.sql.Date)
				oquey.setDate(cpara, (java.sql.Date) parametro);
			else if (parametro instanceof java.util.Date)
				oquey.setDate(cpara, new java.sql.Date(
						((java.util.Date) parametro).getTime()));

			cpara++;
		}

		rObj = oquey.list();
		session.close();

		return rObj;
	}

	public List<?> createQueryList(String hql, Map<String, ?> parametros) {

		List<?> rObj = null;
		org.hibernate.Session session = this.getSession();
		System.out.println(Messages.getString("BaseDAO.10") + hql); //$NON-NLS-1$
		Query oquey = session.createQuery(hql);

		for (String parametro : parametros.keySet()) {
			System.out
					.println(Messages.getString("BaseDAO.11") + parametro.getClass().toString()); //$NON-NLS-1$

			if (parametros.get(parametro) instanceof String)
				oquey.setString(parametro, (String) parametros.get(parametro));
			else if (parametros.get(parametro) instanceof Long)
				oquey.setLong(parametro, (Long) parametros.get(parametro));
			else if (parametros.get(parametro) instanceof Integer) {
				System.out
						.println(Messages.getString("BaseDAO.12") + parametro); //$NON-NLS-1$

				oquey.setInteger(parametro, (Integer) parametros.get(parametro));
			} else if (parametros.get(parametro) instanceof Double)
				oquey.setDouble(parametro, (Double) parametros.get(parametro));
			else if (parametros.get(parametro) instanceof java.sql.Date)
				oquey.setDate(parametro,
						(java.sql.Date) parametros.get(parametro));
			else if (parametros.get(parametro) instanceof java.util.Date)
				oquey.setDate(parametro, new java.sql.Date(
						((java.util.Date) parametros.get(parametro)).getTime()));

		}

		rObj = oquey.list();
		session.close();

		return rObj;
	}

	public List<?> createQueryToBean(String hql, Class<?> bean) {
		org.hibernate.Session session = this.getSession();
		List<?> l = session.createQuery(hql)
				.setResultTransformer(new AliasToBeanResultTransformer(bean))
				.list();
		session.close();
		return l;

	}

	public Object createQueryUnique(String hql, Map<String, ?> parametros) {

		Object rObj = null;
		org.hibernate.Session session = this.getSession();
		System.out.println(Messages.getString("BaseDAO.13") + hql); //$NON-NLS-1$
		Query oquey = session.createQuery(hql);

		for (String parametro : parametros.keySet()) {
			System.out
					.println(Messages.getString("BaseDAO.14") + parametro.getClass().toString()); //$NON-NLS-1$

			if (parametros.get(parametro) instanceof String)
				oquey.setString(parametro, (String) parametros.get(parametro));
			else if (parametros.get(parametro) instanceof Long)
				oquey.setLong(parametro, (Long) parametros.get(parametro));
			else if (parametros.get(parametro) instanceof Integer) {
				System.out
						.println(Messages.getString("BaseDAO.15") + parametro); //$NON-NLS-1$

				oquey.setInteger(parametro, (Integer) parametros.get(parametro));
			} else if (parametros.get(parametro) instanceof Double)
				oquey.setDouble(parametro, (Double) parametros.get(parametro));
			else if (parametros.get(parametro) instanceof java.sql.Date)
				oquey.setDate(parametro,
						(java.sql.Date) parametros.get(parametro));
			else if (parametros.get(parametro) instanceof java.util.Date)
				oquey.setDate(parametro, new java.sql.Date(
						((java.util.Date) parametros.get(parametro)).getTime()));

		}

		rObj = oquey.uniqueResult();
		session.close();

		return rObj;
	}

	public void createUpdQry(String hql, Map<String, ?> parametros) {

		System.out.println(Messages.getString("BaseDAO.16")); //$NON-NLS-1$
		Session sesion = this.getSession();

		Transaction tx = sesion.beginTransaction();
		try {
			// /////////////
			Query oquey = sesion.createQuery(hql);
			for (String parametro : parametros.keySet()) {
				System.out
						.println(Messages.getString("BaseDAO.17") + parametro.getClass().toString()); //$NON-NLS-1$

				if (parametros.get(parametro) instanceof String)
					oquey.setString(parametro,
							(String) parametros.get(parametro));
				else if (parametros.get(parametro) instanceof Long)
					oquey.setLong(parametro, (Long) parametros.get(parametro));
				else if (parametros.get(parametro) instanceof Integer) {
					oquey.setInteger(parametro,
							(Integer) parametros.get(parametro));
				} else if (parametros.get(parametro) instanceof Double)
					oquey.setDouble(parametro,
							(Double) parametros.get(parametro));
				else if (parametros.get(parametro) instanceof java.sql.Date)
					oquey.setDate(parametro,
							(java.sql.Date) parametros.get(parametro));
				else if (parametros.get(parametro) instanceof java.util.Date)
					oquey.setDate(
							parametro,
							new java.sql.Date(((java.util.Date) parametros
									.get(parametro)).getTime()));
				else if (parametros.get(parametro) instanceof Boolean)
					oquey.setBoolean(parametro,
							(Boolean) parametros.get(parametro));
			}

			oquey.executeUpdate();

			tx.commit();
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			// TODO Auto-generated catch block

		} finally {
			sesion.close();
		}

	}

	public Session getSession() {

		Session sesion = null;
		try {
			sesion = sessionFactory.getCurrentSession();

			if (sesion == null)
				sesion = sessionFactory.openSession();
			else if (!sesion.isOpen())
				sesion = sessionFactory.openSession();

		} catch (HibernateException ex) {
			sesion = sessionFactory.openSession();
		}

		return sesion;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public org.hibernate.Transaction getTransaction() {
		return this.getSession().beginTransaction();

	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
