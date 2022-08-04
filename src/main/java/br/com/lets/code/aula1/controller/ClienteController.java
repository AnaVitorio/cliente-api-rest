package br.com.lets.code.aula1.controller;

import br.com.lets.code.aula1.DTO.ClienteDTO;
import br.com.lets.code.aula1.model.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClienteController {

    @GetMapping("/list")
    public List<Cliente> listarClientes() {
        Cliente cliente = new Cliente("João", 20, "61999999999", "joão@gmail.com");
        List<Cliente> listaDeClientes = new ArrayList<>();
        listaDeClientes.add(cliente);
        return listaDeClientes;
    }

    @PutMapping("/{id}")
    public void atualizarCliente() {

    }

    @PostMapping("/client")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> criarCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/cadastrarPrimeirosClientes")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarListaDeClintes(){
        List<Cliente> listaDeClientes = new ArrayList<>();
        Cliente cliente1 = new Cliente("Maria", 21, "6199999999", "maria123@gmail.com");
        Cliente cliente2 = new Cliente("João", 35, "6198888888", "joao321@gmail.com");
        listaDeClientes.add(cliente1);
        listaDeClientes.add(cliente2);

    }


    @DeleteMapping("/{id}")
    public void deletarCliente() {

    }




}
