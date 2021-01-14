package monsterBattle.monster;

public class MonsterFire extends Monster {

	// モンスター固有の能力
	public MonsterFire() {
		name = "ファイヤードラゴン";
		spSkill = "焼き尽くす";
		type = "火";
		critical = 30;
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see monsterBattle.monster.Monster#charAttack()
	 * モンスターの通常必殺技を出力する
	 */
	@Override
	public void charAttack() {
		System.out.println("かえんほうしゃで攻撃");

	}

}
