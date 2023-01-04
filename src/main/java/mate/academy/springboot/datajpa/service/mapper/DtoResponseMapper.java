package mate.academy.springboot.datajpa.service.mapper;

public interface DtoResponseMapper<T, D> {
    T toResponseDto(D object);
}
