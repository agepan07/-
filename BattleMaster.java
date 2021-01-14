package monsterBattle;

import monsterBattle.monster.Monster;

public class BattleMaster {

	/**
	 * 引数の配列に格納されたモンスターより、ランダムに2体選択し、
	 * ステータスと先攻後攻を出力し、結果を返すメソッド
	 *
	 * @param monster
	 *            格納されモンスターの配列
	 * @return selected
	 *         決めた2体のモンスターの配列
	 */
	public Monster[] select(Monster[] monster) {
		Monster[] selected = new Monster[2];
		int monsterA = 0, monsterB = 0;

		// monster配列の数の内、二つの値をmonsterA,monsterBに代入
		// 同一ではない値を入手するまで繰り返す。
		do {
			monsterA = (int) (Math.random() * monster.length);// 自分のモンスター
			monsterB = (int) (Math.random() * monster.length);// 相手のモンスター
		} while (monsterA == monsterB);

		// 選択された子クラスのspeedJudgeメソッドより、
		// 先攻後攻を判定し、先攻を配列の1つ目に後攻を配列の2つ目に格納する。
		if (monster[monsterA].speedJudge(monster[monsterB].getHp(), monster[monsterB].getSpeed())) {
			selected[0] = monster[monsterA];
			selected[1] = monster[monsterB];
		} else {
			selected[0] = monster[monsterB];
			selected[1] = monster[monsterA];
		}

		// 先攻と後攻のモンスター名とステータスを表示する。
		System.out.println("・*:.｡. .｡.:*・ﾟﾟ・* 【先攻】" + selected[0].getName() + " VS【後攻】" + selected[1].getName() + "・*:.｡. .｡.:*・ﾟﾟ・* ");
		for (Monster monst : selected) {
			monst.outputStatus();
		}

		// 選択したモンスターを返り値として返す。
		return selected;
	}

	/**
	 * 選択されたモンスター2体の対戦結果を出力するメソッド
	 *
	 * @param monsters
	 *            選ばれたモンスターが格納されている配列
	 *            monsters[attacker]:先攻のモンスター
	 *            monsters[defender]:後攻のモンスター
	 */
	public void outBattle(Monster[] monsters) {
		final int attacker = 0;
		final int defender = 1;
		// advantageメソッドより、
		// 先攻または後攻のモンスター、どちらが有利か判定し出力する。
		monsters[attacker].advantage(monsters[defender].getType());
		monsters[defender].advantage(monsters[attacker].getType());

		// 戦闘回数
		int count = 1;
		// モンスターの攻撃発生回数
		int attackCount = 0;
		// 順番入れ替えに使用
		Monster change;

		// monsters[attacker]の体力がなくなるまで戦闘内容を出力する
		// ※攻撃を受けたのち、攻守交替しているため
		while (monsters[attacker].getHp() > 0) {
			// 攻撃発生回数が偶数なら表示
			if (attackCount % 2 == 0) {
				System.out.println("\n■■■■■■■" + count + "回戦■■■■■■■");
				// 戦闘回数を増やす
				count++;
			}

			// 攻撃するモンスター名と攻撃力の出力
			System.out.println("\n★攻撃開始>>>" + monsters[attacker].getName() + "(基本攻撃力:" + monsters[attacker].getPower() + ")のターン");

			// ダメージ計算に使用する、攻撃力
			double attackPower = monsters[attacker].getPower();

			// criticalJadgeメソッドより、
			// 必殺技が発動可能であれば必殺技を出す。
			// そうでなければcharAttackメソッド(通常技)を出力する。
			if (monsters[attacker].criticalJadge()) {
				attackPower *= 2.0;
				System.out.println(monsters[defender].getName() + "に" + attackPower + "の攻撃");
			} else {
				monsters[attacker].charAttack();
			}

			// minusHpメソッドにより、
			// 残りの体力を計算し出力する。
			System.out.println("\n【攻撃結果】");
			monsters[defender].minusHp(attackPower);

			// 攻守交替
			change = monsters[attacker];
			monsters[attacker] = monsters[defender];
			monsters[defender] = change;

			// 攻撃発生回数を増やす
			attackCount++;
		}

		// 戦闘結果を出力する
		System.out.println(monsters[attacker].getName() + "は降参した。・゜゜・(>_<)・゜゜・。 \n");
		System.out.println("・*:.｡. .｡.:*・ﾟﾟ・* 勝負あり・*:.｡. .｡.:*・ﾟﾟ・* \n");
		System.out.println(monsters[defender].getName() + "の勝ち ");

	}

}
