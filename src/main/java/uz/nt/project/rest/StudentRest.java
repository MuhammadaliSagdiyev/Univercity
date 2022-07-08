package uz.nt.project.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.nt.project.dto.ResponseDto;
import uz.nt.project.service.StudentService;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentRest {

    private final StudentService studentService;

    @GetMapping
    public ResponseDto<?> getStudentInfo(@RequestParam String name){
        return studentService.getStudentInfo(name);
    }
}
