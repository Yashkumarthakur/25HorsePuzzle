package SortAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ArraySort5MainImpl {

	private static int sortCount = 0;

	public ArraySort5MainImpl() {
		sortCount = 0;
	}

	/**
	 * Method to get max 3 numbers from list with number of sort function calls. 
	 * 
	 * @param input : list of integer type number. 
	 * @return : Result as max 3 numbers with number of function calls.
	 */
	public static List<Integer> getMax3(List<Integer> input) {
		HashMap<Integer, List<Integer>> inputSplitted = sliceInput(input);
		initialSort(inputSplitted);

		HashMap<Integer, List<Integer>> finalWinners = modifyList(get6thSort(inputSplitted), inputSplitted);
		List<Integer> ans = get7thSort(finalWinners);
		ans.add(sortCount);
		return ans;
	}

	/**
	 * method to get 7th sort result.
	 * 
	 * @param finalWinners : 6th sort result.
	 * @return : final max 3 numbers.
	 */
	private static List<Integer> get7thSort(HashMap<Integer, List<Integer>> finalWinners) {
		List<Integer> ans = new ArrayList<>();
		List<Integer> sort7 = new ArrayList<>();
		finalWinners.entrySet().stream().forEach(e -> {
			int counter = 4 - e.getKey();
			if (e.getKey() == 1 && ans.isEmpty()){
				ans.add(e.getValue().get(0));
			}
			for (int i = 0; i < counter; i++){
				if (e.getKey() != 1 || i != 0){
					sort7.add(e.getValue().get(i));
				}
			}
			counter--;
		});
		sort5(sort7);
		ans.addAll(sort7.subList(0, 2));
		return ans;
	}

	/**
	 * Method to modify list after 6th sorting result. 
	 * 
	 * @param get6thSort : result of 6th sort result.
	 * @param races : Actual inputs of numbers.
	 * @return : modified structure to perform last sort.
	 */
	private static HashMap<Integer, List<Integer>> modifyList(List<Integer> get6thSort, HashMap<Integer, List<Integer>> races) {
		HashMap<Integer, List<Integer>> finalRace = new HashMap<>();
		for (int i = 0; i < 3; i++){
			for (int j = 1; j < races.size(); j++){
				if (get6thSort.get(i) == (races.get(j)).get(0)){
					finalRace.put(i + 1, races.get(j));
				}
			}
		}
		return finalRace;
	}

	/**
	 * Method to perform 6th sort for largest, number.
	 * 
	 * @param lists : Input numbers.
	 * @return : list of sorted numbers.
	 */
	private static List<Integer> get6thSort(HashMap<Integer, List<Integer>> lists) {
		List<Integer> listSort = new ArrayList<>();
		for (int i = 1; i <= 5; i++){
			listSort.add((lists.get(i)).get(0));
		}
		sort5(listSort);
		return listSort;
	}

	/**
	 * Sorting method.
	 * 
	 * @param listSort
	 */
	private static void sort5(List<Integer> listSort) {
		Collections.sort(listSort, Collections.reverseOrder());
		sortCount++;
	}

	/**
	 * Method to do sort each list. 5 * 5
	 * 
	 * @param lists
	 */
	private static void initialSort(HashMap<Integer, List<Integer>> lists) {
		lists.entrySet().stream().forEach(e -> sort5(e.getValue()));
	}

	/**
	 * Method to divide 25 numbers into 5 * 5.
	 * 
	 * @param input : input numbers.
	 * @return : divided input.
	 */
	private static HashMap<Integer, List<Integer>> sliceInput(List<Integer> input) {
		HashMap<Integer, List<Integer>> lists = new HashMap<>();
		int size = 0;
		for (int i = 1; i <= 5; i++){
			lists.put(i, new ArrayList<>(input.subList(size, size + 5)));
			size += 5;
		}
		return lists;
	}

	/**
	 * Method to get Random numbers by providing range.
	 * 
	 * @param start : starting range. 
	 * @param end : ending range.
	 * @return : 25 integer type number, within range.
	 */
	public static List<Integer> getRamdomNumbers(int start, int end) {
		int[] intStream = new Random().ints(25, start, end).toArray();
		return Arrays.stream(intStream).boxed().collect(Collectors.toList());
	}

}
