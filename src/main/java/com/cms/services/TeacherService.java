package com.cms.services;

import com.cms.entity.Teacher;
import com.cms.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> findAllTeachers() {

        List<Teacher> teacherList = teacherRepository.findAll();

        return teacherList;
    }

    public Teacher findTeacherById(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {
            return teacher.get();
        }
        else
            throw new RuntimeException("Teacher not found");
    }

    public void saveTeacher(Teacher teacher) {teacherRepository.save(teacher); }

    public void updateTeacher (Teacher teacher) {teacherRepository.save(teacher); }

    public void deleteTeacher(Long teacherId) {teacherRepository.deleteById(teacherId); }

}

