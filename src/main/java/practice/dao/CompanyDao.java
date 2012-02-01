package practice.dao;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.internal.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import practice.dao.GenericDao;
import practice.model.Company;
import practice.model.Employee;

import javax.persistence.criteria.JoinType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gelu
 * Date: 1/21/12
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class CompanyDao extends GenericDao<Company> {

    @Autowired
    private EmployeeDao employeeDao;

    public CompanyDao() {
        setClazz(Company.class);
    }

    public void testHql() {
        Session session = getCurrentSession();

//        // Test join on employees and companies
//        String stringQuery = "from Employee e inner join e.company as c where e.createdOn < :customDate";
//        Query query = session.createQuery(stringQuery);
//
//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.YEAR,2011);
//        cal.set(Calendar.MONTH, 12);
//        Date customDate = cal.getTime();
//
//        query.setDate("customDate", customDate);
//
//        List<Company> companies = query.list();
//
//        // ---------------------------------------------------------
//
//        List<Employee> employees = employeeDao.getAll();
//        List<Long> ids = new ArrayList<Long>();
//        for (Employee emp : employees) {
//            ids.add(emp.getId());
//        }
//        // GOOD PRACTICE: always use parameter replacements !!! Query.setParameter*() methods know how to alter the query.
//        // this is ok String queryString2 = "from Employee e where e.id in (:myList)";
//        String queryString2 = "from Employee e where e in (:myList)";
//        Query q2 = session.createQuery(queryString2);
//        q2.setParameterList("myList", employees);
//
//        List<Employee> results = q2.list();
//
//        System.out.println(companies);
//
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, 1);
        Date date = new Date(cal.getTimeInMillis());
        System.out.println("date = " + date);
        Criteria leftCriteria = session.createCriteria(Employee.class);
        leftCriteria.createAlias("company", "result", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN)
                .add(Restrictions.lt("result.created", date));

        List<Employee> resultEmployees = leftCriteria.list();
        for (Employee emp : resultEmployees) {
            System.out.println(emp.getName() + " - " + emp.getCompany().getName());
        }


        Object result = leftCriteria.list();
        System.out.println(result);

    }

    public void testJoinWithNoFK() {
        Session session = getCurrentSession();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.YEAR, 2011);
        Date date = new Date(cal.getTimeInMillis());
        System.out.println("date = " + date);

        DetachedCriteria employeeCriteria = DetachedCriteria.forClass(Employee.class);
        employeeCriteria.setProjection(Property.forName("company"));
        employeeCriteria.add(Restrictions.lt("createdOn", date));

        Criteria criteria = session.createCriteria(Company.class);
        criteria.add(Property.forName("id").in(employeeCriteria));

        List<Company> companies = criteria.list();

        System.out.println(companies);
    }
}
