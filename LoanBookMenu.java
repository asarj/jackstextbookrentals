/**
 * Name: Ajay Sarjoo
 * SOLAR ID#: 111623178
 * Email: ajay.sarjoo@stonybrook.edu
 * Assignment: Homework #1 (APP ASSIGNMENT)
 * CSE 214 Recitation R12
 */
package com.cse214hw1.ripoffrental;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.cse214hw1.ripoffrental.HomeScreen.current;
import static com.cse214hw1.ripoffrental.HomeScreen.currentName;
import static com.cse214hw1.ripoffrental.HomeScreen.shelfA;
import static com.cse214hw1.ripoffrental.HomeScreen.shelfB;
import static com.cse214hw1.ripoffrental.HomeScreen.shelfC;

public class LoanBookMenu extends AppCompatActivity {
    Button loan;
    EditText shelfInp;
    EditText recipientInp;
    EditText condInp;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_book_menu);

        loan = (Button)findViewById(R.id.loanBookButton);
        recipientInp = (EditText)findViewById(R.id.loan_personInput);
        condInp = (EditText)findViewById(R.id.loan_conditionInput);
        shelfInp = (EditText)findViewById(R.id.loan_shelfInput);
        builder = new AlertDialog.Builder(this);

        loan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean failed = false;
                if(recipientInp.getText().toString().trim().length() == 0){
                    failed = true;
                    recipientInp.setError("This field cannot be empty!");
                }
                if(condInp.getText().toString().trim().length() == 0){
                    failed = true;
                    condInp.setError("This field cannot be empty!");
                }
                if(shelfInp.getText().toString().trim().length() == 0){
                    failed = true;
                    shelfInp.setError("This field cannot be empty!");
                }
                if(Integer.parseInt(condInp.getText().toString()) > 5 || Integer.parseInt(condInp.getText().toString()) < 1 ){
                    failed = true;
                    condInp.setError("This rating is out of bounds!");
                }
                if(Integer.parseInt(shelfInp.getText().toString()) > 20 || Integer.parseInt(shelfInp.getText().toString()) < 0 ){
                    failed = true;
                    shelfInp.setError("This rating is out of bounds!");
                }
                if(current.getBook(Integer.parseInt(shelfInp.getText().toString()) - 1) == null){
                    failed = true;
                    shelfInp.setError("No book exists at this index to loan!");
                }
                if(!failed){
                    current.getBook(Integer.parseInt(shelfInp.getText().toString()) - 1).setBorrower(recipientInp.getText().toString());
                    current.getBook(Integer.parseInt(shelfInp.getText().toString()) - 1).setCondition(Integer.parseInt(condInp.getText().toString()));
                    builder.setCancelable(true);
                    builder.setTitle("Loan Verification");
                    builder.setMessage(current.getBook(Integer.parseInt(shelfInp.getText().toString()) - 1).getTitle() + " loaned to " + recipientInp.getText().toString() + " successfully!");
                    builder.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent goBack = new Intent(LoanBookMenu.this, HomeScreen.class);
                                    goBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(goBack);
                                }
                            });
                    builder.setNegativeButton("LOAN ANOTHER", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            recipientInp.getText().clear();
                            condInp.getText().clear();
                            shelfInp.getText().clear();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    switch (currentName) {
                        case "Shelf A":
                            shelfA = current;
                            break;
                        case "Shelf B":
                            shelfB = current;
                            break;
                        case "Shelf C":
                            shelfC = current;
                            break;
                    }

                }
            }
        });
    }
}
