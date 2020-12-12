package org.kostin.beans;

public class Pdd {
	private String offence_id;
	private String model;
    private String driver_name;
    private String offence_type;
    private float fine;
    
    public Pdd() { 	
    }
    
    public Pdd(String offence_id) {
		this.setOffence_id(offence_id);
    }
    
    public Pdd(String model, String driver_name, String offence_type, float fine) {
		this.model = model;
		this.driver_name = driver_name;
		this.offence_type = offence_type;
		this.fine = fine;
    }
    
    public Pdd(String offence_id, String model, String driver_name, String offence_type, float fine) {
		this.offence_id = offence_id;
		this.model = model;
		this.driver_name = driver_name;
		this.offence_type = offence_type;
		this.fine = fine;
    }

	public String getOffence_id() {
		return offence_id;
	}

	public void setOffence_id(String offence_id) {
		this.offence_id = offence_id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDriver_name() {
		return driver_name;
	}

	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}

	public float getFine() {
		return fine;
	}

	public void setFine(float fine) {
		this.fine = fine;
	}

	public String getOffence_type() {
		return offence_type;
	}

	public void setOffence_type(String offence_type) {
		this.offence_type = offence_type;
	}
}
