package practice.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import practice.dao.CompanyDao;
import practice.model.Company;

import java.beans.PropertyEditorSupport;

/**
 *
 * Responsible for obtaining the company object corresponding the the user selected company id.
 * Date: 1/23/12
 * Time: 11:52 PM
 *
 */
public class CompanyEditor extends PropertyEditorSupport {

    @Autowired
    private CompanyDao companyDao;


    @Override
    public void setAsText(String companyIdAsString) {
        Object value = getValue();
        Company company = companyDao.getById(Long.parseLong(companyIdAsString));
        System.out.println(company);
        setValue(company);
    }

}
