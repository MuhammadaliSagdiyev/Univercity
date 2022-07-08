package uz.nt.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {
    private Integer id;
    private String name;
    private Date year;
    private JournalDto journal;
    private FakultetDto fakultetId;
    private List<StudentDto> students;
    private List<SubjectDto> subjects;
}
