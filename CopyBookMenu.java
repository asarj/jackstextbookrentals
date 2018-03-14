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

public class CopyBookMenu extends AppCompatActivity {
    Button copyShelf;
    EditText ogBook;
    EditText copyBook;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copy_book_menu);

        ogBook = (EditText) findViewById(R.id.copy_firstShelfInput);
        copyBook = (EditText)findViewById(R.id.copy_secondShelfInput);
        copyShelf = (Button)findViewById(R.id.copyToShelf);
        builder = new AlertDialog.Builder(this);

        copyShelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean failed = false;
                if(ogBook.getText().toString().trim().length() == 0){
                    failed = true;
                    ogBook.setError("This field cannot be empty!");
                }
                if(copyBook.getText().toString().trim().length() == 0){
                    failed = true;
                    copyBook.setError("This field cannot be empty!");
                }
                if(Integer.parseInt(ogBook.getText().toString()) > 20 || Integer.parseInt(ogBook.getText().toString()) < 0 ){
                    failed = true;
                    ogBook.setError("This rating is out of bounds!");
                }
                if(Integer.parseInt(copyBook.getText().toString()) > 20 || Integer.parseInt(copyBook.getText().toString()) < 0 ){
                    failed = true;
                    copyBook.setError("This rating is out of bounds!");
                }
                if(current.getBook(Integer.parseInt(ogBook.getText().toString()) - 1) == null){
                    failed = true;
                    ogBook.setError("No book exists at this index to loan!");
                }
                if(!failed){
                    try{
                        Book2 clonedCopy = current.getBook(Integer.parseInt(ogBook.getText().toString()) - 1).clone();
                        current.addBook(Integer.parseInt(copyBook.getText().toString()) - 1, clonedCopy);
                        builder.setCancelable(true);
                        builder.setTitle("Book Copy Verification");
                        builder.setMessage(current.getBook(Integer.parseInt(copyBook.getText().toString()) - 1).getTitle() + " has been successfully copied!");
                        builder.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent goBack = new Intent(CopyBookMenu.this, HomeScreen.class);
                                    goBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(goBack);
                                }
                            });
                        builder.setNegativeButton("COPY ANOTHER", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ogBook.getText().clear();
                                copyBook.getText().clear();
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
                        builder.setTitle("Book Copy Failed");
                        builder.setMessage("The shelf is too full! Consider removing some books or add to a different shelf");
                        builder.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent goBack = new Intent(CopyBookMenu.this, HomeScreen.class);
                                    goBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(goBack);
                                }
                            });
                        builder.setNeutralButton("REMOVE BOOKS", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent goRemove = new Intent(CopyBookMenu.this, RemoveBookMenu.class);
                                goRemove.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(goRemove);
                            }
                        });
                        builder.setNegativeButton("CHANGE SHELF", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent goChange = new Intent(CopyBookMenu.this, ChangeBookshelfMenu.class);
                                goChange.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(goChange);
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
