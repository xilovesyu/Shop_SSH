package com.xixi.service.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.xixi.model.Category;
import com.xixi.service.CategoryService;
import com.xixi.util.HibernateSessionFactory;
@SuppressWarnings("unchecked")
@Service("CategoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

	public CategoryServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	//查询类别信息，级联查询

	public List<Category> queryJoinAccount(String type,int page,int size){
		return getSession().createQuery("from Category c LEFT JOIN FETCH c.account  where c.type LIKE :type order by c.id")
		.setString("type","%"+type+"%")
		.setFirstResult((page-1)*size)
		.setMaxResults(size)
		.list();
	}
//	private SessionFactory sessionFactory;
//	
//	protected  Session getSession() {
//		return sessionFactory.getCurrentSession();
//	}
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
//	//整合的方式
//	@Override
//	public void save(Category category) {
//		// TODO 通过工具类获得session、
////		Session session=HibernateSessionFactory.getSession();
////		try{
////			session.getTransaction().begin();
////			//业务逻辑
////			session.save(category);
////			//手动提交
////			session.getTransaction().commit();
////		}
////		catch(Exception e){
////			session.getTransaction().rollback();
////			e.printStackTrace();
////		}
////		finally{
////			HibernateSessionFactory.closeSession();
////		}
//		getSession().save(category);
//	}
//	@Override
//	public void update(Category category) {
//		// TODO Auto-generated method stub
//		getSession().update(category);
//	}
//	@Override
//	public void delete(int id) {
//		// TODO Auto-generated method stub
////		Object obj=getSession().get(Category.class, id);
////		if(obj!=null){
////			getSession().delete(obj);
////		}
//		String hql="DELETE Category where id=:id";
//		getSession().createQuery(hql).setInteger("id", id).executeUpdate();
//		
//	}
//	@Override
//	public Category get(int id) {
//		// TODO Auto-generated method stub
//		return (Category)getSession().get(Category.class, id);
//	}
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Category> getAll() {
//		// TODO Auto-generated method stub
//		String hql="FROM Category";
//		return getSession().createQuery(hql).list();
//	}

	@Override
	public Long getCount(String type) {
		// TODO Auto-generated method stub
		String hql="select count(c) from Category c where c.type like :type";
		return (Long)getSession().createQuery(hql).setString("type", "%"+type+"%").uniqueResult();
	}

	@Override
	public void deleteByIds(String ids) {
		// TODO Auto-generated method stub
		String hql="delete from Category where id in ("+ ids +")";
		getSession().createQuery(hql).executeUpdate();
	}
}
