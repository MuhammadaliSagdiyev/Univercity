package uz.nt.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.nt.project.entity.Fakultet;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnivercityDto {
    private Integer id;
    private String name;
    private String address;
    private Date openYear;
    private List<FakultetDto> fakultets;
}
