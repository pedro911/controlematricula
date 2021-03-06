package util;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public abstract class DAOImpl<T, I extends Serializable> implements DAOGenerico<T, I>{
	

	private final EntityManager entityManager = EntityManagerUtil.getEntityManager();
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public T save(T entity) {

		T saved = null;

		getEntityManager().getTransaction().begin();
		saved = getEntityManager().merge(entity);
		getEntityManager().getTransaction().commit();

		return saved;
	}

	@Override
	public void remove(T entity) {
		getEntityManager().getTransaction().begin();
		Object c = getEntityManager().merge(entity);
		getEntityManager().remove(c);
		getEntityManager().getTransaction().commit();

	}

	@Override
	public T getById(Class<T> classe, I pk) {

		try {
			return getEntityManager().find(classe, pk);
		} catch (NoResultException e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> classe) {

		return getEntityManager().createQuery("select o from " + classe.getSimpleName() + " o").getResultList();
	}


}