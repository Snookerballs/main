package seedu.address.storage;
//@author winsonhys

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.ExpectedException;

import seedu.address.model.budget.TotalBudget;
import seedu.address.model.budget.TotalBudgetTest;
import seedu.address.storage.budget.XmlAdaptedTotalBudget;


public class XmlAdaptedTotalBudgetTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void testEquals() {
        XmlAdaptedTotalBudget validXmlAdaptedTotalBudget =
            new XmlAdaptedTotalBudget(new TotalBudget(TotalBudgetTest.VALID_BUDGET));

        String anotherValidBudgetString = "3.00";
        assertNotEquals(validXmlAdaptedTotalBudget,
            new XmlAdaptedTotalBudget(new TotalBudget(anotherValidBudgetString)));
        assertEquals(validXmlAdaptedTotalBudget, validXmlAdaptedTotalBudget);
        assertNotEquals(validXmlAdaptedTotalBudget, new Object());
    }

}
