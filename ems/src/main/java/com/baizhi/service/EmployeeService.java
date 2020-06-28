package com.baizhi.service;

import com.baizhi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee login(String name);

    List<Employee> queryAll();

    void delete(String id);

    boolean add(Employee em);

    Employee queryId(String id);

    boolean update(Employee em);
}
