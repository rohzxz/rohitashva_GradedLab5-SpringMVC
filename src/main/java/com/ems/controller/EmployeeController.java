package com.ems.controller;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;


@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("messages", "");
        return "index";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(Model model, @RequestParam String first_name, @RequestParam String last_name,
                              @RequestParam String email) {

        Employee employee = new Employee(first_name, last_name, email);
        employeeService.addEmployee(employee);
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("messages", "");
        return "index";
    }

    @PostMapping("/searchEmployee")
    public String searchEmployee(Model model, @RequestParam long id) {

        List<Employee> emp = employeeService.searchEmployee(id).stream().collect(Collectors.toList());
        model.addAttribute("employees", emp);
        model.addAttribute("messages", "");
        return "index";
    }

    @GetMapping("/employeeUpdate/{id}")
    public String editEmployee(Model model, @PathVariable long id) {
        Optional<Employee> emp = employeeService.searchEmployee(id);

        Employee empr = emp.get();
        model.addAttribute("employee", empr);
        return "editEmployee";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(Model model, @RequestParam String first_name,
                                 @RequestParam String last_name,
                                 @RequestParam String email,
                                 @RequestParam long id) {
        Optional<Employee> emp = employeeService.searchEmployee(id);

        Employee empr = emp.get();
        System.out.println(emp);
        System.out.println(empr);
        System.out.println(email);

        if (empr.getId() == id) {
            Employee employee = new Employee(empr.getId(), first_name, last_name, email);
            employeeService.updateEmployee(employee);
            System.out.println(employee.getEmail());
        } else {

        }

        return "redirect:/";
    }

    @GetMapping("/employeeDelete/{id}")
    public String deleteEmployee(Model model, @PathVariable(value = "id") long id) {

        employeeService.deleteEmployeeById(id);

        return "redirect:/";
    }
}

