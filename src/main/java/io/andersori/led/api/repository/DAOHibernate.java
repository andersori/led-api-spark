package io.andersori.led.api.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public abstract class DAOHibernate<T> implements DAO<T> {

	@Autowired
	@Qualifier("SessionFactory")
	protected SessionFactory sessionFactory;
	
	private final Class<T> type;
	
	protected DAOHibernate(Class<T> type) {
		this.type = type;
	}
	
	@Override
	public List<T> findAll() {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> criteria = builder.createQuery(type);
			
			List<T> result = session.createQuery(criteria).getResultList();
			
            t.commit();
            return result;
        } catch (RuntimeException e) {
            t.rollback();
            throw e;
        } finally {
            session.close();
        }
	}

	@Override
	public Optional<T> save(T value) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		Optional<T> result = Optional.empty();
		
		try {
			if(value != null) {
				session.persist(value);
				t.commit();
				result = Optional.of(value);
			}
		} catch (RuntimeException e) {
            t.rollback();
            throw e;
		} finally {
			session.close();
		}
		
		return result;
	}

	@Override
	public Optional<T> get(Long id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		Optional<T> result = Optional.empty();
		
		try {
			T res = (T) session.get(type, id);
			t.commit();
			result = Optional.of(res);
			
		} catch (RuntimeException e) {
            t.rollback();
            throw e;
		} finally {
			session.close();
		}
		
		return result;
	}

	@Override
	public Optional<T> update(T value) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		Optional<T> result = Optional.empty();
		
		try {
			if(value != null) {
				session.merge(value);
				t.commit();
				result = Optional.of(value);
			}
		} catch (RuntimeException e) {
            t.rollback();
            throw e;
		} finally {
			session.close();
		}
		
		return result;
	}

	@Override
	public Optional<T> remove(T value) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		Optional<T> result = Optional.empty();
		
		try {
			if(value != null) {
				session.delete(value);
				t.commit();
				result = Optional.of(value);
			}
		} catch (RuntimeException e) {
            t.rollback();
            throw e;
		} finally {
			session.close();
		}
		
		return result;
	}
	
}
