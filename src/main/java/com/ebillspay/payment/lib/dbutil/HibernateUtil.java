/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebillspay.payment.lib.dbutil;

import com.ebillspay.payment.lib.entities.Credentials;
import com.ebillspay.payment.lib.entities.Institution;
import com.ebillspay.payment.lib.entities.Ping;
import com.ebillspay.payment.lib.entities.SystemAudit;
import com.ebillspay.payment.lib.entities.Transaction;
import com.ebillspay.payment.lib.util.Util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author chineduojiteli
 */
public class HibernateUtil {

    private static SessionFactory SESSION_FACTORY;

    private HibernateUtil() {

    }

    public static SessionFactory getSessionFactory() {
        if (SESSION_FACTORY == null) {
            synchronized (HibernateUtil.class) {
                try {
                    Util config = new Util();
                    // final AnnotationConfiguration configuration = new AnnotationConfiguration();
                    AnnotationConfiguration configuration = new AnnotationConfiguration();
                    configuration.setProperty("hibernate.connection.driver_class", config.getParameter("hibernatedbClassDriver"));
                    configuration.setProperty("hibernate.connection.url", config.getParameter("hibernatedbUrl"));
                    configuration.setProperty("hibernate.connection.username", config.getParameter("hibernatedbUsername"));
                    configuration.setProperty("hibernate.connection.password", new Util(config.getParameter("encryptionKey")).decryptData(config.getParameter("hibernatedbPassword")));
                    configuration.setProperty("hibernate.dialect", config.getParameter("hibernateDialect"));
                    configuration.setProperty("hibernate.show_sql", config.getParameter("hibernateShowSql"));
                    configuration.setProperty("hibernate.hbm2ddl.auto", config.getParameter("hibernatehbm2ddl"));
                    configuration.setProperty("hibernate.current_session_context_class", "thread");

                    //beginning of connection pooling settings
                    configuration.setProperty("hibernate.c3p0.min_size", config.getParameter("hibernate.c3p0.min_size"));
                    configuration.setProperty("hibernate.c3p0.max_size", config.getParameter("hibernate.c3p0.max_size"));
                    configuration.setProperty("hibernate.c3p0.timeout", config.getParameter("hibernate.c3p0.timeout"));
                    configuration.setProperty("hibernate.c3p0.max_statements", config.getParameter("hibernate.c3p0.max_statements"));
                    configuration.setProperty("hibernate.c3p0.idle_test_period", config.getParameter("hibernate.c3p0.idle_test_period"));
                    configuration.setProperty("hibernate.connection.provider_class", config.getParameter("hibernate.connection.provider_class"));
                    //end of connection pooling settings
                    //load POJOs
                    configuration.addAnnotatedClass(SystemAudit.class);
                    configuration.addAnnotatedClass(Ping.class);
                    configuration.addAnnotatedClass(Institution.class);
                    configuration.addAnnotatedClass(Transaction.class);
                    configuration.addAnnotatedClass(Credentials.class);
//                    configuration.addAnnotatedClass(Fee.class);
                    //                   configuration.addAnnotatedClass(Reversal.class);
                    //end of load POJOs
                    SESSION_FACTORY = configuration.buildSessionFactory();
                    System.out.println("Utility Session Factory successfully built : " + SESSION_FACTORY.toString());
                } catch (Throwable e) {
                    System.err.println("Error in creating Utility Session Factory object."
                            + e.getMessage());
                    throw new ExceptionInInitializerError(e);
                }
            }

        }
        return SESSION_FACTORY;
    }
}
