package monsterBattle.monster;

import java.util.HashMap;
import java.util.Map;

public abstract class Monster {

	// フィールド
	protected String name, spSkill, type;// 名前,必殺技,属性
	private double hp, power;// HP,攻撃力
	protected int critical;// 必殺技が決まる確率
	final private int speed;// スピード

	// コントラクタ
	// HP、攻撃力、スピードの初期値をランダム値にて設定
	Monster() {
		this.hp = (int) (Math.random() * 501) + 1000;
		this.power = (int) (Math.random() * 401) + 100;
		this.speed = (int) (Math.random() * 100) + 1;
	}

	/**
	 * ステータスを表示させるメソッド
	 */
	public void outputStatus() {
		System.out.println("-----" + name + "のステータス-----");
		System.out.println(String.format("HP:%.0f", hp));
		System.out.println("種類属性:" + type);
		System.out.println(String.format("攻撃力：%.0f", power));
		System.out.println("スピード：" + speed);
		System.out.printf("---------------------------------------\n");
	}

	/**
	 * 先攻になるか判定するメソッド
	 *
	 * @param enemyHP
	 *            対戦相手のHP
	 * @param enemySP
	 *            対戦相手のスピード
	 *
	 * @return 条件に一致した時はtrue
	 */
	public boolean speedJudge(double enemyHP, double enemySP) {
		// 自分の方がスピードが速い
		if (speed > enemySP) {
			return true;
		}
		// スピードが同じ且つ、自分の方が体力が多い
		if (speed == enemySP && hp > enemyHP) {
			return true;
		}
		return false;

	}

	/**
	 * 攻撃有利を判定し結果を出力するメソッド
	 *
	 * @param enemyType
	 *            対戦相手のタイプ
	 */
	public void advantage(String enemyType) {
		Map<String, String> attribute = new HashMap<>();

		// 相性関係を登録
		// ki：有利属性,value:不利属性
		attribute.put("火", "木");
		attribute.put("水", "火");
		attribute.put("木", "水");

		// 自分のタイプが相手のタイプに相性有利の時
		// 判定結果を表示
		if (attribute.get(type).equals(enemyType)) {
			power *= 1.5;
			System.out.println("<<<属性有利判定>>");
			System.out.print(name + "の属性有利！\n");
			System.out.println("基本攻撃力が" + power + "にアップ！");
		}
	}

	/**
	 * 通常攻撃を表記するための抽象メソッド
	 */
	public abstract void charAttack();

	/**
	 * 必殺技の発生を判定するメソッド
	 *
	 * @return 条件に一致したときはtrue
	 *
	 */
	public boolean criticalJadge() {

		int rdm = (int) (Math.random() * 101) + 1;
		// criticalがランダムで得た値より大きい
		if (critical >= rdm) {
			System.out.println(name + "の必殺技発動！\n" + spSkill);
			return true;
		}
		return false;
	}

	/**
	 * 攻撃を受けた後のHPを計算、表記するメソッド
	 *
	 * @param atterckerPower
	 *            atterckerの攻撃力
	 *
	 */
	public void minusHp(double atterckerPower) {
		// 攻撃を受ける前の体力を表示する。
		System.out.print(name + "の残りのHP：" + hp);
		hp -= atterckerPower;

		// hpがマイナスになった場合、0を代入する。
		if (hp < 0) {
			hp = 0;
		}
		// 攻撃を受けた後の体力を表示する。
		System.out.println("→" + hp);
	}

	/**
	 * 名前を取得するメソッド
	 *
	 * @return
	 * 		名前
	 */
	public String getName() {
		return name;
	}

	/**
	 * HPを取得するメソッド
	 *
	 * @return
	 * 		HP
	 */
	public double getHp() {
		return hp;
	}

	/**
	 * 属性を取得するメソッド
	 *
	 * @return
	 * 		属性
	 */
	public String getType() {
		return type;
	}

	/**
	 * 攻撃力を取得するメソッド
	 *
	 * @return
	 * 		攻撃力
	 */
	public double getPower() {
		return power;
	}

	/**
	 * スピードを取得するメソッド
	 *
	 * @return
	 * 		スピード
	 */
	public double getSpeed() {
		return speed;
	}

}
