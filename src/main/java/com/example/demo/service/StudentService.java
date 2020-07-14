package com.example.demo.service;

import com.example.demo.Entity.User;
import com.example.demo.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentdao;

    public User select(int id) {
        return studentdao.select(id);
    }

    public User selectSut(int id) {
        return studentdao.selectStu(id);
    }


}
