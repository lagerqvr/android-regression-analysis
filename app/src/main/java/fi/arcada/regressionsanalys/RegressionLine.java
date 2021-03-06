package fi.arcada.regressionsanalys;

import java.util.Arrays;
import java.util.stream.LongStream;

public class RegressionLine {

    // deklarera k, m, x  och correlationCoefficient som double

    double k, m, x, correlationCoefficient;

    public RegressionLine(double yValue, double[] xVals, double[] yVals) {
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

        // Del 3 - Correlation/Pearson
        double ySquaredM, ySquared;

        double sum2 = 0;
        for (int i = 0; i < xVals.length; i++) {
            sum2 = sum2 + yVals[i] * yVals[i];
        }
        ySquaredM = sum2;
        ySquared = sumY * sumY;

        correlationCoefficient = ((yValue * sumAll) - (sumX * sumY)) / Math.sqrt(((yValue * allSquared) - sumSquared) * ((yValue*ySquaredM)- ySquared));
    }

    public double getX(double yValue) {
        x = (yValue - m)/k;
        return x;
    }

    // Del 3 - WIP
    public double getCorrelationCoefficient() {
        return correlationCoefficient;
    }

    public String getCorrelationGrade() {
        String grade;
        if (correlationCoefficient == 1 || correlationCoefficient > 0.8) {
            grade = ("very strong");
            return grade;
        } else if (correlationCoefficient <= 0.8 && correlationCoefficient > 0.6) {
            grade = ("strong");
            return grade;
        } else if (correlationCoefficient <= 0.6 && correlationCoefficient > 0.4) {
            grade = ("moderate");
            return grade;
        } else if (correlationCoefficient <= 0.4 && correlationCoefficient > 0.2) {
            grade = ("weak");
            return grade;
        } else {
            grade = ("very weak");
            return grade;
        }
    }


    // Skapa en konstruktor som tar emot data-arrays f??r x och y
    // Utr??kningen f??r k och m kan ske i konstruktorn m.h.a.
    // formeln f??r minsta kvadratmetoden
    // Del 3: utr??kningen f??r correlationCoefficient kan ocks?? ske i konstruktorn
    // (det ??r f??rst??s ocks?? ok att ha en skild metod f??r utr??knigarna om man vill
    // h??lla konstruktorn simpel.)

    // skapa en metod getX som tar emot ett y-v??rde, r??knar ut x
    // m.h.a. r??ta linjens ekvation y=kx+m, och returnerar x



    // Del 3:
    // - skapa en getter-metod f??r correlationCoefficient
    // - skapa en String-metod getCorrelationGrade() f??r utr??kning av korrelationsgrad

}