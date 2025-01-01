//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
class Solution {

    // Function to find the first negative integer in every window of size k
    static List<Integer> FirstNegativeInteger(int arr[], int k) {
        // write code here
  
        // Result list to store the first negative integer in each window
        List<Integer> result = new ArrayList<>();
        
        // Queue to store the indices of negative numbers in the current window
        LinkedList<Integer> negatives = new LinkedList<>();
        
        int i = 0, j = 0; // Sliding window pointers

        // Traverse the array
        while (j < arr.length) {
            // Step 1: Add the index of the current element to the queue if it's negative
            if (arr[j] < 0) {
                negatives.add(j);
            }

            // Step 2: Expand the window until its size becomes k
            if (j - i + 1 < k) {
                j++;
            }
            // Step 3: Process the window of size k
            else if (j - i + 1 == k) {
                // Add the first negative integer in the current window to the result
                if (!negatives.isEmpty()) {
                    result.add(arr[negatives.peek()]);
                } else {
                    result.add(0); // If no negative integer is present, add 0
                }

                // Step 4: Slide the window
                if (!negatives.isEmpty() && negatives.peek() == i) {
                    negatives.poll(); // Remove the index of the outgoing element if it's negative
                }
                i++;
                j++;
            }
        }

        return result;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            List<Integer> ans = ob.FirstNegativeInteger(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends