package mate.academy.springboot.datajpa.dto.mapper;

public interface DtoRequestMapper<T, D> {
   D toModel(T request);
}
