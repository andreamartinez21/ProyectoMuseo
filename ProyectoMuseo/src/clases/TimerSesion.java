package clases;

import javax.swing.JLabel;

public class TimerSesion implements Runnable {

	JLabel time;
	Thread t;
	boolean cronometroActivo;

	public TimerSesion(JLabel time) {
		this.time = time;
	}

	public void run() {
		Integer minutes = 0, seconds = 0, milliseconds = 0;
		String min = "", seg = "", mil = "";

		try {
			while (cronometroActivo) {
				Thread.sleep(4);
				milliseconds += 4;
				if (milliseconds == 1000) {
					milliseconds = 0;
					seconds += 1;
					if (seconds == 60) {
						seconds = 0;
						minutes++;
					}
				}
				if (minutes < 10) {
					min = "0" + minutes;
				} else {
					min = minutes.toString();
				}
				if (seconds < 10) {
					seg = "0" + seconds;
				} else { 
					seg = seconds.toString();
				}
				if (milliseconds < 10) {
					mil = "00" + milliseconds;
				} else if (milliseconds < 100) {
					mil = "0" + milliseconds;
				} else {
					mil = milliseconds.toString();
				}

				time.setText(min + ":" + seg + ":" + mil);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		time.setText("00:00:000");
	}

	public void iniciarCronometro() {
		cronometroActivo = true;
		t = new Thread(this);
		t.start();
	}

}
