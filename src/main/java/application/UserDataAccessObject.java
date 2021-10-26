package application;

import entities.User;

/**
 * An interface to be implemented by concrete User Data Access Objects.
 */
public interface UserDataAccessObject extends DataAccessObject<User>{

    /**
     * Return User with the given id.
     * @param id            ID of User.
     * @return              User associated with the given id.
     * @throws Exception    If no User exists with given id.
     */
    @Override
    User get(int id) throws Exception;

    /**
     * Update the corresponding User in the attached data store to match the provided User.
     * @param user    Updated User.
     * @return        True iff update was successful.
     */
    @Override
    boolean update(User user);

    /**
     * Insert the given User to the attached data store.
     * @param user    User to insert.
     * @return        True iff insertion was successful.
     */
    @Override
    boolean insert(User user);

    /**
     * Delete the User with provided id from the attached data store. Use with caution.
     * @param id    ID of User to delete.
     * @return      True iff deletion was successful.
     */
    @Override
    boolean delete(int id);
}

