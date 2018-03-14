# Jack’s aMAzin’ Textbook Rentals
Illustrates a textbook rental service that allows users to interact with books

Assignment Description:
College is getting to be really expensive, and it's been getting harder and harder to find the money. Luckily, after getting bored with being rejected by Harvard, your friend Jack Ma has come up with a scheme that will make you both a bit of extra cash on the side. He has realized that you can photocopy obscure textbooks where there is no PDF available, put the pages in a binder, and rent them out for cheaper than Amazon. He has started doing this, but his service became so popular that it was impossible to keep track of all the books he was doing. In order to not have to show up to work, he wants to be able to manipulate the text books on the shelves from his computer, and then have his workers at the warehouse do the physical labor. He has brought you to make him an electronic management system for his photocopied textbook warehouse. In this warehouse, he will have some number of shelves (he is starting with three, labeled A, B, and C), on each of which he keeps up to 20 photocopied textbooks (any more, and the shelf will break). Each textbook has a title, an author, a borrower name, and a condition score, ranking fromm 1-5. Due to his perfectionism, Jack will keep his textbooks in identical boxes, left aligned on the shelf, so that they are aesthetically pleasing. Even when a textbook itself is loaned out, the box will remain on the self as a place-holder, and it will contain the vital information about the book (title, author, borrower, and condition). He wants to be able to add a new book to the collection (whenever he manages to snag a new title and photocopy it), loan books out, duplicate a textbook by photocopying it (this will use the clone() method, as we want to be able to loan the textbook copies out independently) or even a shelf of his most popular titles, swap textbook orders on the shelves (for aesthetic and organizational balance), check if two shelves are identical in content, and remove sufficiently mutilated books from his system. You will write a program that simulates a warehouse with three shelves from the command line.
