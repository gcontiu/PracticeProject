package practice.model;

import junit.framework.Assert;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import practice.dao.CompanyDao;
import practice.dao.EmployeeDao;

import javax.validation.constraints.AssertTrue;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gelu
 * Date: 2/1/12
 * Time: 12:22 AM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/test-context.xml"})
public class CompanyDaoTest {

    private static final Logger LOG = LoggerFactory.getLogger(CompanyDaoTest.class);

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;


//    @BeforeTransaction
//    public void setUp() {
//        employeeDao.deleteAll();
//    }


    @Transactional
    @Rollback(value = true)
    @Test
    public void testCompanyInsertionWithEmployees() {

        for (int i = 1; i < 10; i++) {
            Company c = new Company();
            c.setCreated(new Date());
            c.setName("Company_" + i);
            c.setIndustry(Industry.IT);

            companyDao.create(c);

            Employee e = new Employee();
            e.setCompany(c);
            e.setName("Employee_" + i);

            employeeDao.create(e);

        }
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testCompanyIndustry() {
        for (int i = 0; i < 2; i++) {
            Company c = new Company();
            c.setCreated(new Date());
            c.setIndustry(Industry.IT);
            c.setName("Company_testCompany_" + i);
            companyDao.create(c);
        }

        List<Company> companies = companyDao.getAll();
        Assert.assertNotNull(companies);
        Assert.assertTrue(companies.size() > 0);
        for (Company company : companies ) {
            Assert.assertNotNull(company.getIndustry());
        }
    }

}
