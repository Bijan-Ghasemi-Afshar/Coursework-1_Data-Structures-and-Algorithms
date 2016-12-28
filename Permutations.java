/*
 * Sometimes, we wish to examine all permutations of a collection of n distinct
 * elements. ( Coursework sheet, Description of the Assignment, 2).  
 * Design a recursive algorithm based on the above ideas to determine a 
 * list of (string representations of) all of the permutations of a given
 * list of n distinct elements.
 */
package permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * 21/11/2016
 * @author Bijan
 */
public class Permutations {

    /*
     * A function to compute all the possible permutations of a list of elemets
     * Returns      - A list of all possible permutations
     * Parameters ->
     *  -List list:     A list of random elements
     *  -int n:         The index of the element that is the head
     *  -String head:    The head of a possible permutation
     *  -List<String> perms:  A list to be returned with all the possible permutations
     */
    public static List list_of_perms(List list, int index, String head, List<String> perms){
                        
        // If there is no content in the given list, there is no permutation
        if(list.size() == 0){
            System.out.println("List does not contain any elements");
            return list;
        }
        
        // Making a string out of the elements of the list given
        String str = "";
        for(int i = 0; i < list.size(); i++){
            str += list.get(i);
        }
        
        if(str.length() == 1){            
            return list;
        }
        
        // If the current index is more than the number of elements, return perms
        if(str.length() < index + 1){                        
            return perms;
        } else {
            /* If there are 2 characters in the String made out of the given 
             * list, add the character that we are given the index of to the last,
             * element of the list permsand then add the other one and add 1 to 
             * the index
             */
            if(str.length() == 2){
                
                perms.add(head);
                String container = "";

                if(str.charAt(index) == str.charAt(0)){
                    container += str.charAt(1);
                } else {
                    container += str.charAt(0);
                }
                
                int last_index_of_perms = perms.size() - 1;                     
                String last_element_of_perms = perms.get(last_index_of_perms);      
                last_element_of_perms +=  str.charAt(index);   
                last_element_of_perms +=  container;                                   
                perms.set(last_index_of_perms, last_element_of_perms);
                
                list_of_perms(list, index + 1, head, perms);
                
            } else {
                /* If there are more than 2 characters in the String made out of
                 * the given list, make the element that we are given the index of
                 * the head, and make a new list without the mentioned element
                 */
                
                head += str.charAt(index) ;    
                ArrayList new_list = new ArrayList<String>();
                String new_str = "";
                
                for(int i = 0; i < str.length(); i++){
                    if(str.charAt(index) == str.charAt(i)){
                        continue;
                    } else {
                        new_list.add(str.charAt(i));
                    }
                }

                List X = list_of_perms(new_list, 0, head, perms);

                if(head.length() > 1){
                    list_of_perms(list, index + 1, head.substring(0, head.length() - 1), X);
                } else {
                    list_of_perms(list, index + 1, "", X);
                }
            }
        }        
        return perms;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TESTING
        List list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
//        list.add("d");
//        list.add("e");
//        list.add("f");

//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);

        List perms = new ArrayList<String>();
        List permutations = list_of_perms(list, 0, "", perms);

        // Printing the results
        System.out.print("All permutations: (");      
        for(int i = 0; i < permutations.size(); i++){
            System.out.print(permutations.get(i));
            if(i != permutations.size() - 1){
                System.out.print(", ");
            } else {
                System.out.println(")");
            }             
        }
        System.out.println("Total number of permutations: " + permutations.size());
    }
}
