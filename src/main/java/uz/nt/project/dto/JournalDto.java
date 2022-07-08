package uz.nt.project.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.nt.project.entity.Group;
import uz.nt.project.entity.Subject;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JournalDto {
    private Integer id;
    private String name;
    private GroupDto groupDto;
    private List<SubjectDto> subjects;
}
