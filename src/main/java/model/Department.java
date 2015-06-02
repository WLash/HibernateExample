package model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Department",
        uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
public class Department {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, unique=true, length=11)
    private int id;

    @Column(name="NAME", length=20, nullable=true)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department")
    private Set<Employee> employeeList;


    public Department(){}

    public Department(String name){
        this.name = name;
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

    public Set<Employee> getEmployeeList(){
        return employeeList;
    }

    public void setEmployeeList(Set<Employee> employeeList){
        this.employeeList = employeeList;
    }


    public String toString(){
        return "[Department] ID: "+ getId() + ", Name: " + getName();
    }
}
