package Database;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProjectEmployee
{
    void addProject(Employee p) throws SQLException;
    void deleteProject(Employee p);
    void updateProject(Employee p);
    ArrayList<Employee> getAll () throws SQLException;
    Employee get (Employee p);
}

