package net.jacoblo.algorithm.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

import net.jacoblo.lib.Util;

public class Subsets {
  public static void main(String[] args) {
    int[] set = { 1,2,2};
    ArrayList<ArrayList<Integer>> result = subsetsByBitset(set);
    System.out.println(Util.<Integer>printResult(result));
  }
  
  public static ArrayList<ArrayList<Integer>> subsets(int[] set) {
    if (set == null || set.length <= 0) return new ArrayList<>();
    
    Arrays.sort(set);
    
    return subsets(set,set.length-1);
  }
  
  // This is a dump way to do, using bitset is faster
  public static ArrayList<ArrayList<Integer>> subsetsByBitset(int[] set) {
    if ( set == null || set.length <= 0 ) return new ArrayList<>();
    
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    for ( int i = 0 ; i < Math.pow(2,set.length) ; i++ ) {
      char[] bitsets = toBinaryString(i, set.length).toCharArray();
      ArrayList<Integer> currentSet = new ArrayList<>();
      for ( int j = 0 ; j < set.length ; j++ ) {
        if (j < bitsets.length && bitsets[j] == '1') {
          currentSet.add(set[j]);
        }
      }
      // TODO : use hashtable
      if (!contains(result, currentSet)) {
        result.add(currentSet);
      }
    }
    
    return result;
  }
  
  private static String toBinaryString(int n, int size) {
    if (n < 0 ) return "";
    String numString = Integer.toBinaryString(n);
    StringBuilder sb = new StringBuilder();
    for (int i = 0 ; i < (size - numString.length() ); i++ ) {
      sb.append("0");
    }
    sb.append(numString);
    return sb.toString();    
  }
  
  public static ArrayList<ArrayList<Integer>> subsets(int[] set, int curIndex) {
    
    if (curIndex < 0 || set == null || set.length <= 0) return new ArrayList<>();
    
    if (curIndex == 0) {
      ArrayList<ArrayList<Integer>> result = new ArrayList<>();
      result.add(new ArrayList<Integer>());
      ArrayList<Integer> includeCurrent = new ArrayList<>();
      includeCurrent.add(set[curIndex]);
      result.add(includeCurrent);
      return result;
    }
    
    ArrayList<ArrayList<Integer>> subResult = subsets(set, curIndex-1);
    ArrayList<ArrayList<Integer>> newResult = new ArrayList<>();
    for (int sub = 0 ; sub < subResult.size() ; sub++) {
      ArrayList<Integer> newList = new ArrayList<>();
      for(int i : subResult.get(sub)) {
        newList.add(i);
      }
      newList.add(set[curIndex]);
      newResult.add(newList);
    }
    for (ArrayList<Integer> each : newResult) {
      if (!(contains(subResult, each))) {
        
        subResult.add(each);
      }
    }
    return subResult;
  }
  
  private static boolean contains(ArrayList<ArrayList<Integer>> subset, ArrayList<Integer> set) {
    if (subset == null || set == null) return false;
    
    for (ArrayList<Integer> each : subset) {
      if (equalSet(each,set)) {      
        return true;
      }
    }
    return false;
  }
  
  private static boolean equalSet(ArrayList<Integer> a1, ArrayList<Integer> a2) {
    if (a1 == null || a2 == null || a1.size() != a2.size()) return false;
    
    for (int each : a1) {
      if (!contains(a2,each)) {
        return false;
      }
    }
    for (int each : a2) {
      if (!contains(a1,each)) {
        return false;
      }
    }
    return true;
  }
  
  private static boolean contains(ArrayList<Integer> array, int element) {
    for (int i : array) {
      if (i == element) {
        return true;
      }
    }
    return false;
  }
}
