package practice.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import practice.dao.CompanyDao;
import practice.model.Company;
import practice.model.Employee;

/**
 * Validator implementation used for employee related input data.
 * User: gelu
 * Date: 1/23/12
 * Time: 10:29 PM
 *
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

        ValidationUtils.rejectIfEmpty(errors, "company", "empty comp");

        Company company = companyDao.getById(employee.getCompany().getId());
        if (company == null) {
            errors.rejectValue("company", "Company name does not exist");
        }
    }
}
