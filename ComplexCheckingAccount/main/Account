public class Account {
   protected double balance;
   public Account(double init_balance){
	   balance=init_balance;
   }
   public double getBalance(){
	  return balance;
  }
   public boolean deposit(double amt){
	  balance += amt;
	  return true;
  }
   public boolean withdraw(double amt){
	  if(balance<amt)//余额不足,返回false
	  {
		  return false; 
	  }
	  balance -= amt;
	  return true;//余额足够,返回true.
  }
}
