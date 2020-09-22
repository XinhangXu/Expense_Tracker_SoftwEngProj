package com.expensetracker.spinner_category;

public class CategoryItems {
    private String mCategoryName;
    private int mCategoryImg;

    public CategoryItems(String CategoryName, int CategoryImg) {
        mCategoryName = CategoryName;
        mCategoryImg = CategoryImg;
    }

    public String getCategoryName() {
        return mCategoryName;
    }


    public int getCategoryImg() {
        return mCategoryImg;
    }

}
