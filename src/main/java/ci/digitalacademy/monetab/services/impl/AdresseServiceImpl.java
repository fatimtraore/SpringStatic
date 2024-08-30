package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Adresse;
import ci.digitalacademy.monetab.repositories.AdresseRepository;
import ci.digitalacademy.monetab.services.AdresseService;
import ci.digitalacademy.monetab.services.dto.AdressDTO;
import ci.digitalacademy.monetab.services.mappers.AdressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdresseServiceImpl implements AdresseService {

    private final AdresseRepository adresseRepository;

    @Override
    public AdressDTO save(AdressDTO adressDTO) {
        Adresse adresse = AdressMapper.toEntity(adressDTO);
        adresse = adresseRepository.save(adresse);
        return AdressMapper.toDto(adresse);
    }

    @Override
    public AdressDTO update(AdressDTO adressDTO) {
        return findOne(adressDTO.getId()).map(existingAdress->{
            existingAdress.setCountry(adressDTO.getCountry());
            existingAdress.setCity(adressDTO.getCity());
            return save(existingAdress);
        }).orElseThrow(()->new IllegalArgumentException());
    }

    @Override
    public Optional<AdressDTO> findOne(Long id) {
        return adresseRepository.findById(id).map(adresse -> {
            return AdressMapper.toDto(adresse);
        });
    }

    @Override
    public List<AdressDTO> findAll() {
        return adresseRepository.findAll().stream().map(adresse -> {
            return AdressMapper.toDto(adresse);
        }).toList();
    }

    @Override
    public void delete(Long id) {
        adresseRepository.deleteById(id);

    }
}
