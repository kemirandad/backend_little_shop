package com.accenture.tiendita.Repository;

import com.accenture.tiendita.Entities.Client;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ClientRepository {

    private static int userCounter = 2;

    private static List<Client> clients = new ArrayList<>();
    static {
        clients.add(new Client(1, "user_one", "carrera 11 #14-08", 12345));
        clients.add(new Client(2, "user_two", "calle 11 #14-08", 1234567));
    }

    /**
     * Return the registered clients
     * @return Clients list
     */
    public List<Client> findAll(){
        return clients;
    }

    /**
     * Register a client in the data structure
     * @param client
     * @return client
     */
    public Client addClient(Client client){
        if (client.getIdClient().equals((null))){
            client.setIdClient(++userCounter);
        }
        clients.add(client);
        return client;
    }

    /**
     * Return the client founded in list clients
     * @param id
     * @return client
     */
    public Client findById(int id){
        for (Client client: clients) {
            if (client.getIdClient() == id){
                return client;
            }
        }
        return null;
    }

    /**
     * Remove a client from list client
     * @param id
     */
    public Client deleteClient(int id){
        Iterator<Client> iterator = clients.iterator();
        while (iterator.hasNext()){
            Client client = iterator.next();
            if (client.getIdClient() == id){
                iterator.remove();
                return client;
            }
        }
        return null;
    }


}
