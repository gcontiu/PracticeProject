package practice.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * User: gelu
 * Date: 1/21/12
 * Time: 3:37 PM
 */
public abstract class GenericDao< T extends Serializable > {

    private Class< T > clazz;

    @Autowired
    private SessionFactory sessionFactory;

    public void setClazz (Class< T > clazz) {
        this.clazz = clazz;
    }

    public T getById(Long id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    public T getByPropery(String propertyName, String value) {
        Criteria criteria =  getCurrentSession().createCriteria(clazz);
        criteria.add(Restrictions.eq(propertyName, value));
        List result = criteria.list();
        if (result != null && !result.isEmpty()) {
            return (T) result.get(0);
        }
        return null;
    }

    public List<T> getAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }


    public void create(T entity) {
        getCurrentSession().persist(entity);
    }

    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    public void updateWithMerge(T entity) {
        getCurrentSession().merge(entity);
    }

    public void deleteById(Long id) {
        T entity = getById(id);
        delete(entity);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
