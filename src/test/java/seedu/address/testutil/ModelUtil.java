package seedu.address.testutil;

import java.time.LocalDateTime;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.budget.TotalBudget;
import seedu.address.model.exceptions.NoUserSelectedException;
import seedu.address.model.exceptions.NonExistentUserException;
import seedu.address.model.exceptions.UserAlreadyExistsException;
import seedu.address.model.user.Username;



//@@author JasonChong96
/**
 * Helper methods related to models.
 */
public class ModelUtil {
    public static final Username TEST_USERNAME = new Username("AAA");

    /**
     * An extension of the {@code ModelManager} where developers can pass in the time instead of checking against
     * system clock. Class of a model with a test user that is already logged in with username TEST_USERNAME.
     * The address book is empty. TotalBudget cap is $28 with $10 current expenses
     */

    /**
     * Creates a model with a test user that is already logged in with username TEST_USERNAME. The address book is
     * empty. TotalBudget cap is $28 with $0 current expenses
     * @return a model logged in with a test user
     */
    public static Model modelWithTestUser() throws NonExistentUserException, UserAlreadyExistsException,
        NoUserSelectedException {
        Model model = new ModelManager();
        model.addUser(TEST_USERNAME);
        model.loadUserData(TEST_USERNAME, null);
        model.getNotificationHandler().clearList();
        model.modifyNotificationHandler(LocalDateTime.parse("2018-11-01T17:20:16.847790"), true,
                true);
        model.modifyMaximumBudget(new TotalBudget(28.00, 0.00, LocalDateTime.parse("2018-10-10T10:11:30"), 50000));
        return model;
    }

}


