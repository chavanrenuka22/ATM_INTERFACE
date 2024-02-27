package codeSoftTask3;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

 class AtmDetails 
{
 private double balance;
 private double depositAmount;
 private double withdrawAmount;
public AtmDetails()
{	
	
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public double getDepositAmount() {
	return depositAmount;
}
public void setDepositAmount(double depositAmount) {
	this.depositAmount = depositAmount;
}
public double getWithdrawlAmount() {
	return withdrawAmount;
}
public void setWithdrawlAmount(double withdrawlAmount) {
	this.withdrawAmount = withdrawlAmount;
}
}
 class ATMImpl implements ATMOperationInterface
{
	AtmDetails ad=new AtmDetails();
	Map<Double ,String>m1=new HashMap<>();

	@Override
	public void viewBalance()
	{
		System.out.println("available balance is:"+ad.getBalance());
	
	}
	@Override
	public void depositAmount(double depositAmount) 
	{
		m1.put(depositAmount," Amount Deposited");
        System.out.println(depositAmount+" Deposited Successfully !!");
        ad.setBalance(ad.getBalance()+depositAmount);
        viewBalance();
	}
	@Override
	public void transferAmount(double transferAmount) 
	{
		System.out.println(transferAmount+ "transferred Successfully");
	}

	@Override
	public void withdrawAmount(double withdrawAmount) 
	{
		  if(withdrawAmount%500==0) 
		  {
	            if (withdrawAmount <= ad.getBalance())
	            {
	                m1.put(withdrawAmount, " Amount Withdrawn");
	                System.out.println("Collect the Cash " + withdrawAmount);
	                ad.setBalance(ad.getBalance() - withdrawAmount);
	                viewBalance();
	            } 
	            else 
	            {
	                System.out.println("Insufficient Balance !!");
	            }
	     }
	        else
	        {
	            System.out.println("Please enter the amount in multipal of 500");
	        }
	    }
	
	@Override
	public void showTransactionHistory() {
		
		for(Map.Entry<Double,String> m:m1.entrySet())
		{
            System.out.println(m.getKey()+""+m.getValue());
		}
	}
}

interface ATMOperationInterface {

	public void viewBalance();
	public void depositAmount(double depositAmount);
	public void transferAmount(double transferAmount);
	public void withdrawAmount(double withdrawAmount);
	public void showTransactionHistory();
}
	
public class ATMMain {

 	static ATMOperationInterface a1=(ATMOperationInterface) new ATMImpl();
 	
 	public static void main(String[] args) {
 	int userId=1234;
 	int userPin=2001;
 	
 	System.out.println("----Welcome to ATM machine----");
 	Scanner sc=new Scanner(System.in);
 	
 	System.out.println("Enter userId:");
 	int id=sc.nextInt();
 	
 	System.out.println("Enter userpin:");
 	int pin=sc.nextInt();
 	
 	if((userId==id)&&(userPin==pin))
 	{		
 		while(true)
 		{
 			System.out.println("0:view balance");
 			System.out.println("1.Deposit the amount");
 			System.out.println("2.transfer the amount");
 			System.out.println("3.withdraw the amount");
 			System.out.println("4.show the transaction history");
 			System.out.println("5.Collect your card");
 			
 			System.out.println("Enter the choice");
 			
 			int ch=sc.nextInt();
 			if(ch==0)
 			{
 				a1.viewBalance();
 			}
 			if(ch==1)
 			{
 				System.out.println("Enter amount to deposit:");
 				double depositAmount=sc.nextDouble();
 				a1.depositAmount(depositAmount);
 				a1.viewBalance();
 				
 			}
 			else if(ch==2)
 			{
 			System.out.println("Transfer the amount:");
 			double transferAmount=sc.nextDouble();
 			a1.transferAmount(transferAmount);
 			a1.viewBalance();
 			}
 			else if(ch==3)
 			{
 				System.out.println("Enter amount to withdraw ");
                 double withdrawAmount=sc.nextDouble();
                 a1.withdrawAmount(withdrawAmount);

 			}
 			else if(ch==4)
 			{
 				a1.showTransactionHistory();
 				
 			}
 			else if(ch==5)
 			{
 				System.out.println("please collect your card");
 				
 			}
 		}
 	}
 	else
 	{
 		System.out.println("invalid..!  please insert correct details");
 		System.exit(0);
 	}
 	}
 }