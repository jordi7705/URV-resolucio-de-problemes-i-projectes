import java.security.cert.X509CRL;

public class punt {
    private int x,y;
    /**
     *  constructor per defecte punt (0,0)
     */
    public punt(){
        x=0;
        y=0;
        
    }
/**
 *  constructor inicialitza punt en valors rebuts per parametres(x,y)
 * @param x
 * @param y
 */
    public punt(int x, int y){
      this.x=x;
      this.y=y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public String toString(){

        return("Punt => x: "+x+" y: "+y);
    } 

    public void setX(int x){
         this.x=x;
    }

     public void setY(int y){
         this.y=y;
    }

    public punt copia(){
        punt aux;
        aux=new punt(this.x,this.y);
        return aux;
    }

    public boolean igual(punt p1){
        boolean hoson=false;
        if(p1.getX()==this.x && p1.getY()==this.y){
            hoson=true;
        }
        return hoson;
    }

    public int distancia(punt p){
        int dis, resx,resy;
        resx=this.x-p.x;
        resy=this.y-p.y;
        dis=(int)Math.sqrt((resx*resx)-(resy*resy));
        return dis;
    }
}





