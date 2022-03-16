package com.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.model.Inscripciones;
import com.api.model.Persona;
import com.api.repo.IPersonaRepo;
import com.api.repo.InscripcionRepo;
import com.api.service.interfaces.IPersonaService;


@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaRepo PersonaRepository;
	
	@Autowired
	private InscripcionRepo inscripcionesRepository;
	
	@Override
	public List<Persona> findAll() {

		return PersonaRepository.findAll();
	}

	@Override
	public Persona save(Persona cliente) {
	
		return PersonaRepository.save(cliente);
	}


	@Override
	public Optional<Persona> findProductoById(Integer id) {

		Optional<Persona> persona = PersonaRepository.findById(id);

		return persona;
	}

	@Override
	public Persona delete(Persona persona) {

		PersonaRepository.deleteById(persona.getId());

		return persona;
	}

	@Override
	public Persona buscarEmail(String email) {
		Persona per = new Persona();
		try {
			per= PersonaRepository.findPersonaByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return per;
		
		
//		StringBuilder sql = new StringBuilder();
//		Persona retorno = new Persona();
//		try {
//			sql.append("select * from persona " + "where email= '" + email + "'");
//
//			retorno = jdbcTemplate.query(sql.toString(), new ResultSetExtractor<Persona>() {
//				@Override
//				public Persona extractData(ResultSet rs) throws SQLException, DataAccessException {
//
//					while (rs.next())
//						return new Persona(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
//								rs.getInt("documento"), rs.getInt("telefono"), rs.getString("fechanacimiento"),
//								rs.getString("tipodocumento"), rs.getString("email"), rs.getString("password"));
//
//					return null;
//				}
//			});
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return retorno;
	}

	@Override
	public List<Persona> findAllByCurso(int idCurso) {

		return buscarPersonaByCurso(idCurso);

	}

	private List<Persona> buscarPersonaByCurso(Integer idcurso) {
//		StringBuilder sql = new StringBuilder();
//		Persona retorno = new Persona();
//		List<Persona> personaList = new ArrayList<Persona>();
//		try {
//			sql.append("select distinct p.* from persona p "
//						+ "join inscripciones i on p.id  = i.id_persona "					
//						+ "join curso c on i.id_curso = c.id " 
//						+ "where c.id =" + idcurso
//						+ "");
//
//			retorno = jdbcTemplate.query(sql.toString(), new ResultSetExtractor<Persona>() {
//				@Override
//				public Persona extractData(ResultSet rs) throws SQLException, DataAccessException {
//
//					while (rs.next())
//						personaList.add(new Persona(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
//								rs.getInt("documento"), rs.getInt("telefono"), rs.getString("fechanacimiento"),
//								rs.getString("tipodocumento"), rs.getString("email"), rs.getString("password")));
//
//					return null;
//				}
//			});
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return personaList;
		return null;
	}

	@Override
	public List<Persona> buscarTodosSinCurso(int idCurso) {

		return buscarPersonaSinCurso(idCurso);

	}

	private List<Persona> buscarPersonaSinCurso(Integer idcurso) {
//		StringBuilder sql = new StringBuilder();
//		Persona retorno = new Persona();
//		List<Persona> personaList = new ArrayList<Persona>();
//		try {
//			sql.append("select * from persona p " 
//					+ "where id not in ("
//					+ "select i.id_persona from inscripciones i " + 
//					"join curso c on i.id_curso = c.id " + 
//					"where i.id_curso =" + idcurso
//					+ ")");
//
//			retorno = jdbcTemplate.query(sql.toString(), new ResultSetExtractor<Persona>() {
//				@Override
//				public Persona extractData(ResultSet rs) throws SQLException, DataAccessException {
//
//					while (rs.next())
//						personaList.add(new Persona(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
//								rs.getInt("documento"), rs.getInt("telefono"), rs.getString("fechanacimiento"),
//								rs.getString("tipodocumento"), rs.getString("email"), rs.getString("password")));
//
//					return null;
//				}
//			});
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return personaList;
		return null;
	}

	@Override
	public void eliminarPersonaCurso(int idPersona,int idCurso) {

		eliminarPersonaConCurso(idPersona, idCurso);

	}

	private void eliminarPersonaConCurso(Integer idPersona,int idCurso) {

		
		Map<String, Object> parameters = new HashMap<>();
		try {
//				String query = "delete from inscripciones where id_persona = :idPersona"
//						+ " and id_curso = :idCurso";
//				parameters.put("idPersona", idPersona);
//				parameters.put("idCurso", idCurso);
//
//			jdbcTemplate.update(query, parameters);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void agregarPersonaCurso(int idPersona,int idCurso) {

		agregarPersonaConCurso(idPersona,idCurso);

	}

	private void agregarPersonaConCurso(Integer idPersona, int idCurso) {

		Map<String, Object> parameters = new HashMap<>();
		try {
//			String query = "update persona set id_curso = :idCurso where id = :idPersona";
//				parameters.put("idPersona", idPersona);
//				parameters.put("idCurso", idCurso);
//				
//			jdbcTemplate.update(query, parameters);
			
			Inscripciones inscripcion = new Inscripciones();
			inscripcion.setIdCurso(idCurso);
			inscripcion.setIdPersona(idPersona);
			
			inscripcionesRepository.save(inscripcion);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	

}
