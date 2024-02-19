package util;

import POJO.Point;

import java.util.ArrayList;

public abstract class calculGrad {


    public static double calcErreur(ArrayList<Point> dataSet, double w1, double w2, double b) {

        double erreur=0.0;
        for (Point point : dataSet) {
            double erreurLocale = (point.getClasse() - (1 / (1 + Math.exp(-(point.getX() * w1 + point.getY() * w2 + b)))));
            erreurLocale = erreurLocale * erreurLocale;
            erreur = erreur + erreurLocale;
        }
        erreur=erreur/dataSet.size();   //moyenne

       return erreur;

    }














    public static double calcGradW1Local(ArrayList<Point> dataSet, int i, double w1, double w2, double b) {

        return (-2 * dataSet.get(i).getX())
                *
                (dataSet.get(i).getClasse() - 1 / (1 + Math.exp(-b - dataSet.get(i).getX() * w1 - dataSet.get(i).getY() * w2)))
                *
                (Math.exp(-b - dataSet.get(i).getX() * w1 - dataSet.get(i).getY() * w2))
                /
                Math.pow((1 + Math.exp(-b - dataSet.get(i).getX() * w1 - dataSet.get(i).getY() * w2)), 2);

    }







    public static double calcGradW2Local(ArrayList<Point> dataSet, int i, double w1, double w2, double b) {

        return (-2*dataSet.get(i).getY())
                *
                (dataSet.get(i).getClasse()-1/(1+Math.exp(-b-dataSet.get(i).getX()*w1-dataSet.get(i).getY()*w2)))
                *
                (Math.exp(-b-dataSet.get(i).getX()*w1-dataSet.get(i).getY()*w2))
                /
                Math.pow((1+ Math.exp(-b-dataSet.get(i).getX()*w1-dataSet.get(i).getY()*w2)),2);

    }







    public static double calcGradBLocal(ArrayList<Point> dataSet, int i, double w1, double w2, double b) {

        return (-2)
                *
                (dataSet.get(i).getClasse()-1/(1+Math.exp(-b-dataSet.get(i).getX()*w1-dataSet.get(i).getY()*w2)))
                *
                (Math.exp(-b-dataSet.get(i).getX()*w1-dataSet.get(i).getY()*w2))
                /
                Math.pow((1+ Math.exp(-b-dataSet.get(i).getX()*w1-dataSet.get(i).getY()*w2)),2);

    }





}
