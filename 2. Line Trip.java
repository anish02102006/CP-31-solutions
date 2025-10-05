#java code
import java.util.*;

public class LineTrip {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt(); // Number of test cases
		while (t-- > 0) {
			long n = scanner.nextLong(); // Number of gas stations
			long x = scanner.nextLong(); // Destination point

			// List to store points including start, gas stations, and destination
			List<Long> pointsList = new ArrayList<>();
			pointsList.add(0L); // Start point

			// Loop through each gas station
			for (int i = 0; i < n; i++) {
				long point = scanner.nextLong(); // Read each gas station point
				pointsList.add(point); // Add gas station point to the list
			}

			pointsList.add(x); // Add destination point
			n = pointsList.size(); // Update n to include start, gas stations, and destination

			long maxDistanceBetweenPoints = Long.MIN_VALUE; // Variable to store the maximum distance between consecutive points

			// Loop through each point
			for (int i = 1; i < n; i++) {
				if (i == n - 1) {
					// If it's the last point (destination), consider the round trip distance
					maxDistanceBetweenPoints = Math.max(maxDistanceBetweenPoints, 2 * (pointsList.get(i) - pointsList.get(i - 1)));
				} else {
					// Consider the one-way distance
					maxDistanceBetweenPoints = Math.max(maxDistanceBetweenPoints, pointsList.get(i) - pointsList.get(i - 1));
				}
			}

			// Output the minimum tank capacity needed
			System.out.println(maxDistanceBetweenPoints);
		}
		scanner.close();
	}
}

// Time Complexity (TC): O(n) = O(50)
// Space Complexity (SC): O(n)
