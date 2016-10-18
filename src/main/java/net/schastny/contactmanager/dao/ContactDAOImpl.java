package net.schastny.contactmanager.dao;

import java.util.List;

import net.schastny.contactmanager.domain.Contact;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.gcj.GCJSerializationInstantiator;
import org.springframework.stereotype.Repository;



@Repository
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addContact(Contact contact) {
		sessionFactory.getCurrentSession().save(contact);
	}

	@SuppressWarnings("unchecked")
	public List<Contact> listContact() {

		return sessionFactory.getCurrentSession().createQuery("from Contact")
			.list();
	}

	public void removeContact(Integer id) {
		Contact contact = (Contact) sessionFactory.getCurrentSession().load(
				Contact.class, id);
		if (null != contact) {
			sessionFactory.getCurrentSession().delete(contact);
		}

	}

	public List<Contact> findContact(String name) {


		//Query query = sessionFactory.getCurrentSession().createQuery("from Contact where firstName = :paramname");
		//String myname = name;
		//Query query = sessionFactory.getCurrentSession().createSQLQuery("select * from CONTACTS where email='1'");
		//Query query = sessionFactory.getCurrentSession().createQuery("from Contact where email=:paramname").setParameter("paramname",name);

		//query.setParameter("paramname", name);
		//List<Contact> list = query.list();
		//return list;
		return sessionFactory.getCurrentSession().createQuery("from Contact where firstname = :paramname").setParameter("paramname", name)
				.list();
		//query.setParameter("paramName", "Nick");
	}

}
