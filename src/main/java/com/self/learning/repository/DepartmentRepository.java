package com.self.learning.repository;

import com.self.learning.entity.Department;
import com.self.learning.repository.customer.DepartmentDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Integer>
        ,JpaSpecificationExecutor<Department>,DepartmentDao {

    @QueryHints({@QueryHint(name= org.hibernate.ejb.QueryHints.HINT_CACHEABLE,value="true")})
    @Query("select d from Department d")
    List<Department> getAllDepartments();

}
