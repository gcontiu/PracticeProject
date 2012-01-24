package practice.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import practice.dao.CompanyDao;
import practice.model.Company;

import java.beans.PropertyEditorSupport;

/**
 * Created by IntelliJ IDEA.
 * User: gelu
 * Date: 1/23/12
 * Time: 11:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeEditor extends PropertyEditorSupport {

    @Autowired
    private CompanyDao companyDao;

    private String format;

    public void setFormat(String format) {
        this.format = format;
    }


    @Override
    public void setAsText(String s) {
        Object value = getValue();
        Company company = companyDao.getById(Long.parseLong(s));
        System.out.println(company);
        setValue(company);
    }

    @Override
    public String getAsText() {
        return "ssssttrrrr";
    }
}
