package practice.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import practice.controller.form.EmployeeForm;
import practice.dao.CompanyDao;
import practice.model.Company;
import practice.model.Employee;

/**
 * Created by IntelliJ IDEA.
 * User: gelu
 * Date: 1/23/12
 * Time: 10:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeValidator implements Validator {

    @Autowired
    private CompanyDao companyDao;

    public boolean supports(Class<?> clazz) {
        if (clazz.getName().equals(Employee.class.getName())) {
            return true;
        }
        return false;
    }

    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        employee.setCompany(new Company());
        ValidationUtils.rejectIfEmpty(errors, "company", "empty comp");
        Company company = companyDao.getById(employee.getCompany().getId());
        if (company == null) {
            errors.rejectValue("company", "Company name does not exist");
        }
    }
}
