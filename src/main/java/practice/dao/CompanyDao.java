package practice.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import practice.dao.GenericDao;
import practice.model.Company;

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

    public CompanyDao() {
        setClazz(Company.class);
    }

    public void testHql() {
        Session session = getCurrentSession();
        String stringQuery = "from Employee e inner join e.company as c where e.createdOn < :customDate";
        Query query = session.createQuery(stringQuery);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,2011);
        cal.set(Calendar.MONTH, 12);
        Date customDate = cal.getTime();

        query.setDate("customDate", customDate);

        List<Company> companies = query.list();
        System.out.println(companies);
    }
}
