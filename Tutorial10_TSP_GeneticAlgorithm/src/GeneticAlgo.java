import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;


public class GeneticAlgo {
	
	static double [][] dataset;
	
	
	class Individual{
		
		public ArrayList<Integer> chromosome = new ArrayList<Integer>();
		double fitness;
		
		public Individual(int n) {
			
			Set<Integer> chromosome = new LinkedHashSet<Integer>();//we use set to get unique number within the range
			
			Random r = new Random();
			
			while(chromosome.size()<n) {
				chromosome.add(r.nextInt(n));
			}
			
			this.chromosome = new ArrayList<Integer>(chromosome); //convert set into arrayList
			setFitness();
		}
		
		public void setFitness () {
			
			double res = 0;
			int size = chromosome.size();
			
			for(int i=0; i<size-1; i++) {
				int from = chromosome.get(i);
				int to = chromosome.get(i+1);
				
				//System.out.println(from+" "+to);
				//System.out.println(dataset[from][to]);
				
				res += dataset[from][to];
			}
			//System.out.println(ind.chromosome.get(size-1)+" "+ind.chromosome.get(0));
			res+= dataset[chromosome.get(size-1)][chromosome.get(0)]; //x[n][0] - return to the origin
			//System.out.println(res);
				
			this.fitness = res;
			
		}
		
		public Individual copyGenes(Individual ind) {
			
			Individual res = new Individual(ind.chromosome.size());
			
			for (int i=0; i<ind.chromosome.size(); i++) {
				res.chromosome.set(i, ind.chromosome.get(i));
			}
			
			return res;
		}
		
		public void printChromosome () {
			
			System.out.print(chromosome+" "+fitness);
		
		}
		
	}

	class Population{
		
		public ArrayList<Individual> population = new ArrayList<Individual>();
		
		public Population (int popSize, int chromosomeSize) {
		
			for (int i=0; i<popSize; i++) {
				Individual ind = new Individual(chromosomeSize);
				this.population.add(ind);
			}
		}
		
		public void printPop() {
			
			for (int i=0; i<population.size(); i++) {
				System.out.print(population.get(i).chromosome+"\t");
				System.out.println(population.get(i).fitness);
			}
		}
		
		public Individual crossOver (Individual p1, double rate) {
			
			//Declate a chromosome variable (use Set<Integer>,  new LinkedHashSet<Integer>)
			
			
			//Declare the result variable (should be Individual type), the res size should be the parent's size
			
			
			//Get the crossover point. Use the rate. Value of crossover point should be int
			

		
			//A for loop to copy the genetic from the parent up to the crossover point
			

			
			//Now to get the remaining genes by random. Use while loop to get the remaining genes
			

			
			
			//Since our chromosome in Individual class is ArrayList, convert the Set variable into ArrayList
			
			
			
			return res;
		}
		
		public Individual mutate (Individual p1) {
			
			//Copy the genetic from p1 to our initial result
			Individual res 
			
			//now we mutate the genes, using small change (swap genes by random)
			
			
			
			//Use a while loop to regenerate random j to avoid getting the same gene. WARNING : This is not application is the remaining genes is only 1
			

			
			
			
			
			//Swap the value between i and j for our mutate chromosome
			
			
			
			return res;
		}

		
	}
	
	public static void runGA() {
		
		//create a population object and parameters
		
		
		
		//prepare dataset
		
		
		
		//initialise the population
		
		
		//We sort the candidates by fitness in ascending order, the least the better in this example (TSP)
		
		
		
		//Find solution in the generations
		for (int gen=0; gen<numGeneration; gen++) {
			
			System.out.println("Generation : "+gen);
			
			//get the parents - top 2 from the list
			
			
			
			//get 2 new children
			
			
			
			
			//get a mutate child
			
			
			
			
			//add these new children to the population
			
			
			
			
			
			//sort them
			

			
			
			
			//remove the weak candidate
			
			
			
			
			
		}
		
		System.out.println("====Result====");
	
		
		//Write the result into a csv file
		
		
	
	}
	
	public static double calFitness (ArrayList<Integer> x) {
		double res = 0;
		int size = x.size();
		
		for(int i=0; i<size-1; i++) {
			int from = x.get(i);
			int to = x.get(i+1);
			
			//System.out.println(from+" "+to);
			//System.out.println(dataset[from][to]);
			
			res += dataset[from][to];
		}
		//System.out.println(ind.chromosome.get(size-1)+" "+ind.chromosome.get(0));
		res+= dataset[x.get(size-1)][x.get(0)]; //x[n][0] - return to the origin
		//System.out.println(res);
			
		return res;
	}

	public static void main(String[] args) {
		
		runGA();
		
		double [][] mst = MST.PrimsMST(dataset);
		System.out.println("\nMST fitness : "+MST.getMstValue(mst));
		

	}

}