package practice.dao;

import practice.dao.GenericDao;
import practice.model.Employee;

/**
 * Created by IntelliJ IDEA.
 * User: gelu
 * Date: 1/21/12
 * Time: 4:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeDao extends GenericDao<practice.model.Employee> {

    public EmployeeDao() {
        setClazz(Employee.class);
    }
}
