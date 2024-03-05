package com.itvedant.petstoreapp.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

class Student{
    private int id;
    private String name;
    private double marks;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getMarks() {
        return marks;
    }
    public void setMarks(double marks) {
        this.marks = marks;
    }
}

// @Controller

//@RestController is combining two annotation
//@Controller and @ResponseBody
@RestController
public class DemoController {
    
    @RequestMapping("/message")

    //This annotation will specify that the method 
    //is return the data which will be converted into
    //json and send as the response
    // @ResponseBody
    public String getMessage(){
        //we are returning string data
        //and not the name of the view file
        return "welcome to rest api";
    }

    @RequestMapping("/marks")
    // @ResponseBody
    public double getMarks(){
        return 90.35;
    }


    @RequestMapping("/colors")
    // @ResponseBody
    public List<String> getColors(){
        List<String> colors = Arrays.asList("red","blue","green","yellow");
        return colors;
    }

    @RequestMapping("/stud")
    // @ResponseBody
    public Student getStudent(){
        Student s = new Student();
        s.setId(1);
        s.setName("harry");
        s.setMarks(78.35);
        return s;

        //Here we are returning the object of the student class
        //which will be serialized into JSON format and 
        //then send as the response
    }

    @RequestMapping("/studs")
    // @ResponseBody
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(10);
        s1.setName("rahul");
        s1.setMarks(56.35);
        students.add(s1);

        Student s2 = new Student();
        s2.setId(20);
        s2.setName("leena");
        s2.setMarks(72.62);
        students.add(s2);

        return students;
    }
}
