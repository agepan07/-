package monsterBattle.monster;

public class MonsterWood extends Monster {

	// モンスター固有の能力
	public MonsterWood() {
		name = "グリーンドラゴン";
		spSkill = "地震を起こす";
		type = "木";
		critical = 50;
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see monsterBattle.monster.Monster#charAttack()
	 * モンスターの通常必殺技を出力する
	 */
	@Override
	public void charAttack() {
		System.out.println("このはのまいで攻撃");

	}

}
