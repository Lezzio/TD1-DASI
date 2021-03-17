/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td1.dasi.metier.services;

import com.mycompany.td1.dasi.dao.JpaUtil;
import com.mycompany.td1.dasi.metier.modele.Client;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author aguigal
 */
public class ClientDAO {
    
    public static void registerClient(Client client) {
        try {
            JpaUtil.creerContextePersistance();
            JpaUtil.ouvrirTransaction();
            JpaUtil.sauvegarder(client);
            JpaUtil.validerTransaction();
            System.out.println("> Succès inscription");
            System.out.println(client.toString());
        
        } catch(Exception e) {
            System.out.println("> Echec d'inscription");
            System.out.println(client.toString());
        }
    }
    public static void getClient(Long id) {
        try {
            JpaUtil.creerContextePersistance();
            JpaUtil.ouvrirTransaction();
            Client client = (Client) JpaUtil.trouver(Client.class, id);
            System.out.println(client.toString());
            JpaUtil.validerTransaction();
        } catch(Exception e) {
            System.out.println("> Echec pour trouver le client");
        }
    }
    public static List<Client> listClients() {
        try {
            JpaUtil.creerContextePersistance();
            JpaUtil.ouvrirTransaction();
            List<Client> clients = (List<Client>)(List<?>) JpaUtil.trouverListe(Client.class);
            System.out.println("Clients = " + clients);
            JpaUtil.validerTransaction();
            return clients;
        } catch(Exception e) {
            System.out.println("> Echec pour trouver la liste");
        }
        return null;
    }
    
}