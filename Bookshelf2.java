/**
 * Name: Ajay Sarjoo
 * SOLAR ID#: 111623178
 * Email: ajay.sarjoo@stonybrook.edu
 * Assignment: Homework #1 (APP ASSIGNMENT)
 * CSE 214 Recitation R12
 */
package com.cse214hw1.ripoffrental;

public class Bookshelf2 {
    public final int CAPACITY = 20;
    private int count;
    private Book2[] books;


    public Bookshelf2(){
        this.books = new Book2[CAPACITY];
        this.count = 0;
    }

    public int numBooks(){
        return this.count;
    }

    /**
     * Preconditions:
     *
     *     index must be between 0-19, inclusive
     *
     * Postconditions:
     *
     *     A com.cse214hw1.ripoffrental.Book2 at the given index is return
     *     ed
     * @param index that is an integer value
     * @return a book at the index
     * @exception ArrayIndexOutOfBoundsException if index is not valid
     */
    public Book2 getBook(int index){
        try{
            return this.books[index];
        }
        catch(ArrayIndexOutOfBoundsException a){
            throw new ArrayIndexOutOfBoundsException("Index is not valid");
        }
    }

    /**
     * <dt><b>Preconditions:</b><dd>
     *     The index that the book is retrieved from exists
     *
     *
     * <dt><b>Postconditions:</b><dd>
     *     The book is removed and the all book2s in the shelf are shifted to
     *     the right, or an exception occurs and the com.cse214hw1.ripoffrental.Bookshelf2 is not altered
     * @param index that is an integer value
     * @throws EmptyShelfException2 if there are no book2s on the shelf to
     *         remove
     * @throws ArrayIndexOutOfBoundsException if the index is greater than the
     *         size of the shelf array
     */
    public void removeBook(int index) throws EmptyShelfException2,
            ArrayIndexOutOfBoundsException{
        try{
            if(numBooks() == 0){
                throw new EmptyShelfException2("There is no book on the shelf");
            }
            else{
                String titleRemoved = getBook(index).getTitle();
                String authorRemoved = getBook(index).getAuthor();
                this.books[index] = null;
                for(int i = index; i < this.books.length - 1; i++){
                    this.books[i] = this.books[i + 1];
                    this.books[i + 1] = null;
                }
                this.count--;
                System.out.println("\nRemoval Successful!\n" + titleRemoved +
                        " by " + authorRemoved + " has been removed\n\n");
            }
        }
        catch(ArrayIndexOutOfBoundsException a){
            System.out.println("Index is not valid");
        }

    }

    /**
     * <dt><b>Preconditions:</b><dd>
     *     There are either no book2s on the shelf, the index the
     *               book2 will be placed is a valid index, or the com.cse214hw1.ripoffrental.Bookshelf2 can
     *               be shifted if space needs to be made for the book2 at the
     *               index
     *
     *
     * <dt><b>Postconditions:</b><dd>
     *     com.cse214hw1.ripoffrental.Book2 is added to the com.cse214hw1.ripoffrental.Bookshelf2, the book2 count has
     *                incremented, and all the book2s will shift accordingly.
     *                If the book2 cannot be added, the method will return a
     *                list of indices that the book2 can be placed in,
     *                or return an exception that the shelf is full or index is
     *                too high, and the com.cse214hw1.ripoffrental.Bookshelf2 remains unchanged
     * @param index that is an integer value
     * @param book2 that contains a title, author, and condition
     * @throws FullShelfException2 if com.cse214hw1.ripoffrental.Bookshelf2 is full
     * @throws IllegalArgumentException if index is too high
     */
    public void addBook(int index, Book2 book2) throws FullShelfException2,
            IllegalArgumentException{
        try{
            if(numBooks() + 1 > CAPACITY){
                throw new FullShelfException2("Shelf is full, please try a " +
                        "different shelf or remove some books");
            }
            else if(index == 19 && this.books[19] != null){
                String options = "";
                System.out.println("Books cannot be shifted, please try a " +
                        "different index (1-20) that hasn't been filled yet");
                System.out.print("Available indexes are: ");
                for(int i = 0; i < this.books.length; i++){
                    if(this.books[i] == null){
                        options += Integer.toString(i + 1) + "\n";
                    }
                }
                if (options.matches("[0-9]+")){
                    System.out.println(options);
                }
                else{
                    System.out.println("None available\n");
                    throw new FullShelfException2("Full");
                }
            }
            else{
                if(this.books[index] == null){
                    this.books[index] = book2;
                    count++;
                    System.out.println(book2.getTitle() + " has been added\n");
                }
                else if(book2.equals(getBook(index))){
                    System.out.println("Attempting to add duplicate book, " +
                            "already in system");
                }
                else{
                    for(int i = this.books.length - 1; i > index; i--){
                        if(this.books[i - 1] == null){
                            continue;
                        }
                        else{
                            this.books[i] = this.books[i - 1];
                        }
                    }
                    this.books[index] = book2;
                    count++;
                    System.out.println("Book has been added\n");
                }

            }
        }
        catch(IllegalArgumentException i){
            System.out.println("Index is too high");
        }
    }

