package seedu.address.model.tag;

/**
 * Represents a tutorial tag.
 */
public class TutorialTag extends Tag {
    /**
     * Constructs a {@code Tag}.
     *
     * @param tagName   A valid tag name.
     * @param tagStatus A valid tag status.
     */
    public TutorialTag(String tagName, TagStatus tagStatus) {
        super(tagName, tagStatus);
    }

    public boolean isSameTutorialTag(TutorialTag tutorialTag) {
        return this.getTagName().equals(tutorialTag.getTagName());
    }
    @Override
    public String toString() {
        return getTagName();
    }
}
