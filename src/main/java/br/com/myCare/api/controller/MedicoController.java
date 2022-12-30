package br.com.myCare.api.controller;

import br.com.myCare.api.medico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired //injeção de dependência
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size=15,sort ={"nome"} ) Pageable paginacao) { //a anotação @PageableDefault serve para passarmos
        return repository.findAll(paginacao).map(DadosListagemMedico::new);                                 // parametros de ordenção, caso não seja enviado na requisição http
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizaCadastroMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        repository.save(medico);
    }

//    @DeleteMapping("/{id}")
//    @Transactional
//    public void excluir(@PathVariable Long id){
//        repository.deleteById(id);
//    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }


}
