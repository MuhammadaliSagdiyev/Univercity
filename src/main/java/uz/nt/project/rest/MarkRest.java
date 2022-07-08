package uz.nt.project.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.nt.project.dto.MarkDto;
import uz.nt.project.dto.ResponseDto;
import uz.nt.project.entity.Mark;
import uz.nt.project.entity.Student;
import uz.nt.project.repository.MarkRepository;
import uz.nt.project.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/mark")
public class MarkRest {
    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public ResponseDto<List<?>> get(@RequestParam Integer studentId){
        Student student = studentRepository.findById(studentId).get();
        return new ResponseDto<>(true, 0, student.getName(), markRepository.getStudentSubjects(studentId));
    }
}
