package com.expensetracker;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.expensetracker.Database.DatabaseClass;
import com.expensetracker.spinner_category.CategoryAdapter;
import com.expensetracker.spinner_category.CategoryItems;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class EditRecord extends AppCompatActivity {

    //declare values
    Spinner addregular, currency_sp;
    String[] regular = {"None", "Daily", "Weekly", "Monthly"};
    String[] unit = {"USD", "EUR", "SGD", "JPY", "CNY", "CAD", "AUD"};
    String clickedCategoryName; // to store category name
    TextView date, upload_image;
    Calendar myCalender;
    private static int RESULT_LOAD_Image = 1;
    private static int RESULT_LOAD_B = 200;
    ImageView image;
    String picturePath;
    EditText amount, note;//category,


    SQLiteDatabase database;
    public static DatabaseClass databaseClass;


    private Spinner spinner_category;
    private ArrayList<CategoryItems> mCategoryList;
    private CategoryAdapter mCategoryAdapter;

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    Button saveTodatabase, delete_bt;

    String id_selected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_record);

        SelectedRecordDetails recordDetails = (SelectedRecordDetails) getApplicationContext();


        // find ids from activity expense
        amount = (EditText) findViewById(R.id.amount_edit);
        //category = (EditText) findViewById(R.id.category);
        note = (EditText) findViewById(R.id.description_edit);
        image = (ImageView) findViewById(R.id.images_edit);
        saveTodatabase = (Button) findViewById(R.id.save_edit);
        upload_image = (TextView) findViewById(R.id.imageview_edit);
        addregular = (Spinner) findViewById(R.id.spinner_edit);
        date = (TextView) findViewById(R.id.date_edit);
        currency_sp = (Spinner) findViewById(R.id.currency_unit_edit);
        spinner_category = findViewById(R.id.spinner_category_expense_edit);
        delete_bt = findViewById(R.id.bt_delete);

        initList_expense();//for category spinner

        databaseClass = new DatabaseClass(EditRecord.this);
        database = databaseClass.getWritableDatabase();

        //SelectedRecordDetails recordDetails = (SelectedRecordDetails) getApplicationContext();
        amount.setText(recordDetails.getAmount_selected());
        note.setText(recordDetails.getNote_selected());
        date.setText(recordDetails.getDate_selected());
        //spinner_category
        //spinner: addregular
        //spinner: currency_sp
        //image.setImageResource(recordDetails.getImage_selected())
        id_selected = String.valueOf(recordDetails.getId_selected());

        // provide drop down items spinner
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(EditRecord.this, R.layout.support_simple_spinner_dropdown_item, regular);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        addregular.setAdapter(arrayAdapter);
        myCalender = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthofyear, int dayofmonth) {
                myCalender.set(Calendar.YEAR, year);
                myCalender.set(Calendar.MONTH, monthofyear);
                myCalender.set(Calendar.DATE, dayofmonth);
                updateLabel();
            }
        };
        ArrayAdapter<String> arrayCurrency = new ArrayAdapter<String>(EditRecord.this, R.layout.support_simple_spinner_dropdown_item, unit);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        currency_sp.setAdapter(arrayCurrency);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(EditRecord.this, dateSetListener, myCalender.get(Calendar.YEAR), myCalender.get(Calendar.MONTH), myCalender.get(Calendar.DATE)).show();
            }
        });

        upload_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImageChooser();
            }
        });


        //category spinner
        mCategoryAdapter = new CategoryAdapter(this, mCategoryList);
        spinner_category.setAdapter(mCategoryAdapter);
        spinner_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CategoryItems categoryItems = (CategoryItems) parent.getItemAtPosition(position);
                clickedCategoryName = categoryItems.getCategoryName(); //clickedTypeName
                //Toast.makeText(AddRecord.this, clickedCategoryName + " SELECTED", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        // save data to database
        final Expense.Getpaths pp = new Expense.Getpaths();
        //databaseClass = new DatabaseClass(EditRecord.this);
        saveTodatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    databaseClass.insertDataToExpense(amount.getText().toString() + currency_sp.getSelectedItem().toString(),
                            clickedCategoryName,//category.getText().toString()
                            note.getText().toString(),
                            date.getText().toString(),
                            pp.getPath(),
                            addregular.getSelectedItem().toString());
                    Toast.makeText(EditRecord.this, "Changes Saved", Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                //save previous records, detele old records
                database.execSQL(" DELETE FROM " + "expense" + " WHERE " + "_id" + "=\"" + id_selected + "\";" );
            }
        });


        // button, delete this record
        delete_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*                String table = "expense";
                String whereClause = "_id=?";
                String[] whereArgs = new String[] { String.valueOf(recordDetails.getId_selected()) };
                database.delete(table, whereClause, whereArgs);*/
                //database.delete("expense", "_id = ?", new String[]{ "0"});//new String[]{String.valueOf(recordDetails.getId_selected())}
                database.execSQL(" DELETE FROM " + "expense" + " WHERE " + "_id" + "=\"" + id_selected + "\";" );

                Toast.makeText(EditRecord.this, "Deleted! " + id_selected, Toast.LENGTH_LONG).show();
                //close current intent, open History class, to view new listview
                Intent intent = new Intent(EditRecord.this, History.class);
                startActivity(intent);
                finish();
            }
        });




    }








    // other methods

    private void updateLabel() {
        String myFormat = "dd/MM/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        date.setText(sdf.format(myCalender.getTime()));

    }

    private void openImageChooser() {
        verifyStoragePermissions(EditRecord.this);
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, RESULT_LOAD_Image);

    }
    public static void verifyStoragePermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_Image && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();
            image.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            Expense.Getpaths getpath = new Expense.Getpaths();
            getpath.setPath(picturePath);
        }
    }

    public static class Getpaths {
        static String path;

        public String getPath() {
            return path;
        }

        public void setPath(String picturepPath) {
            this.path = picturepPath;
        }
    }


    private void initList_expense(){
        mCategoryList = new ArrayList<>();
        mCategoryList.add(new CategoryItems("Food", R.drawable.food_ctgry_icon));
        mCategoryList.add(new CategoryItems("Clothes", R.drawable.clothes_ctgry_icon));
        mCategoryList.add(new CategoryItems("Education", R.drawable.education_ctgry_icon));
        mCategoryList.add(new CategoryItems("Exercise", R.drawable.exercise_ctgry_icon));
        mCategoryList.add(new CategoryItems("Entertainment", R.drawable.entertainment_ctgry_icon));
        mCategoryList.add(new CategoryItems("Family", R.drawable.family_ctgry_icon));
        mCategoryList.add(new CategoryItems("Grocery", R.drawable.groccery_ctgry_icon));
        mCategoryList.add(new CategoryItems("Snack", R.drawable.snack_ctgry_icon));
        mCategoryList.add(new CategoryItems("Hospital", R.drawable.hospital_ctgry_icon));
        mCategoryList.add(new CategoryItems("House", R.drawable.house_ctgry_icon));
        mCategoryList.add(new CategoryItems("Car", R.drawable.car_ctgry_icon));
        mCategoryList.add(new CategoryItems("Transportation", R.drawable.transportation_ctgry_icon));
        mCategoryList.add(new CategoryItems("Travel", R.drawable.travel_ctgry_icon));
        mCategoryList.add(new CategoryItems("Telephone", R.drawable.telephone_ctgry_icon));
        mCategoryList.add(new CategoryItems("Socialize", R.drawable.social_ctgry_icon));
        /////////////////////////// copy
        /////////////////////////// change img
    }
















}
