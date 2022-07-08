package uz.nt.project.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.nt.project.dto.ResponseDto;
import uz.nt.project.dto.UnivercityDto;
import uz.nt.project.service.UnivercityService;

import java.util.List;

@RestController
@RequestMapping("/univercity")
@RequiredArgsConstructor
public class UnivercityRest {

    private final UnivercityService univercityService;

    @PostMapping
    public ResponseDto<UnivercityDto> add(@RequestBody UnivercityDto univercityDto){
        return univercityService.add(univercityDto);
    }

    @GetMapping
    public ResponseDto<List<UnivercityDto>> getAll(){
        return univercityService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseDto<UnivercityDto> get(@PathVariable Integer id){
        return univercityService.get(id);
    }

    @DeleteMapping("/{id}")
    public ResponseDto<String> delete(@PathVariable Integer id){
        return univercityService.delete(id);
    }

}
