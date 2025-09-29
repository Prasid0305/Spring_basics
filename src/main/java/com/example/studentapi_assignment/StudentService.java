package com.example.studentapi_assignment;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    private Map<Integer, StudentModel> studentData = new HashMap<>();

    public StudentModel addStudent(StudentModel studentModel){
        studentData.put(studentModel.getId(), studentModel);
        return studentModel;

    }

    public Map<Integer, StudentModel> getAllStudents() {
        return studentData;
    }
    public StudentModel getStudentById(int id) {
        return studentData.get(id);
    }

    public StudentModel updateStudent(int id, StudentModel updatedStudent) {
        studentData.put(id, updatedStudent);
        return updatedStudent;
    }

    public String deleteStudent(int id) {
        studentData.remove(id);
        return "Student removed with ID " + id;
    }

}
