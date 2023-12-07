package model;

import user.User;

import java.util.List;

public class ModelData {
    private List<User> users;
    private List<User> deletedUsers;
    private User activeUser;
    private boolean displayDeletedUserList;

    public boolean isDisplayDeletedUserList() {
        return displayDeletedUserList;
    }

    public void setDisplayDeletedUserList(boolean displayDeletedUserList) {
        this.displayDeletedUserList = displayDeletedUserList;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public List<User> getDeletedUsers() {
        return deletedUsers;
    }

    public void setDeletedUsers(List<User> deletedUsers) {
        this.deletedUsers = deletedUsers;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
