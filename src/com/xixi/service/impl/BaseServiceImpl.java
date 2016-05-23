package com.xixi.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xixi.service.BaseService;
@SuppressWarnings("unchecked")
public class BaseServiceImpl<T> implements BaseService<T>{
	
	protected Class claz;
	protected   SessionFactory sessionFactory;
	
	//得到父类的泛型信息
	public BaseServiceImpl() {
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		claz=(Class)type.getActualTypeArguments()[0];
	}
	protected  Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		getSession().save(t);
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		getSession().update(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String hql="DELETE "+claz.getSimpleName()+" where id=:id";
		getSession().createQuery(hql).setInteger("id", id).executeUpdate();
		
	}


	@Override
	public T get(int id) {
		// TODO Auto-generated method stub
		return (T)getSession().get(claz, id);
	}

	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		String hql="FROM "+claz.getSimpleName();
		return getSession().createQuery(hql).list();
	}

}
