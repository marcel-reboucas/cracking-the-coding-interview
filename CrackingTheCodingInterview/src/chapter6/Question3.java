package chapter6;

/*** 
 * You have a five-quart jug, a three-quart jug, 
 * and an unlimited supply of water (but no measuring cups). 
 * How would you come up with exactly four quarts of water? 
 * Note that the jugs are oddly shaped, such that filling up 
 * exactly "half" of the jug would be impossible.
 * @author Marcel
 *
 * Fill the 3/4, and pour into the 5/4.
 * Then fill the 3/4 again, and pour into the 5/4 until it is full.
 * We are now left with 1/4 of water inside the 3/4 jug.
 * Throw the 5/4 water away, and fill it with the 1/4 from the 3/4 jug.
 * Then, fill the 3/4 and put it on the 5/4 jug. We now have 4/4 inside the 5/4 jug.
 */