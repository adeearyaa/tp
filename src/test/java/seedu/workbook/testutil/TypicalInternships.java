package seedu.workbook.testutil;

import static seedu.workbook.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.workbook.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.workbook.logic.commands.CommandTestUtil.VALID_COMPANY_AMY;
import static seedu.workbook.logic.commands.CommandTestUtil.VALID_COMPANY_BOB;
import static seedu.workbook.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.workbook.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.workbook.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.workbook.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.workbook.logic.commands.CommandTestUtil.VALID_ROLE_AMY;
import static seedu.workbook.logic.commands.CommandTestUtil.VALID_ROLE_BOB;
import static seedu.workbook.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.workbook.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.workbook.model.WorkBook;
import seedu.workbook.model.internship.Internship;

/**
 * A utility class containing a list of {@code Internship} objects to be used in tests.
 */
public class TypicalInternships {

    public static final Internship ALICE = new InternshipBuilder()
        .withCompany("Alice Pauline")
        .withRole("Software Engineer")
        .withAddress("123, Jurong West Ave 6, #08-111")
        .withEmail("alice@example.com")
        .withPhone("94351253")
        .withTags("friends").build();
    public static final Internship BENSON = new InternshipBuilder()
        .withCompany("Benson Meier")
        .withRole("Software Engineer")
        .withAddress("311, Clementi Ave 2, #02-25")
        .withEmail("johnd@example.com")
        .withPhone("98765432")
        .withTags("owesMoney", "friends").build();
    public static final Internship CARL = new InternshipBuilder()
        .withCompany("Carl Kurz")
        .withRole("Software Engineer")
        .withPhone("95352563")
        .withEmail("heinz@example.com")
        .withAddress("wall street").build();
    public static final Internship DANIEL = new InternshipBuilder()
        .withCompany("Daniel Meier")
        .withRole("Software Engineer")
        .withPhone("87652533")
        .withEmail("cornelia@example.com")
        .withAddress("10th street")
        .withTags("friends").build();
    public static final Internship ELLE = new InternshipBuilder()
        .withCompany("Elle Meyer")
        .withRole("Software Engineer")
        .withPhone("9482224")
        .withEmail("werner@example.com")
        .withAddress("michegan ave").build();
    public static final Internship FIONA = new InternshipBuilder()
        .withCompany("Fiona Kunz")
        .withRole("Software Engineer")
        .withPhone("9482427")
        .withEmail("lydia@example.com")
        .withAddress("little tokyo").build();
    public static final Internship GEORGE = new InternshipBuilder()
        .withCompany("George Best")
        .withRole("Software Engineer")
        .withPhone("9482442")
        .withEmail("anna@example.com")
        .withAddress("4th street").build();

    // Manually added
    public static final Internship HOON = new InternshipBuilder()
        .withCompany("Hoon Meier")
        .withRole("Software Engineer")
        .withPhone("8482424")
        .withEmail("stefan@example.com")
        .withAddress("little india").build();
    public static final Internship IDA = new InternshipBuilder()
        .withCompany("Ida Mueller")
        .withRole("Software Engineer")
        .withPhone("8482131")
        .withEmail("hans@example.com")
        .withAddress("chicago ave").build();

    // Manually added - Internship's details found in {@code CommandTestUtil}
    public static final Internship AMY = new InternshipBuilder()
        .withCompany(VALID_COMPANY_AMY)
        .withRole(VALID_ROLE_AMY)
        .withPhone(VALID_PHONE_AMY)
        .withEmail(VALID_EMAIL_AMY)
        .withAddress(VALID_ADDRESS_AMY)
        .withTags(VALID_TAG_FRIEND).build();
    public static final Internship BOB = new InternshipBuilder()
        .withCompany(VALID_COMPANY_BOB)
        .withRole(VALID_ROLE_BOB)
        .withPhone(VALID_PHONE_BOB)
        .withEmail(VALID_EMAIL_BOB)
        .withAddress(VALID_ADDRESS_BOB)
        .withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND).build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalInternships() {} // prevents instantiation

    /**
     * Returns an {@code WorkBook} with all the typical internships.
     */
    public static WorkBook getTypicalWorkBook() {
        WorkBook ab = new WorkBook();
        for (Internship internship : getTypicalInternships()) {
            ab.addInternship(internship);
        }
        return ab;
    }

    public static List<Internship> getTypicalInternships() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}