package designpattern.Behaviuorpattrn;

import java.util.Scanner;

interface Light_State {
	void switchOn(Traffic_Light traffic_Light);

	void switchOff(Traffic_Light traffic_Light);
}

class Traffic_Light {
	Light_State state;

	public void setState(Light_State state) {
		this.state = state;
	}

	public void switchOn() {
		state.switchOn(this);
	}

	public void switchOff() {
		state.switchOff(this);
	}
}

class Red_Light implements Light_State {
	@Override
	public void switchOn(Traffic_Light traffic_Light) {
		System.out.println("Red_Light :ON Already");
	}

	@Override
	public void switchOff(Traffic_Light traffic_Light) {
		System.out.println("Red_Light :OFF");
		traffic_Light.setState(new Yellow_Light());
		System.out.println("--------------------------------------------");
		System.out.println("Yellow_Light :ON");
	}

}

class Yellow_Light implements Light_State {
	@Override
	public void switchOn(Traffic_Light traffic_Light) {
		System.out.println("Yellow_Light :ON Already");
	}

	@Override
	public void switchOff(Traffic_Light traffic_Light) {
		System.out.println("Yellow_Light :OFF");
		traffic_Light.setState(new Green_Light());
		System.out.println("--------------------------------------------");
		System.out.println("Green_Light :ON");
	}

}

class Green_Light implements Light_State {
	@Override
	public void switchOn(Traffic_Light traffic_Light) {
		System.out.println("Green_Light :ON Already");
	}

	@Override
	public void switchOff(Traffic_Light traffic_Light) {
		System.out.println("Green_Light :OFF");
		traffic_Light.setState(new Red_Light());
		System.out.println("--------------------------------------------");
		System.out.println("Red_Light :ON");
	}

}

public class Day_15_Task {
	public static void main(String[] args) {
		Light_State state;
		Red_Light r = new Red_Light();
		Yellow_Light y = new Yellow_Light();
		Green_Light g = new Green_Light();
		Traffic_Light tl = new Traffic_Light();
		Scanner sc = new Scanner(System.in);
		String opt;

		do {
			System.out.println("1.Red_Light\n2.Yellow_Light\n3.Green_Light\n\nSelect light: ");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("1.ON\n2.OFF\nSelect the action:");
				int r_ch = sc.nextInt();
				switch (r_ch) {
				// If Red light is 1st selected
				case 1:
					r.switchOn(tl);
					break;
				case 2:
					r.switchOff(tl);
					// ---------------------------------------------------- YELLOW ON
					System.out.println("1.ON\n2.OFF\nSelect the action:");
					int r_ch1 = sc.nextInt();
					switch (r_ch1) {
					case 1:
						y.switchOn(tl);
						break;
					case 2:
						y.switchOff(tl);
						// ---------------------------------------------------- GREEN ON
						System.out.println("1.ON\n2.OFF\nSelect the action:");
						int r_ch2 = sc.nextInt();
						switch (r_ch2) {
						case 1:
							g.switchOn(tl);
							break;
						case 2:
							g.switchOff(tl);
							System.out.println("---Traffic Light:Shut Down---");
							System.out.println("--------------------------------------------");
							break;
						default:
							System.out.println("Invalid Input...!");
							break;
						}
					}
				}
				break;

			case 2:
				System.out.println("1.ON\n2.OFF\nSelect the action:");
				int y_ch = sc.nextInt();
				switch (y_ch) {
				// If Yellow light is 1st selected
				case 1:
					y.switchOn(tl);
					break;
				case 2:
					y.switchOff(tl);
					// ---------------------------------------------------- GREEN ON
					System.out.println("1.ON\n2.OFF\nSelect the action:");
					int y_ch1 = sc.nextInt();
					switch (y_ch1) {
					case 1:
						g.switchOn(tl);
						break;
					case 2:
						g.switchOff(tl);
						// ---------------------------------------------------- RED ON
						System.out.println("1.ON\n2.OFF\nSelect the action:");
						int y_ch2 = sc.nextInt();
						switch (y_ch2) {
						case 1:
							r.switchOn(tl);
							break;
						case 2:
							r.switchOff(tl);
							System.out.println("---Traffic Light:Shut Down---");
							System.out.println("--------------------------------------------");
							break;
						default:
							System.out.println("Invalid Input...!");
							break;
						}
					}
				}
				break;

			case 3:
				System.out.println("1.ON\n2.OFF\nSelect the action:");
				int g_ch = sc.nextInt();
				switch (g_ch) {
				// If Green light is 1st selected
				case 1:
					g.switchOn(tl);
					break;
				case 2:
					g.switchOff(tl);
					// ---------------------------------------------------- RED ON
					System.out.println("1.ON\n2.OFF\nSelect the action:");
					int g_ch1 = sc.nextInt();
					switch (g_ch1) {
					case 1:
						r.switchOn(tl);
						break;
					case 2:
						r.switchOff(tl);
						// ---------------------------------------------------- YELLOW ON
						System.out.println("1.ON\n2.OFF\nSelect the action:");
						int g_ch2 = sc.nextInt();
						switch (g_ch2) {
						case 1:
							y.switchOn(tl);
							break;
						case 2:
							y.switchOff(tl);
							System.out.println("---Traffic Light:Shut Down---");
							System.out.println("--------------------------------------------");
							break;
						default:
							System.out.println("Invalid Input...!");
							break;
						}
					}
				}
				break;
			default:
				System.out.println("Invalid Input...!");
				break;
			}
			System.out.println("Do you want to continue ?(Y?N)");
			opt = sc.next();
		} while (opt.toUpperCase().equals("Y"));
	}
}
