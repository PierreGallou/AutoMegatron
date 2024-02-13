package org.tool;

import POJO.Point;
import util.init;

import java.util.ArrayList;



public class Main {

    static double alpha=5;
    static double seuilErr=0.01;
    static int maxIter=200;
    static double w1=0;
    static double w2=0;
    static double b=0;



    public static void main(String[] args) {
        ArrayList<Point> dataSet=new ArrayList<>();
        dataSet= init.initDataSet(dataSet);


        double erreur=seuilErr;
        double erreurLocale=0.0;
        int iter=1;

        double gradw1=0.0;
        double gradw1Local=0.0;
        double gradw2=0.0;
        double gradw2Local=0.0;
        double gradb=0.0;
        double gradbLocal=0.0;

        while ((erreur>=seuilErr)&&(iter<=maxIter))
            {


                erreur=0.0; // init erreur
                gradw1=0.0;
                gradw2=0.0;
                gradb=0.0;

            // calculer E
            for (int i=0; i<dataSet.size();i++){
                erreurLocale= (  dataSet.get(i).getClasse()  - ( 1/(1+Math.exp(  -(dataSet.get(i).getX()*w1+dataSet.get(i).getY()*w2+b)   )  )   )   );
                erreurLocale=erreurLocale*erreurLocale;
                erreur=erreur+erreurLocale;
            }
            erreur=erreur/dataSet.size();   //moyenne


            // calculer le grad E
                for (int i=0; i<dataSet.size();i++){
                    gradw1Local= (-2*dataSet.get(i).getX())
                            *
                            (dataSet.get(i).getClasse()-1/(1+Math.exp(-b-dataSet.get(i).getX()*w1-dataSet.get(i).getY()*w2)))
                            *
                            (Math.exp(-b-dataSet.get(i).getX()*w1-dataSet.get(i).getY()*w2))
                            /
                            Math.pow((1+ Math.exp(-b-dataSet.get(i).getX()*w1-dataSet.get(i).getY()*w2)),2);
                    gradw1=gradw1+gradw1Local;


                    gradw2Local= (-2*dataSet.get(i).getY())
                            *
                            (dataSet.get(i).getClasse()-1/(1+Math.exp(-b-dataSet.get(i).getX()*w1-dataSet.get(i).getY()*w2)))
                            *
                            (Math.exp(-b-dataSet.get(i).getX()*w1-dataSet.get(i).getY()*w2))
                            /
                            Math.pow((1+ Math.exp(-b-dataSet.get(i).getX()*w1-dataSet.get(i).getY()*w2)),2);
                    gradw2=gradw2+gradw2Local;


                    gradbLocal= (-2)
                            *
                            (dataSet.get(i).getClasse()-1/(1+Math.exp(-b-dataSet.get(i).getX()*w1-dataSet.get(i).getY()*w2)))
                            *
                            (Math.exp(-b-dataSet.get(i).getX()*w1-dataSet.get(i).getY()*w2))
                            /
                            Math.pow((1+ Math.exp(-b-dataSet.get(i).getX()*w1-dataSet.get(i).getY()*w2)),2);
                    gradb=gradb+gradbLocal;
                }

                gradw1=gradw1/dataSet.size();
                gradw2=gradw2/dataSet.size();
                gradb=gradb/dataSet.size();



            // evoluer les param

                w1=w1-alpha*gradw1;
                w2=w2-alpha*gradw2;
                b=b-alpha*gradb;


                System.out.println("iteration:"+iter+"  erreur global:"+erreur+"  w1:"+w1+"  w2:"+w2+"  b:"+b);
            iter++;
            }







        }




}