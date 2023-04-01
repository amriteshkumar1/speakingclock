package com.java.clock.speakingclock;

public class SpeakingClock {

	    private final int hours;
	    private final int minutes;
	    private String result;

	    private static final String[] TENS = {
	            "zero", "", "twenty ", "thirty ", "forty ", "fifty "
	    };

	    private static final String[] ONES = {
	            "twelve ", "one ", "two ", "three ", "four ", "five ",
	            "six ", "seven ", "eight ", "nine ", "ten ", "eleven ",
	            "twelve ", "thirteen ", "fourteen ", "fifteen ",
	            "sixteen ", "seventeen ", "eighteen ", "nineteen "
	    };

	    public int getHours() {
	        return hours;
	    }

	    public int getMinutes() {
	        return minutes;
	    }

	    public String getResult() {
	        return result;
	    }

	    public void setResult(String result) {
	        this.result = result;
	    }

	    public SpeakingClock(String hour) {

	        try {
	            hour.trim().split(":");
	        } catch (NumberFormatException e) {
	            throw new NumberFormatException("Enter  24 hour format hour");
	        }

	        String[] hours = hour.trim().split(":");

	        try {
	            Integer.parseInt(hours[0]);
	            Integer.parseInt(hours[1]);
	        } catch (NumberFormatException e) {
	            throw new NumberFormatException("Please Enter 24 hour format hour");
	        }

	        this.hours = Integer.parseInt(hours[0]);
	        this.minutes = Integer.parseInt(hours[1]);
	        this.result = "";
	    }

	    public void solve() {

	        String hourInWords = convertToWords(this.getHours(), this.getMinutes());

	        if (hourInWords.equals("")) {
	        } else {
	            this.setResult(hourInWords);
	            printResult();
	        }
	    }

	    private String convertToWords(int hour, int minutes) {

	        StringBuilder result = new StringBuilder();

	        if (this.getMinutes() == 0) {

	            if (this.getHours() == 12) {
	                return result.append("It's Midday").toString();
	            }

	            if (this.getHours() == 24) {
	                return result.append("It's Midnight").toString();
	            }

	            result.append("It's ").append(ONES[hour % 12]);

	        } else if (minutes % 10 == 0) {
	            result.append("It's ").append(ONES[hour % 12]).append(TENS[minutes / 10]);
	        } else if (minutes < 10 || minutes > 20) {
	            result.append("It's ").append(ONES[hour % 12]).append(TENS[minutes / 10]).append(ONES[minutes % 10]);
	        } else {
	            result.append("It's ").append(ONES[hour % 12]).append(ONES[minutes]);
	        }

	        return result.toString();
	    }

	    private void printResult() {
	        System.out.println(this.getResult());
	    }
	}

