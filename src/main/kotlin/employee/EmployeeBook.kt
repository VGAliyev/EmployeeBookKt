package employee

class EmployeeBook {
    private val employees = arrayOfNulls<Employee>(10)

    /**
     * Get all employees from array (all employee information)
     */
    fun printAllEmployees() {
        for (employee in employees) {
            if (employee != null) {
                println(employee)
            }
        }
    }

    internal val salaryAllEmployees: Float
        /**
         * Get payroll costs for all employees
         *
         * @return float - payroll costs for all employees
         */
        get() {
            var result = 0.0f
            for (employee in employees) {
                if (employee != null) {
                    result += employee.salary
                }
            }
            return result
        }

    /**
     * Minimum wage employee
     *
     * @return String - full name minimum wage employee
     */
    fun minSalaryEmployee(): String {
        var index = firstNotNullEmployeeIndex
        var min = employees[index]!!.salary
        for (i in index..<employees.size) {
            if (employees[i] != null) {
                if (employees[i]!!.salary < min) {
                    min = employees[i]!!.salary
                    index = i
                }
            }
        }
        return employees[index]!!.fullName
    }

    /**
     * Highest paid employee
     *
     * @return String - full name highest paid employee
     */
    fun maxSalaryEmployee(): String {
        var index = firstNotNullEmployeeIndex
        var max = employees[index]!!.salary
        for (i in 1..<employees.size) {
            if (employees[i]!!.salary > max) {
                max = employees[i]!!.salary
                index = i
            }
        }
        return employees[index]!!.fullName
    }

    /**
     * Average salary
     *
     * @return float - average salary
     */
    fun averageSalary(): Float {
        var employeeNum = 0 // number of employees
        for (employee in employees) {
            if (employee != null) {
                employeeNum++
            }
        }
        // Round the return value to two decimal places
        val i = (salaryAllEmployees / employeeNum * 100).toInt()
        return i.toFloat() / 100.0f
    }

    val employeeFullNames: Unit
        /**
         * Get all employees from array (only full name)
         */
        get() {
            for (employee in employees) {
                if (employee != null) {
                    println(employee.fullName)
                }
            }
        }

    /**
     * Index salary for all employee
     *
     * @param index - percentage index
     */
    fun indexSalary(index: Int) {
        for (employee in employees) {
            if (employee != null) {
                employee.salary += employee.salary * index / 100.0f
            }
        }
    }

    /**
     * Minimum wage employee for department
     *
     * @param department - department
     * @return String - full name minimum wage employee
     */
    fun minSalaryEmployeeDepartment(department: Int): String {
        val employeesByDepartment = getEmployeesByDepartment(department)
        var j = 0
        var min = employeesByDepartment[0].salary
        for (i in 1..<employeesByDepartment.size) {
            if (employeesByDepartment[i].salary < min) {
                min = employeesByDepartment[i].salary
                j = i
            }
        }
        return employeesByDepartment[j].fullName
    }

    /**
     * Highest paid employee for department
     *
     * @param department - department
     * @return String - full name highest paid employee
     */
    fun maxSalaryEmployeeDepartment(department: Int): String {
        val employeesByDepartment = getEmployeesByDepartment(department)
        var j = 0
        var max = employeesByDepartment[0].salary
        for (i in 1..<employeesByDepartment.size) {
            if (employeesByDepartment[i].salary > max) {
                max = employeesByDepartment[i].salary
                j = i
            }
        }
        return employeesByDepartment[j].fullName
    }

    fun getSalaryDepartmentEmployees(department: Int): Float {
        val employeesByDepartment = getEmployeesByDepartment(department)
        var result = 0.0f
        for ((_, salary) in employeesByDepartment) {
            result += salary
        }
        return result
    }

    /**
     * Average salary for department
     *
     * @param department - department
     * @return float - average salary (rounded to two decimal places)
     */
    fun averageSalaryDepartment(department: Int): Float {
        val employeesByDepartment = getEmployeesByDepartment(department)
        var result = 0.0f
        for ((_, salary) in employeesByDepartment) {
            result += salary / employeesByDepartment.size
        }

        // До вывода результата, округляем до двух цифр (копеек) после запятой
        val i = (result * 100).toInt()
        return i.toFloat() / 100
    }

    /**
     * Index salary for employee by department
     *
     * @param index - percentage index
     * @param department - department
     */
    fun indexSalaryByDepartment(index: Int, department: Int) {
        val employeesByDepartment = getEmployeesByDepartment(department)
        for (employee in employeesByDepartment) {
            employee.salary += employee.salary * index / 100.0f
        }
    }

