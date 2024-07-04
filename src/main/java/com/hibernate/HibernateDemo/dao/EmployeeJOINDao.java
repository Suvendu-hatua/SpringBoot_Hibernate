package com.hibernate.HibernateDemo.dao;

import com.hibernate.HibernateDemo.pojos.ContractEmp_JOIN;
import com.hibernate.HibernateDemo.pojos.PermanentEmp_JOIN;

public interface EmployeeJOINDao {

    public void savePermanentEmp(PermanentEmp_JOIN emp1);
    public void saveContractEmp(ContractEmp_JOIN emp2);
}
