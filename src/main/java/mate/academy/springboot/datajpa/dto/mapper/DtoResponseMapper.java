package mate.academy.springboot.datajpa.dto.mapper;

public interface DtoResponseMapper<T, D> {
    T toResponseDto(D object);
}
