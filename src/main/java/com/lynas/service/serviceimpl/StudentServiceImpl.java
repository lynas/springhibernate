package com.lynas.service.serviceimpl;

import com.lynas.model.Student;
import com.lynas.service.StudentService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Serializable add(Student student) {
        return sessionFactory.getCurrentSession().save(student);
    }
}
