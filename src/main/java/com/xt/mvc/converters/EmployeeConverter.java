package com.xt.mvc.converters;

import com.xt.mvc.crud.entity.Department;
import com.xt.mvc.crud.entity.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 自定义转换器
 */
@Component
public class EmployeeConverter implements Converter<String, Employee> {
    @Override
    public Employee convert(String s) {
        if (!StringUtils.isEmpty(s)) {
            String[] arrs = s.split("-");
            if (arrs!=null && arrs.length == 4) {
                String lastName = arrs[0];
                String email = arrs[1];
                Integer gender = Integer.parseInt(arrs[2]);
                Integer deptId = Integer.parseInt(arrs[3]);

                Department department = new Department();
                department.setId(deptId);
                Employee employee = new Employee(null, lastName, email, gender, department);
                System.out.println(s + "--convert--" + employee);
                return employee;
            }
        }
        return null;
    }
}
