package br.acacio.magelateapi.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.acacio.magelateapi.model.ImagemModel;
import br.acacio.magelateapi.model.RepositoryImagem;
import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class ServiceImagem implements ServiceInterface{

private final RepositoryImagem repository;

@Override
@Transactional
    public ImagemModel save(ImagemModel imagem){
      return  repository.save(imagem);
    }

}