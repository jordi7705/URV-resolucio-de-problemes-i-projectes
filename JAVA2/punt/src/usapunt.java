public class usapunt {
    public static void main(String[] args) throws Exception {
        punt p1=new punt();
        punt p2=new punt(2,3);
        punt p3 =p1.copia();
        System.out.println("p1: "+p1.getX());
        
        System.out.println("p1: "+p1.getX());
         System.out.println("p1: "+p1.toString());
        System.out.println("p2: "+p2.toString());
        p1.setX(10);
        p1.setY(10);
        System.out.println("p1: "+p1.toString()+" Modificat");
        System.out.println("p1: "+p3.toString()+" Copia Original");
        p1.setX(0);
        p1.setY(0);
        
        if(p1.igual(p2)){
            System.out.println("si ho son");
        }
        else
         System.out.println("no ho son");
         if(p1.igual(p3)){
            System.out.println("si ho son");
        }
        else
         System.out.println("no ho son");
        
System.out.println(p1.distancia(p2));
         
    }
}
