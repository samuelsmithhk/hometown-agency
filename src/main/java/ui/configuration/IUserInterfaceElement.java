package ui.configuration;

/**
 * Created by samuelsmith on 3/19/17.
 */
public interface IUserInterfaceElement {

    /**
     * @return Returns a json representation of this element so that the UI can render it
     */
    String getJSON();

    /**
     *
     * @return Returns the string name of the field, for mapping the configuration back to the class
     */
    String getField();

    /**
     * Add validation logic to this element
     *
     * If no validator is added, any input from the user is accepted
     * @param validator The validation logic
     */
    void addValidator(IElementValidator validator);

    /**
     * This is the method called by the agency to get the validation logic for the user's input
     * @return
     */
    IElementValidator getValidator();
}
