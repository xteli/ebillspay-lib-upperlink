/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebillspay.payment.lib.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ebillspay.payment.lib.dbutil.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author chineduojiteli
 */
public class CoreSystem {

    public static SessionFactory getSessionFactory() {
        return HibernateUtil.getSessionFactory();
    }

    public Session BuildSession() {
        SessionFactory sFactory = getSessionFactory();
        Session ses = sFactory.getCurrentSession();
        return ses;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }

    public <T> boolean saveEntity(T entity) {
        boolean saved = false;
        Session builtSession = null;
        Transaction transaction = null;

        try {
            builtSession = BuildSession();
            transaction = builtSession.beginTransaction();
            //the below must be wrapped in a transaction
            builtSession.save(entity);
            transaction.commit();
            saved = true;
        } catch (Exception hex) {
            hex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (builtSession != null && builtSession.isOpen()) {
                builtSession.close();
            }
        }
        return saved;
    }

    public <T> boolean updateEntity(T entity) {
        boolean updated = false;
        Session builtSession = null;
        Transaction transaction = null;
        try {
            builtSession = BuildSession();
            transaction = builtSession.beginTransaction();
            //the below must be wrapped in a transaction
            builtSession.update(entity);
            transaction.commit();
            updated = true;
        } catch (Exception hex) {
            hex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (builtSession != null && builtSession.isOpen()) {
                builtSession.close();
            }
        }
        return updated;
    }

    public <T> T retrieveTransaction(String sessionId, Class<T> entityClass) {
        T entity = null;
        Session builtSession = null;
        Transaction transaction = null;
        try {
            builtSession = BuildSession();
            transaction = builtSession.beginTransaction();
            //the below must be wrapped in a transaction
            Criteria criteria = builtSession.createCriteria(entityClass);
            if (sessionId != null && !"".equals(sessionId)) {
                criteria.add(Restrictions.eq("sessionID", sessionId));
            }

            entity = (T) criteria.uniqueResult();
            transaction.commit();
        } catch (HibernateException hex) {
             hex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (builtSession != null && builtSession.isOpen()) {
                builtSession.close();
            }
        }
        return entity;
    }

}
