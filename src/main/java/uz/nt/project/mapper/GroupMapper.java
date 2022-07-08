package uz.nt.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import uz.nt.project.dto.GroupDto;
import uz.nt.project.entity.Group;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GroupMapper {
    Group toEntity(GroupDto groupDto);
    GroupDto toDto(Group group);
}
