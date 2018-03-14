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

public class AddBookMenu extends AppCompatActivity {
    Button bookToAdd;
    EditText titleInp;
    EditText authorInp;
    EditText condInp;
    EditText shelfInp;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_menu);

        bookToAdd = (Button)findViewById(R.id.addToShelfButton);
        titleInp = (EditText)findViewById(R.id.add_titleInput);
        authorInp = (EditText)findViewById(R.id.add_authorInput);
        condInp = (EditText)findViewById(R.id.add_conditionInput);
        shelfInp = (EditText)findViewById(R.id.add_ShelfInput);
        builder = new AlertDialog.Builder(this);

        bookToAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean failed = false;
                if(titleInp.getText().toString().trim().length() == 0){
                    failed = true;
                    titleInp.setError("This field cannot be empty!");
                }
                if (authorInp.getText().toString().trim().length() == 0){
                    failed = true;
                    authorInp.setError("This field cannot be empty!");
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
                if(!failed){
                    Book2 b = new Book2(titleInp.getText().toString(), authorInp.getText().toString(), Integer.parseInt(condInp.getText().toString()));
                    try{
                        int index = Integer.parseInt(shelfInp.getText().toString()) - 1;
                        current.addBook(index, b);
                        builder.setCancelable(true);
                        builder.setTitle("Added Book2 Verification");
                        builder.setMessage(titleInp.getText().toString() + " added to " + currentName + " successfully!");
                        builder.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent goBack = new Intent(AddBookMenu.this, HomeScreen.class);
                                    goBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(goBack);
                                }
                            });
                        builder.setNegativeButton("ADD ANOTHER", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                titleInp.getText().clear();
                                authorInp.getText().clear();
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
                    catch(FullShelfException2 f){
                        builder.setCancelable(true);
                        builder.setTitle("Added Book Failed");
                        builder.setMessage("The Bookshelf is full!");
                        builder.setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent goBack = new Intent(AddBookMenu.this, HomeScreen.class);
                                        goBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(goBack);
                                    }
                                });

                        builder.setNegativeButton("REMOVE BOOKS", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent goRemove = new Intent(AddBookMenu.this, RemoveBookMenu.class);
                                goRemove.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(goRemove);
                            }
                        });
                    }
                }

            }
        });



    }
}
