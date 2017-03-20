package ui.configuration;

/**
 * Some fields in the agent configuration may require validation.
 *
 * Use an implementation of this class to build that validation logic
 *
 *
 * Created by samuelsmith on 3/19/17.
 */
public interface IElementValidator {

    /**
     * This method is called by the agency to validate a user's input on a configuration form.
     * @param toValidate The string from the user's input to the component that is to be validated
     * @return Empty string if valid, error message if not valid
     */
    String validate(String toValidate);
}
