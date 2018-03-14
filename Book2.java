/**
 * Name: Ajay Sarjoo
 * SOLAR ID#: 111623178
 * Email: ajay.sarjoo@stonybrook.edu
 * Assignment: Homework #1 (APP ASSIGNMENT)
 * CSE 214 Recitation R12
 */
package com.cse214hw1.ripoffrental;

public class Book2 {
    private String title;
    private String author;
    private String borrower;
    private int condition;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        if(condition > 0 && condition < 6){
            this.condition = condition;
        }
        else{
            System.out.println("Condition value is invalid, entry will not " +
                    "be added!");
        }
    }

    /**
     * <dt><b>Postconditions:</b><dd>
     *     The borrower of the book has been set to none
     *
     *
     * @param title The title of the book
     * @param author The author of the book
     * @param condition The condition of the book (1-5)
     */
    public Book2(String title, String author, int condition){
        this.title = title;
        this.author = author;
        this.condition = condition;
        this.borrower = "<none>";
    }

    /**
     *
     * @param obj, which is casted to a com.cse214hw1.ripoffrental.Book2
     * @return returns true if the title, author, and condition match the
     *         params title, author, and condition, returns false if any fields
     *         do not match
     */
    public boolean equals(Object obj){
        Book2 b = (Book2)obj;
        if(b == null){
            return false;
        }
        else{
            return b.title.compareTo(getTitle()) == 0 &&
                    b.author.compareTo(getAuthor()) == 0 &&
                    b.condition == getCondition();
        }
    }

    /**
     *
     * @return a duplicate copyShelf of com.cse214hw1.ripoffrental.Book2 b, with the borrower field being set to
     *         none
     */
    public Book2 clone(){
        Book2 clonedBook = new Book2(getTitle(), getAuthor(),
                getCondition());
        clonedBook.setBorrower("<none>");
        return clonedBook;
    }

    /**
     *
     * @return a neatly formatted String that details the book's title, author,
     *         condition and genre
     */
    public String toString(){
        String format = "Title: " + getTitle() + "\nAuthor: " + getAuthor() + "\nCondition: " + getCondition()
                + "\nBorrower: " + getBorrower();//String.format("%-10s %-40s %-40s %-10s", getTitle(), getAuthor(), getCondition(), getBorrower());
        return format;
    }
}
