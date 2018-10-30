package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.deleteFirstExpense;
import static seedu.address.testutil.ModelUtil.getTypicalModel;

import org.junit.Before;
import org.junit.Test;

import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.exceptions.NoUserSelectedException;

public class RedoCommandTest {

    private final Model model = getTypicalModel();
    private final Model expectedModel = getTypicalModel();
    private final CommandHistory commandHistory = new CommandHistory();

    @Before
    public void setUp() throws NoUserSelectedException {
        // set up of both models' undo/redo history
        deleteFirstExpense(model);
        deleteFirstExpense(model);
        model.undoExpenseTracker();
        model.undoExpenseTracker();

        deleteFirstExpense(expectedModel);
        deleteFirstExpense(expectedModel);
        expectedModel.undoExpenseTracker();
        expectedModel.undoExpenseTracker();
    }

    @Test
    public void execute() throws NoUserSelectedException {
        // multiple redoable states in model
        expectedModel.redoExpenseTracker();
        assertCommandSuccess(new RedoCommand(), model, commandHistory, RedoCommand.MESSAGE_SUCCESS, expectedModel);

        // single redoable state in model
        expectedModel.redoExpenseTracker();
        assertCommandSuccess(new RedoCommand(), model, commandHistory, RedoCommand.MESSAGE_SUCCESS, expectedModel);

        // no redoable state in model
        assertCommandFailure(new RedoCommand(), model, commandHistory, RedoCommand.MESSAGE_FAILURE);
    }
}
