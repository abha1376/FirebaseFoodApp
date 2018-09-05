package com.example.abhatripathi.serverappfoodcubo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.abhatripathi.serverappfoodcubo.Common.Common;
import com.example.abhatripathi.serverappfoodcubo.model.User;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {
    EditText edtphone,edtPassword;
    Button btnSignin;
    FirebaseDatabase db;
    DatabaseReference users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        edtPassword = (MaterialEditText) findViewById(R.id.edtPassword);
        edtphone = (MaterialEditText) findViewById(R.id.edtPhone);
        btnSignin = (Button) findViewById(R.id.btnSignIn);
        //init firebase
        FirebaseApp.initializeApp(this);
        db = FirebaseDatabase.getInstance();
        users = db.getReference("User");
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInUser(edtphone.getText().toString(), edtPassword.getText().toString());
            }


        });
    }
        private void signInUser(String phone, String password) {
            final ProgressDialog mDialog=new ProgressDialog(SignIn.this);
            mDialog.setMessage("Please wait....");
            mDialog.show();
            final String localPhone=phone;
            final String localPassword=password;
            users.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.child(localPhone).exists()){
                        mDialog.dismiss();
                        User user= dataSnapshot.child(localPhone).getValue(User.class);
                        user.setPhone(localPhone);
                        if(Boolean.parseBoolean(user.getIsStaff())){   // if isStaff==true
                            if(user.getPassword().equals(localPassword)){
                                Intent login = new Intent(SignIn.this,Home.class);
                                Common.currentUser=user;
                                startActivity(login);
                                finish();
                            }
                            else{
                                Toast.makeText(SignIn.this,"Wrong Password!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(SignIn.this,"Please login with staff account!", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        mDialog.dismiss();
                        Toast.makeText(SignIn.this,"User does not exiat in database!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }

