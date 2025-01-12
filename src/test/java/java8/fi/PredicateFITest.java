package java8.fi;

import java8.mockdata.MockData;
import java8.mockdata.model.employee.Employee;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.function.Predicate;

public class PredicateFITest {

    /**
     * Create Predicate
     */
    @Test
    void createPredicate(){
        Predicate p = new Predicate() {
            @Override
            public boolean test(Object o) {
                return false;
            }
        };
    }

    /**
     * Create Predicate
     * Check Even Number
     */
    @Test
    void createPredicateSimplified(){
        Predicate p = new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i%2==0;
            }
        };
        var isEven = p.test(11);
        System.out.println(isEven);
    }

    /**
     * Create Predicate
     * Check Even Number
     */
    @Test
    void createPredicateSimplified1(){
        Predicate p = (Predicate<Integer>) i -> i%2==0;
        var isEven = p.test(11);
        System.out.println(isEven);
    }

    /**
     * Create Predicate
     * Check Even Number
     */
    @Test
    void createPredicateSimplified2(){
        Predicate<Integer> p = i -> i%2==0;
        var isEven = p.test(11);
        System.out.println(isEven);
    }

    /**
     * Create Predicate
     * Check String Matching
     */
    @Test
    void createPredicateSimplified3(){
        Predicate p = new Predicate<String>() {
            @Override
            public boolean test(String str) {
                return str.equalsIgnoreCase("shubham");
            }
        };
        var isNameMatched = p.test("shubham1");
        System.out.println(isNameMatched);
    }

    /**
     * Create Predicate
     * Check String Matching
     */
    @Test
    void createPredicateSimplified4() throws IOException {
        Predicate<Employee> p1 = (Employee emp)->{
            return emp.department().equalsIgnoreCase("Human Resources");
        };

        Predicate<Employee> p2 = (Employee emp)->emp.gender().equalsIgnoreCase("male");

        Predicate<Employee> p3 = emp-> emp.salary()>=10000;

        var emp = MockData.getEmployees().get(0);

        var isHrDepartment=p1.test(emp);
        System.out.println("isHrDepartment="+isHrDepartment);

        var isMale=p2.test(emp);
        System.out.println("isMale="+isMale);

        var isFemale=p2.negate().test(emp);
        System.out.println("isFemale="+isFemale);

        var isSalaryMoreThan10000=p3.test(emp);
        System.out.println("isSalaryMoreThan10000="+isSalaryMoreThan10000);

        var chainedResult=p1.or(p2).and(p3).test(emp);
        System.out.println("chainedResult="+chainedResult);
    }
}
