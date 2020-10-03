# Android Money Manager application


# Project management:

• GITHUB link: https://github.com/XinhangXu/Expense_Tracker_SoftwEngProj

• Assignment is done by one student. Work on the assignment individually. 

• Student Name: Xinhang Xu in charge of the whole project.



# Illustrations of alpha-release
# Login interface
![01](https://github.com/XinhangXu/Expense_Tracker_SoftwEngProj/blob/master/gui/01.png)

Login function is used to check user data. Username and password should be matched, so that user can login to this application. There are two edit texts listed on this interface, which are used to get user input. Username and password are recorded in database. There are five attempts for user to input username and password, the application will be disabled if user input wrong username and password over five times. 


# Menu interface

![02](https://github.com/XinhangXu/Expense_Tracker_SoftwEngProj/blob/master/gui/02.jpg)

All the functions of this application are listed on menu interface. There are total seven functions which are add record, view record, financial suggestion, book consulting, investment advice, setting and about app, respectively. All the image views on this interface are set on click listener, so user can select preferred function by clicking the image.

# Add income interface

![03](https://github.com/XinhangXu/Expense_Tracker_SoftwEngProj/blob/master/gui/03.JPG)

Add income function is used to get user input about income details. It requires for amount, currency, category, description, date, and photo. There are two edit texts, one button, two spinners, one calendar, and one image view on this interface. After user input all the income details, this record can be saved by clicking save button. All the data will be transmitted to database incomes table.


# Add expense interface

![04](https://github.com/XinhangXu/Expense_Tracker_SoftwEngProj/blob/master/gui/04.JPG)

Add expense function is used to get user input about expense details. It requires for amount, currency, category, description, date, and photo. There are two edit texts, one button, two spinners, one calendar, and one image view on this interface. After user input all the expense details, this record can be saved by clicking save button. All the data will be transmitted to database expense table.


# Record list interface

![05](https://github.com/XinhangXu/Expense_Tracker_SoftwEngProj/blob/master/gui/05.JPG)

View record function is used to provide a list of input records which have been stored in database. There is a button located on the right-top screen which is used to switch to view income interface or view expense interface. 
The structure of view income interface and view expense interface are similar. List view is used to list all the records from database. In each record, date, image, amount, category and description will be shown on the list view. 

# Edit or delete record interface

![06](https://github.com/XinhangXu/Expense_Tracker_SoftwEngProj/blob/master/gui/06.JPG)

Edit record interface is used to edit selected record or delete it. User can switch to this interface by clicking a certain record listed on view record interface. The details of the clicked record will be listed on edit record interface. User can edit the part that would like to be modified, and then click save changes button to save edited record. User can also delete this record by clicking delete record button.



# Financial suggestion interface

![07](https://github.com/XinhangXu/Expense_Tracker_SoftwEngProj/blob/master/gui/07.JPG)

Financial suggestion function is used to deliver analysis based on user income and expense. On the top of this interface, user total income and expense will be listed. Along with a graphic which is visualization of income and expense records. There is a spinner for user to select a category to check expense of this category, then user can get some feedbacks based on analysis of this category expense records. 


# Book consulting interface

![08](https://github.com/XinhangXu/Expense_Tracker_SoftwEngProj/blob/master/gui/08.JPG)

Booking consulting function is used to book an appointment with financial professor. There is a list view on this interface, which is used to list some financial experts based on user preference. User can click preferred expert and view more detail or book a consulting.


# Investment advice interface

![09](https://github.com/XinhangXu/Expense_Tracker_SoftwEngProj/blob/master/gui/09.JPG)

Investment advice function is used to provide some investment advice based on analysis of user asset. Estimated user asset is displayed on the center of this interface. Following with three investment options, which are stock, bond, and insurance, respectively. User can click preferred option and view more specific advice. 


# Setting interface

![10](https://github.com/XinhangXu/Expense_Tracker_SoftwEngProj/blob/master/gui/10.JPG)

Setting function is used to set a new username and password. There are two edit texts listed on this interface, which are used to get user input of username and password. New username and password will be saved by clicking save changes button.


# About app interface

![11](https://github.com/XinhangXu/Expense_Tracker_SoftwEngProj/blob/master/gui/11.JPG)

About app function is used to display some content that introduce expense tracker application. It includes summary, version and features of this application.




















# 1 Product features


1.1 Ability to track income and expense

Users can input their income and expense. These records will be stored and can be accessed any time. Details of user operation could be: 

o	Add a new record of income or expense. 

o	Add detail description of a record.

o	Read any record at any time.

o	Modify any record at any time.

o	Delete any record.

o	Select a category for the record. (e.g. : Essentials, House, Snack, Gift. etc..)




1.2 Ability to come up with conclusion of income and expense

The application can conclude weekly or monthly income and expense. For example, users can view how much they spend this month. This function allows users to track their income and outcome in a significant and visual way.


1.3 Ability to deliver financial suggestions

This ability of Finance Tracker is about financial analysis. All the analyzing results are based on user data recorded in database. For an example, simple suggestion for July is “You spent too much on coffee, you should save money.” As well as some complicated suggestions, such as investment suggestions.


1.4 Ability to book consulting

This application allows users to book professional financial consulting conveniently. Based on user available date and slot, there will be some suitable professor listed on the interface for user to choose. Users can also view details of a certain professor and decide whether book an appointment or not. 


1.5 Ability to recommend investment project

This function will recommend some project for users to invest. Such as stock, bond, insurance. The application will calculate user flexible asset which could be used to invest based on user income and expense record. 



# 2 Project constrains

2.1 System-supported platform

The application will be developed by using the following platform tools and programming language: 

o	Java

o	Android studio

o	MySQL database



2.2 Design constrains

Due to limited amount of developer and resource. This mobile application is mainly developed by using Android studio. It is only available for Android smart phones. Users must download an Android mobile application. We do not provide computer software, iOS application and website function. 



2.3 Compatibility

Mobile application should be Android-based.


# 3 SQLite
3.1 Database structure overview

SQLite is used for storing user data. There are total three tables created in expense tracker application:

•	TABLE “incomes”: for saving user incomes.

•	TABLE “expense”: for saving user expense.

•	TABLE “users”: for saving user profile.


3.2 TABLE “incomes”

o	_id, integer, primary key, automatic generated

o	Amount, text

o	Category, text

o	Date, text

o	Description, text

o	Image, text


3.3 TABLE “expense”

o	_id, integer, primary key, automatic generated

o	Amount, text

o	Category, text

o	Date, text

o	Description, text

o	Image, text



3.4 TABLE “users”

o	_id, integer, primary key, automatic generated

o	username, text

o	password, text


