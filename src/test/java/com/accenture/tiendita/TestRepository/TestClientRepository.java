package com.accenture.tiendita.TestRepository;

import com.accenture.tiendita.Entities.Client;
import com.accenture.tiendita.Repository.ClientRepository;
import junit.framework.TestCase;
import org.springframework.stereotype.Component;

@Component
public class TestClientRepository extends TestCase {

    private static ClientRepository clientRepository;
    private static Client client = new Client(3, "Dorias", "Av. Siempre Viva", 5645);


    private void root(){
        clientRepository = new ClientRepository();

    }

    public void testFindClient(){
        root();
        assertEquals(null, clientRepository.findById(0));
    }

    public void testAddClient(){
        root();
        assertNotNull("No se puede agregar el cliente se necesita un objeto de tipo Client", clientRepository.addClient(client));
    }

    public void testFindClientThree(){
        root();
        assertEquals(client, clientRepository.findById(3));
    }

    public void testDeleteClientNotExist(){
        root();
        assertNotNull("El cliente no existe", clientRepository.deleteClient(3));
    }

    public void testDeleteClientExist(){
        root();
        assertNotNull("El cliente no existe", clientRepository.deleteClient(2));
    }


}
