package com.api.controller;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.BibliaDto;
import com.api.dto.LibroDto;
import com.api.dto.VersiculoDto;
import com.api.service.interfaces.IBibliaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@RestController
@RequestMapping
public class BibliaController {

	@Autowired
	private IBibliaService bibliaService;



	@GetMapping("/biblia/{idioma}")
	public String biblia(HttpServletResponse response,@PathVariable String idioma, Model model) throws JsonMappingException, JsonProcessingException {
		
		BibliaDto biblia = bibliaService.findBible(idioma);
		model.addAttribute("biblia", biblia);
		return "personas";
	}
	
	@GetMapping("/libros/{lib}")
	public String libros(HttpServletResponse response,@PathVariable String lib, Model model) throws JsonMappingException, JsonProcessingException {
		
		List<LibroDto> libros = bibliaService.findBook(lib);
		model.addAttribute("libros", libros);
		return "personas";
	}
	
	@GetMapping("/capitulos/{cap}")
	public String capitulos(HttpServletResponse response,@PathVariable String lib, Model model) throws JsonMappingException, JsonProcessingException {
		
		List<LibroDto> capitulos = bibliaService.findBook(lib);
		model.addAttribute("capitulos", capitulos);
		return "personas";
	}
	
	@GetMapping("/versiculos/{ver}")
	public String versiculos(HttpServletResponse response,@PathVariable String ver, Model model) throws JsonMappingException, JsonProcessingException {
		
		BibliaDto biblia = bibliaService.findBible(ver);
		model.addAttribute("biblia", biblia);
		return "personas";
	}
	
	@GetMapping("/versiculoDia")
	public void versiculoDia(HttpServletResponse response, Model model) throws JsonMappingException, JsonProcessingException {
		

		VersiculoDto versiculo = bibliaService.findVerseDay();
		model.addAttribute("versiculo", versiculo);
//		return "index2";
	}

	
}
