package org.springcore.Dao;

import org.springcore.Models.Employee;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class EmployeeDao {
    public EmployeeDao() {
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public EmployeeDao(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    private HibernateTemplate hibernateTemplate;
    @Transactional
    public Integer insertData(Employee employee){
        Integer i= (Integer)this.hibernateTemplate.save(employee);
        return i;
    }
    public  Employee getData(int id){
        Employee employee=hibernateTemplate.get(Employee.class,id);
        return employee;
    }
    public List<Employee> getAllEmployee(){
        List<Employee> list=hibernateTemplate.loadAll(Employee.class);
        return list;
    }

    public void updateData(Employee employee){
        this.hibernateTemplate.update(employee);
    }
    public void deleteData(int id){
        Employee employee1=this.hibernateTemplate.get(Employee.class,id);
        this.hibernateTemplate.delete(employee1);
    }
}
