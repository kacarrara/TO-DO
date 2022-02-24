package com.apptodo.service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import javax.validation.ValidationException;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.apptodo.enums.TarefaStatusEnum;
import com.apptodo.model.Categoria;
import com.apptodo.model.Tarefa;
import com.apptodo.model.Usuario;
import com.apptodo.repository.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private UsuarioService usuarioService;

    static final ValidationException TAREFA_NAO_ENCONTRADA = new ValidationException("Tarefa não encontrada");

    public void save(Tarefa tarefa) {
        if (isNovaTarefa(tarefa)) {
            tarefa.setStatus(TarefaStatusEnum.ABERTA);
            tarefa.setDataTarefa(LocalDate.now());
        }
        tarefa.setUltimaAtualizacao(LocalDate.now());
        tarefaRepository.save(tarefa);
    }

    public void alterarStatusFazendoTarefa(int id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> TAREFA_NAO_ENCONTRADA);
        if (!isNovaTarefa(tarefa)) {
            tarefa.setStatus(TarefaStatusEnum.FAZENDO);
            tarefa.setUltimaAtualizacao(LocalDate.now());
        }
        tarefaRepository.save(tarefa);
    }

    public void finalizarTarefa(int id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> TAREFA_NAO_ENCONTRADA);
        if (!isNovaTarefa(tarefa)) {
            tarefa.setStatus(TarefaStatusEnum.FINALIZADA);
            tarefa.setUltimaAtualizacao(LocalDate.now());
        }
        tarefaRepository.save(tarefa);
    }

    public boolean isNovaTarefa(Tarefa tarefa) {
        return ObjectUtils.isEmpty(tarefa.getId());
    }

    public List<Tarefa> buscarTodasAsTarefas() {
        return tarefaRepository.findAll();
    }

    public Tarefa buscarUmaTarefa(int id) {
        return tarefaRepository.findById(id)
            .orElseThrow(() -> TAREFA_NAO_ENCONTRADA);
    }

    public void delete(int id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> TAREFA_NAO_ENCONTRADA);
        tarefaRepository.delete(tarefa);
    }

    public List<Tarefa> findByCategoria(Integer idCategoria) {
        Categoria categoria = categoriaService.buscarUmaCategoria(idCategoria);
        return tarefaRepository.findByCategoria(categoria);
    }

    public List<Tarefa> findByUsuarios(Integer idUsuario) {
        Usuario usuario = usuarioService.buscarUmUsuario(idUsuario);
        return tarefaRepository.findByUsuarios(Collections.singletonList(usuario));
    }

    public List<Tarefa> findByDataInicialAndDataFinal(String dataInicial, String dataFinal) {
        return tarefaRepository.findByDataTarefaBetween(LocalDate.parse(dataInicial), LocalDate.parse(dataFinal));
    }
    public void excluir(Integer id) {
		tarefaRepository.deleteById(id);	
}
    public Tarefa salvarAlteracao(Tarefa tarefaAlterada) throws ObjectNotFoundException {
		Tarefa tarefa = buscarPorID(tarefaAlterada.getId());
		tarefa.setId(tarefaAlterada.getId());
		tarefa.setCategoria(tarefaAlterada.getCategoria());
		tarefa.setDataTarefa(tarefaAlterada.getDataTarefa());
		tarefa.setStatus(tarefaAlterada.getStatus());
		tarefa.setTarefa(tarefaAlterada.getTarefa());
		tarefa.setUltimaAtualizacao(tarefaAlterada.getUltimaAtualizacao());
		return tarefa;
	}

	private Tarefa buscarPorID(Integer id) {
				return null;
	}

    
}
