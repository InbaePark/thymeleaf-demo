package com.example.demo.form;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MyForm {

    @Size(min=3)
    @NotBlank
    private String value;
    
    private boolean checked;
    private String selectedRadio = "piyo";
    private String selectedOption = "";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Map<String, String> radioButtons() {
        Map<String, String> radioButtons = new LinkedHashMap<>();
        radioButtons.put("hoge", "HOGE");
        radioButtons.put("fuga", "FUGA");
        radioButtons.put("piyo", "PIYO");

        return radioButtons;
    }

    public String getSelectedRadio() {
        return selectedRadio;
    }

    public void setSelectedRadio(String selectedValue) {
        this.selectedRadio = selectedValue;
    }
    
    public Map<String, String> options() {
        Map<String, String> radioButtons = new LinkedHashMap<>();
        radioButtons.put("sw", "昭和");
        radioButtons.put("hs", "平成");
        radioButtons.put("rw", "令和");

        return radioButtons;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

}