package com.baizhi.service.impl;

import com.baizhi.dao.EmployeeDAO;
import com.baizhi.entity.Employee;
import com.baizhi.service.EmployeeService;
import com.baizhi.util.MyBatisUtil;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee login(String name) {
        EmployeeDAO ed = (EmployeeDAO)MyBatisUtil.getMapper(EmployeeDAO.class);
        Employee em = ed.login(name);
        return em;
    }

    @Override
    public List<Employee> queryAll() {
        ArrayList<Employee> list = new ArrayList<>();
        EmployeeDAO ed = (EmployeeDAO) MyBatisUtil.getMapper(EmployeeDAO.class);
        list = ed.queryAll();

        return list;
    }

    @Override
    public void delete(String id) {
        EmployeeDAO ed = (EmployeeDAO) MyBatisUtil.getMapper(EmployeeDAO.class);
        try {
            ed.delete(id);
            MyBatisUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MyBatisUtil.rollback();
        }
        MyBatisUtil.closeSqlSession();

    }

    @Override
    public boolean add(Employee em) {
        ArrayList<Employee> list = new ArrayList<>();
        EmployeeDAO ed = (EmployeeDAO) MyBatisUtil.getMapper(EmployeeDAO.class);
        list = ed.queryAll();
        for (Employee a: list) {
            if(a.getName().equals(em.getName())){
                System.out.println("有重名的");
                return false;
            }
        }
        try {
            ed.add(em);
            MyBatisUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MyBatisUtil.rollback();
        }
        MyBatisUtil.closeSqlSession();
        return true;
    }

    @Override
    public Employee queryId(String id) {
        EmployeeDAO ed = (EmployeeDAO) MyBatisUtil.getMapper(EmployeeDAO.class);
        Employee em = ed.queryId(id);
        return em;
    }

    @Override
    public boolean update(Employee em) {

        EmployeeDAO ed = (EmployeeDAO) MyBatisUtil.getMapper(EmployeeDAO.class);
        System.out.println(em);
        Employee ee = ed.queryName(em);

        if(ee!=null){
            return false;
        }
        try {
            ed.update(em);
            MyBatisUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MyBatisUtil.rollback();
        }
        MyBatisUtil.closeSqlSession();
        return true;
    }
}
