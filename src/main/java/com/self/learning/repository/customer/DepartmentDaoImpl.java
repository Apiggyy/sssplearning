package com.self.learning.repository.customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DepartmentDaoImpl implements DepartmentDao {
    @PersistenceContext
    private EntityManager entityManager;

}
