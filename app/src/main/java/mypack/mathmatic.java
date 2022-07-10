package mypack;

public class mathmatic extends bomb implements mathmaticclass {

    public boolean isEven(){
        if(super.password%2==0)
            return true;
        else
            return false;
    }
    public boolean isPrime(){
        if(super.password==0||super.password==1)
            return false;
        for(int i=2;i<=Math.sqrt(super.password);++i){
            if(super.password%i==0)
                return false;
        }
        return true;
    }
    public int AdditionOfDigits(){
        int addition=super.firstdigit + super.seconddigit + super.thirddigit;
        return addition;

    }
    public int Biggestnumber(){
        if(super.firstdigit>=super.seconddigit)
        {if(super.firstdigit>=super.thirddigit)
            return super.firstdigit;
        else
            return super.thirddigit;
        }
        else
        {if(super.seconddigit>=super.thirddigit)
            return super.seconddigit;
        else
            return super.thirddigit;
        }
    }
    public boolean TimesBy3(){
        if(super.password%3==0)
            return true;
        else
            return false;
    }

}
