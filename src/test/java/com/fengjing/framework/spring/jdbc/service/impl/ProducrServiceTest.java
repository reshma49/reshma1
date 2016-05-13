package com.fengjing.framework.spring.jdbc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fengjing.framework.spring.jdbc.model.Product;
import com.fengjing.framework.spring.jdbc.service.ProductService;



@ContextConfiguration(locations={"classpath:spring-jdbc.xml"})
@RunWith(value=SpringJUnit4ClassRunner.class)
public class ProducrServiceTest {
	
	@Resource(name="jdbcProductServiceImpl")
	ProductService productService;
	
	@Test
	public void save(){
		Product product=new Product();
		product.setName("SONY 3d��ʵ�");
		product.setPrice(79.0f);
		product.setDescription("SONY");
		product.setCategoryid("3");
		productService.save(product);
	}
	
	
	@Test
	public void getProduct(){
		Product product=productService.findById(3);
		System.out.println(product.getName()+"\t"+product.getDescription());
	}
	
	@Test
	public void getProductListByCategory(){
		List<Product> lists=productService.getProductListByCategory("�ֻ�");
		for (Product product : lists) {
			System.out.println(product.getName()+"\t"+product.getDescription()+"\t"+product.getCategoryid());
		}
	}
	
	
	@Test
	public void listAll(){
		List<Product> lists=productService.listAll();
		for (Product product : lists) {
			System.out.println(product.getName()+"\t"+product.getDescription()+"\t"+product.getCategoryid());
		}
	}
}
