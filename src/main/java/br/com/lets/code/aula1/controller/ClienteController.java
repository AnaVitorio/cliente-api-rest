package br.com.lets.code.aula1.controller;

import br.com.lets.code.aula1.DTO.ClienteDTO;
import br.com.lets.code.aula1.model.Cliente;
import br.com.lets.code.aula1.repository.ClienteRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    public ResponseEntity<Void> criarCliente(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> atualizarCliente(@RequestBody Cliente clienteAtualizado, @PathVariable("id") Long id) {
        Cliente cliente = clienteRepository.findById(id).get();
        cliente.setName(clienteAtualizado.getName());
        cliente.setAge(clienteAtualizado.getAge());
        cliente.setEmail(clienteAtualizado.getEmail());
        cliente.setNumber(clienteAtualizado.getNumber());

        return  ResponseEntity.noContent().build();

    }
    @DeleteMapping("/delete/{id}")
    public void deletarCliente(@PathVariable("id") Long id){
       clienteRepository.deleteById(id);
    }

}
