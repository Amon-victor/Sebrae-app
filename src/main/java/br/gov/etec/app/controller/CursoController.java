package br.gov.etec.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.etec.app.dtos.CursoDto;
import br.gov.etec.app.entity.Curso;
import br.gov.etec.app.repository.CursoRepository;
//import java.util.Map;
//import java.util.ArrayList;
//import java.util.HashMap;

//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

//import br.gov.etec.app.entity.Curso;

@RestController
public class CursoController {
	
	@Autowired
	private CursoRepository repository;
	
	 private static final Logger log = LoggerFactory.getLogger(CursoController.class);
	
	@RequestMapping("/listarcursos")
	public List<Curso> listarCursos(){
		log.info("listando todos cursos da base de dados");
		List<Curso> cursos = repository.findAll();
		for (Curso curso : cursos) {
			log.debug("Curso: " ,curso.toString());
		}
		return cursos;
	}
	
	
	
	@PostMapping
	@RequestMapping("/cadastrar")
	public void cadastrarCurso(@RequestBody CursoDto dto) {
		Curso curso = this.toDtoEntity(dto);
		repository.save(curso);
	}
	
	//Mapping
	private Curso toDtoEntity(CursoDto dto) {
		log.info("Cadastro do ", dto.toString());
		log.debug("Cadastro do ", dto.toString());
		Curso curso = new Curso();
		curso.setNome(dto.getNome());
		curso.setDescricao(dto.getDescricao());
		return curso;
	}
	
	
	// - private Map<Integer, Curso> curso;
	
	// -@RequestMapping(value = "/listacurso")
	// -ResponseEntity<List<Curso>> listaCurso(){
		
	// -	curso = new HashMap<Integer, Curso>();
		
	// -	Curso ds = new Curso();
	// -	ds.setId(1L);
	// -	ds.setNome("DEsenvolvimento de Software");
	// -	ds.setDescricao("Desenvolvimente de software em java");
	// -	curso.put(1,  ds);
		
	// -	return new ResponseEntity<List<Curso>>(new ArrayList<Curso>(curso.values()), HttpStatus.OK);
	// -}
	
	
}
