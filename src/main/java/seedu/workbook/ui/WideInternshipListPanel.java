package seedu.workbook.ui;

import java.util.List;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.workbook.commons.core.LogsCenter;
import seedu.workbook.model.internship.Internship;
import seedu.workbook.model.internship.Stage;
import seedu.workbook.model.internship.util.StageUtil;

/**
 * Panel containing the list of internships for wide window format.
 */
public class WideInternshipListPanel extends UiPart<Region> {
    private static final String FXML = "WideInternshipListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(WideInternshipListPanel.class);

    @FXML
    private HBox tipsPanelContainer;

    @FXML
    private ListView<Internship> wideInternshipListView;

    /**
     * Creates a {@code InternshipListPanel} with the given {@code ObservableList}.
     */
    public WideInternshipListPanel(ObservableList<Internship> internshipList) {
        super(FXML);
        wideInternshipListView.setItems(internshipList);
        wideInternshipListView.setCellFactory(listView -> new WideInternshipListViewCell());
        setInternshipSelectedEventHandlers();
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Internship} using a {@code InternshipCard}.
     */
    class WideInternshipListViewCell extends ListCell<Internship> {
        @Override
        protected void updateItem(Internship internship, boolean empty) {
            super.updateItem(internship, empty);

            if (empty || internship == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new NarrowInternshipCard(internship, getIndex() + 1).getRoot());
            }
        }
    }

    private void setInternshipSelectedEventHandlers() {
        this.wideInternshipListView.getSelectionModel().selectedItemProperty().addListener((observable, oldVal, newVal) -> {
            Internship selectedInternship = wideInternshipListView.getSelectionModel().getSelectedItem();
            TipsPanel tipsPanel = tipPanelBuilder(selectedInternship.getStage());
            tipsPanelContainer.getChildren().clear();
            tipsPanelContainer.getChildren().add(tipsPanel.getRoot());
        });
    }

    private TipsPanel tipPanelBuilder(Stage internshipStage) {

        TipsPanel tipsPanel = new TipsPanel();

        //Set header of tips to be name of stage.
        tipsPanel.setTipsHeader(internshipStage.value);

        if (internshipStage.hasNoTips()) {
            tipsPanel.noTipsPopulate();
            return tipsPanel;
        }

        List<String> tips = StageUtil.getStageSpecificTips(internshipStage);

        tipsPanel.populateTips(tips);

        return tipsPanel;
    }

}
