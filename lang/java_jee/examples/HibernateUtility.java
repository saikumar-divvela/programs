package com.theatre.utils;

import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtility {

		private static final SessionFactory sessionFactory;

		static {
				try {
					// Create the SessionFactory
					sessionFactory = new Configuration().configure().buildSessionFactory();
				} catch (Expection ex) {
					System.out.println("Initial SessionFactory creation failed.", ex);
					throw new ExceptionInInitializerError(ex);
			}
		}

		public static final ThreadLocal session = new ThreadLocal();

		public static Session currentSession() throws HibernateException {
				Session s = (Session) session.get();
				// Open a new Session, if this Thread has none yet
				if (s == null) {
					s = sessionFactory.openSession();
					session.set(s);
				}
				return s;
		}

		public static void closeSession() throws HibernateException {
						Session s = (Session) session.get();
						session.set(null);
						if (s != null)
						s.close();
		}



}
