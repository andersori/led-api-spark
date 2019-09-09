package io.andersori.led.api.repository;

import java.util.Optional;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import io.andersori.led.api.entity.UserLed;

@Repository("UserRepositoryIm")
public class UserRepositoryIm extends DAOHibernate<UserLed> implements UserRepositoryIn {

	protected UserRepositoryIm(Class<UserLed> type) {
		super(type);
	}
	
	public UserRepositoryIm() {
		this(UserLed.class);
	}

	@Override
	public Optional<UserLed> findByUsername(String username) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		Optional<UserLed> result = Optional.empty();

		try {
			TypedQuery<UserLed> typedQuery = session.createQuery("SELECT u FROM UserLed u WHERE u.username = :username", UserLed.class);
			typedQuery.setParameter("username", username);

			result = Optional.of(typedQuery.getSingleResult());
			t.commit();
		} catch (Exception e) {
			t.rollback();
			throw e;
		} finally {
			session.close();
		}

		return result;
	}

}
