package br.acacio.magelateapi.controler;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.acacio.magelateapi.model.ImagemModel;
import br.acacio.magelateapi.service.ServiceImagem;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/imagens")
@Slf4j
public class Imagens{
@Autowired
public ServiceImagem service;

@PostMapping
public ResponseEntity save(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("tags") List<String> tags
            ) throws IOException {

        log.info("Imagem recebida: name: {}, size: {}", file.getOriginalFilename(), file.getSize());
        ImagemModel imagem= ImagemModel.builder()
        .name(name)
        .file()
        .size(file.getSize())
        .tags(String.join(",", tags))
        .extension(file.getContentType())
        .build(); 
        service.save(imagem);

        return ResponseEntity.ok().build();
    }


}