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
import practice.controller.validator.CompanyEditor;
import practice.controller.validator.EmployeeValidator;
import practice.dao.CompanyDao;
import practice.dao.EmployeeDao;
import practice.model.Company;
import practice.model.Employee;

import javax.validation.Valid;
import java.util.List;

/**
 *
 * User: anghel
 * Date: 1/23/12
 * Time: 6:24 PM
 *
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
    private CompanyEditor companyEditor;


    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(employeeValidator);
        dataBinder.registerCustomEditor(Company.class, companyEditor);
    }

    /**
     * Adds a new Employee instance to the model s.t. it will be used by the form.
     * @param model the M from MVC
     * @return view name, corresponding to a jsp file.
     */
    @RequestMapping(value = "/create-employee.htm", method = RequestMethod.GET)
    public String addEmployee(Model model) {
        List companies = companyDao.getAll();
        model.addAttribute("companies", companies);

        Employee employee = new Employee();
        model.addAttribute("employee", employee);
                
        return "addEmployee";
    }
    
    @RequestMapping(value = "/create-employee.htm", method = RequestMethod.POST)
    public String addEmployee(@Valid @ModelAttribute("employee") Employee employee,
                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "addEmployee";
        }
        
        employeeDao.create(employee);
        
        System.out.println("Successfully added the new employee " + employee.getName());
        return "success";        
    }
}
