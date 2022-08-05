package br.com.lets.code.aula1.controller;

import br.com.lets.code.aula1.model.Cliente;
import br.com.lets.code.aula1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

@RestController
@RequestMapping("/client")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/list")
    public ResponseEntity<Iterable<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteRepository.findAll());
    }

    @PostMapping("/client")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> criarCliente(@Valid @RequestBody Cliente cliente) {
        if(!cliente.equals(null)){
            clienteRepository.save(cliente);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> atualizarCliente(@Valid @RequestBody Cliente clienteAtualizado, @PathVariable("id") Long id) {
        clienteAtualizado.setId(id);
        clienteRepository.save(clienteAtualizado);

        return  ResponseEntity.noContent().build();

    }

    @DeleteMapping("/delete/{id}")
    public void deletarCliente(@PathVariable("id") Long id){
       clienteRepository.deleteById(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getAllErrors()
                            .forEach(e -> {
                                String nome = ((FieldError)e).getField();
                                String messagemErro = e.getDefaultMessage();
                                erros.put(nome, messagemErro);
                            });
        return erros;

    }

}
