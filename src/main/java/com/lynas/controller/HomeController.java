package com.lynas.controller;

import com.lynas.model.Student;
import com.lynas.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sazzad on 8/11/2015.
 */
@Controller
public class HomeController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/add")
    public String add() {
        Student student = new Student();
        student.setName("sazzad");
        studentService.add(student);
        return "index";
    }


}