    /**
     * <dt><b>Preconditions:</b><dd>
     *     Both indices are valid and at least one of the indices
     *               that is retrieved using getBook() returns an actual book
     *
     *
     * <dt><b>Postconditions:</b><dd>
     *     Both book2s are swapped, or one book is moved to another
     *                index if the other index returns a blank slot, or throws
     *                an exception if one or both indices are invalid. If
     *                exception is thrown, no book2s are swapped, com.cse214hw1.ripoffrental.Bookshelf2
     *                remains unchanged
     * @param index1 that is a valid integer
     * @param index2 that is a valid integer
     * @throws ArrayIndexOutOfBoundsException if either index is invalid
     */
    public void swapBooks(int index1, int index2) throws
            ArrayIndexOutOfBoundsException{
        try{
            Book2 temp = this.books[index1];
            this.books[index1] = this.books[index2];
            this.books[index2] = temp;
            System.out.println("Books have been swapped!");
        }
        catch(ArrayIndexOutOfBoundsException a){
            System.out.println("Invalid Index");
        }
    }

    /**
     *
     * @return a duplicate copyShelf of all the book2s in the com.cse214hw1.ripoffrental.Bookshelf2, and sets all
     *         the book2s in the borrower field to none to indicate that
     *         there is no borrower in the copyShelf com.cse214hw1.ripoffrental.Bookshelf2
     */
    @Override
    public Bookshelf2 clone(){
        Bookshelf2 clonedBookshelf2 = new Bookshelf2();
        for(int i = 0; i < this.books.length; i++){
            Book2 original = this.books[i];
            if(original == null){
                continue;
            }
            else if(original.getBorrower().equals("<none>") ||
                    original.getBorrower().length() > 0){
                original.setBorrower("<none>");
                try {
                    clonedBookshelf2.addBook(i, original);
                }
                catch (FullShelfException2 e) {
                    System.out.println("Caught Full Shelf Exception");
                }
            }

        }

        return clonedBookshelf2;
    }

    /**
     *
     * @param o, which is casted to a com.cse214hw1.ripoffrental.Bookshelf2
     * @return true if all the book2s in the com.cse214hw1.ripoffrental.Bookshelf2 are equal to the book2s in
     *         the other com.cse214hw1.ripoffrental.Bookshelf2, returns false if any of the book2s are not
     *         equal to each other
     */
    public boolean equals(Object o){
        Bookshelf2 b = (Bookshelf2)o;
        for(int i = 0; i < b.books.length; i++){
            if((this.books[i] == null && b.books[i] == null) ||
                    (this.books[i].equals(b.books[i]))){
                continue;
            }
            else if((this.books[i] != null && b.books[i] == null) ||
                    (this.books[i] == null && b.books[i] != null)){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @return a String that is designed in a table format detailing all the
     *         book2s (if any) that are contained in the com.cse214hw1.ripoffrental.Bookshelf2
     */
    public String toString(){
        String output = "";
        for(int i = 0; i < this.books.length; i++){
            if(!(getBook(i) == null)){
                output += String.format("%d.\n%s\n\n", i + 1, getBook(i).toString());
            }
            else{
                continue;
            }
        }
        return output;
    }
}
