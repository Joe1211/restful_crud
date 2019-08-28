package com.joe.restful_crud.controller;

import com.joe.restful_crud.dao.DepartmentDao;
import com.joe.restful_crud.dao.EmployeeDao;
import com.joe.restful_crud.entities.Department;
import com.joe.restful_crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工列表
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String addPage(Model model){
        //显示部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //添加员工
    //springMvcz自动将请求参数和入参对象一一绑定；要求名字一样
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("员工"+employee);
        //保存员工
        employeeDao.save(employee);
        //重定向到一个路径
        return "redirect:/emps";
    }

    //来到员工修改页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        //页面显示所有部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        //来到修改页面(添加和修改是一个页面)
        return "emp/edit";
    }

    @PutMapping("/emp/123")
    public String updateEmp(Employee employee){
        System.out.println("修改的员工信息"+employee);
        return "redirect:/emps";
    }


}
