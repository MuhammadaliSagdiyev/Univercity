package uz.nt.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.nt.project.dto.ResponseDto;
import uz.nt.project.entity.Student;
import uz.nt.project.repository.StudentRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public ResponseDto<?> getStudentInfo(String name) {
        Optional<Student> student = studentRepository.findByName(name);

        if (student.isEmpty()){
            return new ResponseDto<>(false, -9, name + " ismlik student mavjud emas!", null);
        }

        Student student1 = student.get();

        return new ResponseDto<>(true, 0, "OK", studentRepository.findStudentInfo(student1.getName()));
    }
}
