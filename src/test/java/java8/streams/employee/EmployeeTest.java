package java8.streams.employee;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeTest {

  List<EmployeeObj> empList = EmployeeObj.getEmployees();

  /** Group the Employees by city */
  @Test
  void groupEmployeesByCity() {
    Map<String, List<EmployeeObj>> result =
        empList.stream().collect(Collectors.groupingBy(EmployeeObj::getCity));
    System.out.println(result);
  }

  /** Group the Employees by age */
  @Test
  void groupEmployeesByAge() {
    Map<Integer, List<EmployeeObj>> result =
        empList.stream().collect(Collectors.groupingBy(EmployeeObj::getAge));
    System.out.println(result);
  }

  /** Find the count of male and female employees present in the organization */
  @Test
  void FindMaleAndFemaleCount() {
    Map<String, Long> result =
        empList.stream()
            .collect(Collectors.groupingBy(EmployeeObj::getGender, Collectors.counting()));
    System.out.println(result);
  }

  /** Print the names of all departments in the organization */
  @Test
  void AllDepartmentNames() {
    empList.stream().map(EmployeeObj::getDeptName).distinct().forEach(System.out::println);
  }

  /** Print employee details whose age is greater than 28 */
  @Test
  void EmployeeAgeGreaterThan28() {
    empList.stream().filter(emp -> emp.getAge() > 28).forEach(System.out::println);
  }

  /** Find maximum age of employee */
  @Test
  void MaxAgeOfEmployee() {
    Optional<EmployeeObj> maxAgeEmployee =
        empList.stream().max(Comparator.comparing(EmployeeObj::getAge));
    System.out.println(maxAgeEmployee);

    OptionalInt maxAge = empList.stream().mapToInt(EmployeeObj::getAge).max();
    if (maxAge.isPresent()) {
      System.out.println(maxAge.getAsInt());
    }
  }

  /** Print Average age of Male and Female Employees */
  @Test
  void AverageAgeOfEmployee() {
    Map<String, Double> averageAge =
        empList.stream()
            .collect(
                Collectors.groupingBy(
                    EmployeeObj::getGender, Collectors.averagingInt(EmployeeObj::getAge)));
    averageAge.entrySet().stream()
        .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
  }

  /** Print the number of employees in each department */
  @Test
  void employeeCountInEachDepartment() {
    Map<String, Long> empCount =
        empList.stream()
            .collect(Collectors.groupingBy(EmployeeObj::getDeptName, Collectors.counting()));
    System.out.println(empCount);
  }

  /** Find oldest employee */
  @Test
  void findOldestEmployee() {
    Optional<EmployeeObj> oldestEmployee =
        empList.stream().max(Comparator.comparing(EmployeeObj::getAge));
    if (oldestEmployee.isPresent()) {
      oldestEmployee.stream().forEach(System.out::println);
    }
  }

  /** Find youngest female employee */
  @Test
  void youngestFemaleEmployee() {
    Optional<EmployeeObj> minAgeFemaleEmployee =
        empList.stream()
            .filter(emp -> emp.getGender() == "F")
            .min(Comparator.comparing(EmployeeObj::getAge));
    if (minAgeFemaleEmployee.isPresent()) {
      EmployeeObj minAgeFemaleEmployeeObj = minAgeFemaleEmployee.get();
      System.out.println(minAgeFemaleEmployeeObj);
    }
  }

  /** Find employees whose age is greater than 30 and employees whose age is less than 30 */
  @Test
  void employeeAgeGreaterAndLessThan30() {
    Map<Boolean, List<EmployeeObj>> employeeMap =
        empList.stream().collect(Collectors.partitioningBy(emp -> emp.getAge() >= 30));
    employeeMap.entrySet().stream()
        .forEach(
            entry -> {
              if (entry.getKey().equals(Boolean.TRUE)) {
                System.out.println("Greater Than 30 Employees = " + entry.getValue());
              } else {
                System.out.println("Less Than 30 Employees = " + entry.getValue());
              }
            });
  }

  /** Find the department name which has the highest number of employees */
  @Test
  void departmentWithHighestEmployeeCount() {
    Map<String, Long> employeeCountGroupByDepartment =
        empList.stream()
            .collect(Collectors.groupingBy(EmployeeObj::getDeptName, Collectors.counting()));
    Optional<Map.Entry<String, Long>> maxDepartmentEntrySet =
        employeeCountGroupByDepartment.entrySet().stream()
            .max(Comparator.comparing(Map.Entry::getValue));
    if (maxDepartmentEntrySet.isPresent()) {
      System.out.println(
          maxDepartmentEntrySet.get().getKey() + " - " + maxDepartmentEntrySet.get().getValue());
    }
  }

  /** Find if there any employees from HR Department */
  @Test
  void anyEmployeeInHRDepartment() {
    boolean empInHRDept = empList.stream().anyMatch(emp -> emp.getDeptName() == "HR");
    System.out.println(empInHRDept);

    Optional<EmployeeObj> empInHRDept1 =
        empList.stream().filter(emp -> emp.getDeptName() == "HR").findAny();
    if (empInHRDept1.isPresent()) {
      System.out.println("Employee Present in HR Department");
      System.out.println(empInHRDept1.get());
    } else {
      System.out.println("No Employee Present in HR Department");
    }

    long count = empList.stream().filter(emp -> emp.getDeptName() == "HR").count();
    System.out.println(count);
  }

  /**
   * Find the department names that these employees work for, where the number of employees in the
   * department is over 3
   */
  @Test
  void departmentWithEmployeeCountGreaterThan3() {
    Map<String, Long> employeeDepartmentCount =
        empList.stream()
            .collect(Collectors.groupingBy(EmployeeObj::getDeptName, Collectors.counting()));
    Map<String, Long> filteredEmpDeptCount =
        employeeDepartmentCount.entrySet().stream()
            .filter(entry -> entry.getValue() > 3)
            .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
    System.out.println(filteredEmpDeptCount);
  }

  /**
   * Find all employees who lives in ‘Blore’ city, sort them by their name and print the names of
   * employees
   */
  @Test
  void employeeLiveInBangloreSorted() {
    List<String> empList =
        this.empList.stream()
            .filter(emp -> emp.getCity() == "Blore")
            .sorted(Comparator.comparing(EmployeeObj::getName))
            .map(EmployeeObj::getName)
            .toList();
    System.out.println(empList);
  }

  /** No of employees in the organisation */
  @Test
  void totalEmployeeCount() {
    long empCount = empList.stream().count();
    System.out.println(empCount);
  }

  /** Find employee count in every department */
  @Test
  void empCountInEachDepartment() {
    Map<String, Long> empCountInEachDept =
        empList.stream()
            .collect(Collectors.groupingBy(EmployeeObj::getDeptName, Collectors.counting()));
    System.out.println(empCountInEachDept);
  }

  /** Find the department which has the highest number of employees */
  @Test
  void departmentWithHighestEmployee() {
    Map<String, Long> empCountInEachDepartment =
        empList.stream()
            .collect(Collectors.groupingBy(EmployeeObj::getDeptName, Collectors.counting()));
    Optional<Map.Entry<String, Long>> maxEmployeeCountDepartment =
        empCountInEachDepartment.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
    if (maxEmployeeCountDepartment.isPresent()) {
      System.out.println(maxEmployeeCountDepartment);
    }
  }

  /** Sorting a Stream by age and name fields */
  @Test
  void sortEmployeeListByAgeAndName() {
    List<EmployeeObj> sortedEmpList =
        empList.stream()
            .sorted(Comparator.comparing(EmployeeObj::getAge).thenComparing(EmployeeObj::getName))
            .toList();
    System.out.println(sortedEmpList);
  }

  /** Highest experienced employees in the organization */
  @Test
  void highestExperiencedEmployee() {
    Optional<EmployeeObj> maxExperiencedEmp =
        empList.stream().min(Comparator.comparing(EmployeeObj::getYearOfJoining));
    if (maxExperiencedEmp.isPresent()) {
      System.out.println(maxExperiencedEmp.get());
    }
  }

  /** Print average and total salary of the organization */
  @Test
  void averageAndTotalSalary() {
    LongSummaryStatistics salaryStatics =
        empList.stream().collect(Collectors.summarizingLong(EmployeeObj::getSalary));
    System.out.println(salaryStatics.getAverage());
    System.out.println(salaryStatics.getSum());

    OptionalDouble averageSalary = empList.stream().mapToLong(EmployeeObj::getSalary).average();
    long totalSalary = empList.stream().mapToLong(EmployeeObj::getSalary).sum();
    System.out.println(averageSalary.getAsDouble());
    System.out.println(totalSalary);
  }

  /** Print Average salary of each department */
  @Test
  void averageAndTotalSalaryInEachDepartment() {
    Map<String, LongSummaryStatistics> departmentWiseSalaryStatics =
        empList.stream()
            .collect(
                Collectors.groupingBy(
                    EmployeeObj::getDeptName, Collectors.summarizingLong(EmployeeObj::getSalary)));
    departmentWiseSalaryStatics.entrySet().stream()
        .forEach(
            entry ->
                System.out.println(
                    "Department : "
                        + entry.getKey()
                        + "\nAverage : "
                        + entry.getValue().getAverage()
                        + "\nSum : "
                        + entry.getValue().getSum()));

    Map<String, Double> averageSalaryPerDepartment =
        empList.stream()
            .collect(
                Collectors.groupingBy(
                    EmployeeObj::getDeptName, Collectors.averagingLong(EmployeeObj::getSalary)));
    System.out.println(averageSalaryPerDepartment);
  }

  /** Find Highest salary in the organisation */
  @Test
  void highestSalaryInCompany() {
    Optional<EmployeeObj> highestPaidEmployee =
        empList.stream().max(Comparator.comparing(EmployeeObj::getSalary));
    System.out.println(highestPaidEmployee);

    Optional<EmployeeObj> highestPaidEmployee1 =
        empList.stream()
            .sorted(Comparator.comparingLong(EmployeeObj::getSalary).reversed())
            .findFirst();
    System.out.println(highestPaidEmployee1);
  }

  /** Find Second Highest salary in the organisation */
  @Test
  void secondHighestSalaryInCompany() {
    Optional<EmployeeObj> secondHighestPaidEmployee =
        empList.stream()
            .sorted(Comparator.comparingLong(EmployeeObj::getSalary).reversed())
            .skip(1)
            .limit(1)
            .findFirst();
    System.out.println(secondHighestPaidEmployee.get());
  }

  /** Nth Highest salary */
  @Test
  void nthHighestSalary() {
    int nth = 8;
    NavigableMap<Long, List<EmployeeObj>> collect =
        empList.stream()
            .collect(
                Collectors.groupingBy(EmployeeObj::getSalary, TreeMap::new, Collectors.toList()))
            .reversed();

    Map.Entry<Long, List<EmployeeObj>> nthSalaryEmp =
        collect.entrySet().stream()
            .skip(nth - 1)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Out Of Range"));
    System.out.println(nthSalaryEmp);

    Map<String, EmployeeObj> collect1 =
        empList.stream()
            .collect(
                Collectors.groupingBy(
                    EmployeeObj::getDeptName,
                    Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                          return list.stream()
                              .sorted(Comparator.comparing(EmployeeObj::getSalary).reversed())
                              // .skip(1)
                              .findFirst()
                              .orElseThrow();
                          // .collect(Collectors.toCollection(ArrayList::new));
                        })));
    System.out.println(
        "-----------------------------------------------------------------------------");
    System.out.println(collect1);
    System.out.println(
        "-----------------------------------------------------------------------------");

    Map<String, EmployeeObj> collect2 =
        empList.stream()
            .collect(
                Collectors.groupingBy(
                    ee1 -> ee1.getDeptName(),
                    Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingLong(ee1 -> ee1.getSalary())),
                        Optional::get)));

    System.out.println(collect2);
  }

  /** Find highest paid salary in the organisation based on gender */
  @Test
  void highestSalaryGenderWise() {
    Map<String, Optional<EmployeeObj>> collect =
        empList.stream()
            .collect(
                Collectors.groupingBy(
                    EmployeeObj::getGender,
                    Collectors.maxBy(Comparator.comparing(EmployeeObj::getSalary))));
    System.out.println(collect);
  }

  /** Find lowest paid salary in the organisation based in the organisation */
  @Test
  void minPaidEmployee() {
    Optional<EmployeeObj> minPaidEmployee =
        empList.stream().min(Comparator.comparingLong(EmployeeObj::getSalary));
    System.out.println(minPaidEmployee.get());
    ;
  }

  /** Sort the employees salary in the organisation in ascending order */
  @Test
  void sortEmpBySalaryAsc() {
    List<EmployeeObj> sortedEmp =
        empList.stream().sorted(Comparator.comparingLong(EmployeeObj::getSalary)).toList();
    System.out.println(sortedEmp);
  }

  /** Sort the employees salary in the organisation in descending order */
  @Test
  void sortEmpBySalaryDesc() {
    List<EmployeeObj> sortedEmp =
        empList.stream()
            .sorted(Comparator.comparingLong(EmployeeObj::getSalary).reversed())
            .toList();
    System.out.println(sortedEmp);
  }

  /** Highest salary based on department */
  @Test
  void highestSalaryInEachDepartment() {
    Map<String, Long> collect =
        empList.stream()
            .collect(
                Collectors.groupingBy(
                    ee -> ee.getDeptName(),
                    Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingLong(EmployeeObj::getSalary)),
                        ee1 -> ee1.get().getSalary())));
    System.out.println(collect);
  }

  /** Print list of employee’s second highest record based on department */
  @Test
  void secondHighestPaidEmployeeInEachDepartment() {
    // List<EmployeeObj> empList = new ArrayList<>();
    // empList.add(new EmployeeObj(1, "abc", 28, 123, "F", "HR", "Blore", 2020));

    Map<String, EmployeeObj> secondPaidEmp
            = empList.stream()
            .collect(
                    Collectors.groupingBy(
                            EmployeeObj::getDeptName,
                            Collectors.collectingAndThen(
                                    Collectors.toList(),
                                    list ->
                                            list.stream()
                                                    .sorted(Comparator.comparingLong(EmployeeObj::getSalary))
                                                    .skip(1)
                                                    .findFirst().orElseThrow(() -> new RuntimeException("No Emp Found")))));
    System.out.println(secondPaidEmp);

  }

  /** Sort the employees salary in each department in ascending order */
  @Test
  void groupEmpByDeptAndThenSortBySalaryAsc() {
    Map<String, List<EmployeeObj>> collect = empList.stream().collect(Collectors.groupingBy(e -> e.getDeptName(),
            Collectors.collectingAndThen(Collectors.toList(),
                    list -> list.stream().sorted(Comparator.comparingLong(EmployeeObj::getSalary))
                            .collect(Collectors.toList()))));
    System.out.println(collect);
  }

  /** Sort the employees salary in each department in descending order */
  @Test
  void groupEmpByDeptAndThenSortBySalaryDesc() {
    Map<String, List<EmployeeObj>> collect = empList.stream().collect(Collectors.groupingBy(e -> e.getDeptName(),
            Collectors.collectingAndThen(Collectors.toList(),
                    list -> list.stream().sorted(Comparator.comparingLong(EmployeeObj::getSalary).reversed())
                            .collect(Collectors.toList()))));
    System.out.println(collect);
  }
}
