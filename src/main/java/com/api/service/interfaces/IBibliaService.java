package com.api.service.interfaces;

import java.util.List;

import com.api.dto.BibliaDto;
import com.api.dto.CapituloDto;
import com.api.dto.LibroDto;
import com.api.dto.VersiculoDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


public interface IBibliaService {
	public BibliaDto findBible(String idioma) throws JsonMappingException, JsonProcessingException;
	
	public List<LibroDto> findBook(String idBible) throws JsonMappingException, JsonProcessingException;
	public List<CapituloDto> findChapters(String idBible,String idBook ) throws JsonMappingException, JsonProcessingException;
	public List<VersiculoDto> findIdVerses(String idBible,String idChapter ) throws JsonMappingException, JsonProcessingException;
	public VersiculoDto findVerse(String idBible,String idVerse) throws JsonMappingException, JsonProcessingException;
	public VersiculoDto findVerseDay() throws JsonMappingException, JsonProcessingException;
}
