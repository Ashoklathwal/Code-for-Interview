/*
*
*  We could explore a variety of solutions to this problem. For instance, we could maintain a single queue.
* This would make dequeueAny easy, but dequeueDog and dequeueCat would require iteration through
* the queue to find the first dog or cat. This would increase the complexity of the solution and decrease the
* efficiency.
* An alternative approach that is simple, clean and efficient is to simply use separate queues for dogs and
* cats, and to place them within a wrapper class called Anima lQueue. We then store some sort of timestamp
* to mark when each animal was enqueued. When we call dequeueAny, we peek at the heads of both the
* dog and cat queue and return the oldest.
*
* Desigin data structures for Cat and Dog, and Animal.
* @throws Exception 
*  
*  @Runtime & spaces
* 	runtime: O(1)
* 	space: O(n)
*
*/
import java.util.List;
import java.util.LinkedList;
import java.util.Date;
import java.util.Queue;
import java.util.Arrays;


public class shelterAnimals
{
	public static void main(String[] args) throws Exception
	{
		AnimalShelter as = new AnimalShelter();
		List<Animal> animallist = Arrays.asList(new Dog(), new Cat(), new Dog(), new Cat(), new Cat(),
			                                    new Dog(), new Cat(), new Dog(), new Dog(), new Cat());
		for(Animal animal : animallist)
		{
			as.enqueue(animal);
		}
		as.dequeueAny();
		as.dequeueCat();
		as.dequeueDog();
        System.out.println(as.cats.size());
        System.out.println(as.dogs.size());
	}
}

// wrpper class
class Animal
{
	String type;
	Date dateArrived;
}
class Dog extends Animal
{
	Dog()
	{
		super();
		type = "dog";
	}
}
class Cat extends Animal
{
	Cat()
	{
		super();
		type = "cat";
	}
}

class AnimalShelter
{
	Queue<Dog> dogs;
	Queue<Cat> cats;
	public AnimalShelter()
	{
		dogs = new LinkedList<>();
		cats = new LinkedList<>();
	}

	public void enqueue(Animal animal) throws Exception
	{ 
		// during enqueue check it is cat or dog
		boolean isCat = animal.type.equals("cat");
		boolean isDog = animal.type.equals("dog");
        // if it is not cat ot nor dog
        //if((!isDog) && (!isCat))
        //	throws new Exception("Unknown type of animal");
        // timestamp starts for retuning the oldest animal
        animal.dateArrived = new Date();

        if(isCat)
        {
        	if(animal instanceof Cat)
        		cats.offer((Cat)animal);
        }
        if(isDog)
        {
        	if(animal instanceof Dog)
        		dogs.offer((Dog)animal);
        }

	}

	public Animal dequeueAny() throws Exception
	{
	    boolean noCat = cats.isEmpty();
		boolean noDog = dogs.isEmpty();
		if (noCat && noDog)
			throw new Exception("There are no more animals!");
		// if no cat but dog is there
		if(noCat && !noDog)
			return dogs.poll();
		// no dog but cat is there
		if(noDog && !noCat)
			return cats.poll();
		// both cat and dog available then return oldest animal
		//if(!dogs.isEmpty() && !cats.isEmpty())
			return cats.peek().dateArrived.compareTo(dogs.peek().dateArrived) < 0 ? cats.poll() : dogs.poll();
        
	}

	public Animal dequeueCat() throws Exception
	{
		if(cats.isEmpty())
			throw new Exception("There is no more cat!");
		return cats.poll();
	}

	public Animal dequeueDog() throws Exception
	{
		if(dogs.isEmpty())
			throw new Exception("There is no more dog!");
		return dogs.poll();
	}
}
