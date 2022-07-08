package uz.nt.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.nt.project.dto.FakultetDto;
import uz.nt.project.dto.ResponseDto;
import uz.nt.project.dto.ValidatorDto;
import uz.nt.project.entity.Fakultet;
import uz.nt.project.helpers.FakultetImpl;
import uz.nt.project.mapper.FakultetMapper;
import uz.nt.project.repository.FakultetRepository;
import uz.nt.project.repository.GroupRepository;
import uz.nt.project.repository.UnivercityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FakultetService {

    private final FakultetRepository fakultetRepository;
    private final UnivercityRepository univercityRepository;
    private final FakultetMapper fakultetMapper;



    public ResponseDto<FakultetDto> add(FakultetDto fakultetDto) {
        List<ValidatorDto> validatorDtos = new ArrayList<>();

        fakultetDto.setId(null);

        if (fakultetDto.getName() == null){
            validatorDtos.add(new ValidatorDto("name", "name null bo'lishi mumkin emas"));
        }
        if (fakultetDto.getUnivercity().getId() == null){
            validatorDtos.add(new ValidatorDto("UnivercityId", "Univercity id null bo'lishi mumkin emas!"));
        }

        boolean b = univercityRepository.existsById(fakultetDto.getUnivercity().getId());

        if (!b){
            validatorDtos.add(new ValidatorDto("UnivercityId", "Bunday Universitet topilmadi!"));
        }

        if (validatorDtos.isEmpty()){
            Fakultet fakultet = fakultetMapper.toEntity(fakultetDto);
            fakultetRepository.save(fakultet);
            return new ResponseDto<>(true, 0, "OK", fakultetMapper.toDto(fakultet));
        }
        return new ResponseDto<>(false, -10, "Validatsiyada hatolik", fakultetDto, validatorDtos);
    }


    public ResponseDto<List<FakultetImpl>> countGroup(Integer id) {
        Optional<Fakultet> fakultet = fakultetRepository.findById(id);

        if (fakultet.isEmpty()){
            return new ResponseDto<>(false, -9, "Bu ID lik Fakultet topilmadi!", null);
        }

        Fakultet fakultet1 = fakultet.get();


        return new ResponseDto<>(true, 0, fakultet1.getName(), fakultetRepository.getGroupCount(id));
    }


    public ResponseDto<String> delete(Integer id) {
        Optional<Fakultet> fakultet = fakultetRepository.findById(id);

        if (fakultet.isEmpty()){
            return new ResponseDto<>(false, -10, id +" ID lik fakultet topilmadi!", null);
        }

        Fakultet fakultet1 = fakultet.get();

        fakultetRepository.delete(fakultet1);
        return new ResponseDto<>(true, 0, "OK", fakultet1.getName() + " fakulteti o'chirildi!");
    }
}
