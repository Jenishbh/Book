

class Error extends Exception{
    int code; // Error code
 public Error(int code1){
    code=code1;}
    public int getCode() {
        return code;
        
    }
   public void setError(int code1) {
       code=code1; 
       
   } 
 
}
class Invalidfrontcover extends Error{
    
    int l,nl;
    public Invalidfrontcover(int nl1){
        super(1);
           
        nl=nl1;
    }
    public int getInvalidfrontcover(){
        return l;
    }
    public int getCover_frontCover(){return nl; }

}

class InvalidBackCover extends Error{
    int l,nll;
    public InvalidBackCover(int nll1){
        super(2);
        
        nll=nll1;
    }
    public int getInvalidBackcover(){
        return l;
    }
    public int getCover_backCover(){return nll;}
}
class EmptyBook extends Error{
    int np,h,w,nl,nll;
    public EmptyBook(int np1){
        super(4);
        np=np1;
    }
    public int getEmptyBook(){
        return np;}
    
    public int getPage(){return np;}
    
    
}
class SquareBook extends Error{
    int side1,side2,side3,h,w;
    public SquareBook(int h1,int w1){
        super(5);
        h=h1;
        w=w1;
        
    }
    public int getSquareBook(){
        return h+w;
    }
    public int getHeight() {
        return h;
    }
    public int getWidth(){return w;}


}


class Cover_frontCover implements Cloneable {
    private int nl;
    public Cover_frontCover(int nl1)throws Invalidfrontcover,Error{
        if(nl==10){throw new Invalidfrontcover(nl1);}
       else{nl=nl1;}
        nl=nl1;
    }
    
        // TODO Auto-generated constructor stub
        public void setCover_frontCover(int nl1)throws Invalidfrontcover,Error{
            if(nl==10){throw new Invalidfrontcover(nl1);}
           else{nl=nl1;}
            nl=nl1;
        }
        
    
} 
 class Cover_backCover implements Cloneable{
    int nll;
    
    public Cover_backCover(int nll1)throws InvalidBackCover,Error {
        
       if(nll==20){throw new InvalidBackCover(nll1);}
       else{nll=nll1;}
        nll=nll1;
    }
    public void setCover_backCover(int nll1)throws InvalidBackCover,Error {
        
        if(nll==20){throw new InvalidBackCover(nll1);}
        else{nll=nll1;}
         nll=nll1;
     }

    

}
class Book {
    int np; // Number of pages                     |
   int w, h; // Width and height
    int nl;
    int nll;

   
   


public Book(int np1, int w1, int h1, int nl1, int nll1)throws EmptyBook,SquareBook,Error,InvalidBackCover,Invalidfrontcover  {
       if(np1<=0){
           throw new EmptyBook(np1);
       }
      else{ np=np1;}
      if(w1==h1){
          throw new SquareBook(h1,w1);
      }
       else{w=w1;
       h=h1;}
       
       if(nll1<=20){ System.out.println("x");
           throw new InvalidBackCover(nll1);}
       System.out.println("x");
       if(nl1<=10){throw new Invalidfrontcover(nl1);}
       else{nll=nll1;
       nl=nl1;}
       
    }
       
   

  

    

public void  setBook(int np1, int w1, int h1, int nl1,int nll1)throws EmptyBook,SquareBook,Error  {
    if(np1==0){
        throw new EmptyBook(np1);
    }
   else{ np=np1;}
   if(w1==h1){
       throw new SquareBook(h1,w1);
   }
    else{w=w1;
    h=h1;}
    if(nl1>=10){throw new Invalidfrontcover(nl1);}
        
    if(nll1>=20){throw new InvalidBackCover(nll1);}
    else{nl=nl1;
        nll=nll1;}
    
    
}



 
}

public class Demo4{
     public static void main(String[] args) {

       try{ Book a1 =new Book(0, 5, 2,9,12);}
       
       catch(EmptyBook e){
           System.out.println("The Error Code: "+e.getCode()+" That means You have empty book \n"+"You Have :"+e.getPage()+" Page");    
       }
       catch(Error e){
           System.out.println("Error");

       }
       try{ Book a1 =new Book(200,3,4,5,6);}
       
       catch(InvalidBackCover e) {
           System.out.println("The Error Code: "+e.getCode()+" That means Your book do not match our minimum requrment of back Cover  \n"+"You Have :"+e.getCover_backCover()
                   + " Lines in back cover");
       }
       catch(Error e){
           System.out.println("Error");

       }
       try{ Book a1 =new Book(435,5,6,4,5);}
       
       catch(Invalidfrontcover e) {
           System.out.println("The Error Code: "+e.getCode()+" That means Your book do not match our minimum requrment of front Cover \n"+"You Have :"+e.getCover_frontCover()
                   + " Lines in front cover");
       }
       catch(Error e){
           System.out.println("Error");

       }
       try{ Book a1 =new Book(300,4,4,5,6);}
       
       catch(SquareBook e) {
           System.out.println("The Error Code: "+e.getCode()+" That means Your book has square size, it is not acceptable \n"+"You Have :"+e.getHeight()
                   + " Height and Weight :"+e.getWidth());
       }
       catch(Error e){
           System.out.println("Error");
        
    }
     }}





