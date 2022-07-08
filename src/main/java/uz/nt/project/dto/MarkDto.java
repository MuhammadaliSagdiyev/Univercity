package uz.nt.project.dto;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.nt.project.entity.Student;
import uz.nt.project.entity.Subject;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkDto {
    private Integer id;
    private Integer mark;
    private Date date;
    private StudentDto studentDto;
    private SubjectDto subjectDto;
}
