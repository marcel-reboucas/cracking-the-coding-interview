package chapter6;

/***
 * You have 20 bottles of pills. 19 bottles have 1.0 gram pills, 
 * but one has pills of weight 1.1 grams. Given a scale that provides 
 * an exact measurement, how would you find the heavy bottle? 
 * You can only use the scale once.
 * @author Marcel
 *
 *
 * I would leave 1 pill on the first bottle, 2 on the second and so on. 
 * Then, would weight all bottles and remove the base weight (210 grams (21*10)). 
 * The rest, divided by 0.1 is the number of the heavy bottle.
 */
