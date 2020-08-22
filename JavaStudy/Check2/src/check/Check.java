package check;

import constants.Constants;

public class Check {

	// ⓵変数を宣言.
	// ミス : メソッド内で宣言してエラー
	private static String firstName = "SOGA";
	private static String lastName = "KEI";

	public static void main(String[] args) {

//		⓷メソッドで連結した変数を表示
	    System.out.println("printNameメソッド→ " + printName(firstName, lastName));

//	    ⓸他のクラスのメソッド(コンストラクタ)を使って表示
//	    ミス : 前提から間違っていたので論外
	    Pet pet = new Pet(Constants.CHECK_CLASS_JAVA, Constants.CHECK_CLASS_HOGE);
	    pet.introduce();
	    Pet robopet = new RobotPet(Constants.CHECK_CLASS_R2D2, Constants.CHECK_CLASS_LUKE);
	    robopet.introduce();
	}
		// ⓶変数を連結して返すメソッド
		// ミス : static忘れ
		private static String printName( String firstName, String lastName) {
			return firstName + lastName;
	}
}
