package com.baizhi.dao;

import com.baizhi.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface EmployeeDAO {

    Employee login(@Param("name")String name);

    ArrayList<Employee> queryAll();

    void delete(@Param("id")String id);

    void add(Employee em);

    Employee queryId(@Param("id")String id);

    Employee queryName(Employee em);

    void update(Employee em);
}
