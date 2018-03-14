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

import static com.cse214hw1.ripoffrental.HomeScreen.current;
import static com.cse214hw1.ripoffrental.HomeScreen.currentName;
import static com.cse214hw1.ripoffrental.HomeScreen.shelfA;
import static com.cse214hw1.ripoffrental.HomeScreen.shelfB;
import static com.cse214hw1.ripoffrental.HomeScreen.shelfC;

public class ChangeBookshelfMenu extends AppCompatActivity {
    AlertDialog.Builder builder;
    Button changeA;
    Button changeB;
    Button changeC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_bookshelf_menu);

        changeA = (Button)findViewById(R.id.changeToAButton);
        changeB = (Button)findViewById(R.id.changeToBButton);
        changeC = (Button)findViewById(R.id.changeToCButton);
        builder = new AlertDialog.Builder(this);

        changeA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current = shelfA;
                currentName = "Shelf A";
                builder.setCancelable(true);
                builder.setTitle("Bookshelf Change Verification");
                builder.setMessage("Bookshelf is now Book" + currentName);
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent goBack = new Intent(ChangeBookshelfMenu.this, HomeScreen.class);
                                goBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(goBack);
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        changeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current = shelfB;
                currentName = "Shelf B";
                builder.setCancelable(true);
                builder.setTitle("Bookshelf Change Verification");
                builder.setMessage("Bookshelf is now Book" + currentName);
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent goBack = new Intent(ChangeBookshelfMenu.this, HomeScreen.class);
                                goBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(goBack);
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        changeC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current = shelfC;
                currentName = "Shelf C";
                builder.setCancelable(true);
                builder.setTitle("Bookshelf Change Verification");
                builder.setMessage("Bookshelf is now Book" + currentName);
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent goBack = new Intent(ChangeBookshelfMenu.this, HomeScreen.class);
                                goBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(goBack);
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
