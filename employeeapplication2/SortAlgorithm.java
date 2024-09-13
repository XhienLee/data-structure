/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure.employeeapplication;

/**
 *
 * @author Segn Lee
 */
class SortAlgorithm extends DS_EmployeeList_Array {
    public SortAlgorithm() {
        super();
    }
    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (employeeList[j].getID() < employeeList[min].getID()) {
                    min = j;
                }
            }
            if (min != i) {
                Employee temp = employeeList[i];
                employeeList[i] = employeeList[min];
                employeeList[min] = temp;
            }
        }
    }

    public void doubleSelectionSort() {
        Employee temp;
        int max = size - 1;
        boolean swap;
        for (int i = 0; i < max / 2; i++) {
            swap = false;
            for (int x = i; x < max - i; x++) {
                if (employeeList[x].getID() > employeeList[x + 1].getID()) {
                    temp = employeeList[x];
                    employeeList[x] = employeeList[x + 1];
                    employeeList[x + 1] = temp;
                    swap = true;
                }
            }
            for (int x = i; x > max - i - 1; x--) {
                if (employeeList[x].getID() < employeeList[x - 1].getID()) {
                    temp = employeeList[x];
                    employeeList[x] = employeeList[x - 1];
                    employeeList[x - 1] = temp;
                    swap = true;
                }
            }

            if (!swap) {
                break;
            }
        }
    }

    public void bubbleSort() {
        Employee temp;
        boolean swap;
        for (int i = 0; i < size - 1; i++) {
            swap = false;
            for (int x = 1; x < size - i; x++) {
                if (employeeList[x - 1].getID() > employeeList[x].getID()) {
                    temp = employeeList[x - 1];
                    employeeList[x - 1] = employeeList[x];
                    employeeList[x] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }

    public void insertionSort() {
        for (int i = 1; i < size; i++) {
            Employee temp = employeeList[i];
            int index = i - 1;
            while (employeeList[index].getID() > temp.getID()) {
                employeeList[index + 1] = employeeList[index];
                index = index - 1;
                if (index < 0) {
                    break;
                }
            }
            employeeList[index + 1] = temp;
        }
    }

    public void quickSort(int low, int high) {
        if (low < high) {
            Employee last = employeeList[high];
            int first = low;
            for (int i = low; i < high; i++) {
                if (employeeList[i].getID() < last.getID()) {
                    Employee temp = employeeList[first];
                    employeeList[first] = employeeList[i];
                    employeeList[i] = temp;
                    first++;
                }
            }
            Employee temp = employeeList[first];
            employeeList[first] = employeeList[high];
            employeeList[high] = temp;
            quickSort(low, first - 1);
            quickSort(first + 1, high);
        }
    }

    public void mergeSort(int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;
        Employee[] leftList = new Employee[sizeLeft];
        Employee[] rightList = new Employee[sizeRight];

        for (int i = 0; i < sizeLeft; i++) {
            leftList[i] = employeeList[left + i];
        }
        for (int i = 0; i < sizeRight; i++) {
            rightList[i] = employeeList[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;
        while (i < sizeLeft && j < sizeRight) {
            if (leftList[i].getID() <= rightList[j].getID()) {
                employeeList[k] = leftList[i];
                i++;
            } else {
                employeeList[k] = rightList[j];
                j++;
            }
            k++;
        }

        while (i < sizeLeft) {
            employeeList[k] = leftList[i];
            i++;
            k++;
        }
        while (j < sizeRight) {
            employeeList[k] = rightList[j];
            j++;
            k++;
        }
    }

}
