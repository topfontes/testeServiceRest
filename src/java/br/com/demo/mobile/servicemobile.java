/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.demo.mobile;

import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author marcos
 */
@Path("mobile")
public class servicemobile {

    @Path("olamundo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String heloWold() {
        return "Ola Mundo!";
    }

    @Path("login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String login(String json) {
        try {
            Autentication aut = new Gson().fromJson(json, Autentication.class);
            aut.setNome("José de Figueiredo Júnior");
            return new Gson().toJson(aut);
            
        } catch (Exception e) {
            return "Erro ao realizar o login";
        }

    }

    public class Autentication {

        /**
         * @return the user
         */
        public String getUser() {
            return user;
        }

        /**
         * @param user the user to set
         */
        public void setUser(String user) {
            this.user = user;
        }

        /**
         * @return the password
         */
        public String getPassword() {
            return password;
        }

        /**
         * @param password the password to set
         */
        public void setPassword(String password) {
            this.password = password;
        }

        private String user;
        private String password;
        private String nome;

        /**
         * @return the nome
         */
        public String getNome() {
            return nome;
        }

        /**
         * @param nome the nome to set
         */
        public void setNome(String nome) {
            this.nome = nome;
        }
    }
}
