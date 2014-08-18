package br.com.teste_web.model.dao;

import br.com.teste_web.model.entities.Cidade;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;


public class HibernateDAO<T> implements InterfaceDAO<T>, Serializable {

    private static final long serialVersionUID = 1L;
    
    private Class<T> classe;
    private Session session;

    public HibernateDAO(Class<Cidade> aClass, Session requestSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void save(T entity) {
    session.save(entity);
    }

    @Override
    public void update(T entity) {
      session.update(entity);
    }

    @Override
    public void remove(T entity) {
       session.delete(entity);
    }

    @Override
    public void marge(T entity) {
      session.merge(entity);
    }

    @Override
    public T getEntity(Serializable id) {
     T entity = (T)session.get(classe, id);
     return entity;
    }

    @Override
    public T getEntityByDetacheCriteria(DetachedCriteria criteria) {
       T entity = (T)criteria.getExecutableCriteria(session).uniqueResult();
       return entity;
    }

   @Override
    public List<T> getListByDetachedCriteria(DetachedCriteria criteria) {
        return criteria.getExecutableCriteria(session).list();
    }
    
    @Override
    public List<T> getEntities() {
        List<T> enties = (List<T>) session.createCriteria(classe).list();
        return enties;
    }    
    
}