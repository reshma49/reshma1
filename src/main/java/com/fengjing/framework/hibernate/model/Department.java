package com.fengjing.framework.hibernate.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * ����ʵ����
 * @author scott
 *
 */
@Entity
@Table(name="t_department",catalog="hibernate4")
public class Department {
	/**
	 * ���ű��
	 */
	private int id;
	/**
	 * ��������
	 */
	private String deptname;
	/**
	 * �ò������еĹ�Ա
	 */
	private Set<Employee> sets;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	
	@OneToMany(mappedBy="department")
	@Cascade(value={CascadeType.ALL})
	public Set<Employee> getSets() {
		return sets;
	}

	public void setSets(Set<Employee> sets) {
		this.sets = sets;
	}

}
