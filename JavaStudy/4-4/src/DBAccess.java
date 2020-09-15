import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
/**
 * ■ データベースに接続するプログラム
 *
 * カリキュラム「JDBCドライバ」を参考に
 * JDBCドライブのjarファイルの設置とビルドパスの追加も忘れないようにしましょう。
 *
 * 問①〜問④までを回答し、データベースと接続してみましょう。
 * カリキュラム「データベースを扱うための準備」を参考にしてください。
 *
 * 実行結果の提出に関しては、
 * いつも通りソースをコミットしていただきますが、
 * 今回は実行結果のスクリーンショットも合わせて提出していただきます。
 * 画像名はDBAccess.pngとして、4-4フォルダの中に入れ、これまでと同様に提出してください。
 *
 */



public class DBAccess {
 
 /** ドライバーのクラス名 */
 private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
 /** ・JDMC接続先情報 */
  // 問① データベースのホスト名・データベース名を定数にしなさい。
 private static final String JDBC_CONNECTION = "jdbc:postgresql://localhost:5432/4-4";
 /** ・ユーザー名 */
  // 問② データベースのユーザー名を定数にしなさい。
 private static final String USER = "postgres";
 /** ・パスワード */
  // 問③ データベースのパスワードを定数にしなさい。
 private static final String PASS = "postgres";
 
 public static void main(String[] args) {
 
 Connection connection = null;
 Statement statement = null;
 ResultSet resultSet = null;
 
 try {
 Class.forName(POSTGRES_DRIVER);
  // 問④ 問①〜③の定数を使ってデータベースと接続しなさい。
		 connection = DriverManager.getConnection(
		 "jdbc:postgresql://localhost:5432/4-4", "postgres", "postgres");
		 
		 // 「Connection」インターフェースで定義されている"createStatement"メソッドを使い、SQL文をデータベースに送るための Statement オブジェクトを生成できる準備
		 statement = connection.createStatement();
		 
		 String SQL = "SELECT * FROM TB_SHOHIN";
		 
		 // SELECT文なので executeQuery() メソッドで実行
			 // 引数にSQL文を指定するので、上記の変数SQLを指定
		 // ❶executeQueryメソッド の戻り値はデータベースから取得した ResultSetオブジェクト となり、先頭から読み出される。
		 resultSet = statement.executeQuery(SQL);
		 
		 // nextメソッド で次の行がない場合にfalseを返し、falseを返すまでwhileループを繰り返す
		 // ❷最初の戻り値が先頭の行にあるので、nextメソッドを使用して次の行を読み込んでいく。
		 while (resultSet.next()) {
		 String column1 = resultSet.getString("SHOHIN_ID");
		 String column2 = resultSet.getString("SHOHIN_NAME");
		 int column3 = resultSet.getInt("TANKA");
		 
		 System.out.print(column1 + ",");
		 System.out.print(column2 + ",");
		 System.out.println(column3);
		 }
		 
		  // forName()で例外発生
		  // ClassNotFoundException で以下の時にスロー
			  // ・forName で指定された名前のクラスの定義が見つからなかった場合
		 } catch (ClassNotFoundException e) {
		 e.printStackTrace();
		 
		  // getConnection()、createStatement()、executeQuery()で例外発生
		  // SQLException で以下の時にスロー
			  // ・Connectionオブジェクトがクローズされている場合
			  // ・Statementオブジェクトの生成でエラーが発生した場合、
			  // ・データベースのアクセスエラーが発生した場合
		 } catch (SQLException e) {
		 e.printStackTrace();
		 
		 // 接続出来た後は切断する
		 } finally {
		 try {
		 if (resultSet != null) {
		 resultSet.close();
		 }
		 if (statement != null) {
		 statement.close();
		 }
		 if (connection != null) {
		 connection.close();
		 }
		 
		 } catch (SQLException e) {
		 e.printStackTrace();
		 
		 }
		 }
		 }
		}

