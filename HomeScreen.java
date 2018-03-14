/**
 * Name: Ajay Sarjoo
 * SOLAR ID#: 111623178
 * Email: ajay.sarjoo@stonybrook.edu
 * Assignment: Homework #1 (APP ASSIGNMENT)
 * CSE 214 Recitation R12
 */
package com.cse214hw1.ripoffrental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {
    Button bookAdd;
    Button loanBook;
    Button copyBook;
    Button removeBook;
    Button swapBook;
    Button changeShelf;
    Button overShelf;
    Button compShelf;
    Button printShelf;

    public static Bookshelf2 shelfA = new Bookshelf2();
    public static Bookshelf2 shelfB = new Bookshelf2();
    public static Bookshelf2 shelfC = new Bookshelf2();
    public static Bookshelf2 current = shelfA;
    public static String currentName = "Shelf A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        bookAdd = (Button)findViewById(R.id.addToShelfButton);
        loanBook = (Button)findViewById(R.id.loanBookButton);
        copyBook = (Button)findViewById(R.id.copyBookButton);
        removeBook = (Button)findViewById(R.id.removeBookButton);
        swapBook = (Button)findViewById(R.id.swapBookButton);
        changeShelf = (Button)findViewById(R.id.changeCurrentBookshelfButton);
        overShelf = (Button)findViewById(R.id.copyToSelectedShelfButton);
        compShelf = (Button)findViewById(R.id.compareBookshelfButton);
        printShelf = (Button)findViewById(R.id.printBookshelfButton);

        bookAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToAddMenu = new Intent(HomeScreen.this, AddBookMenu.class);
                startActivity(goToAddMenu);
            }
        });

        loanBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToLoanMenu = new Intent(HomeScreen.this, LoanBookMenu.class);
                startActivity(goToLoanMenu);
            }
        });

        copyBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToCopyMenu = new Intent(HomeScreen.this, CopyBookMenu.class);
                startActivity(goToCopyMenu);
            }
        });

        removeBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToRemoveMenu = new Intent(HomeScreen.this, RemoveBookMenu.class);
                startActivity(goToRemoveMenu);
            }
        });

        swapBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToSwapMenu = new Intent(HomeScreen.this, SwapBookMenu.class);
                startActivity(goToSwapMenu);
            }
        });

        changeShelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToChangeShelfMenu = new Intent(HomeScreen.this, ChangeBookshelfMenu.class);
                startActivity(goToChangeShelfMenu);
            }
        });

        overShelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToOverwriteShelfMenu = new Intent(HomeScreen.this, OverwriteBookshelfMenu.class);
                startActivity(goToOverwriteShelfMenu);
            }
        });

        compShelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToCompShelfMenu = new Intent(HomeScreen.this, CompareBookshelfMenu.class);
                startActivity(goToCompShelfMenu);
            }
        });

        printShelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToPrintMenu = new Intent(HomeScreen.this, PrintCurrentBookshelf.class);
                startActivity(goToPrintMenu);
            }
        });
    }
}
