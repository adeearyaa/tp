package seedu.workbook.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
import seedu.workbook.commons.core.LogsCenter;

/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Stage> {

    public static final String ADD_COMMAND = "add c/COMPANY r/ROLE s/STAGE [d/DATETIME] [e/EMAIL] "
            + "[l/PROGRAMMING LANGUAGE]… [t/TAG]…";
    public static final String EDIT_COMMAND = "edit INDEX [c/COMPANY] [r/ROLE] [s/STAGE] [d/DATETIME] [e/EMAIL] "
            + "[l/PROGRAMMING LANGUAGE]… [t/TAG]…";
    public static final String DELETE_COMMAND = "delete INDEX";
    public static final String CLEAR_COMMAND = "clear";
    public static final String LIST_COMMAND = "list";
    public static final String FIND_COMMAND = "find  c/COMPANY | r/ROLE | s/STAGE";
    public static final String UNDO_COMMAND = "undo";
    public static final String REDO_COMMAND = "redo";
    public static final String EXIT_COMMAND = "exit";
    public static final String USERGUIDE_URL = "https://ay2223s1-cs2103t-t10-3.github.io/tp/UserGuide.html";
    public static final String URL_MESSAGE = "Refer to the user guide for more information: " + USERGUIDE_URL;

    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String FXML = "HelpWindow.fxml";

    @FXML
    private Label addCommand;

    @FXML
    private Label clearCommand;

    @FXML
    private Label deleteCommand;

    @FXML
    private Label editCommand;

    @FXML
    private Label listCommand;

    @FXML
    private Label redoCommand;

    @FXML
    private Label undoCommand;

    @FXML
    private Label findCommand;

    @FXML
    private Label exitCommand;

    @FXML
    private Button copyButton;

    @FXML
    private Label urlMessage;

    /**
     * Creates a new HelpWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root) {
        super(FXML, root);

        addCommand.setText(ADD_COMMAND);
        editCommand.setText(EDIT_COMMAND);
        deleteCommand.setText(DELETE_COMMAND);
        clearCommand.setText(CLEAR_COMMAND);
        listCommand.setText(LIST_COMMAND);
        redoCommand.setText(REDO_COMMAND);
        undoCommand.setText(UNDO_COMMAND);
        findCommand.setText(FIND_COMMAND);
        exitCommand.setText(EXIT_COMMAND);
        urlMessage.setText(URL_MESSAGE);
    }

    /**
     * Creates a new HelpWindow.
     */
    public HelpWindow() {
        this(new Stage());
    }

    /**
     * Shows the help window.
     * @throws IllegalStateException
     *     <ul>
     *         <li>
     *             if this method is called on a thread other than the JavaFX Application Thread.
     *         </li>
     *         <li>
     *             if this method is called during animation or layout processing.
     *         </li>
     *         <li>
     *             if this method is called on the primary stage.
     *         </li>
     *         <li>
     *             if {@code dialogStage} is already showing.
     *         </li>
     *     </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void copyUrl() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(USERGUIDE_URL);
        clipboard.setContent(url);
    }
}
