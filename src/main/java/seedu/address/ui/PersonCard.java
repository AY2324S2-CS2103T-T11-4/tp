package seedu.address.ui;

import java.util.Comparator;
import java.util.function.Predicate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;
import seedu.address.model.person.PersonType;
import seedu.address.model.tag.Tag;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;

    @FXML
    private Label index;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;

    @FXML
    private Label type;
    @FXML
    private FlowPane assignmentTags;
    @FXML
    private FlowPane attendanceTags;
    @FXML
    private FlowPane tutorialTags;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        index.setText(Integer.toString(displayedIndex));
        name.setText(person.getName().fullName);
        id.setText(person.getId().value);
        phone.setText(person.getPhone().value);
        email.setText(person.getEmail().value);
        type.setText(person.getType().toString());
        type.getStyleClass().setAll(person.getType() == PersonType.TA ? "type-ta" : "type-stu");
        addTagsToContainer(person, Tag::isAssignment, assignmentTags);
        addTagsToContainer(person, Tag::isAttendance, attendanceTags);
        addTagsToContainer(person, Tag::isAssigned, tutorialTags);
        addTagsToContainer(person, Tag::isAvailable, tutorialTags);
    }

    private void addTagsToContainer(Person person, Predicate<Tag> filterPredicate, FlowPane container) {
        person.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.getTagName()))
                .filter(filterPredicate)
                .forEach(tag -> {
                    Label tagLabel = new Label(tag.getTagName());
                    tagLabel.getStyleClass().addAll("label", tag.getTagStatus().toString().toLowerCase());
                    container.getChildren().add(tagLabel);
                });
    }
}
