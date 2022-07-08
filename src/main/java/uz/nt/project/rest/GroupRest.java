package uz.nt.project.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.nt.project.dto.GroupDto;
import uz.nt.project.dto.ResponseDto;
import uz.nt.project.entity.Group;
import uz.nt.project.helpers.GroupImpl;
import uz.nt.project.service.GroupService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupRest {

    private final GroupService groupService;

    @GetMapping("/{groupId}")
    public ResponseDto<List<GroupImpl>> getGroupImpl(@PathVariable Integer groupId){
        return groupService.getGroupImpl(groupId);
    }

}
