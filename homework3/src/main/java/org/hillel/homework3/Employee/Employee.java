package org.hillel.homework3.Employee;

final class Employee {
    private final String name;
    private final String email;
    private final String phone;
    private final String position;
    private final int age;

    Employee(String name, String email, String phone, String position, int age) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.position = position;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPosition() {
        return position;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee[" +
                "name=" + name + ", " +
                "email=" + email + ", " +
                "phone=" + phone + ", " +
                "position=" + position + ", " +
                "age=" + age + ']';
    }


}


