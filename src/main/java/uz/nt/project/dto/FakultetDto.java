package uz.nt.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FakultetDto {
    private Integer id;
    private String name;
    private UnivercityDto univercity;
    private List<GroupDto> groups;
}
