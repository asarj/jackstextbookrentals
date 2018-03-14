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

import static com.cse214hw1.ripoffrental.HomeScreen.shelfA;
import static com.cse214hw1.ripoffrental.HomeScreen.shelfB;
import static com.cse214hw1.ripoffrental.HomeScreen.shelfC;

public class CompareBookshelfMenu extends AppCompatActivity {
    AlertDialog.Builder builder;
    Button compare;
    EditText shelfInp1;
    EditText shelfInp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_bookshelf_menu);
        builder = new AlertDialog.Builder(this);
        compare = (Button)findViewById(R.id.compareShelvesButton);
        shelfInp1 = (EditText)findViewById(R.id.compare_shelf1Input);
        shelfInp2 = (EditText)findViewById(R.id.compare_shelfInput2);

        compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean failed = false;
                if(!(shelfInp1.getText().toString().matches("[a-cA-C]"))){
                    failed = true;
                    shelfInp1.setError("This field must be a valid Bookshelf2 choice!");
                }
                if(!(shelfInp2.getText().toString().matches("[a-cA-C]"))){
                    failed = true;
                    shelfInp2.setError("This field must be a valid Bookshelf2 choice!");
                }
                if(shelfInp1.getText().toString().trim().length() == 0){
                    failed = true;
                    shelfInp1.setError("This field cannot be empty!");
                }
                if(shelfInp2.getText().toString().trim().length() == 0){
                    failed = true;
                    shelfInp2.setError("This field cannot be empty");
                }
                if(!failed){
                    String a = shelfInp1.getText().toString();
                    String aName = "";
                    String b = shelfInp2.getText().toString();
                    String bName = "";
                    Bookshelf2 b1 = null;
                    Bookshelf2 b2 = null;
                    if(a.equals("a") || a.equals("A")){
                        b1 = shelfA;
                        aName = "Shelf A";
                    }
                    else if(a.equals("b") || a.equals("B")){
                        b1 = shelfB;
                        aName = "Shelf B";
                    }
                    else if(a.equals("c") || a.equals("C")){
                        b1 = shelfC;
                        aName = "Shelf C";
                    }

                    if(b.equals("a") || b.equals("A")){
                        b2 = shelfA;
                        bName = "Shelf A";
                    }
                    else if(b.equals("b") || b.equals("B")){
                        b2 = shelfB;
                        bName = "Shelf B";
                    }
                    else if(b.equals("c") || b.equals("C")){
                        b2 = shelfC;
                        bName = "Shelf C";
                    }

                    if(b1.equals(b2)){
                        builder.setCancelable(true);
                        builder.setTitle("Bookshelf Comparison Results");
                        builder.setMessage("Book" + aName + " and Book" + bName + " are equal!");
                        builder.setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent goBack = new Intent(CompareBookshelfMenu.this, HomeScreen.class);
                                        goBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(goBack);
                                    }
                                });
                        builder.setNegativeButton("COMPARE", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                shelfInp1.getText().clear();
                                shelfInp2.getText().clear();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                    else{
                        builder.setCancelable(true);
                        builder.setTitle("Bookshelf Comparison Results");
                        builder.setMessage("Book" + aName + " and Book" + bName + " are not equal!");
                        builder.setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent goBack = new Intent(CompareBookshelfMenu.this, HomeScreen.class);
                                        goBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(goBack);
                                    }
                                });
                        builder.setNegativeButton("COMPARE", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                shelfInp1.getText().clear();
                                shelfInp2.getText().clear();
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
