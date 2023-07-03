package com.example.evac02LimayllaHans;

import java.lang.String;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/api/curso") // This means URL's start with /demo (after Application path)
public class CursoController {
    @Autowired // This means to get the bean called userRepository
    private CursoRepository CursoRepository;

    @PostMapping(path = "/nuevo") // Map ONLY POST Requests
    public @ResponseBody String addNewCurso(@RequestParam String name, @RequestParam Integer creditos) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Curso n = new Curso();
        n.setName(name);
        n.setCreditos(creditos);
        CursoRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/listar")
    public @ResponseBody Iterable<Curso> getAllCursos() {
        return CursoRepository.findAll();
    }

    // @GetMapping(path = "/ver/{id}")
    // public @ResponseBody User getById(@PathVariable("id") Integer id) {

    // return CursoRepository.findById(id).orElse(null);
    // }

    // @PutMapping(path = "/edit")
    // public @ResponseBody String ediCursos(@RequestParam Integer id, @RequestParam
    // String name,
    // @RequestParam Integer creditos) {
    // Curso curso = CursoRepository.findById(id).orElse(null);
    // if (curso != null) {
    // curso.setName(name);
    // curso.setCreditos(creditos);
    // CursoRepository.save(curso);
    // return "Editado";
    // }

    // return "Not Found";

    // }

    @DeleteMapping(path = "/eliminar")
    public @ResponseBody String deleteCurso(@RequestParam Integer id) {
        Curso curso = CursoRepository.findById(id).orElse(null);
        if (curso != null) {
            CursoRepository.delete(curso);
            return "Deleted";
        }
        return "Not Found";
    }

    // @GetMapping(path = "/report")
    // public @ResponseBody List<Map<String, Object>> getReport() {
    // String sql = "SELECT CONCAT(name, '==>', email) as reporte FROM user";
    // List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
    // return queryResult;

    // }

}