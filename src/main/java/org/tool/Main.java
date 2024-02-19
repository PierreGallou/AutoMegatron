package org.tool;

import POJO.Point;
import util.calculGrad;
import util.init;

import java.util.ArrayList;



public class Main {

   final static double alpha=0.1;
   final static double seuilErr=0.2;
   final static int maxEpoch=100;
   static double w1=-1;
   static double w2=-1;
   static double b=-1;



    public static void main(String[] args) {

        ArrayList<Point> dataSet= init.initDataSet();
//        dataSet=init.normalizeDataSet(dataSet);

        double erreur=seuilErr;
        int epoch=1;

        double gradw1;
        double gradw2;
        double gradb;

        while ((erreur>=seuilErr)&&(epoch<=maxEpoch))
            {


            // calculer E
           erreur= calculGrad.calcErreur(dataSet,w1,w2,b);



            // calculer le grad de E
                gradw1=0.0;
                gradw2=0.0;
                gradb=0.0;

                for (int i=0; i<dataSet.size();i++){
                    gradw1=gradw1+calculGrad.calcGradW1Local(dataSet,i,w1,w2,b);
                    gradw2=gradw2+calculGrad.calcGradW2Local(dataSet,i,w1,w2,b);
                    gradb=gradb+calculGrad.calcGradBLocal(dataSet,i,w1,w2,b);
                }

                gradw1=gradw1/dataSet.size();
                gradw2=gradw2/dataSet.size();
                gradb=gradb/dataSet.size();



            // mise a jour des parametres
                w1=w1-alpha*gradw1;
                w2=w2-alpha*gradw2;
                b=b-alpha*gradb;


                System.out.println("epoque:"+epoch+"  erreur global:"+erreur+"  w1:"+w1+"  w2:"+w2+"  b:"+b);
                epoch++;
            }







        }




}