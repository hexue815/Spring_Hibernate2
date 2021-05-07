package com.how2java.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.how2java.dao.CategoryDAO;
import com.how2java.pojo.Category;

public class TestSpring {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		
		CategoryDAO dao = (CategoryDAO) context.getBean("dao");
		List<Category> cs = dao.find("from Category c");
		for(Category c : cs){
			System.out.println(c.getName());
		}
		
		Category c = new Category();
		c.setName("category yyy");
		
		dao.save(c);
	
		Category c2 = dao.get(Category.class, 2);
		c2.setName("category zzz");
		dao.update(c2);
		
		
		//dao.delete(c2);
	}
}
