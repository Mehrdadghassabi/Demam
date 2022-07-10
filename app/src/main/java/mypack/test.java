package mypack;

public class test extends key implements testclass{
    mathmatic a=new mathmatic();
    test(mathmatic a) {
        this.a.password=a.password;
        this.a.firstdigit=a.firstdigit;
        this.a.seconddigit=a.seconddigit;
        this.a.thirddigit=a.thirddigit;
    }
    public boolean passwordentry(int password){
        if(a.password==password)
            return true;
        else
        return false;
    }
    public boolean enoughKey(){
        if(super.keynumber>=1)
            return true;
        else
        return false;
    }
}
