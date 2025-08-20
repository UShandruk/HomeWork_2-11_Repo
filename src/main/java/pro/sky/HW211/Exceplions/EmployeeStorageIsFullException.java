package pro.sky.HW211.Exceplions;

public class EmployeeStorageIsFullException extends Exception {

    public EmployeeStorageIsFullException(String message)
    {
        super("Превышен лимит количества сотрудников в фирме. " + message);
    }
}
