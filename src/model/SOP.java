package model;
public class SOP {	

	/**************************
	 * 	TERMINALES
	 **************************/
	public static boolean agregarMejorVecino (Instance ins){
		return ins.agregarMejorVecino();
	}	
	public static boolean agregarCercano (Instance ins){
		return ins.agregarCercano();
	}
	public static boolean agregarMediana (Instance ins){
		return ins.agregarMediana();
	}
	public static boolean agregarLejano (Instance ins){
		return ins.agregarLejano();
	}
	public static boolean eliminarPeor (Instance ins){
		return ins.eliminarPeor();
	}
	public static boolean eliminarUltimo (Instance ins){
		return ins.eliminarUltimo();
	}
	public static boolean swap (Instance ins){
		return ins.swap();
	}
	public static boolean opt2 (Instance ins){
		return ins.opt2();
	}
	public static boolean inverse (Instance ins){
		return ins.inverse();
	}
}