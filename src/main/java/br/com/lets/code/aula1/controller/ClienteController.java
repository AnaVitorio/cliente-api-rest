package br.com.lets.code.aula1.controller;

import br.com.lets.code.aula1.model.Cliente;
import br.com.lets.code.aula1.service.ClienteService;
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

    private final ClienteService clienteService;
    

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @GetMapping("/list")
    public ResponseEntity<Iterable<Cliente>> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/list/client/{id}")
    public ResponseEntity<Cliente> listarClientePeloId(@PathVariable("id") long id){
        return clienteService.listarClientePeloId(id);
    }

    @GetMapping("/list/{vatNumber}")
    public ResponseEntity<Cliente> listarClientePeloVatNumber(@PathVariable("vatNumber") String vatNumber){
        return clienteService.listarClientePeloVatNumber(vatNumber);
    }

    @PostMapping("/client")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> criarCliente(@Valid @RequestBody Cliente cliente) {
        return clienteService.criarCliente(cliente);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> atualizarCliente(@Valid @RequestBody Cliente clienteAtualizado, @PathVariable("id") Long id) {
        return clienteService.atualizarCliente(clienteAtualizado, id);

    }

    @DeleteMapping("/delete/{id}")
    public void deletarCliente(@PathVariable("id") Long id){
       clienteService.deletarCliente(id);;
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
