package ase.group17.controller;

import ase.group17.model.DatabaseConnection;
import ase.group17.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

import java.sql.SQLException;

/**
 * Login Controller.
 */
public class LoginAction extends ActionSupport {

    /**
     * Empty password message string.
     */
    private static final String EMPTY_PASSWORD_MESSAGE = "Please enter your password";

    /**
     * Empty username message string.
     */
    private static final String EMPTY_USER_MESSAGE = "Please enter your username";

    /**
     * Invalid login message string.
     */
    private static final String INVALID_LOGIN_MESSAGE = "Invalid username/password!";

    /**
     * User object.
     */
    private final User user;

    /**
     * Initialises Login Action.
     */
    public LoginAction() {
        user = new User();
    }

    /**
     * Gets password of user object.
     *
     * @return Password of user.
     */
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Sets password of user object.
     *
     * @param password Password of user.
     */
    @RequiredStringValidator(message = EMPTY_PASSWORD_MESSAGE)
    public void setPassword(String password) {
        user.setPassword(password);
    }

    /**
     * Gets username of user object.
     *
     * @return Username of user.
     */
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * Sets username of user object.
     *
     * @param username Password of user.
     */
    @RequiredStringValidator(message = EMPTY_USER_MESSAGE)
    public void setUsername(String username) {
        user.setUsername(username);
    }

    /**
     * Executes login action.
     *
     * @return SUCCESS if username and password is valid, ERROR otherwise.
     * @throws SQLException If there are connection problem(s) to the database.
     */
    public String execute() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        if (databaseConnection.isLoginValid(getUsername(), getPassword())) {
            return SUCCESS;
        }
        addActionError(INVALID_LOGIN_MESSAGE);
        return ERROR;
    }
}
