package com.unexus.minegocio.domain.service;


import com.unexus.minegocio.persitence.crud.ClienteCRUDRepository;
import com.unexus.minegocio.persitence.entity.Cliente;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;


class ClientServiceTest {

    @Mock
    private ClienteCRUDRepository clienteCRUDRepository;
    @InjectMocks
    private ClientService clienteService;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
    Cliente cliente = Cliente.builder()
            .idCliente(1234567)
            .tipoIdentificacion("DNI")
            .numeroIdentificacion("128764567")
            .nombres("Juan Jose Paso")
            .correo("ej@mail.com")
            .celular("23454569876")
            .build();
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("Debe mostrar listado de clientes")
    @Test
    void getAll() {
        Cliente cliente1 = Cliente.builder()
                .idCliente(1234567)
                .tipoIdentificacion("DNI")
                .numeroIdentificacion("1234567")
                .nombres("Nombre de prueba")
                .correo("email@mail.com")
                .celular("23454567")
                .build();

        clienteCRUDRepository.save(cliente);
        clienteCRUDRepository.save(cliente1);


        List <Cliente> listaClientes = (List<Cliente>) clienteCRUDRepository.findAll();

        assertThat(listaClientes).isNotNull();
        assertThat(listaClientes.size()).isEqualTo(2);
    }

    @DisplayName("Debe encontrar el cliente por el id")
    @Test
    void getClient(long clientId) {

        clienteCRUDRepository.save(cliente);

        Optional<Cliente> clienteGuardado = clienteCRUDRepository.findById(cliente.getId());
        assertThat(clienteGuardado).isNotNull();
        assertThat(clienteGuardado).isEqualTo(cliente.getId());
    }

    @DisplayName("Debe guardar un nuevo cliente")
    @Test
    void save() {

        clienteCRUDRepository.save(cliente);

        Optional<Cliente> clienteGuardado = clienteCRUDRepository.findById(cliente.getId());
        assertThat(clienteGuardado).isNotNull();
        assertThat(clienteGuardado).isEqualTo(cliente.getId());

    }

    @DisplayName("Debe eliminar un cliente")
    @Test
    void delete() {
        clienteCRUDRepository.save(cliente);

        clienteCRUDRepository.deleteById(cliente.getId());
        Optional<Cliente> clienteOptional = clienteCRUDRepository.findById(cliente.getId());

        assertThat(clienteOptional).isEmpty();
    }

    @DisplayName("Debe actualizar el recurso")
    @Test
    void update() {
        clienteCRUDRepository.save(cliente);

        Optional<Cliente> clienteGuardado = clienteCRUDRepository.findById(cliente.getId());
        clienteGuardado.setCelular("12111211112");

        Cliente clienteActualizado = clienteCRUDRepository.save(clienteGuardado);
        assertThat(clienteActualizado.getCelular()).isEqualTo("12111211112");

    }
}