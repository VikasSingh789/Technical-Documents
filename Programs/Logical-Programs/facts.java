import java.util.Scanner;
public class facts
{
public int fact(int num)
{
if(num<0)
return 0;
else if(num<=1)
return 1;
else
return (num*fact(num-1));
}
public static void main(String[] args)
{
Scanner scan=new Scanner(System.in);
System.out.println("enter the number");
int num=scan.nextInt();
facts f=new facts();
System.out.println("factorial of "+num+"is  "+f.fact(num));
}
}
