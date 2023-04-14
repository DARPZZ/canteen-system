# canteen-system
To get all employees
List<Employee> employees = pd.GetAll();
        for (Employee employee1 : employees) {
            System.out.println(employee1.getName() + " - " + employee1.getSaldo());
        }
