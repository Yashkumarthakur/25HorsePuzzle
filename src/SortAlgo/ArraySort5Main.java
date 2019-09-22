package SortAlgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArraySort5Main {

	private ArraySort5Main() {
	}

	public static void main(String[] args) {
		Scanner scan = null;
		System.out.println("-----------Sorting problem with minimum sort function call---------\n");
		System.out.println("Enter 1 for manually enter 25 numbers.");
		System.out.println("Enter 2 for generate random 25 numbers.\n");
		try{
			scan = new Scanner(System.in);
			List<Integer> input = new ArrayList<>();
			int inputSelection = scan.nextInt();

			switch (inputSelection) {
			case 1:
				System.out.println("Enter 25 integer elemets for sorting: \n");
				for (int i = 0; i < 25; i++){
					input.add(scan.nextInt());
				}
				PrintResult(ArraySort5MainImpl.getMax3(input));
				break;
			case 2:
				System.out.println("Enter start number for range (eg. 0): ");
				int start = scan.nextInt();
				System.out.println("Enter END number for range (eg. 100): ");
				int end = scan.nextInt();
				input = ArraySort5MainImpl.getRamdomNumbers(start, end);

				System.out.println("Random generated numbers : \n NOTE : Their can be duplicate numbers! \n");
				System.out.println(input);

				PrintResult(ArraySort5MainImpl.getMax3(input));
				break;

			default:
				System.out.println("Invalid input, please try again!");
			}

		} catch (Exception e){
			System.err.println("exception :" + e);
		}
		finally{
			if (scan != null) 
				scan.close();
		}
	}
	
	/**
	 * Method to print answer.
	 * 
	 * @param ans
	 */
	private static void PrintResult(List<Integer> ans) {
		for (int i = 0; i < 3; i++){
			System.out.println("Largest elements by ranks : " + (i + 1) + ", number :" + ans.get(i));
		}
		System.out.println("number of Sort5(), calls : " + ans.get(3));
	}
}
