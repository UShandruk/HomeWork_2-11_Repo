package pro.sky.HW211.service;
import org.springframework.stereotype.Service;
import pro.sky.HW211.Exceplions.EmployeeAlreadyAddedException;
import pro.sky.HW211.Exceplions.EmployeeNotFoundException;
import pro.sky.HW211.model.Employee;
import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeService {
    // Записи о сотрудниках
    private List<Employee> listEmployees;

    // Максимальное возможное количество сотрудников в фирме.
    private final int maxCountOfEmployee = 10;

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

    // Найти сотрудника
    public Employee findEmployee(Employee employeeToFind)
    {
        //boolean isContains = listEmployees.contains(employeeToFind); // не работает
        List<Employee> listFoundedEmployees = listEmployees.stream().filter(e -> e.equals(employeeToFind)).toList();

        //List<Employee> listFoundedEmployees = listEmployees.stream().filter(e -> e.getFirstName() == employeeToFind.getFirstName()).filter(e -> e.getLastName() == employeeToFind.getLastName()).toList();
        //List<Employee> tt1 = listEmployees.stream().filter(e -> e.getFirstName() == employeeToFind.getFirstName()).toList();
        //List<Employee> tt2 = tt1.stream().filter(e -> e.getLastName() == employeeToFind.getLastName()).toList();

            if (listFoundedEmployees.size() > 0)
            {
                return listFoundedEmployees.get(0);
            }

        return null;
    }

    // Конструктор
    public EmployeeService() {
        this.listEmployees = new ArrayList<Employee>(); // null;
        fill();
    }

    // Заполнить список сотрудников
    private void fill()
    {
        listEmployees.add(new Employee("Иван", "Иванов"));
        listEmployees.add(new Employee("Иван", "Иванов"));
        listEmployees.add(new Employee("Екатерина", "Павлова"));
        listEmployees.add(new Employee("Марина", " Антонова"));
        listEmployees.add(new Employee("Семён", "Сергеев"));
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

    // Найти сотрудника по его id
    private Employee privateFindEmployeeById(int employeeId) throws Exception
    {
        //Arrays.stream(arrayEmployees).filter(emp -> emp.getId() == employeeId);
        for (Employee e : listEmployees) {
            if (e.getId() == employeeId)
            {
                return e;
            }
            else
            {
                throw new EmployeeNotFoundException("");
            }
        }
        return null;
    }

    // Добавить нового сотрудника
    public String addEmployee(String firstName, String lastName) throws Exception
    {
        Employee employeeToAdd = new Employee(firstName, lastName);
        //boolean isEmployeeToAddExist = listEmployees.contains(employeeToAdd); // не работает
        Employee foundedEmployee = findEmployee(employeeToAdd);
        if(foundedEmployee != null)
        {
            throw new EmployeeAlreadyAddedException("");
        }
        if(listEmployees.size() >= maxCountOfEmployee)
        {
            throw new IndexOutOfBoundsException("Коллекция переполнена.");
        }
        listEmployees.add(employeeToAdd);
        boolean isAddedSuccessful = listEmployees.contains(employeeToAdd);
        if(isAddedSuccessful)
            return employeeToAdd.toJSON(); //("Сотрудник успешно добавлен.");
        return "Сотрудник не добавлен.";
    }

    // Удалить сотрудника
    public String removeEmployee(String firstName, String lastName) throws Exception
    {
        Employee employeeToDel = new Employee(firstName, lastName);
        //boolean isEmployeeToDelExist = listEmployees.contains(employeeToDel);
        Employee foundedEmployee = findEmployee(employeeToDel);
        if(foundedEmployee != null)
        {
           throw new EmployeeNotFoundException("");
        }
        listEmployees.remove(employeeToDel);
        boolean isExist = listEmployees.contains(employeeToDel);
        if(!isExist)
            throw new EmployeeNotFoundException("");
        return employeeToDel.toJSON(); //("Сотрудник успешно удалён.");
    }

    // Найти сотрудника по его id
    public String findEmployeeById(int employeeId) throws Exception
    {
        //Arrays.stream(arrayEmployees).filter(emp -> emp.getId() == employeeId);
        for (Employee e : listEmployees) {
            if (e.getId() == employeeId)
            {
                return e.toJSON();
            }
            else
            {
                throw new EmployeeNotFoundException("");
            }
        }
        return null;
    }
}