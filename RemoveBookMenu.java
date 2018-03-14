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

public class RemoveBookMenu extends AppCompatActivity {
    Button remove;
    EditText shelfInp;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_book_menu);

        remove = (Button)findViewById(R.id.removeBookButton);
        shelfInp = (EditText)findViewById(R.id.remove_shelfInput);
        builder = new AlertDialog.Builder(this);

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean failed = false;
                if(shelfInp.getText().toString().trim().length() == 0){
                    failed = true;
                    shelfInp.setError("This field cannot be empty!");
                }
                if(Integer.parseInt(shelfInp.getText().toString()) > 20 || Integer.parseInt(shelfInp.getText().toString()) < 0 ){
                    failed = true;
                    shelfInp.setError("This rating is out of bounds!");
                }
                if(!failed){
                    try{
                        String removedBook = current.getBook(Integer.parseInt(shelfInp.getText().toString()) - 1).getTitle();
                        current.removeBook(Integer.parseInt(shelfInp.getText().toString()) - 1);
                        builder.setCancelable(true);
                        builder.setTitle("Removal Verification");
                        builder.setMessage(removedBook + " has been removed");
                        builder.setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent goBack = new Intent(RemoveBookMenu.this, HomeScreen.class);
                                        goBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(goBack);
                                    }
                                });
                        builder.setNegativeButton("REMOVE ANOTHER", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
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
                    catch(EmptyShelfException2 e){
                        builder.setCancelable(true);
                        builder.setTitle("Removal Failed");
                        builder.setMessage("There are no books on the shelf!");
                        builder.setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent goBack = new Intent(RemoveBookMenu.this, HomeScreen.class);
                                        goBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(goBack);
                                    }
                                });
                        builder.setNegativeButton("ADD BOOKS", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent goAdd = new Intent(RemoveBookMenu.this, AddBookMenu.class);
                                goAdd.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(goAdd);
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }

                }
            }
        });
    }
}
