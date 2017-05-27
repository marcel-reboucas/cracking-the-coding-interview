package chapter3;

import java.util.LinkedList;

/**
 * An animal shelter holds only dogs and cats, and operates on a strictly "first
 * in, first out" basis. People must adopt either the "oldest" (based on arrival
 * time) of all animals at the shelter, or they can select whether they would
 * prefer a dog or a cat (and will receive the oldest animal of that type). They
 * cannot select which specific animal they would like. Create the data
 * structures to maintain this system and implement opera- tions such as
 * enqueue, dequeueAny, dequeueDog and dequeueCat. Youmay use the built-in
 * LinkedList data structure.
 */
public class Question7 {

	public static void main(String[] args) {

		Shelter shelter = new Shelter();

		shelter.enqueue(new Dog("DOG1"));
		shelter.enqueue(new Cat("CAT1"));
		shelter.enqueue(new Dog("DOG2"));
		shelter.enqueue(new Dog("DOG3"));
		shelter.enqueue(new Dog("DOG4"));
		shelter.enqueue(new Cat("CAT2"));
		shelter.enqueue(new Cat("CAT3"));

		System.out.println(shelter);

		System.out.println(shelter.dequeueCat());
		System.out.println(shelter);
		System.out.println(shelter.dequeueDog());
		System.out.println(shelter);
		System.out.println(shelter.dequeueAny());
		System.out.println(shelter);
		System.out.println(shelter.dequeueDog());
		System.out.println(shelter);
		System.out.println(shelter.dequeueCat());
		System.out.println(shelter);

	}
}

class Shelter {

	private LinkedList<Animal> animals;

	public Shelter() {
		animals = new LinkedList<Animal>();
	}

	public void enqueue(Animal animal) {
		animals.add(animal);
	}

	public Animal dequeueAny() {

		if (!animals.isEmpty()) {
			return animals.poll();
		}

		return null;
	}

	public Dog dequeueDog() {

		Dog dog = null;

		for (Animal animal : animals) {
			if (animal instanceof Dog) {
				dog = (Dog) animal;
				break;
			}
		}

		if (dog != null) {
			animals.remove(dog);
		}
		return dog;
	}

	public Cat dequeueCat() {

		Cat cat = null;

		for (Animal animal : animals) {
			if (animal instanceof Cat) {
				cat = (Cat) animal;
				break;
			}
		}

		if (cat != null) {
			animals.remove(cat);
		}
		return cat;
	}

	public String toString() {
		return animals.toString();
	}
}

abstract class Animal {

	String name;

	public Animal(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return getName();
	}
}

class Dog extends Animal {

	public Dog(String name) {
		super(name);
	}
}

class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}
}