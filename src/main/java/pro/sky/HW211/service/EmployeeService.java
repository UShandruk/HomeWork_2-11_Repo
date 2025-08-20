package pro.sky.HW211.service;
import org.springframework.stereotype.Service;
import pro.sky.HW211.model.Employee;
import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeService {
    // Записи о сотрудниках
    private List<Employee> listEmployees;

    // Максимальное возможное количество сотрудников в фирме.
    private final int maxCountOfEmployee = 20;

    // Конвертировать List<Employee> в List<String>
    private List<String> convertListEmployeesToListString(List<Employee> listInput)
    {
        List<String>listOutput = new ArrayList<>();
        for (Employee employee : listInput)
        {
            String e = employee.toStringAll();
            listOutput.add(e);
        }

        return listOutput;
    }

    // Конструктор
    public EmployeeService() {
        this.listEmployees = new ArrayList<Employee>(); // null;
        fill();
    }

    // Заполнить список сотрудников
    private void fill()
    {
        listEmployees.add(new Employee(4, "Иван", "Иванов"));
        listEmployees.add(new Employee(3, "Иван", "Иванов"));
        listEmployees.add(new Employee(2, "Екатерина", "Павлова"));
        listEmployees.add(new Employee(1, "Марина", " Антонова"));
        listEmployees.add(new Employee(5, "Семён", "Сергеев"));
       /* arrayEmployees[5] = new Employee("Иванов Александр Иванович", 1, 40000);
        arrayEmployees[6] = new Employee("Петров Семён Александрович", 3, 50000);
        arrayEmployees[7] = new Employee("Семёнова Елена Ивановна", 2, 60000);
        arrayEmployees[8] = new Employee("Антонова Марина Сергеевна", 4, 80000);
        arrayEmployees[9] = new Employee("Сергеев Семён Алексеевич", 1, 50000);*/
    }

    // Получить список всех сотрудников
    private List<Employee> getListOfEmployeesAll()
    {
        List<Employee> listOfEmployeesAll = listEmployees.stream().filter(e -> e != null).toList();
        return listOfEmployeesAll;
    }

    // Получить список всех сотрудников (список строк, для браузера)
    private List<String> getListStringOfEmployeesAll()
    {
        List<Employee> listInput = getListOfEmployeesAll();
        List<String> listOutput = convertListEmployeesToListString(listInput);
        return listOutput;
    }

    // Добавить нового сотрудника
    public String addEmployee(Employee employeeToAdd)
    {
        boolean isEmployeeToAddExist = listEmployees.contains(employeeToAdd);
        if(isEmployeeToAddExist)
        {
            return ("Сотрудник был добавлен ранее.");
        }
        listEmployees.add(employeeToAdd);
        boolean isAddedSuccessful = listEmployees.contains(employeeToAdd);
        if(isAddedSuccessful)
            return ("Сотрудник " + employeeToAdd.getId() + " был успешно добавлен.");
        return "Сотрудник не добавлен.";
    }

    // Удалить сотрудника
    public String deleteEmployee(int employeeToDelId)
    {
        Employee employeeToDel = findEmployeeById(employeeToDelId);
        boolean isEmployeeToDelExist = listEmployees.contains(employeeToDel);
        if(!isEmployeeToDelExist)
        {
            return ("Сотрудник был удалён ранее.");
        }
        listEmployees.remove(employeeToDel);
        boolean isExist = listEmployees.contains(employeeToDel);
        if(!isExist)
            return ("Сотрудник был удалён ранее.");
        return ("Сотрудник успешно удалён.");
    }

    // Найти сотрудника по его id
    public Employee findEmployeeById(int employeeId)
    {
        //Arrays.stream(arrayEmployees).filter(emp -> emp.getId() == employeeId);
        for (Employee e : listEmployees) {
            if (e.getId() == employeeId)
            {
                return e;
            }
        }
        return null;
    }

}