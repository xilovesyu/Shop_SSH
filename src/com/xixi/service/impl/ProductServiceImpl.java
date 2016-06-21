package com.xixi.service.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.xixi.model.Product;
import com.xixi.service.ProductService;
import com.xixi.util.HibernateSessionFactory;
@SuppressWarnings("unchecked")
@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

	public ProductServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Product> queryJoinCategory(String name, int page, int size) {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Product p LEFT JOIN FETCH p.category  where p.name LIKE :name order by p.id")
				.setString("name","%"+name+"%")
				.setFirstResult((page-1)*size)
				.setMaxResults(size)
				.list();
	}

	@Override
	public Long getCount(String name) {
		// TODO Auto-generated method stub
		String hql="select count(p) from Product p where p.name like :name";
		return (Long)getSession().createQuery(hql).setString("name", "%"+name+"%").uniqueResult();
	}

	@Override
	public List<Product> queryByCid(int cid) {
		// TODO Auto-generated method stub
		String hql="from Product p join fetch p.category where p.commend=true and  p.available=true  and p.category.id= :cid order by p.date desc";
		return getSession().createQuery(hql).setInteger("cid", cid)
		.setFirstResult(0)
		.setMaxResults(4)
		.list();
	}
}
