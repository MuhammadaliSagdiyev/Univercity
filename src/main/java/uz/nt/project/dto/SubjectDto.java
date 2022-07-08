package uz.nt.project.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.nt.project.entity.Group;
import uz.nt.project.entity.Journal;
import uz.nt.project.entity.Mark;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDto {
    private Integer id;
    private String name;
    private List<GroupDto> groups;
    private List<JournalDto> journals;
    private List<MarkDto> marks;
}
