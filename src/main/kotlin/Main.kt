import employee.EmployeeBook

    fun main() {
        println("Курсовая работа (1 курс)")
        println("Employee Book")
        println()

        // Код для проверки курсовой

        // Добавим сотрудников в массив (10) - проверка метода add
        val eb = EmployeeBook()
        eb.add("Иванов Иван Иванович", 52600.00f, 1)
        eb.add("Алексеев Алексей Алексеевич", 62600.00f, 1)
        eb.add("Сидоров Лев Петрович", 59800.00f, 3)
        eb.add("Магомедов Джамал Ильдусович", 75900.00f, 3)
        eb.add("Скоробогатько Пётр Михайлович", 76100.00f, 2)
        eb.add("Васильев Михаил Петрович", 48300.00f, 3)
        eb.add("Любимова Майа Андреевна", 63500.00f, 2)
        eb.add("Давлетов Давлет Давлетович", 79250.00f, 4)
        eb.add("Шихсаидов Рустем Максудович", 56600.00f, 5)
        eb.add("Алиев Владислав Геннадиевич", 92600.00f, 5)

        // Печать всех сотрудников
        eb.printAllEmployees()

        // Печать сотрудников по отделам
        eb.printEmployeesByAllDepartments()

        // Пробуем добавить ещё одного сотрудника (11-го)
        if (eb.add("Одиннадцатый", 10000.0f, 3)) {
            println("Сотрудник успешно добавлен")
        } else {
            println("Сотрудник лишний!")
        }

        // Удаляем сотрудника (существующее имя)
        if (eb.delete("Иванов Иван Иванович")) {
            println("Сотрудник успешно удалён!")
        } else {
            println("Неудачная попытка удаления!")
        }
        // Пробуем удалить сотрудника с несуществующим ID
        if (eb.delete(12)) {
            println("Сотрудник успешно удалён!")
        } else {
            println("Неудачная попытка удаления!")
        }

        // Salary all
        println("All salary = " + eb.salaryAllEmployees)

        // Salary by department 3
        println("Salary department 3 = " + eb.getSalaryDepartmentEmployees(3))

        // Max, min and average salary
        println("Max salary - " + eb.maxSalaryEmployee())
        println("Min salary - " + eb.minSalaryEmployee())
        println("Average salary - " + eb.averageSalary())

        // Max, min and average salary by department
        println("Max salary (department 3) - " + eb.maxSalaryEmployeeDepartment(3))
        println("Min salary (department 3) - " + eb.minSalaryEmployeeDepartment(3))
        println("Average salary (department 3) - " + eb.averageSalaryDepartment(3))

        // Get full names all employee
        eb.employeeFullNames

        // Index salary for all employee
        eb.indexSalary(13)
        eb.printAllEmployees()

        // Index salary for employees by department 3
        eb.indexSalaryByDepartment(13, 3)
        eb.printEmployeesByDepartment(3)

        // Print employees with salary >= givenSalary and salary < givenSalary
        val givenSalary = 69000.0f
        println("Salary >= $givenSalary")
        eb.printEmployeesWithHigherSalary(givenSalary)
        println("Salary < $givenSalary")
        eb.printEmployeesWithLowerSalary(givenSalary)

        // Change employee successful
        if (eb.changeEmployee("Сидоров Лев Петрович", 4, 23000.0f)) {
            println("Successful change employee!")
        } else {
            println("Unsuccessful change!")
        }

        // Change employee unsuccessful
        if (eb.changeEmployee("", 4, 23000.0f)) {
            println("Successful change employee!")
        } else {
            println("Unsuccessful change!")
        }
    }