package ui.configuration.validators;

import ui.configuration.IElementValidator;

/**
 * This class is a standard validator for radio elements, it just checks that a radio option has been selected.
 *
 * Created by samuelsmith on 3/20/17.
 */
public class DefaultRadioValidator implements IElementValidator {

    @Override
    public String validate(String toValidate) {
        if (toValidate.isEmpty()) return "No option selected";
        return "";
    }
}
