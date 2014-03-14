package com.brp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brp.bean.UserBean;

@Repository
public class UserDAOImpl implements UserDAO  {
	
	@Autowired  
	public SessionFactory sessionFactory; 
	
	@Override
	public UserBean signInUser(UserBean userBeanObj) {
		Session session = sessionFactory.getCurrentSession();
		
		Criteria cr = session.createCriteria(UserBean.class);
		cr.add(Restrictions.eq("email", userBeanObj.getEmail().toString()));
		cr.add(Restrictions.eq("password", userBeanObj.getPassword().toString()));
		 
		List<UserBean> rowCount = cr.list();

	     if(rowCount!=null && rowCount.size()>0){
			 return rowCount.get(0);
		 }
		 else{
			 return null;
		 }
	}
}
