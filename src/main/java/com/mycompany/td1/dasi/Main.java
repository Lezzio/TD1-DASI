/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td1.dasi;

import com.mycompany.td1.dasi.metier.modele.Client;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.mycompany.td1.dasi.dao.JpaUtil;
import com.mycompany.td1.dasi.metier.services.ClientDAO;
import java.util.List;

/**
 * @author aguigal
 */
public class Main {
    
    public static EntityManagerFactory emf;
    public static EntityManager em;
    
    public static void main(String[] args) {
        System.out.println("TD1 - DASI init");
        JpaUtil.init();
        /*
        emf = Persistence.createEntityManagerFactory("com.mycompany_TD1-DASI_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
        initialiserClients();
        */
        testerInscriptionClient();
    }
    public static void initialiserClients() {
        em.getTransaction().begin();
        Client client1 = new Client("Dupond", "Jean", "jd@gmail.com", "mdp1");
        Client client2 = new Client("Martin", "Alice", "am@gmail.com", "mdp2");
        em.persist(client1);
        em.persist(client2);
        System.out.println("Generated id = " + client1.getId());
        Client clientFetched = em.find(Client.class, 1L);
        System.out.println("Client fetched : " + clientFetched.getNom());
        em.flush();
        em.getTransaction().commit();
    }
    public static void testerInscriptionClient() {
        Client client1 = new Client("Dupond", "Jean", "jd@gmail.com", "mdp1");
        //ClientDAO.registerClient(client1);
        List<Client> clients = ClientDAO.listClients();
        clients.forEach((client -> System.out.println(client)));
    }
    
}