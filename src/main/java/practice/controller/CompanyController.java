package practice.controller;

import org.hibernate.validator.method.MethodConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import practice.dao.CompanyDao;
import practice.model.Company;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * User: anghel
 * Date: 1/23/12
 * Time: 12:13 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class CompanyController {
    
    @Autowired
    private CompanyDao companyDao;

    @RequestMapping(value = "create-company.htm", method = RequestMethod.POST)
    public String createCompany(@Valid @ModelAttribute("newCompany") Company company, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addCompany";
        }
            companyDao.create(company);

        System.out.println("Successfully added company " + company.getName());
        return "success";
    }
    
    @RequestMapping(value = "create-company.htm", method = RequestMethod.GET)
    public String addCompany(Model model) {
        System.out.println("Detected request for adding a company form...");
        Company newCompany = new Company();
        model.addAttribute("newCompany", newCompany);
        return "addCompany";
    }
}
