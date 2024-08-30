package ci.digitalacademy.monetab.services.mappers;

import ci.digitalacademy.monetab.models.Adresse;
import ci.digitalacademy.monetab.services.dto.AdressDTO;

public final class AdressMapper {

    private AdressMapper(){}

    public static AdressDTO toDto (Adresse adresse){
        AdressDTO adressDTO = new AdressDTO();
        adressDTO.setId(adresse.getId());
        adressDTO.setCity(adresse.getCity());
        adressDTO.setCountry(adresse.getCountry());
        adressDTO.setStreet(adresse.getStreet());
        return adressDTO;
    }

    public static Adresse toEntity(AdressDTO adressDTO){
        Adresse adresse = new Adresse();
        adresse.setId(adressDTO.getId());
        adresse.setCity(adressDTO.getCity());
        adresse.setCountry(adressDTO.getCountry());
        adresse.setStreet(adressDTO.getStreet());
        return adresse;
    }

}
