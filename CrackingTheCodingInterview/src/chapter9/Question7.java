package chapter9;

/***
 * Implement the "paint fill" function that one might see on many image editing programs. 
 * That is, given a screen (represented by a two-dimensional array of colors), a point, 
 * and a new color, fill in the surrounding area until the color changes from the original
 * color.
 */

enum Color {
	Red,
	Green,
	Blue,
	Yellow,
	White,
	Black
}

public class Question7 {

	private static void fill(Color[][] picture, int x, int y, Color initialColor, Color newColor) {
		
		if (x < 0 || x > picture[0].length-1 || y < 0 || y > picture.length-1) {
			return;
		}
		
		if (picture[y][x] == initialColor){
			picture[y][x] = newColor;
			fill(picture, x - 1, y, initialColor, newColor);
			fill(picture, x + 1, y, initialColor, newColor);
			fill(picture, x, y - 1, initialColor, newColor);
			fill(picture, x, y + 1, initialColor, newColor);
		} 
	}
	
	public static void fill(Color[][] picture, int x, int y, Color newColor) {
		
		if (x < 0 || x > picture[0].length-1 || y < 0 || y > picture.length-1) {
			return;
		}
	
		fill(picture, x, y,picture[y][x], newColor);
	}
	
	public static void main(String[] args) {
		
		Color[][] picture = new Color[][]{
			{Color.Red,Color.Red,Color.Yellow,Color.Red},
			{Color.Green,Color.Red,Color.Yellow,Color.Red},
			{Color.Yellow,Color.Red,Color.Red,Color.Blue},
			{Color.Red,Color.Red,Color.Red,Color.Red}};
		
			
			//System.out.println(p.nearPoints(5, 5));
			
			fill(picture, 1,1, Color.White);
			
			for (Color[] row : picture){
				for (Color c : row){
					System.out.print(c.name()+"\t");
				}
				System.out.println();
			}
	}
}
