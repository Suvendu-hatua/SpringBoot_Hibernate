package com.hibernate.HibernateDemo.dao;

import com.hibernate.HibernateDemo.pojos.ContractEmployee;
import com.hibernate.HibernateDemo.pojos.PermanentEmployee;

public interface EmpInheritanceDao {
    public void saveContractEmployee(ContractEmployee contractEmployee);
    public void savePermanentEmployee(PermanentEmployee permanentEmployee);
}
