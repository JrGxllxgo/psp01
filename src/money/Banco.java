package money;
/**
 * Implementa los metodos de meter y sacar dienro
 * @author Kacha
 *
 */
public class Banco {
	
	CuentaCorriente cc = new CuentaCorriente();

	Banco(){
		System.out.println("Banco en funcionamiento");
	}
	
	public void moneyOut(int amount) throws InterruptedException {
		synchronized(cc) {
			cc.saldo-=amount;
			System.out.println(cc.saldo);
			Thread.sleep(1000);
		}
	}
	
	public void moneyIn(int amount) throws InterruptedException{
		synchronized(cc) {
			cc.saldo+=amount;
			System.out.println(cc.saldo);
			Thread.sleep(1000);
		}
	}
}
