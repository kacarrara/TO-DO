package com.apptodo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.apptodo.model.Tarefa;
import com.apptodo.service.TarefaService;

@RestController
@CrossOrigin
@RequestMapping("/app/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping("/todas")
    public List<Tarefa> findAll() {
        return tarefaService.buscarTodasAsTarefas();
    }

    @GetMapping("/buscar/{id}")
    public Tarefa findTarefa(@PathVariable int id) {
        return tarefaService.buscarUmaTarefa(id);
    }

    @PostMapping("/salvar")
    public void salvarTarefa(@RequestBody Tarefa tarefa) {
        tarefaService.save(tarefa);
    }

    @GetMapping("/fazer/{id}")
    public void fazerTarefa(@PathVariable int id) {
        tarefaService.alterarStatusFazendoTarefa(id);
    }

    @GetMapping("/finalizar/{id}")
    public void finalizarTarefa(@PathVariable int id) {
        tarefaService.finalizarTarefa(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteTarefa(@PathVariable int id) {
        tarefaService.delete(id);
    }

    @GetMapping("/por-categorias/{idCategoria}")
    public List<Tarefa> findByCategoria(@PathVariable(value = "idCategoria") Integer idCategoria) {
        return tarefaService.findByCategoria(idCategoria);
    }

    @GetMapping("/por-usuarios/{idUsuario}")
    public List<Tarefa> findByUsuarios(@PathVariable(value = "idUsuario") Integer idUsuario) {
        return tarefaService.findByUsuarios(idUsuario);
    }

    @GetMapping("/por-data")
    public List<Tarefa> findByUsuarios(@PathParam(value = "dataInicial") String dataInicial, @PathParam("dataFinal") String dataFinal) {
        return tarefaService.findByDataInicialAndDataFinal(dataInicial, dataFinal);
    }
    
    @GetMapping("/cadastrarNovaTarefa")
	public ModelAndView cadastraNovaTarefa() {
		ModelAndView mView = new ModelAndView("tarefa/cadastraNovaTarefa");
		mView.addObject("tarefa", new Tarefa());
		return mView;
	}
    

    @PutMapping("/alteraTarefa")
	public ResponseEntity<Tarefa> alteraTarefantity(@RequestBody Tarefa Tarefa) {
		Tarefa novoTarefa = TarefaService.salvarAlteracao(Tarefa);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoTarefa);
	}
    
   
	
}
