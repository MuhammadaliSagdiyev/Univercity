package uz.nt.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import uz.nt.project.dto.GroupDto;
import uz.nt.project.dto.ResponseDto;
import uz.nt.project.dto.ValidatorDto;
import uz.nt.project.entity.Group;
import uz.nt.project.helpers.GroupImpl;
import uz.nt.project.mapper.GroupMapper;
import uz.nt.project.repository.FakultetRepository;
import uz.nt.project.repository.GroupRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;
    private final FakultetRepository fakultetRepository;
    private final GroupMapper groupMapper;

    public ResponseDto<List<GroupImpl>> getGroupImpl(Integer groupId) {
        Optional<Group> group = groupRepository.findById(groupId);

        if (group.isEmpty()){
            return new ResponseDto<>(false, -9, "Bu ID lik group mavjud emas!", null);
        }

        List<GroupImpl> groups = groupRepository.getSredniyBallWithGroupId(groupId);

        return new ResponseDto<>(true, 0, "OK, group name - " + group.get().getName(), groups);
    }

}
