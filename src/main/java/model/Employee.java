package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Employee", 
	   uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true, length=11)
	private int id;
	
	@Column(name="NAME", length=20, nullable=true)
	private String name;
	
	@Column(name="ROLE", length=20, nullable=true)
	private String role;
	
	@Column(name="insert_time", nullable=true)
	private Date insertTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_DEPARTMENT", nullable = false)
	private Department department;

	public Employee(){}

	public Employee(String name, String role, Date insertTime, Department department){
		this.name = name;
		this.role = role;
		this.insertTime = insertTime;
		this.department = department;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public Department getDepartment() { return department;}
	public void setDepartment(Department department){ this.department = department;}


	public String toString(){
		return "[Employee] ID: "+ getId() +
				"Name: " + getName() +
				", Role: " + getRole() +
				", InsertTime: " + getInsertTime() +
				", Department: "+getDepartment();
	}
}
