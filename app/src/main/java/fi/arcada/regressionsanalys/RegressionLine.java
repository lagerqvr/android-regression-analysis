package fi.arcada.regressionsanalys;

import java.util.Arrays;
import java.util.stream.LongStream;

public class RegressionLine {

    // deklarera k, m, x  och correlationCoefficient som double

    double k, m, x, correlationCoefficient;
    double[] xVals, yVals;

    public RegressionLine(double[] xVals, double[] yVals) {
        double sumAll, sumX, sumY, sumSquared, allSquared, arrLength;

        // Amount of pairs
        arrLength = xVals.length;

        // Sum of all values x*y
        double sum1 = 0;
        for (int i = 0; i < xVals.length; i++) {
            sum1 = sum1 + xVals[i] * yVals[i];
        }
        sumAll = sum1;

        // Sum of all x values
        sumX = Arrays.stream(xVals).sum();

        // Sum of all y values
        sumY = Arrays.stream(yVals).sum();

        // Sum of all x squared
        double sum = 0;
        for (double xVal : xVals) {
            sum = sum + xVal * xVal;
        }
        allSquared = sum;

        // Sum of x squared
        sumSquared = sumX * sumX;

        k = (arrLength * sumAll - sumX * sumY)/(arrLength * allSquared - sumSquared);
        m = (sumY/arrLength) - (k * sumX/arrLength);
    }

    public double getX(double yValue) {
        x = (yValue - m)/k;
        return x;
    }

    // Del 3 - WIP
    public double getCorrelationCoefficient(double yValue) {
        return 0.0;
    }


    // Skapa en konstruktor som tar emot data-arrays för x och y
    // Uträkningen för k och m kan ske i konstruktorn m.h.a.
    // formeln för minsta kvadratmetoden
    // Del 3: uträkningen för correlationCoefficient kan också ske i konstruktorn
    // (det är förstås också ok att ha en skild metod för uträknigarna om man vill
    // hålla konstruktorn simpel.)

    // skapa en metod getX som tar emot ett y-värde, räknar ut x
    // m.h.a. räta linjens ekvation y=kx+m, och returnerar x



    // Del 3:
    // - skapa en getter-metod för correlationCoefficient
    // - skapa en String-metod getCorrelationGrade() för uträkning av korrelationsgrad

}