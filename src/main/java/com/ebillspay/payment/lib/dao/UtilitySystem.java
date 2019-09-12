/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebillspay.payment.lib.dao;

import com.ebillspay.payment.lib.entities.Credentials;
import com.ebillspay.payment.lib.entities.Institution;
import com.ebillspay.payment.lib.entities.Ping;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author chineduojiteli
 */
public class UtilitySystem extends CoreSystem {

    public Ping isServiceAvailable() {
        Ping ping = null;
        Session session = BuildSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            //the below must be wrapped in a transaction
            Criteria criteria = session.createCriteria(Ping.class);
            ping = (Ping) criteria.uniqueResult();
            transaction.commit();
        } catch (HibernateException hex) {
            hex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return ping;
    }

    public Institution retrieveInstitution(String bankCode) {
        Institution institution = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = BuildSession();
            transaction = session.beginTransaction();
            //the below must be wrapped in a transaction
            Criteria criteria = session.createCriteria(Institution.class);
            if (bankCode != null && !"".equals(bankCode)) {
                criteria.add(Restrictions.eq("bankCode", bankCode));
            }

            institution = (Institution) criteria.uniqueResult();
            transaction.commit();
        } catch (HibernateException hex) {
            hex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return institution;
    }

    public Credentials retrieveCredentials(String orgCode) {
        Credentials cred = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = BuildSession();
            transaction = session.beginTransaction();
            //the below must be wrapped in a transaction
            Criteria criteria = session.createCriteria(Credentials.class);
            if (orgCode != null && !"".equals(orgCode)) {
                criteria.add(Restrictions.eq("organisationCode", orgCode));
            }

            cred = (Credentials) criteria.uniqueResult();
            transaction.commit();
        } catch (HibernateException hex) {
            hex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cred;
    }

    public List<com.ebillspay.payment.lib.entities.Transaction> retrieveTransactions(String startDate, String endDate, String sessionId, String bankCode, String srcAcctNo, String paymentRef) {
        List<com.ebillspay.payment.lib.entities.Transaction> tranList = null;
        Session session = BuildSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            //the below must be wrapped in a transaction
            Criteria criteria = session.createCriteria(com.ebillspay.payment.lib.entities.Transaction.class).addOrder(Order.desc("requestTime"));

            if (startDate != null && endDate != null) {
                criteria.add(Restrictions.between("requestTime", new SimpleDateFormat("yyyy-MM-dd").parse(startDate), new SimpleDateFormat("yyyy-MM-dd").parse(endDate)));
            }
            if (sessionId != null && !"".equals(sessionId)) {
                criteria.add(Restrictions.eq("sessionID", sessionId));
            }
            if (bankCode != null && !"".equals(bankCode)) {
                criteria.add(Restrictions.eq("srcBankCode", bankCode));
            }
            if (srcAcctNo != null && !"".equals(srcAcctNo)) {
                criteria.add(Restrictions.eq("srcAccountNumber", srcAcctNo));
            }
            if (paymentRef != null && !"".equals(paymentRef)) {
                criteria.add(Restrictions.eq("paymentRef", paymentRef));
            }

            tranList = criteria.list();
            transaction.commit();
        } catch (Exception hex) {
            hex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return tranList;
    }

}
