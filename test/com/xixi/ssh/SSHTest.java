package com.xixi.ssh;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xixi.model.Category;
import com.xixi.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class SSHTest {
	
	@Resource
	private CategoryService categoryService;
//	@Test //test hibernate
//	public void hibernate(){
//		CategoryServiceImpl serviceImpl=new CategoryServiceImpl();
//		serviceImpl.save(new Category("男士休闲22",true));
//	}
	
	@Test //test spring + hibernate
	public void testSH(){
		categoryService.update(new Category(5,"男士休闲4",false));
	}
}
