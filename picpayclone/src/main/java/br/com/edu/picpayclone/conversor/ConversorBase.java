package br.com.edu.picpayclone.conversor;

import java.util.ArrayList;
import java.util.List;

public abstract class ConversorBase<E, D>{

    public abstract D converterEntidadeParaDto(E entidade);
    public abstract E converterDtoParaEntidade(D dto);

    public List<D> converterEntidadeParaDtos(List<E> entidades){
        List<D> dtos = new ArrayList<>();
        entidades.forEach(entidade -> dtos.add(converterEntidadeParaDto(entidade)));
        return dtos;
    }

    public List<E> converterDtosPraEntidades(List<D> dtos){
        List<E> entidades = new ArrayList<>();
        dtos.forEach(dto -> entidades.add(converterDtoParaEntidade(dto)));
        return entidades;
    }
}
