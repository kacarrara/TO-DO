package com.apptodo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.apptodo.enums.TarefaStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tarefa")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String tarefa;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private TarefaStatusEnum status;

    @Column(name = "data_tarefa", nullable = false, updatable = false)
    private LocalDate dataTarefa;

    @Column(name = "ultima_atualizacao")
    private LocalDate ultimaAtualizacao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToMany
    @JoinTable(
            name = "usuarios_tarefas",
            joinColumns = @JoinColumn(name = "tarefa_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> usuarios;

}
