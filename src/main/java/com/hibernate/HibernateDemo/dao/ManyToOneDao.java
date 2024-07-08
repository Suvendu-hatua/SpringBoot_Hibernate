package com.hibernate.HibernateDemo.dao;

import com.hibernate.HibernateDemo.pojos.Department_Pojo;
import com.hibernate.HibernateDemo.pojos.Organization_Pojo;

public interface ManyToOneDao {
    public void saveOrganization(Organization_Pojo organizationPojo);
    public void saveDepartments(Department_Pojo departmentPojo);
}
