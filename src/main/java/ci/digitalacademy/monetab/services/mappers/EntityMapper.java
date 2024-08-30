package ci.digitalacademy.monetab.services.mappers;

public interface EntityMapper<D, E> {

    D toDto(E entity);

    E toEntity(D dto);

}
