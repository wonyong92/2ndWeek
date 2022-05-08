
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

    public static String plus(double a,double b){
        return a+b+"";
    }

    public static String minus(double a,double b){
        return a-b+"";
    }

    public static String multi(double a,double b){
        return a*b+"";
    }

    public static String divide_c(double a,double b){
        if(b==0.0){
            return "false";
        }
        return "true";
    }
    
    public static String divide(double a,double b){

        return a/b+"";
    }

    public static String module(double a,double b){

        return a%b+"";
    }

    public static void clear()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public static void cont_check(){

        System.out.printf("press any key continue or press 'X' to exit : ");

        control = sc.nextLine();

        if (control.equals("X")||control.equals("x")) {
            clear();
            System.out.printf("X inputted. calculator will be stopped\n\n");
            System.exit(0);
        }
        clear();
    }

    public static void wrong(String str)
    {
        clear();
        System.out.println(str);
        System.out.printf("check your input and retry%n");
        cont_check();
    }
    
    public static boolean is_number(String str)
    {
        int count =0;
        char temp;

        if(str.length()==0)
        {
            return false;
        }
        for(int i = 0;i<str.length();i++)
        {
            temp = str.charAt(i);
            if((int)temp ==46)
            {
                count ++;
            }
            if(((int)temp !=46&&(int)temp <48 )|| (int)temp>57 ||count>=2)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean set_var(String msg,String var)
    {
        System.out.print(msg);
        var = sc.nextLine();

        if(var.equals(""))
        {
            wrong("nothing inputted");
            return false;
        }

        if(msg.equals(left_msg))
            {
                if(is_number(var))
                {
                    Dleft = Double.parseDouble(var);
                }
                else
                {
                    wrong("wrong \"left number\" input");
                    return false;
                }
            }
         else if(msg.equals(right_msg))
            {
                if(is_number(var))
                {
                    Dright = Double.parseDouble(var);
                }
                else
                {
                    wrong("wrong \"right number\" input");
                    return false;
                }

            }

          else
            {
                cvar = var.charAt(0);
                op +=cvar;
                switch(cvar)
                {
                    case '+':
                        Dresult = Double.parseDouble(plus(Dleft,Dright));
                        break;
                    case '-':
                        Dresult =  Double.parseDouble(minus(Dleft,Dright));
                        break;
                    case '*':
                        Dresult =  Double.parseDouble(multi(Dleft,Dright));
                        break;
                    case '/':
                        if(Boolean.parseBoolean(divide_c(Dleft,Dright)))
                        {
                            Dresult =  Double.parseDouble(divide(Dleft,Dright));
                        }
                        else
                        {
                            wrong("you tried diving or moduling by zero");
                            return false;
                        }
                        break;
                    case '%':
                        if( Boolean.parseBoolean( divide_c(Dleft,Dright)))
                        {
                            Dresult =  Double.parseDouble(module(Dleft,Dright));
                        }
                        else
                        {
                            wrong("you tried diving or moduling by zero");
                            return false;
                        }
                        break;
                    default:
                        wrong("input error please check \"op\" input");
                        return false;
                }
            }
        clear();
        return true;
    }

    public static void main(String[] args)
    {
        clear();
        sc = new Scanner(System.in);
        while(true)
        {
            op = "";
            clear();
            System.out.println("calculator start");
            System.out.println("\n");

            if(!set_var(left_msg, left))
            {
                continue;
            }
            
            System.out.println("\n\n");

            if(!set_var(right_msg,right))
            {
                continue;
            }
            
            System.out.println("\n\n");
            
            if(!set_var(op_msg,op))
            {
                    continue;
            }
            
            clear();
            
            System.out.printf("result :: %.5f %s %.5f = %.5f\n",Dleft,op,Dright,Dresult);
            System.out.println();
            cont_check();

        }//while end
    }//main end
}//class end

