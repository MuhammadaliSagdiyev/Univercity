package uz.nt.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import uz.nt.project.dto.UnivercityDto;
import uz.nt.project.entity.Univercity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UnivercityMapper {
    UnivercityDto toDto(Univercity univercity);
    Univercity toEntity(UnivercityDto univercityDto);
}
