package org.HMB;

import org.HMB.dao.ClientCrudService;
import org.HMB.dao.PlanetCrudService;
import org.HMB.dao.TicketCrudService;
import org.HMB.dataBaseService.DatabaseInitPostgres;
import org.HMB.entity.Client;
import org.HMB.entity.Planet;
import org.HMB.entity.Ticket;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        new DatabaseInitPostgres().initDBPostgres();

        ClientCrudService clientCrudService = new ClientCrudService();
        Client client = new Client();
        client.setName("Tolya");
//        boolean isClient = clientCrudService.saveClient(client);
//        if (isClient){
//            System.out.println("new client: " + client + " create");
//        } else {System.out.println("new client: " + client + " not create");}

        Client getClient = clientCrudService.findClientByIdWithTickets(9L);
        System.out.println("Client - with tickets -----------");
        System.out.println("Client - " + getClient.toString());
        System.out.println("Client - " + getClient.getTickets().toString());
//        Client updateClient = new Client();
//        updateClient.setName("Jon");
//        updateClient.setId(16);
//        boolean isUpdateClient = clientCrudService.updateClient(updateClient);
//        if (isUpdateClient){
//            System.out.println("client: " + updateClient.getName() + " update");
//        } else {System.out.println("client: " + updateClient.getName() + " not update");}

        List<Client> allClients = clientCrudService.getAllClient();
        allClients.forEach(clients -> System.out.println("client list ==> " + clients));

//       clientCrudService.deleteClientById(17L);
//
//        System.out.println("======= new list Clients after delete one =========");
//
//        List<Client> allListClients = clientCrudService.getAllClient();
//        allListClients.forEach(clients -> System.out.println("client list ==> " + clients));

// Planet test CRUD service
        System.out.println("======= Planet test CRUD service =========");
        PlanetCrudService planetCrudService = new PlanetCrudService();
//        Planet planet = new Planet();
//        planet.setName("Uran");
//        planet.setId("URAN");
//        boolean isPlanet = planetCrudService.savePlanet(planet);
//        if (isPlanet){
//            System.out.println("new planet: " + planet + " save");
//        } else {System.out.println("new planet: " + planet + " not save");}

        Planet getPlanet = planetCrudService.findPlanetById("MARS");
        System.out.println("Planet = " + getPlanet);

//        Planet updatePlanet = new Planet();
//        updatePlanet.setName("Uranus");
//        updatePlanet.setId("URAN");
//        boolean isUpdatePlanet = planetCrudService.updatePlanet(updatePlanet);
//        if (isUpdatePlanet){
//            System.out.println("planet: " + updatePlanet.getName() + " update");
//        } else {System.out.println("planet: " + updatePlanet.getName() + " not update");}

        List<Planet> allPlanets = planetCrudService.getAllPlanets();
        allPlanets.forEach(planets -> System.out.println("planet ==> " + planets));

//        planetCrudService.deletePlanetById("URAN");
//
//        System.out.println("======= new list Planets after delete one =========");
//
//        List<Planet> allListPlanets = planetCrudService.getAllPlanets();
//        allListPlanets.forEach(planets -> System.out.println("planet ==> " + planets));
//
// Ticket test CRUD service
        System.out.println("======= Ticket test CRUD service =========");
        TicketCrudService ticketCrudService = new TicketCrudService();
        Ticket ticket = new Ticket();
        ticket.setClient(client);
        ticket.setCreatedAt(new Date());
        ticket.setFromPlanet(getPlanet);
        ticket.setToPlanet(planetCrudService.findPlanetById("MARS"));
        boolean newTicket = ticketCrudService.saveTicket(ticket);
        if (newTicket){
            System.out.println("new ticket: " + newTicket + " create");
        } else {System.out.println("new ticket: " + newTicket + " not create");}

        System.out.println("======= all Tickets =========");
        List<Ticket> allTickets = ticketCrudService.getAllTickets();
        allTickets.forEach(tickets -> System.out.println("ticket ==> " + tickets));

//        ticketCrudService.deleteTicket(6);
//        System.out.println("======= all Tickets after delet one =========");
//        List<Ticket> allListTickets = ticketCrudService.getAllTickets();
//        allListTickets.forEach(tickets -> System.out.println("ticket ==> " + tickets));
    }
}