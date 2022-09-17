package simple;
import java.io.*;
public class primefactors {
	public static void main(String[] args)throws IOException
	{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		/*int n;*/
		System.out.println("enter a number");
		int n=Integer.parseInt(br.readLine());
		int i=2;
		while(n>1)
		{
			if(n%i==0)
			{
				System.out.println(i+" ");
				n=n/i;
			}
			else
				i++;
	}
		
}
}