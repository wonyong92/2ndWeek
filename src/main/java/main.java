import java.util.*;
import java.lang.*;


public class main {
    static Scanner sc;
    static String left_msg = "input left number : ";
    static String right_msg = "input right number : ";
    static String op_msg = "input operator : ";
    static double Dleft;
    static double Dright;
    static double Dresult;
    static String left = "";
    static String right = "";
    static String op = "";
    static String control = "";
    static double temp;
    static char cvar;
    public static double plus(double a,double b){
        return a+b;
    }

    public static double minus(double a,double b){
        return a-b;
    }

    public static double multi(double a,double b){
        return a*b;
    }

    public static double divide(double a,double b){
        if(b==0.0){
            throw new ArithmeticException();
        }
        return a/b;
    }

    public static double module(double a,double b){
        if(b==0.0){
            throw new ArithmeticException();
        }
        return a%b;
    }
    public static void clear()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void cont_check(){
        System.out.printf("press any key continue or press 'X' to exit : ");
        sc.nextLine();
        control = sc.nextLine();

        if (control.equals("X")||control.equals("x")) {
            clear();
            System.out.printf("X inputted. calculator will be stopped\n\n");
            System.exit(0);
        }
        clear();
    }
    public static void set_var(String msg,String var) throws Exception
    {
        System.out.print(msg);

        var = sc.next();

        if(var.equals(""))
        {
           System.out.println("nothing inputted");
           cont_check();
           throw new Exception();
        }
        cvar = var.charAt(0);

        try{
            if(msg.equals(left_msg))
                {
                    Dleft = Double.parseDouble(var);
                }
            else if(msg.equals(right_msg))
                {
                    Dright = Double.parseDouble(var);
                }

            else{
                
                op +=cvar;
                switch(cvar)
                {
                    case '+':
                        Dresult = plus(Dleft,Dright);
                        break;
                    case '-':
                        Dresult =  minus(Dleft,Dright);
                        break;
                    case '*':
                        Dresult =  multi(Dleft,Dright);
                        break;
                    case '/':
                        Dresult =  divide(Dleft,Dright);
                        break;
                    case '%':
                        Dresult =  module(Dleft,Dright);
                        break;
                    default:
                        System.out.print("input error please check op input");
                        throw new Exception("");
                        break;
                }
            }
        }
        catch(ArithmeticException e)
            {
                clear();
                System.out.println("you tried diving or moduling by zero \n please check your input");
                cont_check();
                throw new Exception("");
            }
        catch(Exception e) {
            System.out.printf("wrong input....%n");
            throw new Exception("");
        }
        clear();
    }

    public static void main(String[] args)
    {
        clear();
        sc = new Scanner(System.in);
        while(true)
            {
                op = new String("");
                clear();
                System.out.println("calculator start");
                try
                    {
                        set_var(left_msg, left);
                        set_var(right_msg,right);
                        set_var(op_msg,op);
                    }
                catch(Exception e)
                    {
                        op = new String("");
                        continue;
                    }

                clear();

                if(op.equals("/")||op.equals("%"))
                    {
                        if(Dright == 0)
                        {
                            op = new String("");
                            continue;
                        }
                    }

                System.out.printf("Dleft : %3f\n",Dleft);
                System.out.printf("Dright : %3f\n",Dright);
                System.out.printf("op : %s\n",op);

                System.out.print("result ");
                System.out.println(Dresult);
                System.out.println();

                cont_check();

            }//while end
       }//main end
    }//class end
