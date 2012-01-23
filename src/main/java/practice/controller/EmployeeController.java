package practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import practice.controller.form.EmployeeForm;
import practice.controller.validator.EmployeePropertyEditor;
import practice.controller.validator.EmployeeValidator;
import practice.dao.CompanyDao;
import practice.dao.EmployeeDao;
import practice.model.Company;
import practice.model.Employee;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anghel
 * Date: 1/23/12
 * Time: 6:24 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeDao employeeDao;
    
    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeValidator employeeValidator;

    @Autowired
    private EmployeePropertyEditor employeePropertyEditor;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
//        dataBinder.setValidator(employeeValidator);
        dataBinder.registerCustomEditor(Employee.class, employeePropertyEditor);
    }

    @RequestMapping(value = "/create-employee.htm", method = RequestMethod.GET)
    public String addEmployee(Model model) {
        List companies = companyDao.getAll();
        model.addAttribute("companies", companies);

        Employee employee = new Employee();
        model.addAttribute("employee", employee);
                
        return "addEmployee";
    }
    
    @RequestMapping(value = "/create-employee.htm", method = RequestMethod.POST)
    public String addEmployee(@Valid @ModelAttribute("newEmployee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addEmployee";
        }
        
//        employeeDao.create(employee);
        
        System.out.println("Successfully addded the new employee " + employee.getName());
        return "success";        
    }
}
