package monsterBattle.monster;

public class MonsterWater extends Monster {

	// モンスター固有の能力
	public MonsterWater() {
		name = "アクアドラゴン";
		spSkill = "嵐を呼び出す";
		type = "水";
		critical = 40;
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see monsterBattle.monster.Monster#charAttack()
	 * モンスターの通常必殺技を出力する
	 */
	@Override
	public void charAttack() {
		System.out.println("アクアテールで攻撃");

	}

}
