package com.api.controller;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.model.Persona;
import com.api.service.interfaces.IPersonaService;


@Controller
@RequestMapping
public class personaController {

	@Autowired
	private IPersonaService personaService;

	List<Persona> personasList;

	@GetMapping("/listar")
	public String personas(HttpServletResponse response, Model model) {
		personasList = personaService.findAll();
		model.addAttribute("personas", personasList);
		return "personas";
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Object> getProductoById(@PathVariable Integer id) {

		return ResponseEntity.ok(personaService.findProductoById(id));

	}

	@PostMapping("/save")
	public String save(@ModelAttribute Persona persona) {
		Persona per = personaService.buscarEmail(persona.getEmail());
		String url = "redirect:/404.html";
		if (per.getEmail() == null) {
			Persona personaSave = personaService.save(persona);
			url = "redirect:/index2.html";
		}
		return url;
	}

	@PostMapping("/eliminar")
	public String deleteProductoById(@ModelAttribute Persona persona, HttpServletResponse response,
			Model model) {
		persona.setId(persona.getId());
		personaService.delete(persona);
		return "redirect:/listar";

	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute Persona persona, HttpServletResponse response, Model model) {
		Persona per = personaService.buscarEmail(persona.getEmail());
		String url = "redirect:/404.html";
		if (per != null
				&& (persona.getEmail().equals(per.getEmail()) && persona.getPassword().equals(per.getPassword()))) {
			url = "redirect:/index2.html";
		}
		return url;
	}
	
	@PostMapping("/personasCurso")
	public String personasCurso(@RequestParam int idCurso,@RequestParam String nombreCurso,
			Model model) {
		personasList = personaService.findAllByCurso( idCurso);
		model.addAttribute("personas", personasList);
		model.addAttribute("idCurso", idCurso);
		model.addAttribute("nombreCurso", nombreCurso);
		model.addAttribute("msj", "Personas asociadas al curso: " + nombreCurso);
		model.addAttribute("titulo", "Lista de Personas inscritas");
		model.addAttribute("add", false);
		model.addAttribute("delete", true);
		return "personasCurso";
	}
	
	@PostMapping("/buscarPersonasSinCurso")
	public String buscarPersonasSinCurso(@RequestParam int idCurso,@RequestParam String nombreCurso,
			Model model) {
		personasList = personaService.buscarTodosSinCurso(idCurso);
		model.addAttribute("personas", personasList);
		model.addAttribute("msj", "Personas las cuales se puede agregar al curso: " + nombreCurso);
		model.addAttribute("titulo", "Lista de Personas no inscritas");
		model.addAttribute("add", true);
		model.addAttribute("delete", false);
		model.addAttribute("nombreCurso",nombreCurso);
		model.addAttribute("idCurso", idCurso);
		return "personasCurso";
	}
	
	@PostMapping("/eliminarPersonasCurso")
	public String eliminarPersonasCurso(@RequestParam int idPersona,@RequestParam int idCurso,@RequestParam String nombreCurso,
		Model model) {
		personaService.eliminarPersonaCurso(idPersona,idCurso);
		personasList = personaService.findAllByCurso( idCurso);
		model.addAttribute("personas", personasList);
		model.addAttribute("msj", "Personas asociadas al curso: " + nombreCurso);
		model.addAttribute("titulo", "Lista de Personas inscritas");
		model.addAttribute("add", false);
		model.addAttribute("delete", true);
		return "personasCurso";
	}
	
	@PostMapping("/agregarPersonasCurso")
	public String AgregarPersonasCurso(@RequestParam int idPersona,@RequestParam int idCurso,@RequestParam String nombreCurso,
			Model model) {
		personaService.agregarPersonaCurso(idPersona,idCurso);
		personasList = personaService.findAllByCurso( idCurso);
		model.addAttribute("personas", personasList);
		model.addAttribute("msj", "Personas asociadas al curso: " + nombreCurso);
		model.addAttribute("titulo", "Lista de Personas inscritas");
		model.addAttribute("add", false);
		model.addAttribute("delete", true);
		return "personasCurso";
	}

}
