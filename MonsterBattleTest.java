package monsterBattle;

import monsterBattle.monster.Monster;
import monsterBattle.monster.MonsterFire;
import monsterBattle.monster.MonsterWater;
import monsterBattle.monster.MonsterWood;

public class MonsterBattleTest {

	/**
	 * メインメソッド
	 * モンスターの選択と戦闘内容を呼び出す。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// クラス：Monsterの各子クラスをインスタンス化(fire,water,wood)
		MonsterFire fire = new MonsterFire();
		MonsterWater water = new MonsterWater();
		MonsterWood wood = new MonsterWood();

		// BattleMonsterをインスタンス化(battleMaster)
		BattleMaster battleMaster = new BattleMaster();

		// Monster[]型の変数:monsterを準備し、
		// 各子クラスのインスタンス名を配列型で格納
		Monster[] monsters = { fire, water, wood };

		// *モンスター2匹をランダム選択し先攻後攻とステータスを表示する。
		// Monster[]型の変数:selectedに、
		// battleMasterのselectメソッドの結果を表示し代入
		// 引数：monsters
		Monster[] selected = battleMaster.select(monsters);

		// *選択したモンスター2匹の戦闘内容を表示する。
		// battleMasterのoutBattleメソッドを実行
		// 引数：selected
		battleMaster.outBattle(selected);

	}

}
