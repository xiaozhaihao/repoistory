package com.baizhi.action;

import com.baizhi.entity.Employee;
import com.baizhi.service.EmployeeService;
import com.baizhi.service.impl.EmployeeServiceImpl;
import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAction {
    private Employee em;
    private List<Employee> list;
    private String id;
    /**
     *
     * @return 登陆
     */
    public String login(){
        System.out.println(em);
        EmployeeService es = new EmployeeServiceImpl();
        Employee employee = es.login(em.getName());


        if(employee.getPassword().equals(em.getPassword())){
            ServletActionContext.getRequest().getSession().setAttribute("employee",employee);
            return Action.SUCCESS;
        }
        return Action.ERROR;
    }

    /**
     *
     * @return 查询所有
     */
    public String queryAll(){
        EmployeeServiceImpl es = new EmployeeServiceImpl();
        list = new ArrayList<>();
        list = es.queryAll();
        return Action.SUCCESS;
    }

    /**
     *
     * @return 删除
     */
    public String delete(){

        EmployeeServiceImpl es = new EmployeeServiceImpl();
        es.delete(id);
        return Action.SUCCESS;
    }

    /**
     *
     * @return 添加用户
     */
    public String add(){

        System.out.println(em);
        EmployeeServiceImpl es = new EmployeeServiceImpl();
        if(es.add(em)){
            return Action.SUCCESS;
        }

        return Action.ERROR;
    }

    /**
     *
     * @return 预修改
      */
    public String preUpdate(){

        EmployeeServiceImpl es = new EmployeeServiceImpl();
        em = es.queryId(id);
        ServletActionContext.getRequest().getSession().setAttribute("em",em);
        return Action.SUCCESS;
    }

    /**
     *
     * @return update
     */
    public String update(){
        EmployeeServiceImpl es = new EmployeeServiceImpl();
       if(es.update(em)){
           return Action.SUCCESS;
       }

        return Action.ERROR;
    }
    public Employee getEm() {
        return em;
    }

    public void setEm(Employee em) {
        this.em = em;
    }

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
