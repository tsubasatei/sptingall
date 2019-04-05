package com.xt.mvc.crud;

import com.xt.mvc.crud.dao.DepartmentDao;
import com.xt.mvc.crud.dao.EmployeeDao;
import com.xt.mvc.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * employees 的增删改查
 */
@Controller
public class EmployeeHandler {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @ModelAttribute
    public void getEmployee(@RequestParam(value="id", required = false)Integer id, Map<String, Object> map) {
        if(id != null) {
            Employee employee = employeeDao.get(id);
            map.put("employee", employee);
        }
    }

    @PutMapping("/emp")
    public String update(@ModelAttribute("emp") Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String input(@PathVariable("id") Integer id, Map<String, Object> map) {
        Employee employee = employeeDao.get(id);
        map.put("employee", employee);
        map.put("depts", departmentDao.getDepartments());
        return "input";
    }

    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    @PostMapping("/emp")
    public String save(@Valid Employee employee, BindingResult result, Map<String, Object> map) {
        if (result.hasErrors()) {
            for (FieldError error: result.getFieldErrors()) {
                System.out.println(error.getField() + " : " + error.getDefaultMessage());
            }
            //若验证出错, 则转向定制的页面
            map.put("depts", departmentDao.getDepartments());
            return "input";
        }
        employeeDao.save(employee);
        System.out.println(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp")
    public String input(Map<String, Object> map) {
        map.put("depts", departmentDao.getDepartments());
        map.put("employee", new Employee());
        return "input";
    }

    @RequestMapping("/emps")
    public String list(Map<String, Object> map) {
        map.put("emps", employeeDao.getAll());
        return "list";
    }

    /*@InitBinder
    public void initBinder(WebDataBinder binder) {
        // lastName 不设值
        binder.setDisallowedFields("lastName");
    }*/
}
