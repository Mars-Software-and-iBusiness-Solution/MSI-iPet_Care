package com.mars.itech.msi_ipetcare.Java_Class;

import android.widget.EditText;

public class User_Register_Details
{



    public String Name, Email,NIC,Phone,VehicleB,VehicleM,VehicleN ,Date;


    public User_Register_Details(EditText name, EditText email, EditText NIC , EditText phone , EditText vehicleB , EditText vehicleM , EditText vehicleN)
    {


    }



    public User_Register_Details(String name, String email, String NIC, String phone, String vehicleB, String vehicleM, String vehicleN, String date) {
        Name = name;
        Email = email;
        this.NIC = NIC;
        Phone = phone;
        VehicleB = vehicleB;
        VehicleM = vehicleM;
        VehicleN = vehicleN;
        Date = date;
    }
}
