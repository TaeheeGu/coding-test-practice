package practice.gyocharo;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		int[] answer = new int[N];
		Arrays.fill(answer, -1);

		Queue<Car> pq = new PriorityQueue<>(new Comparator<Car>() {

			@Override
			public int compare(Car o1, Car o2) {
				if (o1.time != o2.time) {
					return o1.time - o2.time;
				} else if (o1.road != o2.road) {
					return o1.road - o2.road;
				} else {
					return o1.idx - o2.idx;
				}
			}
		});

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());

			int time = Integer.parseInt(st.nextToken());
			char road = st.nextToken().charAt(0);

			pq.add(new Car(time, road, i));
		}

		int count = N;
		int condition = 0;
		Car cur;

		while (true) {
			if (count == 0) {
				break;
			}

			if (condition == 4) {
				break;
			}

			cur = pq.poll();

			List<Car> list = new ArrayList<Car>();
			list.add(cur);

			while (!pq.isEmpty()) {
				Car next = pq.poll();
				if (cur.time == next.time) {
					list.add(next);
				} else {
					pq.add(next);
					break;
				}
			}

			int[] dir = new int[4];
			int[] duple = new int[4];

			for (int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i));
				int idx = list.get(i).road - 'A';
				dir[idx]++;
			}
//			System.out.println();

			for (int i = 0; i < list.size(); i++) {
				Car car = list.get(i);
				int idx = car.road - 'A';
				if (idx != 0) {
					if (dir[idx - 1] == 0 && duple[idx] == 0) {
						answer[list.get(i).idx] = car.time;
						duple[idx] = 1;
						count--;
					} else {
						pq.add(new Car(car.time + 1, car.road, car.idx));
						condition++;
					}
				}
				if (idx == 0) {
					if (dir[3] == 0 && duple[idx] == 0) {
						answer[list.get(i).idx] = car.time;
						duple[idx] = 1;
						count--;
					} else {
						pq.add(new Car(car.time + 1, car.road, car.idx));
						condition++;
					}
				}
			}

		}

		for (int i = 0; i < N; i++) {
			sb.append(answer[i]).append('\n');
		}

		out.write(sb.toString());
		out.close();
	}
}

class Car {
	public int time;
	public char road;
	public int idx;

	public Car(int time, char road, int idx) {
		this.time = time;
		this.road = road;
		this.idx = idx;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [time=").append(time).append(", road=").append(road).append(", idx=").append(idx + 1)
				.append("]");
		return builder.toString();
	}

}