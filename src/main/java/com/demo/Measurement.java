package com.demo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class Measurement implements Serializable{
	private static final long serialVersionUID = 2700987877207186088L;
	
	private static final Random RANDOM = new Random(); 
	
	private LocalDateTime dateTime = LocalDateTime.now();
	private Float globalActivePower;
	private Float globalReactivePower;
	private Float voltage;
	private Float globalIntensity;
	
	public Measurement() {
		globalActivePower = 3.5f + RANDOM.nextFloat()*2;
		globalReactivePower = RANDOM.nextFloat();
		voltage = 230 + RANDOM.nextFloat()*5;
		globalIntensity = 15 + RANDOM.nextFloat()*5;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Float getGlobalActivePower() {
		return globalActivePower;
	}

	public void setGlobalActivePower(Float globalActivePower) {
		this.globalActivePower = globalActivePower;
	}

	public Float getGlobalReactivePower() {
		return globalReactivePower;
	}

	public void setGlobalReactivePower(Float globalReactivePower) {
		this.globalReactivePower = globalReactivePower;
	}

	public Float getVoltage() {
		return voltage;
	}

	public void setVoltage(Float voltage) {
		this.voltage = voltage;
	}

	public Float getGlobalIntensity() {
		return globalIntensity;
	}

	public void setGlobalIntensity(Float globalIntensity) {
		this.globalIntensity = globalIntensity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateTime, globalActivePower, globalIntensity, globalReactivePower, voltage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Measurement other = (Measurement) obj;
		return Objects.equals(dateTime, other.dateTime) && Objects.equals(globalActivePower, other.globalActivePower)
				&& Objects.equals(globalIntensity, other.globalIntensity)
				&& Objects.equals(globalReactivePower, other.globalReactivePower)
				&& Objects.equals(voltage, other.voltage);
	}

	@Override
	public String toString() {
		return "Measurement [dateTime=" + dateTime + ", globalActivePower=" + globalActivePower
				+ ", globalReactivePower=" + globalReactivePower + ", voltage=" + voltage + ", globalIntensity="
				+ globalIntensity + "]";
	}

}
