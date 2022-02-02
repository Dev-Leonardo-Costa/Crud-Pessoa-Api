package br.com.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.crud.model.Pessoa;
import br.com.crud.servico.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService services;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pessoa> buscarTodasPessoas(){
        return services.buscarTodos();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Pessoa buscarPorId(@PathVariable("id") Long id ){
        return services.buscarPorId(id);
    }
    
    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST,
     consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Pessoa criar(@RequestBody Pessoa pessoa){
        return services.criarPessoa(pessoa);
    }

    @RequestMapping(method = RequestMethod.PUT,
    consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
   public Pessoa atualizar(@RequestBody Pessoa pessoa){
       return services.atualizarPessoa(pessoa);
   }
   
   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   public void deleta(@PathVariable("id") Long id){
      services.deletarPessoa(id);
   }
    
    
    
}
