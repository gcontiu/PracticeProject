package practice.dao;

import practice.dao.GenericDao;
import practice.model.Company;

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
}
