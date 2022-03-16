package com.api.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dto.CursoDto;
import com.api.model.Curso;
import com.api.repo.ICursoRepo;
import com.api.service.interfaces.ICursoService;
import com.sun.el.parser.ParseException;

@Service
public class CursoServiceImpl implements ICursoService {

	@Autowired
	private ICursoRepo cursoRepository;
	
	List<Curso> listaCursos = new ArrayList<>();

	@Override
	public List<Curso> findAll() {

		return cursoRepository.findAll();

	}

	@Override
	public Curso save(CursoDto curso) throws java.text.ParseException, ParseException {
		Curso cursoSave = new Curso();
		
		cursoSave.setFechaFin(curso.getFechaFin());
		cursoSave.setFechaInicio(curso.getFechaInicio());
		cursoSave.setId(curso.getId());
		cursoSave.setNombreCurso(curso.getNombreCurso());
		cursoSave.setValorTotal(curso.getValorTotal());
		
		return cursoRepository.save(cursoSave);
	}

	@Override
	public Optional<Curso> findProductoById(Integer id) {

		Optional<Curso> curso = cursoRepository.findById(id);

		return curso;
	}

	@Override
	public Curso delete(Curso curso) {

		cursoRepository.deleteById(curso.getId());
		
		return curso;
	}
	
	@Override
    public Date ParseFecha(String fecha) throws java.text.ParseException, ParseException
    {
    	fecha = fecha.replace("-", "/");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        fechaDate = formato.parse(fecha);
        return fechaDate;
    }

	@Override
	public String formatFecha(String fecha) throws java.text.ParseException, ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
//		fecha = fecha.replace("-", "/");
//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        fechaDate = dateFormat.parse(fecha);
		
		Date date = new Date();
		String dateToStr = dateFormat.format(fechaDate);
		System.out.println("fechaInicio  formateada " + dateToStr);
		return dateToStr;
	}

}
