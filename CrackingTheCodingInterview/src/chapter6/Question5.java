package chapter6;

/***
 * There is a building of 100 floors. If an egg drops from the Nth 
 * floor or above, it will break. If it's dropped from any 
 * floor below, it will not break. You're given two eggs. 
 * Find N, while minimizing the number of drops for the worst case.
 * 
 * Breaking one egg, but maximum of drops: 
 * 		Keep dropping from 1 to n, until it breaks. - Found n. Worst case: 100.
 * 
 * Breaking two eggs, half of worst case drops:
 * 		Drop from 50. If it breaks, iterate from 1 to 49. Else, iterate from 51 to 100. 
 * 		Worst case: 50;
 * 
 * Breaking two eggs, skipping 5:
 * 		Drop from 5. If it breaks, iterate from 1 to 5. Drop from 10.
 * 		Worst case: 25;
 * 
 * Breaking two eggs, skipping 10:
 * 		Drop from 10. If it breaks, iterate from 1 to 9. Else Drop from 10.
 * 		Worst case: 20;
 * 
 * Breaking many eggs, minimun of drops:
 * 		Drop from 50. If it breaks, drop from 25, else drop from 75. Keep slicing in half.
 * 		Worst case: log N drops and broken eggs.
 * 
 * 
 * Edit after looking at the answer: As in many other maximizing / minimizing problems, "
 * the key in this problem is "worst case balancing." - Could be 14 if it was balanced.
 */

public class Question5 {

}
