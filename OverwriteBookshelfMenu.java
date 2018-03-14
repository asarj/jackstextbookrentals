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

public class OverwriteBookshelfMenu extends AppCompatActivity {
    AlertDialog.Builder builder;
    Button copyA;
    Button copyB;
    Button copyC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overwrite_bookshelf_menu);

        copyA = (Button)findViewById(R.id.copyToAButton);
        copyB = (Button)findViewById(R.id.copyToBButton);
        copyC = (Button)findViewById(R.id.copyToCButton);
        builder = new AlertDialog.Builder(this);

        copyA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shelfA = current.clone();
                builder.setCancelable(true);
                builder.setTitle("Bookshelf Overwrite Verification");
                builder.setMessage("Bookshelf A has been overwritten by Book" + currentName);
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent goBack = new Intent(OverwriteBookshelfMenu.this, HomeScreen.class);
                                goBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(goBack);
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        copyB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shelfB = current.clone();
                builder.setCancelable(true);
                builder.setTitle("Bookshelf Overwrite Verification");
                builder.setMessage("Bookshelf B has been overwritten by Book" + currentName);
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent goBack = new Intent(OverwriteBookshelfMenu.this, HomeScreen.class);
                                goBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(goBack);
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        copyC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shelfC = current.clone();
                builder.setCancelable(true);
                builder.setTitle("Bookshelf Overwrite Verification");
                builder.setMessage("Bookshelf C has been overwritten by Book" + currentName);
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
