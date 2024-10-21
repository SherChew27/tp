package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalTags.VALID_TAG_BRIDES_FRIEND;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.tag.Tag;

/**
 * Contains tests for DeleteTagCommand.
 */
public class DeleteTagCommandTest {

    private Model model = new ModelManager();

    @Test
    public void execute_existingTag_success() {
        Tag existingTag = VALID_TAG_BRIDES_FRIEND;
        model.addTag(existingTag);

        DeleteTagCommand deleteTagCommand = new DeleteTagCommand(existingTag);

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());

        String expectedMessage = DeleteTagCommand.MESSAGE_SUCCESS + " " + existingTag + "\n"
                + "Your tags: ";

        assertCommandSuccess(deleteTagCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_nonExistentTag_failure() {
        Tag nonExistentTag = VALID_TAG_BRIDES_FRIEND;

        DeleteTagCommand deleteTagCommand = new DeleteTagCommand(nonExistentTag);
        String expectedMessage = DeleteTagCommand.MESSAGE_NONEXISTENT;

        assertCommandFailure(deleteTagCommand, model, expectedMessage);
    }
}