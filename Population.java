/**
* A population class to be part of an SIR simulation with a discrete number
* of acquaintances of each member of the population.
* @author Matthew Bardoe
* @author Ben Birney
* @author Yonghyun Lee
* @author Taylor Rossini
* @author Sonja Eliason
* @author Channy Hong
* @version 0.1
* @date 10/21/14
*/

public class Population  {
 private int populationSize;
 private Person[] people;
 private int numContacts;
 
 /**
 * A constructor method for the Population class 
 * @param populationSize an int that indicates the size of the population
 * @param numContacts an int that indicates the number of contacts each member of the population will have.
 */
 public Population(int populationSize, int numContacts){
    this.populationSize=populationSize;
    people = new Person[populationSize];
    for( int i = 0 ; i< this.populationSize ; i++)
    {
      people[i]=new Person(numContacts);
    }
    this.numContacts=numContacts;
  }

 /**
 * This method creates the acquaintances for all the
 * people in the population.
 * @param int 
 * this parameter gives the number of people a person has been in contact with and therefore potentially infected
 */
 private void createContacts(int numContacts)
 {
  Person currentPerson, friend;
  int friendIndex;
   for (int i = 0; i<populationSize; i++)
   {
     currentPerson = people[i];
       for (int j = 0; j<numContacts; j++)
        { 
         friendIndex = (int)Math.random()*populationSize;
         friend = people[friendIndex];
         currentPerson.addContact(friend);
        // randomly generate an integer from 
        //friendIndex = Math.random();
        //== addContact;
       
      }
   }
}

 /**
 * This function returns the number of people that are 
 * infected in the population.
 * @return int the number of infected people in the population.
 */
 public int numInfected()
 {
   int numInfected = 0;
   for( int i = 0 ; i< populationSize ; i++)
   {
   if (people[i].infected())
     {
       numInfected++;
     }
   }
   return numInfected;
 }
 
 /**
  * This function returns the number of people that are 
  * alive in the population.
  * @return int number of alive people in population
  */
 public int numAlive()
  {
    int numAlive = 0;
   for( int i = 0 ; i< populationSize ; i++)
    {
      if (people[i].alive())
      {
        numAlive++;
      }
    }
    return numAlive;
  }
  
   /**
  * This function returns the number of people that are 
  * recovered in the population.
  * @return int number of recovered people in population
  */
  public int numRecovered()
  {
    int numRecovered = 0;
   for( int i = 0 ; i< populationSize ; i++)
    {
      if (people[i].recovered())
      {
        numRecovered++;
      }
    }
    return numRecovered;
  }
  /**
  * A method that tells each person in the population to spread the virus.
  */
  public void spreadVirus()
  {
     for( int i = 0 ; i< populationSize ; i++)
    {
      people[i].spreadVirus();
    }
  }
 
/**
* A method to create a string that reports out
*   <ul>
*   <li>Population Size</li>
*   <li>Number Alive</li>
*   <li>Number Infected</li>
*   <li>Number Recovered</li>
*   </ul>
* @return a string that reports out the status of the population.
*/
 public String toString()
 {
              return "Population Size -" + this.populationSize + "Number Infected -" + this.numInfected() + "Number Alive -" + this.numAlive() + "Number Recovered -" + this.numRecovered();
 }
 /**
  * A method which returns the nth person of the population.
  * @param n an int which represents the number/place of the person within the people array
  * @return Person a selected person from the people array 
  */
 public Person getPerson(int n)
{
  return people[n];
}
 
/**
 * A testing method for the class which creates a population of size 100 where everyone knows 5 other people
 */
 public static void main(String[] args)
 {
  Population population = new Population(100,5);
  Person larry = population.getPerson(30);
  System.out.println(larry);
  System.out.println(population);
 }
}
