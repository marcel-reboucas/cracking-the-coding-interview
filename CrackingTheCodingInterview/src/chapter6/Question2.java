package chapter6;

/***
 * There is an 8x8 chess board in which two diagonally opposite corners have
 * been cut off. You are given 31 dominos, and a single domino can cover exactly
 * two squares. Can you use the 31 dominos to cover the entire board? Prove your
 * answer (by providing an example or showing why it's impossible).
 * 
 * @author Marcel
 * 
 *         The board now has 62 squares - 6 rows with 8 squares and 2 rows with
 *         7 squares. Now, it its impossible, because you always end up with
 *         diagonal-squares - since to fill each row, you always take one space
 *         of another. And it doesn't fit on the last row.
 *
 *         EDIT AFTER LOOKING THE ANSWER: The black and white solution is
 *         actually much better.
 */
