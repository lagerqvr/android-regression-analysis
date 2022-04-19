package fi.arcada.regressionsanalys;

import java.util.Arrays;
import java.util.stream.LongStream;

public class RegressionLine {

    // deklarera k, m, x  och correlationCoefficient som double

    double k, m, x, correlationCoefficient;
    double[] xVals, yVals;

    public RegressionLine(double[] xVals, double[] yVals) {
        double sumAll, sumX, sumY, sumSquared, allSquared, arrLength;

        // Del 2 - Estimation
        // Amount of pairs
        arrLength = xVals.length;

        // Sum of all values x*y
        double sum = 0;
        for (int i = 0; i < xVals.length; i++) {
            sum = sum + xVals[i] * yVals[i];
        }
        sumAll = sum;

        // Sum of all x values
        sumX = Arrays.stream(xVals).sum();

        // Sum of all y values
        sumY = Arrays.stream(yVals).sum();

        // Sum of all x squared
        double sum1 = 0;
        for (double xVal : xVals) {
            sum1 = sum1 + xVal * xVal;
        }
        allSquared = sum1;

        // Sum of x squared
        sumSquared = sumX * sumX;

        // Calculate k & m
        k = (arrLength * sumAll - sumX * sumY)/(arrLength * allSquared - sumSquared);
        m = (sumY/arrLength) - (k * sumX/arrLength);

        // Del 3 - Correlation
        double sumPairs, bothSums, xSquaredM, ySquaredM, ySquared, xSquared, sX, sY, tot;

        bothSums = sumX * sumY;
        sumPairs = (arrLength * sumAll) - bothSums;

        xSquaredM = arrLength * allSquared;

        double sum2 = 0;
        for (double yVal : yVals) {
            sum2 = sum2 + yVal * yVal;
        }
        ySquaredM = sum2;

        xSquared = sumSquared;
        ySquared = sumY * sumY;

        sX = xSquaredM - xSquared;
        sY = ySquared - ySquaredM;
        tot = Math.sqrt(sX * sY);

        correlationCoefficient = 0.3;
    }

    public double getX(double yValue) {
        x = (yValue - m)/k;
        return x;
    }

    // Del 3 - WIP
    public double getCorrelationCoefficient() { return correlationCoefficient; }

    public String getCorrelationGrade() {
        String grade;
        if (correlationCoefficient == 1) {
            grade = ("perfect");
            return grade;
        } else if (correlationCoefficient <= 0.99 && correlationCoefficient > 0.75) {
            grade = ("high");
            return grade;
        } else if (correlationCoefficient <= 0.74 && correlationCoefficient > 0.40) {
            grade = ("moderate");
            return grade;
        } else if (correlationCoefficient <= 0.39 && correlationCoefficient > 0.2) {
            grade = ("low");
            return grade;
        } else {
            grade = ("little to none");
            return grade;
        }
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