package mate.academy.springboot.datajpa.service.mapper;

public interface DtoRequestMapper<T, D> {
    D toModel(T request);
}
