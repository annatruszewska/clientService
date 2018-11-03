package controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Client;

@ManagedBean
@SessionScoped
public class ClientController implements Serializable {  
   
    private List<Client> clients;
    private List<Client> filteredClients;

    private Client client = new Client();  

    public List<Client> getFilteredClients() {
        return filteredClients;
    }

    public void setFilteredClients(List<Client> filteredClients) {
        this.filteredClients = filteredClients;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

   
     public String insert(){   
       client.setUniqueId(String.valueOf(UUID.randomUUID()));
       client.setCreationDate(LocalDate.now());
       this.clients.add(client);
       filteredClients.clear();
       filteredClients.addAll(clients);
       this.client = new Client();
       return "index";   
   } 

     public void delete(Client client){
         this.clients.remove(client); 
         filteredClients.clear();
         filteredClients.addAll(clients);
        
     }  
    
      public List<Client> getClientsList(){
        return clients;
      } 
  
       public List<Client> findAll(){
      
       return clients;
   }   
              
       public ClientController() { 
      clients = new ArrayList();
      clients.add(new Client("Alice", "Cooper", "888 888 888", "singer")); 
      clients.add(new Client("Lars", "Urlich", "645 555 455", "guitarist")); 
       clients.add(new Client("Keanu", "Reeves", "555 644 446", "presiden"));
       filteredClients = new ArrayList<>();
       filteredClients.addAll(clients);
}

}
    

