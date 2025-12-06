package org.example.javafxandjdbc;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {
    private SimpleStringProperty name;
    private SimpleIntegerProperty id;
    private SimpleIntegerProperty age;
    private SimpleDoubleProperty grade;
    private SimpleStringProperty course;
    private SimpleStringProperty email;

    public Student(String name, int id,  int age, double grade, String course, String email ) {
        this.name = new SimpleStringProperty(name);
        this.id = new SimpleIntegerProperty(id);
        this.age = new SimpleIntegerProperty(age);
        this.grade = new SimpleDoubleProperty(grade);
        this.course = new SimpleStringProperty(course );
        this.email = new SimpleStringProperty(email);
    }

    public String getName() {return name.get();}

    public int getId() {return id.get();}

    public int getAge() {return age.get();}

    public double getGrade() {return grade.get();}

    public String getCourse() {return course.get();}
    public String getEmail() {return email.get();}

    public void setName(String name) {this.name.set(name);}
    public void setAge(int age) {this.age.set(age);}
    public void setGrade(int grade) {this.grade.set(grade);}
    public void setCourse(String course) {this.course.set(course);}
    public void setEmail(String email) {this.email.set(email);}

    public SimpleStringProperty nameProperty() {return name;}
    public SimpleIntegerProperty idProperty() {return id;}
    public SimpleIntegerProperty ageProperty() {return age;}
    public SimpleDoubleProperty gradeProperty() {return grade;}
    public SimpleStringProperty courseProperty() {return course;}
    public SimpleStringProperty emailProperty() {return email;}
}
