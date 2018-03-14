/**
 * Name: Ajay Sarjoo
 * SOLAR ID#: 111623178
 * Email: ajay.sarjoo@stonybrook.edu
 * Assignment: Homework #1 (APP ASSIGNMENT)
 * CSE 214 Recitation R12
 */
package com.cse214hw1.ripoffrental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import static com.cse214hw1.ripoffrental.HomeScreen.currentName;
import static com.cse214hw1.ripoffrental.HomeScreen.current;
import static com.cse214hw1.ripoffrental.HomeScreen.shelfA;
import static com.cse214hw1.ripoffrental.HomeScreen.shelfB;
import static com.cse214hw1.ripoffrental.HomeScreen.shelfC;

public class PrintCurrentBookshelf extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_current_bookshelf);
        TextView count = findViewById(R.id.bookshelfCount);
        TextView disp = findViewById(R.id.bookshelfDetails);
        TextView shelf = findViewById(R.id.shelfDisplay);
        String total = "";
        switch (currentName) {
            case "Shelf A":
                shelf.setText(currentName);
                total = Integer.toString(shelfA.numBooks());
                count.setText(String.format("%s books found", total));
                disp.setText(shelfA.toString());
                break;
            case "Shelf B":
                shelf.setText(currentName);
                total = Integer.toString(shelfB.numBooks());
                count.setText(String.format("%s books found", total));
                disp.setText(shelfB.toString());
                break;
            case "Shelf C":
                shelf.setText(currentName);
                total = Integer.toString(shelfC.numBooks());
                count.setText(String.format("%s books found", total));
                disp.setText(shelfC.toString());
                break;
        }

    }
}
