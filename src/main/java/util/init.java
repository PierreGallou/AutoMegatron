package util;
import POJO.Point;
import java.util.ArrayList;

public abstract class   init {


    public static ArrayList<Point> initDataSet(){

        ArrayList<Point> dataSet=new ArrayList<>();

        //dataset 1
        dataSet.add(new Point(0.2,0.5,0));
        dataSet.add(new Point(0.8,1.2,0));
        dataSet.add(new Point(1.3,1,0));
        dataSet.add(new Point(1.8,2,0));
        dataSet.add(new Point(2,1.2,0));
        dataSet.add(new Point(2.2,1.5,0));
        dataSet.add(new Point(2.5,2,0));
        dataSet.add(new Point(0.1,2.1,1));
        dataSet.add(new Point(0.6,2.5,1));
        dataSet.add(new Point(1.1,3.2,1));
        dataSet.add(new Point(1.2,2.8,1));
        dataSet.add(new Point(1.8,3,1));
        dataSet.add(new Point(2,3.4,1));
        dataSet.add(new Point(2.6,4,1));


        //dataset 2
//        dataSet.add(new Point(319.0,-51.0,1));
//        dataSet.add(new Point(307.0,-37.0,1));
//        dataSet.add(new Point(220.0,-18.0,1));
//        dataSet.add(new Point(322.0,-50.0,1));
//        dataSet.add(new Point(201.0,-37.0,1));
//        dataSet.add(new Point(244.0,-27.0,1));
//        dataSet.add(new Point(276.0,-19.0,1));
//        dataSet.add(new Point(283.0,-32.0,1));
//        dataSet.add(new Point(202.0,-20.0,1));
//        dataSet.add(new Point(157.0,-7.0,1));
//        dataSet.add(new Point(180.0,-1.0,1));
//        dataSet.add(new Point(175.0,-19.0,1));
//        dataSet.add(new Point(275.0,-27.0,1));
//        dataSet.add(new Point(267.0,-40.0,1));
//        dataSet.add(new Point(100.0,-0.0,1));
//        dataSet.add(new Point(238.0,-9.0,1));
//        dataSet.add(new Point(491.0,-30.0,0));
//        dataSet.add(new Point(631.0,26.0,0));
//        dataSet.add(new Point(309.0,67.0,0));
//        dataSet.add(new Point(575.0,-18.0,0));
//        dataSet.add(new Point(365.0,-11.0,0));
//        dataSet.add(new Point(515.0,61.0,0));
//        dataSet.add(new Point(194.0,7.0,0));
//        dataSet.add(new Point(570.0,-25.0,0));
//        dataSet.add(new Point(201.0,5.0,0));
//        dataSet.add(new Point(418.0,68.0,0));
//        dataSet.add(new Point(212.0,58.0,0));
//        dataSet.add(new Point(111.0,6.0,0));
//        dataSet.add(new Point(141.0,51.0,0));
//        dataSet.add(new Point(121.0,57.0,0));
//        dataSet.add(new Point(099.0,52.0,0));
//        dataSet.add(new Point(379.0,-12.0,0));
//        dataSet.add(new Point(495.0,19.0,0));
//        dataSet.add(new Point(643.0,16.0,0));
//        dataSet.add(new Point(405.0,27.0,0));
//        dataSet.add(new Point(390.0,-39.0,0));


        return dataSet;
    }





    public static ArrayList<Point> normalizeDataSet(ArrayList<Point> dataSet){
        // normalisation par loi normale centree reduite (esperance et ecart type)

        double esperanceX=0;
        double ecartTypeX=0;
        double esperanceY=0;
        double ecartTypeY=0;


        //on balaye le dataset pour cumuler les esperance de chacun
        for (Point point : dataSet) {
            esperanceX = esperanceX + point.getX();
            esperanceY = esperanceY + point.getY();
        }
        esperanceX=esperanceX/dataSet.size();
        esperanceY=esperanceY/dataSet.size();

        //on balaye le dataset pour cumuler la variance de chacun
        for (Point point : dataSet) {
            ecartTypeX = ecartTypeX + (point.getX() - esperanceX) * (point.getX() - esperanceX);
            ecartTypeY = ecartTypeY + (point.getY() - esperanceY) * (point.getY() - esperanceY);
        }
        ecartTypeX=ecartTypeX/(dataSet.size()-1);
        ecartTypeY=ecartTypeY/(dataSet.size()-1);


    //conversion variance vers ecart-type
    ecartTypeX=Math.sqrt(ecartTypeX);
    ecartTypeY=Math.sqrt(ecartTypeY);


    // normalisation du dataset
        for (Point point : dataSet) {
            point.setX((point.getX() - esperanceX) / ecartTypeX);
            point.setY((point.getY() - esperanceY) / ecartTypeY);
        }


    System.out.println("esperance X:"+esperanceX+"  ecart type X:"+ecartTypeX);
    System.out.println("esperance Y:"+esperanceY+"  ecart type Y:"+ecartTypeY);

        return dataSet;

}





}
