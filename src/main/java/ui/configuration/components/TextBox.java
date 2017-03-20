package ui.configuration.components;

import ui.configuration.IElementValidator;
import ui.configuration.IUserInterfaceElement;

/**
 * Created by samuelsmith on 3/19/17.
 */
public class TextBox implements IUserInterfaceElement {

    private final String field;
    private String tooltip, defaultValue, label;

    private IElementValidator validator;


    public TextBox(String field) {
        this.field = field;
        validator = null;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getJSON() {
        return "{\"field\":\"" + field + "\",\"type\":\"textbox\",\"label\":\"" + label + "\",\"defaultValue\":\""
                + defaultValue + "\",\"tooltip\":\"" + tooltip + "\"}";
    }

    @Override
    public String getField() {
        return field;
    }

    @Override
    public void addValidator(IElementValidator validator) {
        this.validator = validator;
    }

    @Override
    public IElementValidator getValidator() {
        return validator;
    }
}
