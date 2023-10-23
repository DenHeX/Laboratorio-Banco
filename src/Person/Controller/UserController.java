package Person.Controller;

import Controller.Controller;
import Dao.Dao;
import Person.Dtos.UserDto;
import Person.User;
import Views.View;
import java.util.ArrayList;
import java.util.List;

public class UserController implements Controller<User> {

    private View view;
    private Dao dao;

    public UserController(View view, Dao dao) {
        this.view = view;
        this.dao = dao;
    }

    @Override
    public boolean create(User user) {
        if (dao.read(user.getId()) != null) {
            view.displayMessage("Id de usuario duplicado");
            return false;
        } else {
            UserDto userDto = new UserDto(user.getId(), user.getName(), user.getUsername(), user.getPassword());
            if (dao.create(userDto)) {
                view.displayMessage("Usuario agregado correctamente");
                return true;
            } else {
                view.displayMessage("Error al agregar usuario");
                return false;
            }
        }
    }

    @Override
    public User read(String id) {
        UserDto userDto = (UserDto) dao.read(id);
        if (userDto == null) {
            view.displayMessage("Id de usuario no encontrado");
        } else {
            User user = new User(userDto.getId(), userDto.getName(), userDto.getUsername(), userDto.getPassword());
            view.display(user);
            return user;
        }
        return null;
    }

    @Override
    public List<User> readAll() {
        List<User> users = new ArrayList<>();
        List<UserDto> userDtos = dao.readAll();

        for (UserDto userDto : userDtos) {
            User user = new User(userDto.getId(), userDto.getName(), userDto.getUsername(), userDto.getPassword());
            users.add(user);
        }

        return users;
    }

    @Override
    public boolean update(User user) {
        if (dao.read(user.getId()) == null) {
            view.displayMessage("Id de usuario no encontrado");
            return false;
        } else {
            UserDto userDto = new UserDto(user.getId(), user.getName(), user.getUsername(), user.getPassword());
            if (dao.update(userDto)) {
                view.displayMessage("Usuario actualizado correctamente");
                return true;
            } else {
                view.displayMessage("Error al actualizar usuario");
                return false;
            }
        }
    }

    @Override
    public boolean delete(User user) {
        if (dao.read(user.getId()) == null) {
            view.displayMessage("Id de usuario no encontrado");
            return false;
        } else {
            if (dao.delete(user.getId())) {
                view.displayMessage("Usuario eliminado correctamente");
                return true;
            } else {
                view.displayMessage("Error al eliminar usuario");
                return false;
            }
        }
    }
}
