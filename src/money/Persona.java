package money;

/**
 * Puede ingresar dinero o reintegrar dinero
 * 
 * @author Kacha
 *
 */
public class Persona extends Thread {

	Banco banco;
	int saldo;

	boolean canExtract;

	Persona(int saldo, Banco banco, Boolean canExtract) {
		this.saldo = saldo;
		this.banco = banco;
		this.canExtract = canExtract;

		System.out.println("El saldo inicial es " + this.saldo);
	}

	public void run() {
		for(int i = 10; i > 0; i--) {
			if (!canExtract) {
				try {
					banco.moneyIn(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				try {
					banco.moneyOut(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
