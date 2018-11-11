package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.exceptions.NegativeValueParseException;
import seedu.address.commons.exceptions.TooRichException;
import seedu.address.logic.commands.SetBudgetCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.budget.TotalBudget;


//@author winsonhys
/**
 * Parses input arguments and creates a new SetBudgetCommand object
 */
public class SetBudgetCommandParser implements Parser<SetBudgetCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the LoginCommand
     * and returns an LoginCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public SetBudgetCommand parse(String userInput) throws ParseException {
        try {
            TotalBudget totalBudget = new TotalBudget(userInput.trim());
            if (totalBudget.getBudgetCap() <= 0) {
                throw new NegativeValueParseException();
            }
            if (totalBudget.getBudgetCap() > 99999999999999999999999.00) {
                throw new TooRichException();
            }
            return new SetBudgetCommand(totalBudget);
        } catch (IllegalArgumentException iae) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, SetBudgetCommand.MESSAGE_USAGE));
        }
    }
}
