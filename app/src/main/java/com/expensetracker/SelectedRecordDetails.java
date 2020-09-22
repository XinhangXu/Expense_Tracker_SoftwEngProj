package com.expensetracker;

// a global class to store selected record in History.class
// then EditeRecord.class will call data in this class to specify which record need to be edit


import android.app.Application;

public class SelectedRecordDetails extends Application {

    private int id_selected;
    private String amount_selected;
    private String category_selected;
    private String note_selected;
    private String date_selected;
    private String image_selected;
    private String spinner_selected;

    // ?? Question: global class seems like do not need constructor
/*    public SelectedRecordDetails(int id_selected, String amount_selected, String category_selected, String note_selected, String date_selected, String image_selected, String spinner_selected) {
        this.id_selected = id_selected;
        this.amount_selected = amount_selected;
        this.category_selected = category_selected;
        this.note_selected = note_selected;
        this.date_selected = date_selected;
        this.image_selected = image_selected;
        this.spinner_selected = spinner_selected;
    }*/

    public int getId_selected() {
        return id_selected;
    }

    public void setId_selected(int id_selected) {
        this.id_selected = id_selected;
    }

    public String getAmount_selected() {
        return amount_selected;
    }

    public void setAmount_selected(String amount_selected) {
        this.amount_selected = amount_selected;
    }

    public String getCategory_selected() {
        return category_selected;
    }

    public void setCategory_selected(String category_selected) {
        this.category_selected = category_selected;
    }

    public String getNote_selected() {
        return note_selected;
    }

    public void setNote_selected(String note_selected) {
        this.note_selected = note_selected;
    }

    public String getDate_selected() {
        return date_selected;
    }

    public void setDate_selected(String date_selected) {
        this.date_selected = date_selected;
    }

    public String getImage_selected() {
        return image_selected;
    }

    public void setImage_selected(String image_selected) {
        this.image_selected = image_selected;
    }

    public String getSpinner_selected() {
        return spinner_selected;
    }

    public void setSpinner_selected(String spinner_selected) {
        this.spinner_selected = spinner_selected;
    }
}
