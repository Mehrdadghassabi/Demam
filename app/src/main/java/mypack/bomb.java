package mypack;
import java.util.Random;

public class bomb implements bombinterface{
    protected int password;
    protected int firstdigit;
    protected int seconddigit;
    protected int thirddigit;
    public bomb(){

        this.password=createpass();//used to create the password
        this.firstdigit=getdigit(this.password,3);//finding first digit
        this.seconddigit=getdigit(this.password,2);//finding second digit
        this.thirddigit=getdigit(this.password,1);//finding third digit

    }
   public int getPassword(){
        return password;
    }
    public int getFirstdigit(){
        return firstdigit;}
     public int getSeconddigit(){
        return seconddigit;}
       public int getThirddigit(){
        return thirddigit;
        }


     public int createpass(){
        Random rnd=new Random();
         return rnd.nextInt(999);//used to create a int between 0 to 999
    }
    public  int getdigit(int number,int digit){
        int hold=0;
        while(digit!=0){// returns (digit)th of number from righthandside
            hold=number-(10*(number/10));
            number /=10;

            digit--;
        }
        return hold;
    }
}
