package ui.configuration.components;

import ui.configuration.IElementValidator;
import ui.configuration.IUserInterfaceElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samuelsmith on 3/19/17.
 */
public class Radio implements IUserInterfaceElement {

    private final String field;
    private String label, tooltip;
    private List<String> options;
    private IElementValidator validator;

    public Radio(String field) {
        this.field = field;
        options = new ArrayList<>();
        validator = null;
    }

    public void addOption(String option) {
        options.add(option);
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    @Override
    public String getJSON() {
        StringBuilder sb = new StringBuilder("{");

        sb.append("\"field\":\"").append(field).append("\",").append("\"type:\":\"radio\",\"label\":").append(label)
                .append("\",\"tooltip\":\"").append(tooltip).append("\",\"options:\":[");
        for (String option : options) sb.append("\"").append(option).append("\",");
        sb.deleteCharAt(sb.lastIndexOf(","));

        return sb.append("]}").toString();
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
