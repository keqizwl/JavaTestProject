package leetcode;
import java.util.ArrayList;
import java.util.List;

public class FuelStationProblem {

	public static void main(String[] args) {
		int target = 1000;
		int startFuel = 83;
		int[][] stations = {{133,1},{137,63},{374,20},{392,82},{451,19},{568,43},{690,41},{767,69},{796,50},{900,74}};

		System.out.println(minRefuelStops(target, startFuel, stations));
	}

	public static class TempInfo {
		int startStationIndex;
		int startFuel;

		public TempInfo(int startStationIndex, int startFuel) {
			this.startStationIndex = startStationIndex;
			this.startFuel = startFuel;
		}
	}

	public static List<TempInfo> tempInfos = new ArrayList<>();

	public static int minRefuelStops(int target, int startFuel, int[][] stations) {
		/**
		 * 思路：
		 * 1检查不经过点是否能到达
		 * 2检查进过一个点能否到达，并保存可以到达的一个点的列表信息
		 * 3在检查过1个点的基础上，在检查进过两个点能否到达，并保存两个点的起始信息
		 * 。。。
		 */
		
		if (startFuel >= target) {
			return 0;
		}
		
		tempInfos.add(new TempInfo(-1, startFuel));
		for(int i = 1; i <= stations.length; i++) {
			List<TempInfo> lastTempInfos = tempInfos;
			tempInfos = new ArrayList<>();
			
			if(lastTempInfos.size() == 0) {
				break;
			}else {
				for(TempInfo tempInfo : lastTempInfos) {
					for(int j = tempInfo.startStationIndex + 1; j < stations.length; j ++) {
						int leftFuel = tempInfo.startFuel - (stations[j][0] - (tempInfo.startStationIndex < 0 ? 0 : stations[tempInfo.startStationIndex][0]));
						if(leftFuel >= 0) {
							if(leftFuel + stations[j][1] >= target - stations[j][0]) {
								return i;
							}else {
								tempInfos.add(new TempInfo(j, leftFuel + stations[j][1]));
							}
						}
					}
				}
			}
		}
		
		return -1;
	}

	// public static int canReach(int target, int startFuel, int[][] stations) {
	// if (stations.length == 0) {
	// return startFuel >= target ? 0 : -1;
	// }
	//
	// for (int i = 0; i <= stations.length; i++) {
	// if (canReach(target, startFuel, stations, -1, i)) {
	// return i;
	// }
	// }
	// return -1;
	// }
	//
	// public static boolean canReach(int target, int startFuel, int[][] stations,
	// int startIndex, int pointLimit) {
	// if (pointLimit == 0) {
	// return startFuel >= target - (startIndex >= 0 ? stations[startIndex][0] : 0);
	// }
	//
	// for (int i = startIndex + 1; i < stations.length; i++) {
	// int fuelLeft = startFuel - stations[i][0] + (startIndex >= 0 ?
	// stations[startIndex][0] : 0);
	// if (fuelLeft >= 0) {
	// int newStartFuel = fuelLeft + stations[i][1];
	// int newStartIndex = i;
	// int newPointLimit = pointLimit - 1;
	// boolean canReach = canReach(target, newStartFuel, stations, newStartIndex,
	// newPointLimit);
	// if (canReach) {
	// return true;
	// }
	// }
	// }
	//
	// return false;
	// }
}
