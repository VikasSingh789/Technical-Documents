import java.util.Scanner;
public class example
{
public static void main(String[] args)
{
Scanner scan=new Scanner(System.in);
System.out.println("enter the string");
String s=scan.next();
int x=s.length();
String rev=" ";
for(int i=0;i<s.length();i++){
rev=rev+s.charAt(x-1);
x--;
}
System.out.println("reverse of a string is="+rev);
}
}