
package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSubsets {
	    
	    
	    
	    public int[] finalWords(String words[]){
	        
	        int[] finalList = new int[26];
	        
	        for(int i=0; i<words.length; i++){
	            
	            int[] innerWord = new int[26];
	            for(int j=0; j<words[i].length(); j++){
	                innerWord[words[i].charAt(j)-'a']++;
	                
	            }
	            
	            for(int j=0; j<26; j++){
	                if(innerWord[j] >= finalList[j] ){
	                    finalList[j] = innerWord[j];
	                }
	            }
	        }
	        return finalList;
	        
	    }
	    
	    public boolean myResult( int words[], String word){
	        
	        for(int i=0; i<word.length(); i++){
	            words[word.charAt(i)-'a']--;
	        }
	        for(int i=0; i<26; i++){
	            if(words[i] > 0 )return false;
	        }
	        
	        return true;
	    }
	        
	    
	    
	    public List<String> wordSubsets(String[] words1, String[] words2) {
	        
	        List<String> result = new ArrayList<String>();
	        
	        int arr[] = finalWords(words2);
	        for(int i=0; i<arr.length; i++){
	            System.out.print(arr[i]+" ");
	        }
	        
	        for(int i=0; i<words1.length; i++){
	        	int inner[] = Arrays.copyOf(arr, arr.length);
	            if(myResult(inner, words1[i])){
	                result.add(words1[i]);
	               System.out.println(words1[i]);
	            }
	                
	            //int words[] = new int[26];
	            //for(int j=0; j<words1[i].length(); j++){
	              //  words[words1[i].charAt(j)-'a']++;
	            //}
	            //if(isCorrectWord(words2, words1[i])){
	                //result.add(words1[i]);
	                //System.out.println(words1[i]);
	            //}
	            
	        }
	        return result;
	    }
	    
	    
	    public static void main(String[] args) {
			String[] words1 = {"amazon","apple","facebook","google","leetcode"};
			String [] words2 = {"n", "aa", "n","aa","m"};
			
			WordSubsets words = new WordSubsets();
			
			System.out.println(words.wordSubsets(words1, words2));
		}
	}