    /**
     * Output to the console of department employees
     *
     * @param department - department
     */
    fun printEmployeesByDepartment(department: Int) {
        val employeesByDepartment = getEmployeesByDepartment(department)
        for (employee in employeesByDepartment) {
            println(stringEmployeeWithoutDepartment(employee))
        }
    }

    /**
     * Output to the console of employees with lower salary
     *
     * @param salary - given salary
     */
    fun printEmployeesWithLowerSalary(salary: Float) {
        for (employee in employees) {
            if (employee != null) {
                if (employee.salary < salary) {
                    println(stringEmployeeWithoutDepartment(employee))
                }
            }
        }
    }

    /**
     * Output to the console of employees with higher or equal salary
     *
     * @param salary - given salary
     */
    fun printEmployeesWithHigherSalary(salary: Float) {
        for (employee in employees) {
            if (employee != null) {
                if (employee.salary >= salary) {
                    println(stringEmployeeWithoutDepartment(employee))
                }
            }
        }
    }

    /**
     * Add employee
     *
     * @param fullName String - full name employee
     * @param salary float - employee salary
     * @param department int - department
     *
     * @return boolean - true, if adding an employee was successful, else false
     */
    fun add(fullName: String?, salary: Float, department: Int): Boolean {
        for (i in employees.indices) {
            if (employees[i] == null) {
                employees[i] = Employee(fullName!!, salary, department)
                return true
            }
        }
        return false
    }

    /**
     * Delete employee by full name
     *
     * @param fullName - full name employee
     *
     * @return boolean - true, if deleting an employee was successful, else false
     */
    fun delete(fullName: String?): Boolean {
        if (fullName != null) {
            for (i in employees.indices) {
                if (employees[i] != null) {
                    if (employees[i]!!.fullName == fullName) {
                        employees[i] = null
                        return true
                    }
                }
            }
        }
        return false
    }

    /**
     * Delete employee by ID
     *
     * @param id - employee ID
     *
     * @return boolean - true, if deleting an employee was successful, else false
     */
    fun delete(id: Int): Boolean {
        if (id != 0) {
            for (i in employees.indices) {
                if (employees[i] != null) {
                    if (employees[i]!!.getId() == id) {
                        employees[i] = null
                        return true
                    }
                }
            }
        }
        return false
    }

    /**
     * Change employee
     *
     * @param fullName - full name employee (if != "", then, if exists full name - change)
     * @param department -  department (if != 0, then change)
     * @param salary - salary employee
     *
     * @return boolean - true, if change an employee was successful, else false
     */
    fun changeEmployee(fullName: String?, department: Int, salary: Float): Boolean {
        for (employee in employees) {
            if (employee != null) {
                if (employee.fullName == fullName) {
                    if (salary != 0.0f) {
                        employee.salary = salary
                    }
                    if (department != 0) {
                        employee.department = department
                    }
                    return true
                }
            }
        }
        return false
    }

    /**
     * Print all employees by department (department \n employees)
     */
    fun printEmployeesByAllDepartments() {
        // Обходим все отделы (по условиям их 5)
        for (i in 1..5) {
            if (getEmployeesByDepartment(i).isNotEmpty()) {
                println("Department $i\n")
                for (j in getEmployeesByDepartment(i).indices) {
                    println(getEmployeesByDepartment(i)[j].fullName)
                }
                println() // Separate department
            }
        }
    }

    private val firstNotNullEmployeeIndex: Int
        get() {
            var index = 0
            for (i in employees.indices) {
                if (employees[i] != null) {
                    index = i
                    break
                }
            }
            return index
        }

    /**
     * Getting an array of employees of a given department
     *
     * @param department - department
     * @return Employee[] by department
     */
    private fun getEmployeesByDepartment(department: Int): Array<Employee> {
        val employeeDepartmentList = ArrayList<Employee>()
        for (employee in employees) {
            if (employee != null) {
                if (employee.department == department) {
                    employeeDepartmentList.add(employee)
                }
            }
        }
        return employeeDepartmentList.toTypedArray<Employee>()
    }

    /**
     * Get string employee without department
     *
     * @param employee - employee
     * @return String - formatted string
     */
    private fun stringEmployeeWithoutDepartment(employee: Employee): String {
        val id: Int = employee.getId()
        val name: String = employee.fullName
        val salary: Float = employee.salary
        return "$id: $name, salary: $salary"
    }
}