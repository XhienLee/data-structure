/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure.employeeapplication;

/**
 *
 * @author Segn Lee
 */
class DS_EmployeeList_Array {

    final int arraySize = 100;
    Employee[] employeeList;
    int size;

    DS_EmployeeList_Array() {
        employeeList = new Employee[arraySize];
        this.size = 0;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < size; i++) {
            if (employee.getID() == employeeList[i].getID()) {
                return false;
            }
        }
        employeeList[size] = new Employee(employee);
        this.size++;
        return true;
    }

    public boolean addEmployeeWithIndex(Employee employee, int index) {
        for (int i = 0; i < size; i++) {
            if (employee.getID() == employeeList[i].getID()) {
                return false;
            }
        }
        if (this.size == employeeList.length) {
            this.size++;
        }
        Employee temp = employeeList[index];
        employeeList[index] = employee;
        for (int i = index + 1; i <= this.size; i++) {
            Employee nextTemp = employeeList[i];
            employeeList[i] = temp;
            temp = nextTemp;
        }
        return true;
    }

    public boolean removeEmployee(int id) {
        int indexToRemove;
        for (int i = 0; i < this.size; i++) {
            if (employeeList[i] != null && employeeList[i].getID() == id) {
                for (int x = i; x < this.size - 1; x++) {
                    employeeList[x] = employeeList[x + 1];
                }
                employeeList[this.size - 1] = null;
                this.size--;
                return true;
            }
        }
        return false;
    }

    public boolean removeLastIndex() {
        if (size > 0) {
            employeeList[size - 1] = null;
            size--;
            return true;
        }
        return false;
    }

    public boolean removeEmployeeByIndex(int index) {
        employeeList[index] = null;
        for (int x = index; x < this.size - 1; x++) {
            employeeList[x] = employeeList[x + 1];
        }
        this.size--;
        return true;
    }

    public Employee searchByID(int id) {
        for (int i = 0; i < this.size; i++) {
            if (employeeList[i] != null && employeeList[i].getID() == id) {
                return employeeList[i];
            }
        }
        return null;
    }

    public Employee searchByIndex(int index) {
        if (index >= 0 && index < this.size && employeeList[index] != null) {
            return employeeList[index];
        }
        return null;
    }

    public Employee searchByName(String name) {
        for (int i = 0; i < this.size; i++) {
            if (employeeList[i] != null && employeeList[i].getName().equalsIgnoreCase(name)) {
                return employeeList[i];
            }
        }
        return null;
    }

    public void makeEmpty() {
        employeeList = new Employee[arraySize];
        this.size = 0;
    }

    @Override
    public String toString() {
        if (this.size == 0) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            str.append(employeeList[i].toString()).append("\n\n");
        }
        return str.toString();
    }

    public Employee getEmployee(int i) { // use for next and previous
        if (i > size || i < 0) {
            return null;
        }
        return employeeList[i];
    }
    // another version of next and prev, but this one use the inputted employee data to get the previous or next

    public Employee next(Employee E) {
        for (int i = 0; i < size - 1; i++) {
            if (employeeList[i].equals(E)) {
                return employeeList[i + 1];
            }
        }
        return null;
    }

    public Employee previous(Employee E) {
        for (int i = 1; i < size; i++) {
            if (employeeList[i].equals(E)) {
                return employeeList[i - 1];
            }
        }
        return null;
    }
}
