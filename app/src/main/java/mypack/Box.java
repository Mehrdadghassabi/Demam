package mypack;
import java.util.Random;

public final class Box implements boxinterface {
    private int num;
    mathmatic b=new mathmatic();
    private final  int createrndforBox(){
        Random rnd =new Random();
        int rand=(int) (rnd.nextDouble()*3);
        rand++;
        return rand;

    }
    public Box(mathmatic b){
        this.num=createrndforBox();

        this.b.password=b.password;
        this.b.firstdigit=b.firstdigit;
        this.b.seconddigit=b.seconddigit;
        this.b.thirddigit=b.thirddigit;
    }
    public String ShowDigit(){
        if(num==1)
        return "first digit is"+b.firstdigit;

        if(num==2)
        return "second digit is"+b.seconddigit;

        if(num==3)
       return "third digit is"+b.thirddigit;

        return "Never get here!";
    }

}
