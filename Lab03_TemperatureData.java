/*
 * COSC 2351 - Data Structures
 * Lab 3 - Array Data Lab
 *
 * Name: Aleena Peter
 * Date: 09/25/26
 *
 * Description:
 * This program uses one-dimensional and two-dimensional
 * arrays to store and analyze temperature data.
 */


package labs;
import java.util.Scanner;


public class Lab03_TemperatureData {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[] week1 = new double[7]; //initializes first week array that will accept user input
        double[] week2 = new double[7]; //same as the line above, but for the second week
        double[][] twoWeeks = {week1,week2}; //makes a larger, nested array, containing the information for both weeks.

        System.out.println("===================================================");

        for (int i = 1; i <= week1.length; i++) { //starts with day 1 and asks the user for temperatures, which get stored in the week1 array.
            System.out.print("Enter the temperature for Week 1, Day " + i  +
                    ":");
            double temp = input.nextDouble();
            week1[i - 1] = temp;
        }

        System.out.print("The temperatures for week 1 are: ");
        for (int i = 0; i < week1.length; i++) {
            System.out.printf("%.2f ", week1[i]);
        }

        System.out.println();
        System.out.println("===================================================");

        for (int i = 1; i <= week2.length; i++) { //starts with day 1 and asks the user for temperatures which get stored in the week2 array.
            System.out.print("Enter the temperature for Week 2, Day " + i + ":");
            double temp = input.nextDouble();
            week2[i - 1] = temp;
        }

        System.out.print("The temperatures for week 2 are: ");
        for (int i = 0; i < week2.length; i++) {
            System.out.printf("%.2f ", week2[i]);
        }

        System.out.println();
        System.out.println("===================================================");
        System.out.println("                  WEATHER SUMMARY                  ");
        System.out.println("===================================================");
        System.out.println();

        double average = calculateAverage(week1); //calls the calculate average function and passes the week1 array as an argument.
        System.out.printf("The average is: %.2f ", average);
        System.out.println();

        double highest = findHighest(week1); //calls the findHighest function and passes the week1 array as an argument.
        System.out.printf("The highest temperature for week 1 was %.2f ",highest);
        System.out.println();

        double lowest = findLowest(week1); //calls the findLowest function and passes the week1 array as an argument.
        System.out.printf("The lowest temperature for week 1 was %.2f " , lowest);
        System.out.println();

        int aboveAverageCount = countAboveAverage(week1, average); //calls the countAboveAverage and passes the week1 array, as well as the average calculated a couple lines prior as an argument.
        System.out.println("Days above average for week 1: " + aboveAverageCount);

        int highestDay = findHighestDay(week1); //calls the findHighestDay function and passes the week1 array as an argument.
        System.out.println("Highest day in week 1: Day " + highestDay);

        double highestTwoWeeks = findOverallHighest(twoWeeks); //calls the findOverallHighest function and uses the larger twoWeeks array as an argument.
        System.out.printf("Highest temp in 2 weeks: %.2f" , highestTwoWeeks);
        System.out.println();


    }

    public static double calculateAverage(double[] data) { //function that calculates the average of the temperatures given
        double sum = 0;
        for (int i = 0; i < data.length; i++) { //increments through the array and adds the number at each index to the total sum to be divided.
            double num = data[i];
            sum += num;
        }
        double average = sum / data.length;
        return average;
    }

    public static double findHighest(double[] data) { //method that finds the highest temp out of the ones given
        double highest = data[0]; //assumes the highest temp is the first number
        for (int i = 0; i < data.length; i++) {
            if (data[i] > highest) { //if the temp that is being looked at currently is higher than the highest, it gets reassigned the value of highest.
                highest = data[i];
            }
        }
        return highest;

    }

    public static double findLowest(double[] data) { //method that finds the lowest temp out of the ones givcen
        double lowest = data[0]; //assumes the lowest temp is the first number
        for (int i = 0; i < data.length; i++) {
            if (data[i] < lowest) { //reassigns the value of lowest to the number currently being analyzed if it is less than the current lowest number
                lowest = data[i];
            }
        }
        return lowest;
    }

    public static int countAboveAverage(double[] data, double average) { //method that counts how many temperatures are above the calculated average
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > average) { //if the current number is higher than the average, the count variable is incremented by one.
                count++;
            }
        }
        return count;
    }

    public static int findHighestDay(double[] data) { //method that finds the day on which the highest temperature occured.
        int highestIndex = 0;
        for (int i = 1; i < data.length; i++) {
            if (data[i] > data[highestIndex]) { //if the current index being looked at is higher than the highestIndex, then it is reassigned its value.
                highestIndex = i;
            }
        }
        return highestIndex + 1; //the plus one allows for the accurate day to appear.
    }

    public static double findOverallHighest(double[][] data) { //method that finds the overall highest value between 2 weeks, which are multidimensional arrays.
        double highest = data[0][0]; //assumes the highest temp is in the first week, first day

        for (int row = 0; row < data.length; row++) { //starts in week one, then week two
            for (int column = 0; column < data[row].length; column++) { //goes through each day (column) within the week
                if (data[row][column] > highest) { //if the current day is higher than the highest value, the highest variable is reassigned to the current temp.
                    highest = data[row][column];
                }
            }
        }
        return highest;
    }
}


/*What is the main difference between traversing a one-dimensional array and traversing a two-dimensional array?
Why are nested loops useful for two-dimensional data?


When traversing a one-dimensional array, you only need one 'for' loop to navigate through, as there is only one series of values.
However, with a two-dimensional array, one 'for' loop is not enough, as there are 2 arrays one would need to traverse through, and a 'for' loop
would only analyze the first array. As such, nested loops are necessary for navigating through these types of arrays, as they allow you to traverse each array one by one,
and then each of their individual elements as well.
 */


