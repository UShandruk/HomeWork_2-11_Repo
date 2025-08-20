package pro.sky.HW211.Exceplions;

public class EmployeeAlreadyAddedException extends Exception {

    public EmployeeAlreadyAddedException(String message)
    {
        super("Данный сотрудник уже есть в коллекции. " + message);
    }
}
