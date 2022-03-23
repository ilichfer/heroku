package com.api.controller;

import java.text.ParseException;
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

import com.api.dto.CursoDto;
import com.api.model.Curso;
import com.api.model.Pago;
import com.api.service.interfaces.IPagoService;

@Controller
@RequestMapping
public class PagoController {
	@Autowired
	private IPagoService pagoService;

	List<Pago> pagoList;

	@GetMapping("/listarPagos")
	public String Cursos(HttpServletResponse response, Model model) {
		pagoList = pagoService.findAll();
		model.addAttribute("cursos", pagoList);
		return "cursos";
	}

	@PostMapping("/buscarPagosCurso")
	public String buscarPagosCurso(@RequestParam int idPersona, @RequestParam int idCurso, Model model) {

		pagoList = pagoService.findPagosByIdCurso(idPersona, idCurso);
		model.addAttribute("pagos", pagoList);
		return "pagos";

	}

	@PostMapping("/savePago")
	public String save(@ModelAttribute Pago pago) throws ParseException, com.sun.el.parser.ParseException {
		String url = "redirect:/404.html";
		if (pago != null) {
			Pago pagoSave = pagoService.save(pago);
			url = "redirect:/index2.html";
		}
		return url;
	}

	@PostMapping("/eliminarPago")
	public String deleteProductoById(@ModelAttribute Pago pago, HttpServletResponse response, Model model) {
		pagoService.delete(pago);
		return "redirect:/listar";

	}

	@PostMapping("/editarPago")
	public String editarCursoById(@ModelAttribute CursoDto curso, HttpServletResponse response, Model model)
			throws ParseException, com.sun.el.parser.ParseException {
		Curso cursoMostrar = new Curso();
//		pagoService.save(curso);
		System.out.println("fechaInicio para modificacion " + curso.getFechaInicio());
		System.out.println("fechaFin para modificacion " + curso.getFechaFin());
		cursoMostrar.setId(curso.getId());
//		cursoMostrar.setFechaInicio(pagoService.ParseFecha(curso.getFechaInicio()));
//		cursoMostrar.setFechaFin(pagoService.ParseFecha(curso.getFechaFin()));
		cursoMostrar.setNombreCurso(curso.getNombreCurso());
		cursoMostrar.setValorTotal(curso.getValorTotal());

//		curso.setFechaInicio(pagoService.formatFecha(curso.getFechaInicio()));
//		curso.setFechaFin(pagoService.formatFecha(curso.getFechaFin()));
		model.addAttribute("curso", curso);

		return "edit-curso";

	}

}