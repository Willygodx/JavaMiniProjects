package model;

import user.User;
import model.service.UserService;
import model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model{
    private UserService userService = new UserServiceImpl();
    private ModelData modelData = new ModelData();
    private List<User> deletedUsers;
    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
        List<User> users = getAllUsers();
        modelData.setUsers(users);
    }

    @Override
    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        List<User> deletedUsers = userService.getAllDeletedUsers();
        modelData.setUsers(deletedUsers);
    }
    @Override
    public void loadUserById(long userId) {
        modelData.setDisplayDeletedUserList(false);
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        modelData.setDisplayDeletedUserList(false);
        userService.deleteUser(id);
        List<User> users = getAllUsers();
        modelData.setUsers(users);
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name, id, level);
        List<User> users = getAllUsers();
        modelData.setUsers(users);
    }

    private List<User> getAllUsers() {
        List<User> allUsers = userService.getUsersBetweenLevels(1, 100);
        allUsers = userService.filterOnlyActiveUsers(allUsers);
        return allUsers;
    }

}

