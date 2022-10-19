package money;

public class Principal {

	public static void main(String[] args) {
		Banco banco = new Banco();
		CuentaCorriente cc = new CuentaCorriente();
		
		Persona pers1 = new Persona(cc.saldo, banco, false);
		Persona pers2 = new Persona(cc.saldo, banco, true);
		
		pers1.start();
		pers2.start();
	}

}
