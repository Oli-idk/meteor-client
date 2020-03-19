package minegame159.meteorclient.settings;

import minegame159.meteorclient.gui.widgets.WTextBox;

import java.util.function.Consumer;

public class StringSetting extends Setting<String> {
    public StringSetting(String name, String description, String defaultValue, Consumer<String> onChanged, Consumer<Setting<String>> onModuleActivated) {
        super(name, description, defaultValue, onChanged, onModuleActivated);

        widget = new WTextBox(get(), 32);
        ((WTextBox) widget).action = textBox -> set(textBox.text.trim());
    }

    @Override
    protected String parseImpl(String str) {
        return str.trim();
    }

    @Override
    protected void resetWidget() {
        ((WTextBox) widget).text = get();
    }

    @Override
    protected boolean isValueValid(String value) {
        return true;
    }

    @Override
    protected String generateUsage() {
        return "#blue<text>";
    }

    public static class Builder {
        private String name = "undefined", description = "";
        private String defaultValue;
        private Consumer<String> onChanged;
        private Consumer<Setting<String>> onModuleActivated;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder defaultValue(String defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        public Builder onChanged(Consumer<String> onChanged) {
            this.onChanged = onChanged;
            return this;
        }

        public Builder onModuleActivated(Consumer<Setting<String>> onModuleActivated) {
            this.onModuleActivated = onModuleActivated;
            return this;
        }

        public StringSetting build() {
            return new StringSetting(name, description, defaultValue, onChanged, onModuleActivated);
        }
    }
}