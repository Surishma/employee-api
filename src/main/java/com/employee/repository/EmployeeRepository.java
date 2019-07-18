package com.employee.repository;

import com.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Employee> getEmployeeByFirstName(String firstName){
        Query query = new Query(Criteria.where("firstName").is(firstName));
        return mongoTemplate.find(query,Employee.class,"Employee");

    }

    public List<Employee> getEmployeeByName(String firstName, String lastName){

        Criteria criteria = null;

        if(firstName==null && lastName==null)
        {
            criteria =new Criteria();
        }

        if(firstName!=null) {
            criteria = Criteria.where("firstName").is(firstName);
        }

        if(lastName!=null ){
            if(criteria == null) {
            criteria = Criteria.where("lastName").is(lastName);
            }
            else {
             criteria.and("lastName").is(lastName);
            }
        }

        Query query = new Query(criteria);
        return mongoTemplate.find(query,Employee.class,"Employee");

    }


    /*public List<Employee> getEmployeeByLastName(String lastName){
        Query query = new Query(Criteria.where("firstName").is("Ajith"));
        return mongoTemplate.find(query,Employee.class,"Employee");

    }*/


    public void createEmployee(Employee employee){
        mongoTemplate.insert(employee);
    }

}
