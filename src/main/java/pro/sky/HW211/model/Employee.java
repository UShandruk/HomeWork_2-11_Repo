package pro.sky.HW211.model;

import java.util.Objects;

/// Сотрудник
public class Employee {

    /// Id для hashCode()
    private int id;

    /// Имя
    private String firstName;

    /// Фамилия
    private String lastName;


    /// Конструктор
    public Employee(int id, String firstName, String lastName)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    /// Методы
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public String toStringAll() {
        return (id + " " + lastName + " " + firstName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (this.id == ((Employee) o).id)
            return true;
        if (this.hashCode() == o.hashCode())
            return true;
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        /*int result = this != null ? this.hashCode() : 0;
        result = 31 * result + id;*/
        int result = Objects.hash(id);
        return result;
    }
}