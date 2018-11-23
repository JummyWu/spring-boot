package com.atguigu.springboot.controller;

import com.atguigu.springboot.dao.DepartmentDao;
import com.atguigu.springboot.dao.EmployeeDao;
import com.atguigu.springboot.entities.Department;
import com.atguigu.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employeeList = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps", employeeList);
        return "emp/list";
    }

    //跳转添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //去到添加页面
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //添加员工
    //springmvc自动将请求参数和入参的名字对象的属性名一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面

        //保存员工
        employeeDao.save(employee);
        //forward:表示转发到一个地址
        return "redirect:/emps";
    }

    //修改页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //页面显示部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        //回到修改页面(add是修改跟添加一起的页面)
        return "emp/add";
    }

    //员工修改,需要提交id
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){

        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
