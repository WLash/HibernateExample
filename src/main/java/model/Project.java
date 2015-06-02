package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Project",
        uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
public class Project {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, unique=true, length=11)
    private int id;

    @Column(name="NAME", length=20, nullable=true)
    private String name;

   /* @ManyToMany(mappedBy="projects")*/
    //private Set<Employee> employeeList= new HashSet<Employee>();


    public Project(){}

    public Project(String name){
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

    /*public Set<Employee> getEmployeeList(){
        return employeeList;
    }

    public void setEmployeeList(Set<Employee> employeeList){
        this.employeeList = employeeList;
    }*/


    public String toString(){
        return "[Project] ID: "+ getId() + ", Name: " + getName();
    }
}
