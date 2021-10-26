package gateways;

import application.UserDataAccessObject;
import entities.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A temporary User Data Access Object for development purposes. Serialized User objects are stored by their user id
 * in the project directory under /tempDataStore/users/
 */
public class TempUsers implements UserDataAccessObject {
    private final String usersPath = "tempDataStore/users/";

    public static void main(String[] args) {
        List<String> interests = new ArrayList<>();
        interests.add("Bikes");
        interests.add("Programming");
        User user = new User("Spencer", "password", interests, "Spencer#0");
        TempUsers tempUsers = new TempUsers();
        tempUsers.insert(user);
    }

    @Override
    public String getNextId(String username) {
        return null;
    }

    /**
     * Return User with the given id.
     * @param id            ID of User.
     * @return              User associated with the given id.
     * @throws Exception    If no User exists with given id.
     */
    @Override
    public User get(String id) throws Exception {
        FileInputStream fileInput = new FileInputStream(usersPath + id + ".ser");
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);
        User userFromStore = (User) objectInput.readObject();
        objectInput.close();
        return userFromStore;
    }

    /**
     * Update the corresponding User in the attached data store to match the provided User.
     * @param user    Updated User.
     * @return        True iff update was successful.
     */
    @Override
    public boolean update(User user) {
        return false;
    } // TODO: Implement this!

    /**
     * Insert the given User to the attached data store.
     * @param user    User to insert.
     * @return        True iff insertion was successful.
     */
    @Override
    public boolean insert(User user) {
        try {
            File file = new File(usersPath + user.getId() + ".ser");
            if (!file.createNewFile()) {
                return false;
            }
            FileOutputStream fileOutput = new FileOutputStream(file);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(user);
            objectOutput.flush();
            objectOutput.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Delete the User with provided id from the attached data store. Use with caution.
     * @param id    ID of User to delete.
     * @return      True iff deletion was successful.
     */
    @Override
    public boolean delete(String id) {
        File file = new File(usersPath + id + ".ser");
        return file.delete();
    }
}
