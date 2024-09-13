/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package datastructure.employeeapplication;

/**
 *
 * @author Segn Lee
 */
import javax.swing.*;

public class EmployeeApplication {

    private static SortAlgorithm employeeList = new SortAlgorithm();
    private static Employee newEmployee;
    private static int option, index;

    public static void main(String[] args) {
        Employee searchId, searchIndex, msgObject, temp;
        int idToSearch, nextOrPrev;
        String msgString;
        String[] prevNextButton = {"Previous", "Main Menu", "Next"};
        employeeList.addEmployee(new Employee("Vera", "President", (byte) 21, 2050));
        employeeList.addEmployee(new Employee("test", "test", (byte) 25, 2020));
        employeeList.addEmployee(new Employee("Vera", "President", (byte) 21, 2024));
        employeeList.addEmployee(new Employee("John", "Manager", (byte) 30, 2023));
        employeeList.addEmployee(new Employee("Alice", "Developer", (byte) 25, 2030));
        employeeList.addEmployee(new Employee("Bob", "Analyst", (byte) 28, 2025));
        int idToRemove;
        boolean removed;
        do {
            String choice = "Choose Option\n"
                    + "[1] Add Employee\n"
                    + "[2] Add Employee With Index\n"
                    + "[3] Remove Employee\n"
                    + "[4] Remove Employee By Index\n"
                    + "[5] Show All Employees\n"
                    + "[6] Search Employee By ID\n"
                    + "[7] Search Employee By Index\n"
                    + "[8] Search Employee By Name\n"
                    + "[9] Remove Last\n"
                    + "[10] Check Employee With Previous and Next Button\n"
                    + "[11] Sorting Menu\n"
                    + "[0] Exit\n";
            String input = JOptionPane.showInputDialog(choice);
            if (input == null || input.trim().isEmpty()) {
                System.exit(0);
            }
            option = Integer.parseInt(input.trim());
            switch (option) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Closing the appplication");
                    break;
                case 1:
                    addEmployeeGui(false); // by index = false
                    break;
                case 2:
                    addEmployeeGui(true); // by index = true
                    break;
                case 3:
                    idToRemove = Integer.parseInt(JOptionPane.showInputDialog("Enter ID of Employee to remove:"));
                    removed = employeeList.removeEmployee(idToRemove);
                    if (removed) {
                        JOptionPane.showMessageDialog(null, "Employee removed successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Employee not found.");
                    }
                    break;
                case 4:
                    index = Integer.parseInt(JOptionPane.showInputDialog("Enter index of Employee to remove:"));
                    removed = employeeList.removeEmployeeByIndex(index);
                    if (removed) {
                        JOptionPane.showMessageDialog(null, "Employee removed successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Employee not found.");
                    }
                    break;
                case 5:
                    if (employeeList.toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "No employee yet.");
                        break;
                    }
                    JOptionPane.showMessageDialog(null, employeeList.toString());
                    break;
                case 6:
                    idToSearch = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID: "));
                    searchId = employeeList.searchByID(idToSearch);
                    if (searchId == null) {
                        JOptionPane.showMessageDialog(null, "ID " + searchId + " not found");
                        break;
                    } else {
                        temp = searchId;
                        while (true) {
                            if (searchId == null) {
                                JOptionPane.showMessageDialog(null, "No employee");
                                msgString = temp.toString();
                                searchId = temp;
                            } else {
                                temp = searchId;
                                msgString = searchId.toString();
                            }
                            nextOrPrev = JOptionPane.showOptionDialog(null, msgString, "Employee", 0, JOptionPane.PLAIN_MESSAGE, null, prevNextButton, null);
                            if (nextOrPrev == 0) {
                                searchId = employeeList.previous(searchId);
                            } else if (nextOrPrev == 2) {
                                searchId = employeeList.next(searchId);
                            } else {
                                break;
                            }
                        }
                    }
                    break;
                case 7:
                    index = Integer.parseInt(JOptionPane.showInputDialog("Enter the Index number: "));
                    searchIndex = employeeList.searchByIndex(index);
                    if (searchIndex == null) {
                        JOptionPane.showMessageDialog(null, "Index " + index + " not found");
                        break;
                    } else {
                        msgObject = employeeList.getEmployee(index);
                        while (true) {
                            if (msgObject == null) {
                                msgString = "No employee in number: " + index;
                            } else {
                                msgString = msgObject.toString();
                            }
                            nextOrPrev = JOptionPane.showOptionDialog(null, msgString, "Employee Number: " + index, 0, JOptionPane.PLAIN_MESSAGE, null, prevNextButton, null);
                            if (nextOrPrev == 0) {
                                index--;
                                msgObject = employeeList.getEmployee(index);
                            } else if (nextOrPrev == 2) {
                                index++;
                                msgObject = employeeList.getEmployee(index);
                            } else {
                                break;
                            }
                        }
                    }
                    break;

                case 8:
                    String searchName = JOptionPane.showInputDialog("Enter the Name: ");
                    Employee foundName = employeeList.searchByName(searchName);
                    if (foundName == null) {
                        JOptionPane.showMessageDialog(null, "Name " + searchName + " not found");
                        break;
                    } else {
                        temp = foundName;
                        while (true) {
                            if (foundName == null) {
                                JOptionPane.showMessageDialog(null, "No employee");
                                msgString = temp.toString();
                                foundName = temp;
                            } else {
                                temp = foundName;
                                msgString = foundName.toString();
                            }
                            nextOrPrev = JOptionPane.showOptionDialog(null, msgString, "Employee", 0, JOptionPane.PLAIN_MESSAGE, null, prevNextButton, null);
                            if (nextOrPrev == 0) {
                                foundName = employeeList.previous(foundName);
                            } else if (nextOrPrev == 2) {
                                foundName = employeeList.next(foundName);
                            } else {
                                break;
                            }
                        }
                    }
                    break;
                case 9:
                    removed = employeeList.removeLastIndex();
                    if (removed) {
                        JOptionPane.showMessageDialog(null, "Employee removed successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Employee not found.");
                    }
                case 10:
                    int getI = 0;
                    msgObject = employeeList.getEmployee(getI);
                    while (true) {
                        if (msgObject == null) {
                            msgString = "No employee in number: " + getI;
                        } else {
                            msgString = msgObject.toString();
                        }
                        nextOrPrev = JOptionPane.showOptionDialog(null, msgString, "Employee Number: " + getI, 0, JOptionPane.PLAIN_MESSAGE, null, prevNextButton, null);
                        if (nextOrPrev == 0) {
                            getI--;
                            msgObject = employeeList.getEmployee(getI);
                        } else if (nextOrPrev == 2) {
                            getI++;
                            msgObject = employeeList.getEmployee(getI);
                        } else {
                            break;
                        }
                    }
                    break;
                case 11:
                    sortMenu();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        } while (option != 0);
    }

    public static void sortMenu() {
        int option = 0;
        do {
            String choice = "Choose Option\n"
                    + "[1] Selection Sort\n"
                    + "[2] Double Selection Sort\n"
                    + "[3] Bubble Sort\n"
                    + "[4] Insertion Sort\n"
                    + "[5] Quick Sort\n"
                    + "[6] Merge Sort\n"
                    + "[7] Display Employee\n"
                    + "[0] Exit\n";
            String input = JOptionPane.showInputDialog(choice);
            if (input == null || input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Input cannot be empty. Exiting.");
                System.exit(1);
            }
            option = Integer.parseInt(input.trim());

            switch (option) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Exiting menu.");
                    return; // go to main menu
                case 1:
                    employeeList.selectionSort();
                    JOptionPane.showMessageDialog(null, employeeList.toString());
                    break;
                case 2:
                    employeeList.doubleSelectionSort();
                    JOptionPane.showMessageDialog(null, employeeList.toString());
                    break;
                case 3:
                    employeeList.bubbleSort();
                    JOptionPane.showMessageDialog(null, employeeList.toString());
                    break;
                case 4:
                    employeeList.insertionSort();
                    JOptionPane.showMessageDialog(null, employeeList.toString());
                    break;
                case 5:
                    employeeList.quickSort(0, employeeList.getSize() - 1);
                    JOptionPane.showMessageDialog(null, employeeList.toString());
                    break;
                case 6:
                    employeeList.mergeSort(0, employeeList.getSize() - 1);
                    JOptionPane.showMessageDialog(null, employeeList.toString());
                    break;
                case 7:
                    if (employeeList.toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "No employee yet.");
                        break;
                    }
                    JOptionPane.showMessageDialog(null, employeeList.toString());
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        } while (option != 0);
    }

    public static void addEmployeeGui(boolean useIndex) {
        String name = "", position = "";
        int age = 0, id = 0, index = 0;
        boolean success = true;
        name = JOptionPane.showInputDialog("Enter Name: ");
        position = JOptionPane.showInputDialog("Enter Position: ");
        id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID: "));
        age = (byte) Integer.parseInt(JOptionPane.showInputDialog("Enter age: "));
        if (useIndex) {
            index = Integer.parseInt(JOptionPane.showInputDialog("Enter Index: "));
        }
        newEmployee = new Employee(name, position, (byte) age, id);
        if (useIndex) {
            success = employeeList.addEmployeeWithIndex(newEmployee, index);
        } else {
            success = employeeList.addEmployee(newEmployee);
        }
        if (!success) {
            JOptionPane.showMessageDialog(null, "Duplicate Id");
        } else {
            JOptionPane.showMessageDialog(null, "Employee added successfully.");
        }
    }
}
