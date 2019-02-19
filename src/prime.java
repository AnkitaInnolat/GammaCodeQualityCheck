import java.util.Scanner;

//CODE ARENA

public class prime {

	public static void main(String[] args) {
		int flag=1,n,flag1=1;
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		scan.close();
		for(int i=2;i<=n/2;i++) {
			for(int j=2;j<=i/2;j++) {
				if(i%j == 0) {
					flag=0;
					break;
				}
				else
					flag=1;
			}
			if(flag==1) {
//				System.out.print(i+"\t");
				for(int k=2;k<i/2;k++) {
					if(i%k==0) {
						System.out.println("Arjit");
						flag1=0;
						break;
					}
					else {
						flag1=1;
					}
						
				}
				if(flag1==1) {
					
				
					System.out.println("Deepa");
					break;
				}
			}
		}
		if(n==2)
			System.out.println("Arjit");
		
	}

}
