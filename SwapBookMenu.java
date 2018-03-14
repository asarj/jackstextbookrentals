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

public class SwapBookMenu extends AppCompatActivity {
    AlertDialog.Builder builder;
    Button swap;
    EditText shelfInp1;
    EditText shelfInp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap_book_menu);

        builder = new AlertDialog.Builder(this);
        swap = (Button)findViewById(R.id.swapBookButton);
        shelfInp1 = (EditText)findViewById(R.id.swap_shelfInput1);
        shelfInp2 = (EditText)findViewById(R.id.swap_shelfInput2);

        swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean failed = false;
                if(shelfInp1.getText().toString().trim().length() == 0){
                    failed = true;
                    shelfInp1.setError("This field cannot be empty!");
                }
                if(Integer.parseInt(shelfInp1.getText().toString()) > 20 || Integer.parseInt(shelfInp1.getText().toString()) < 0 ){
                    failed = true;
                    shelfInp1.setError("This rating is out of bounds!");
                }
                if(shelfInp2.getText().toString().trim().length() == 0){
                    failed = true;
                    shelfInp2.setError("This field cannot be empty!");
                }
                if(Integer.parseInt(shelfInp2.getText().toString()) > 20 || Integer.parseInt(shelfInp2.getText().toString()) < 0 ){
                    failed = true;
                    shelfInp2.setError("This rating is out of bounds!");
                }
                if(current.getBook(Integer.parseInt(shelfInp1.getText().toString()) - 1) == null && current.getBook(Integer.parseInt(shelfInp2.getText().toString()) - 1) == null){
                    failed = true;
                    builder.setCancelable(true);
                    builder.setTitle("Book Swap Failed");
                    builder.setMessage("There are no books to swap at these indices!");
                    builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent goBack = new Intent(SwapBookMenu.this, HomeScreen.class);
                                goBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(goBack);
                            }
                        });
                    builder.setNeutralButton("EDIT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            shelfInp1.getText().clear();
                            shelfInp2.getText().clear();
                        }
                    });
                    builder.setNegativeButton("ADD BOOKS", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent goAdd = new Intent(SwapBookMenu.this, AddBookMenu.class);
                            goAdd.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(goAdd);
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                if(!failed){
                    current.swapBooks(Integer.parseInt(shelfInp1.getText().toString()) - 1, Integer.parseInt(shelfInp2.getText().toString()) - 1);
                    builder.setCancelable(true);
                    builder.setTitle("Book Swap Verification");
                    builder.setMessage(current.getBook(Integer.parseInt(shelfInp1.getText().toString()) - 1).getTitle() + " and " + current.getBook(Integer.parseInt(shelfInp2.getText().toString()) - 1).getTitle() + " have swapped successfully!");
                    builder.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent goBack = new Intent(SwapBookMenu.this, HomeScreen.class);
                                    goBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(goBack);
                                }
                            });
                    builder.setNegativeButton("SWAP ANOTHER", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            shelfInp1.getText().clear();
                            shelfInp2.getText().clear();
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
