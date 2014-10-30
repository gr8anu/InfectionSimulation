/**
* A population class to be part of an SIR simulation with a discrete number
* of acquaintances of each member of the population.
* @author Matthew Bardoe, etc.
* @version 0.1
* @date 10/21/14
*/

public class Population  {
 private int populationSize;
 private Person[] people;
 
 
 public void Population(int populationSize){
    this.populationSize=populationSize;
    people = new Person[populationSize];
    for( int i = 0 ; i< this.populationSize ; i++)
    {
      people[i]=new Person();
    }
  }
 /**
 * This method creates the acquaintances for all the
 * people in the population.
 */
 private void createAquaintances(){
    
 }

 /**
 * This function returns the number of people that are 
 * infected in the population.
 * @return int the number of infected people in the population.
 */
 public int numberInfected();
 {
   int numInfected = 0;
   for( int i = 0 ; i< populationSize ; i++)
   {
     if ( people[i].infected())
     {
       numInfected++;
     }
   }
   return numInfected;
 }
 
 
 public static void main(String[] args)
 {
  // Create a population of size 1000 where everyone knows
  // 5 other people.
  Population population = new Population(1000,5);
  Person larry = population.getPerson(300);
  System.out.println(larry);
  System.out.println(population.numberInfected);
  System.out.println(population.numberAlive);
  System.out.println(population.numberRecovered);
 }
}
