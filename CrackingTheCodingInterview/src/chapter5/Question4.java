package chapter5;

/***
 * Explain what the following code does :((n & (n-1)) == 0).
 * @author Marcel
 *
 * The code checks wether an int n and an int n-1 never has paired 1's.
 * e.g. 0100(4) and 0011(3) would be true, 0101(5) and 0100(4) would be false.
 * This is just true if n is 2ˆx.
 *
 */
