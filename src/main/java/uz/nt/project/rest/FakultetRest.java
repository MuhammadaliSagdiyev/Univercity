package uz.nt.project.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.nt.project.dto.FakultetDto;
import uz.nt.project.dto.ResponseDto;
import uz.nt.project.helpers.FakultetImpl;
import uz.nt.project.service.FakultetService;

import java.util.List;

@RestController
@RequestMapping("/fakultet")
@RequiredArgsConstructor
public class FakultetRest {

    private final FakultetService fakultetService;

    @PostMapping
    public ResponseDto<FakultetDto> add(@RequestBody FakultetDto fakultetDto){
        return fakultetService.add(fakultetDto);
    }

    @GetMapping
    public ResponseDto<List<FakultetImpl>> countGroup(@RequestParam Integer id){
        return fakultetService.countGroup(id);
    }

    @DeleteMapping("/{id}")
    public ResponseDto<String> delete(@PathVariable Integer id){
        return fakultetService.delete(id);
    }
}
