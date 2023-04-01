package com.java.clock.speakingclock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpeakingClockMain {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String hour = "one";
		try {
			hour = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

        SpeakingClock speakingClock = new SpeakingClock(hour);
        speakingClock.solve();

	}

}
