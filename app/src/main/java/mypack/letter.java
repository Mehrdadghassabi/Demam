package mypack;
import java.util.Random;

public final class letter implements letterclass{
    private int num;
    mathmatic a=new mathmatic();
    int get(){
        return num;
    }
    public letter(mathmatic a){

        this.num= createrndforletter();

        this.a.password=a.password;
        this.a.firstdigit=a.firstdigit;
        this.a.seconddigit=a.seconddigit;
        this.a.thirddigit=a.thirddigit;
    }
    public String Showletter(){
        if(num==1) {
            if (a.TimesBy3())
                return "the password is divisible by 3";

            else
                return "the password is not divisible by 3";
        }

        if(num==2)
           return "the biggest digit of password is"+a.Biggestnumber();


        if(num==3)
        return "the addition of the digits is"+a.AdditionOfDigits();


        if(num==4){
            if(a.isPrime())
                return "the password is prime";
            else
                return "the password is not prime";
        }


        if(num==5){
            if (a.isEven())
                return "the password is Even";
            else
                return "the password is odd";
        }

       return "NEVER GET HERE";
    }
    private final  int createrndforletter(){
        Random rnd =new Random();
        int rand=(int) (rnd.nextDouble()*5);
        rand++;
        return rand;

    }
}
