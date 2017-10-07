public class CheckingAccount extends Account
{
private SavingAccount protectedBy;
public CheckingAccount(double init_balance)
{
	super(init_balance);
}
public CheckingAccount(double init_balance, SavingAccount protectedBy)
{
	super(init_balance);
	this.protectedBy = protectedBy;
}
@Override
public boolean withdraw(double amt){
	//余额足够
	if(balance >=amt){
		balance -=amt;
	}
	else{
		/*这个地方要弄清楚的比较多
		 * 1. Account的方法,但是要注意的一点是,只能使用父类非private的方法,不仅如此,父类的父类的父类,只
		 *   要不是private,都可以被子类调用.
		 * 2.注意这里并没有声明变量balance,但是却能直接用balance,因为前面有super(init_balance),作用
		 *   等同于(Account中的)balance=init_balance.
		 * 3.怎么理解protectedBy.withdraw(amt-balance)这句话？首先它的前提是balance<amt,即要取的钱
		 *   大于余额,另外这里需要注意的是这个withdraw方法并不是本类当中的这个withdraw方法,而是Account类
		 *   中的withdraw方法，protectedBy不是CheckingAccount类的,不能用它当中的方法,可以写一个程序试试.
		 *   此外,在测试当中还发现了一个非常有趣的现象,protectedBy必须在大括号当中才能用Account的方法,为什么？
		 */
		if(protectedBy !=null&&protectedBy.getBalance() >=(amt-balance))//透支保护足够
		{
			protectedBy.withdraw(amt-balance);//要取500，但是只有200，那么就从透支保护当中再取300
			balance=0;
		}
		//余额不足，并且透支保护也不足
		else{
			return false;
		}
	}
	return true;
}
}
