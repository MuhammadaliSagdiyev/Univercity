package uz.nt.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.nt.project.dto.FakultetDto;
import uz.nt.project.dto.ResponseDto;
import uz.nt.project.dto.UnivercityDto;
import uz.nt.project.dto.ValidatorDto;
import uz.nt.project.entity.Fakultet;
import uz.nt.project.entity.Univercity;
import uz.nt.project.mapper.FakultetMapper;
import uz.nt.project.mapper.UnivercityMapper;
import uz.nt.project.repository.FakultetRepository;
import uz.nt.project.repository.UnivercityRepository;

import javax.swing.text.html.Option;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UnivercityService {

    private final UnivercityRepository univercityRepository;
    private final FakultetRepository fakultetRepository;


    private final UnivercityMapper univercityMapper;
    private final FakultetMapper fakultetMapper;

    public ResponseDto<UnivercityDto> add(UnivercityDto univercityDto) {
        List<ValidatorDto> validatorDtos = new ArrayList<>();

        Univercity univercity = univercityMapper.toEntity(univercityDto);
        univercity.setId(null);

        if (univercity.getName() == null){
            validatorDtos.add(new ValidatorDto("name", "name null bo'lishi mumkin emas!"));
        }

        if (univercity.getAddress() == null){
            validatorDtos.add(new ValidatorDto("address", "address null bo'lishi mumkin emas!"));        }

        if (univercity.getOpenYear() == null){
            Calendar calendar = Calendar.getInstance();
            univercity.setOpenYear(calendar.getTime());
        }

        if (validatorDtos.isEmpty()){
            univercityRepository.save(univercity);
            return new ResponseDto<>(true, 0, "OK", univercityMapper.toDto(univercity));
        }
        else {
            return new ResponseDto<>(false, -10, "Validatsiyada xatolik", univercityMapper.toDto(univercity), validatorDtos);
        }
    }

    public ResponseDto<List<UnivercityDto>> getAll() {
        List<Univercity> univercities = univercityRepository.findAll();

        for (int i = 0; i < univercities.size(); i++){
            univercities.get(i).setFakultets(null);
        }

//        for (int i = 0; i < univercities.size(); i++) {
//            for (int i1 = 0; i1 < univercities.get(i).getFakultets().size(); i1++) {
//                univercities.get(i).getFakultets().get(i1).setUnivercity(null);
//            }
//        }

        List<UnivercityDto> univercityDtos = univercities.stream().map(u -> univercityMapper.toDto(u)).collect(Collectors.toList());

        return new ResponseDto<>(true, 0, "OK", univercityDtos);
    }

    public ResponseDto<UnivercityDto> get(Integer id) {
        Optional<Univercity> univercity = univercityRepository.findById(id);

        if (univercity.isEmpty()){
            return new ResponseDto<>(false, -9, "Bu ID lik Universitet tomilmadi!", null);
        }

        Univercity univercity1 = univercity.get();

        for (int i = 0; i < univercity1.getFakultets().size(); i++) {
            univercity1.getFakultets().get(i).setUnivercity(null);
            univercity1.getFakultets().get(i).setGroups(null);
        }

        return new ResponseDto<>(true, 0, "OK", univercityMapper.toDto(univercity1));
    }

    public ResponseDto<String> delete(Integer id) {
        Optional<Univercity> univercity = univercityRepository.findById(id);

        if (univercity.isEmpty()){
            return new ResponseDto<>(false, -9, "Bu ID lik Universitet tomilmadi!", null);
        }

        Univercity univercity1 = univercity.get();

        univercityRepository.delete(univercity1);
        return new ResponseDto<>(true, 0, "OK", univercity1.getName() + " universiteti o'chirildi!");
    }

}





