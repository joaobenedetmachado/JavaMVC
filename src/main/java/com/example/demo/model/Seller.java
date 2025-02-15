package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "O nome do vendedor não pode ser vazio")
    @Size(min = 2, max = 100, message = "O nome do vendedor deve ter entre 2 e 100 caracteres")
    private String name;

    @NotEmpty(message = "O email nao deve ser vazio")
    @Size(min = 8, max = 100, message = "O email deve ter entre 8 e 100 caracteres")

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private double baseSalary;

    public Seller() {}

    @ManyToOne
    @JoinColumn(name = "departmentId")  // Chave estrangeira para o Department
    private Department department;

    public Seller(Integer id, String name, Date birthDate, double baseSalary, Department department) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}