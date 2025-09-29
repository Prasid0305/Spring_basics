package com.example.studentapi_assignment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/students")

public class StudentController {



        @Autowired
        private StudentService studentService;


        @PostMapping
        public StudentModel addStudent(@RequestBody StudentModel studentModel) {
            return studentService.addStudent(studentModel);
        }


        @GetMapping
        public Map<Integer, StudentModel> getAllStudents() {
            return studentService.getAllStudents();
        }


        @GetMapping("/{id}")
        public StudentModel getStudentById(@PathVariable int id) {
            return studentService.getStudentById(id);
        }


        @PutMapping("/{id}")
        public StudentModel updateStudent(@PathVariable int id, @RequestBody StudentModel studentModel) {
            return studentService.updateStudent(id, studentModel);
        }


        @DeleteMapping("/{id}")
        public String deleteStudent(@PathVariable int id) {
            return studentService.deleteStudent(id);
        }
}
