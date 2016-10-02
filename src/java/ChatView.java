/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Falbe
 */
package org.primefaces.showcase.push.chat;

import EntityBeans.Users;
import java.io.Serializable;
import java.util.List;
import org.primefaces.context.RequestContext;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import query.UsersController;

@ManagedBean
@ViewScoped
public class ChatView implements Serializable {
 private String username;
    private String password;
    private int type = -10;
    private UsersController uController = new UsersController();
    private List<Users> usersList;

    //private final PushContext pushContext = PushContextFactory.getDefault().getPushContext();
    private final EventBus eventBus = EventBusFactory.getDefault().eventBus();

    @ManagedProperty("#{chatUsers}")
    private Users users;

    private String privateMessage;

    private String globalMessage;

    private boolean loggedIn;

    private String privateUser;

    private final static String CHANNEL = "/{room}/";

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getPrivateUser() {
        return privateUser;
    }

    public void setPrivateUser(String privateUser) {
        this.privateUser = privateUser;
    }

    public String getGlobalMessage() {
        return globalMessage;
    }

    public void setGlobalMessage(String globalMessage) {
        this.globalMessage = globalMessage;
    }

    public String getPrivateMessage() {
        return privateMessage;
    }

    public void setPrivateMessage(String privateMessage) {
        this.privateMessage = privateMessage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void sendGlobal() {
        eventBus.publish(CHANNEL + "*", username + ": " + globalMessage);

        globalMessage = null;
    }

    public void sendPrivate() {
        eventBus.publish(CHANNEL + privateUser, "[PM] " + username + ": " + privateMessage);

        privateMessage = null;
    }

    public void login() {

        usersList = uController.findUsersEntities();
        Users user = uController.login(username, password, type);
    }

    public void disconnect() {
        //remove user and update ui
        
        
        //reset state
        loggedIn = false;
        username = null;
        password = null;
        type = -10;
        RequestContext.getCurrentInstance().update("form:users");

        //push leave information
        eventBus.publish(CHANNEL + "*", username + " left the channel.");

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
    }
}
