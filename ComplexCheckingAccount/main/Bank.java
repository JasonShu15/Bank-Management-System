public class Bank {
private Customer [] customers;
private int numberOfCustomers;
public Bank()
{
	customers=new Customer[100];
}
public void addCustomer(String f,String l)
{
	Customer customer=new Customer(f,l);
	customers[numberOfCustomers]=customer;
	numberOfCustomers++;
}
public int getNumOfCustomers(){
	return numberOfCustomers;
}
public Customer getCustomer(int index){
	return customers[index];
}
}
