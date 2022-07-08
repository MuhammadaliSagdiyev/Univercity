package uz.nt.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import uz.nt.project.dto.FakultetDto;
import uz.nt.project.entity.Fakultet;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FakultetMapper {
    Fakultet toEntity(FakultetDto fakultetDto);
    FakultetDto toDto(Fakultet fakultet);
}
