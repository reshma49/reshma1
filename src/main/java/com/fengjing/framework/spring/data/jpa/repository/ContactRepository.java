package com.fengjing.framework.spring.data.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.fengjing.framework.springmvc.model.Contact;

/**
 * Spring Data Jpa Repository
 * @author fengjing
 *
 */
public interface ContactRepository extends PagingAndSortingRepository<Contact, Integer>{
	
	/**
	 * �÷���ʵ�����ǲ�ѯcom.fengjing.framework.model.Contact �е�@NamedQuery(name="findById",query="select a from Contact a where a.id= ?1")
	 * @see com.fengjing.framework.model.Contact<br/>@NamedQuery(name="Contact.findById",query="select a from Contact a where a.id= ?1")
	 * @param id
	 * @return
	 */
	Contact findById(int id);
	
	/**
	 * ��ѯ����С��150�� �Ұ�Id��������
	 * @param age
	 * @param pageable
	 * @return
	 */
	Page<Contact> findByAgeLessThanEqualOrderByIdDesc(int age,Pageable pageable);
	
}
