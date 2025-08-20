package pro.sky.HW211.Exceplions;

public class EmployeeNotFoundException extends Exception {

    public EmployeeNotFoundException(String message)
    {
        super("Cотрудник не найден. " + message);
    }
}
