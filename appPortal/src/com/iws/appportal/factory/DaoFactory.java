
	

public class DaoFactory {

	private static LoginDaoIF loginDaoIF = null;
	private static PromoCodeGeneratorDaoIF codeGenerator=null;
	static {
		loginDaoIF=new LoginDaoImpl();
		codeGenerator=new PromoCodeGeneratorDaoImpl();	
	}
	public static LoginDaoIF loginDaoFactory(){
		return loginDaoIF;
	}
	public static PromoCodeGeneratorDaoIF getCodeGenerator(){
		return codeGenerator;
	}
	}
