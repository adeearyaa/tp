package seedu.workbook.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.workbook.commons.exceptions.IllegalValueException;
import seedu.workbook.model.internship.Address;
import seedu.workbook.model.internship.Company;
import seedu.workbook.model.internship.Email;
import seedu.workbook.model.internship.Internship;
import seedu.workbook.model.internship.Phone;
import seedu.workbook.model.internship.Role;
import seedu.workbook.model.tag.Tag;

/**
 * Jackson-friendly version of {@link Internship}.
 */
class JsonAdaptedInternship {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Internship's %s field is missing!";

    private final String company;
    private final String role;
    private final String phone;
    private final String email;
    private final String address;
    private final List<JsonAdaptedTag> tagged = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedInternship} with the given Internship details.
     */
    @JsonCreator
    public JsonAdaptedInternship(@JsonProperty("company") String company, @JsonProperty("role") String role,
            @JsonProperty("phone") String phone,
            @JsonProperty("email") String email, @JsonProperty("address") String address,
            @JsonProperty("tagged") List<JsonAdaptedTag> tagged) {
        this.company = company;
        this.role = role;
        this.phone = phone;
        this.email = email;
        this.address = address;
        if (tagged != null) {
            this.tagged.addAll(tagged);
        }
    }

    /**
     * Converts a given {@code Internship} into this class for Jackson use.
     */
    public JsonAdaptedInternship(Internship source) {
        company = source.getCompany().name;
        role = source.getRole().value;
        phone = source.getPhone().value;
        email = source.getEmail().value;
        address = source.getAddress().value;
        tagged.addAll(source.getTags().stream()
                .map(JsonAdaptedTag::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted Internship object into the model's
     * {@code Internship} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in
     *                               the adapted Internship.
     */
    public Internship toModelType() throws IllegalValueException {
        final List<Tag> internshipTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tagged) {
            internshipTags.add(tag.toModelType());
        }

        if (company == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Company.class.getSimpleName()));
        }
        if (!Company.isValidCompany(company)) {
            throw new IllegalValueException(Company.MESSAGE_CONSTRAINTS);
        }
        final Company modelCompany = new Company(company);

        if (role == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Role.class.getSimpleName()));
        }
        if (!Role.isValidRole(role)) {
            throw new IllegalValueException(Role.MESSAGE_CONSTRAINTS);
        }
        final Role modelRole = new Role(role);

        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }
        if (!Phone.isValidPhone(phone)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Phone modelPhone = new Phone(phone);

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        if (address == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName()));
        }
        if (!Address.isValidAddress(address)) {
            throw new IllegalValueException(Address.MESSAGE_CONSTRAINTS);
        }
        final Address modelAddress = new Address(address);

        final Set<Tag> modelTags = new HashSet<>(internshipTags);
        return new Internship(modelCompany, modelRole, modelPhone, modelEmail, modelAddress, modelTags);
    }

}