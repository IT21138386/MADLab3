package com.spsh.madtutorial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.spsh.madtutorial1.data.Message;

public class MainActivity extends AppCompatActivity {   //this class only handles user interactions and things related to android in that particular activity
    EditText txtMessage; //object from EditText
    Button btnSend; //button object, can be globally accessed
    Message message; //creating object from the Message class we created
    String message1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMessage = findViewById(R.id.et_1_sathira); //initializing object from like 11
        btnSend = findViewById(R.id.bt_1_sathira); //initialized means, this object has all the attributes of their respective components
        //for example if you want to change the color of the button you can do it using the above btnSend object
        message = new Message(); //initialized message object

        //instead of getting text in the onclick method ,after text is entered it will be stored
        txtMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //these cannot be removed they must be kept empty, if not you get an error
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //these cannot be removed they must be kept empty, if not you get an error
            }

            @Override
            public void afterTextChanged(Editable editable) {
                message.setMessage(editable.toString()); //using setter
                message1 = editable.toString();
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, message.getMessage(), Toast.LENGTH_LONG).show(); //context means the current Activity we are on which is given by "this" -> then you must give the sequence(message)->then you have to give the duration of the toast message-> then finally we have to call show() method for the toast message to appear
            }
        });
    }

    //choose this in the method in the onClick attribute of the button if you are using this method
//    public void displayMessage(View view){ //this is one way to display the toast message, if you use this method then no need to initialize button object
////        message.setMessage(txtMessage.getText().toString()); //using setter
//        Toast.makeText(this, message.getMessage(), Toast.LENGTH_LONG).show(); //context means the current Activity we are on which is given by "this" -> then you must give the sequence(message)->then you have to give the duration of the toast message-> then finally we have to call show() method for the toast message to appear
//
//        //message1 = txtMessage.getText().toString();
////        Toast.makeText(this, message1, Toast.LENGTH_SHORT).show();
//    }
}