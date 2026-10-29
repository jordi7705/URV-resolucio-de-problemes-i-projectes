/**
 * Classe Punt: permet definir i operar amb punts de dos dimensions en l'espai
 * euclideo
 * 
 * @author Professores programació
 * @version 1.0
 * 
 */
public class Punt {
  private int x, y;

  private static int xIni = 10, yIni=10, xFi=40, yFi=40; //constans

  /**
   * Constructor per defecte
   * no rep cap paràmetre, 
   * (no sabem quins valors donar al punt estem creant)
   */
  public Punt() {
    x = xIni;
    y = yIni;
  }

  /**
   * Constructor que rep el valor de 
   * les coordenades x e y del punt
   * 
   * @param x és el valor de la component x del punt
   * @param y és el valor de la component y del punt
   */
  public Punt(int x, int y) {
    if(xcorrecte(x) && ycorrecte(y)){
    this.x = x;
    this.y = y;
    }
    else{
      this.x=xIni;
      this.y=yIni;
    }
  }

 

  private boolean ycorrecte(int y2) {
    return(y>=yIni && y<=yFi);
  }

  private boolean xcorrecte(int x2) {
    return(x>=xIni && x<=xFi);
  }

  public Punt(int x) {
    if(xcorrecte(x)){
    this.x = x;
    this.y = 0;}
    else{
      this.x=xIni;
      this.y=yIni;
    }
  }

  /**
   * setter
   * 
   * @param x és el valor de la component x del punt
   */
  public void setX(int x) {
    if(xcorrecte(x)){
    this.x = x;
  }
  }

  /**
   * setter
   * 
   * @param y és el valor de la component x del punt
   */
  public void setY(int y) {
    if(ycorrecte(y)){
    this.y = y;
  }
  }

  /**
   * getter
   * 
   * @return retorna la component x del punt
   */
  public int getX() {
    return (x);
  }

  /**
   * getter
   * 
   * @return retorna la component y del punt
   */
  public int getY() {
    return (y);
  }

  /**
   * Mètode toString que transforma el contingut de l'objecte en una cadena de
   * text per mostrar-la per pantalla
   */
  public String toString() {
    return ("\tPUNT: ( " + x + ", " + y + ") ");
  }

  public static String mostraFinestra(){
    String aux;
    aux="Finestra de punts valids:\n";
    aux=aux+"\txIni:"+xIni+"\txFi:"+xFi+"\tyIni:"+yIni+"\tyFi:"+yFi;
    return aux;
  }

  /**
   * mètode que crea una copia de l'objecte actual
   * 
   * @return retorna una nova instància de la classe Punt amb el mateix contingut
   *         que l'objecte actual
   */
  public Punt copia() {
    Punt aux = new Punt(x, y);
    return aux;
  }

  /**
   * 
   * mètode que comprova si l'objecte actual té el mateix contingut al que 
   * rep per paràmetre
   * 
   * @param p és la referencia de l'objecte amb el que es vol comparar el
   *          contingut de l'objecte actual
   * @return retorna cert o fals segons si els continguts coincideixen
   */
  public boolean iguals(Punt p) {
    return ((p.x == x) && (p.y == y));
  }

  /**
   * mètode que calcula la distància entre l'objecte actual i el que rep per
   * paràmetre
   * 
   * @param p és la referencia de l'objecte amb el que es vol calcular la
   *          distància respecte a l'objecte actual
   * @return retorna la distancia entera entre els dos punts
   */
  public int distancia(Punt p) {
    double d;
    d = Math.sqrt((p.x - x) * (p.x - x) + (p.y - y) * (p.y - y));
    return ((int) d);
  }

  /**
   * Mètode que calcula el punt resultant de la reflexió sobre l'eix x.
   * 
   * @return el punt aplicada la reflexió
   */
  public Punt reflexio() {
    Punt nou = new Punt(x, - y);
    return nou;
  }

}
