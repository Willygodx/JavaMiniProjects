package view;

import user.User;
import controller.Controller;
import model.ModelData;

import java.util.List;

public class UsersView implements View {
    private Controller controller;
    @Override
    public void refresh(ModelData modelData) {
        if (modelData.isDisplayDeletedUserList()) {
            System.out.println("All deleted users:");
        } else {
            System.out.println("All users:");
        }
        List<User> usersToPrint = modelData.getUsers();
        for (User user : usersToPrint) {
            System.out.print("\t");
            System.out.println(user.toString());
        }
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }
    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }
}

