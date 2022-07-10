package mypack;

public class WrongInputPassException  extends NumberFormatException {

    public WrongInputPassException() {

        super();
    }

    class WrongInputforEachRoom extends ArrayIndexOutOfBoundsException{

        Object id;
        public WrongInputforEachRoom(Object a)
        {
            id=a;
            if(!Input(a))
                throw new ArrayIndexOutOfBoundsException();
        }

        boolean Input(Object a){
            return((String)a!="letter"||(String)a!="key"||(String)a!="box");
        }


    }

    class WrongInputforFirstRoom extends NullPointerException{

        Object id;
        public WrongInputforFirstRoom(Object a)
        {
            id=a;
            if(!Input(a))
                throw new NullPointerException();
        }

        boolean Input(Object a){
            return(!a.equals("letter")||!a.equals("key"));
        }

    }

}