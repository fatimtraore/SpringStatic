package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.models.Adresse;
import ci.digitalacademy.monetab.models.FicheNote;
import ci.digitalacademy.monetab.services.dto.AdressDTO;

import java.util.List;
import java.util.Optional;

public interface AdresseService {

    AdressDTO save(AdressDTO adressDTO);

    AdressDTO update(AdressDTO adressDTO);

    Optional<AdressDTO> findOne(Long id);

    List<AdressDTO> findAll();

    void delete(Long id);
}
