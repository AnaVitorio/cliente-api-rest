package br.com.lets.code.aula1.service;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import br.com.lets.code.aula1.model.Cliente;
import br.com.lets.code.aula1.repository.ClienteRepository;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    
    public ResponseEntity<Iterable<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteRepository.findAll());
    }

    public ResponseEntity<Cliente> listarClientePeloId(Long id){
        return ResponseEntity.ok(clienteRepository.findById(id).get());
    }

    public ResponseEntity<Cliente> listarClientePeloVatNumber(String vatNumber){
        List<Cliente> clienteProcurado = StreamSupport.stream(clienteRepository.findAll().spliterator(), false)
            .filter(cliente -> cliente.getVatNumber().equals(vatNumber))
            .collect(Collectors.toList());
        
        return ResponseEntity.ok(clienteProcurado.get(0));

    }

    public ResponseEntity<Void> criarCliente(Cliente cliente) {
        if(!cliente.equals(null)){
            clienteRepository.save(cliente);
        }
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Void> atualizarCliente(Cliente clienteAtualizado, Long id) {
        clienteAtualizado.setId(id);
        clienteRepository.save(clienteAtualizado);

        return  ResponseEntity.noContent().build();

    }

    public void deletarCliente(Long id){
       clienteRepository.deleteById(id);
    }

}
