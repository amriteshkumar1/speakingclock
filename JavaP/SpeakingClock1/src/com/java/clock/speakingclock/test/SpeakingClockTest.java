package com.java.clock.speakingclock.test;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.java.clock.speakingclock.SpeakingClock;
public class SpeakingClockTest {
	
	 @Rule
	 public ExpectedException exceptionRule = ExpectedException.none();

	    @Test
	    public void whenEnteredLetters_thenShouldReturnExceptionTest() {
	        exceptionRule.expect(NumberFormatException.class);
	        exceptionRule.expectMessage("Enter valid 24 hour format hour");
	        SpeakingClock speakingClock = new SpeakingClock("12:aa");
	        speakingClock.solve();
	    }

	    @Test
	    public void whenSemicolonInsteadOfColon_thenShouldReturnExceptionTest() {
	        exceptionRule.expect(NumberFormatException.class);
	        exceptionRule.expectMessage("Enter valid 24 hour format hour");
	        SpeakingClock speakingClock = new SpeakingClock("12;13");
	        speakingClock.solve();
	    }

	    @Test
	    public void whenEnteredMiddayTest() {
	        SpeakingClock speakingClock = new SpeakingClock("12:00");
	        speakingClock.solve();
	        assertEquals("It's Midday", speakingClock.getResult());
	    }

	    @Test
	    public void whenEnteredMidnightTest() {
	        SpeakingClock speakingClock = new SpeakingClock("24:00");
	        speakingClock.solve();
	        assertEquals("It's Midnight", speakingClock.getResult());
	    }

	    @Test
	    public void whenEnteredTwelveFiftyTest() {
	        SpeakingClock speakingClock = new SpeakingClock("12:50");
	        speakingClock.solve();
	        assertEquals("It's twelve fifty ", speakingClock.getResult());
	    }

	    @Test
	    public void whenEnteredOneTest() {
	        SpeakingClock speakingClock = new SpeakingClock("13:00");
	        speakingClock.solve();
	        assertEquals("It's one ", speakingClock.getResult());
	    }

	    @Test
	    public void whenEnteredTwoOhSixTest() {
	        SpeakingClock speakingClock = new SpeakingClock("14:06");
	        speakingClock.solve();
	        assertEquals("It's two zerosix ", speakingClock.getResult());
	    }

	    @Test
	    public void whenEnteredFiveFifteenTest() {
	        SpeakingClock speakingClock = new SpeakingClock("17:15");
	        speakingClock.solve();
	        assertEquals("It's five fifteen ", speakingClock.getResult());
	    }
	}

