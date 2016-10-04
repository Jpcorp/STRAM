package com.yousoft.stram.domain.application;

import com.yousoft.stram.domain.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jguinart
 */
public class UserList implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private List<User> users;

    public UserList() {
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
}
