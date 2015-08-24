package model;

import ec.gp.GPData;


public class SOPData extends GPData{
	private static final long serialVersionUID = 1236137301060685291L;

	protected boolean result;
	protected Instance instance;
	
	public SOPData(){
		result = false;
		instance = new Instance();
	}
	
	public String toString() {
		return ("[result=" + result + "]\n[instance=" + "]\n");
	}
	
	@Override
	public SOPData clone() {
		SOPData clon = new SOPData();
		clon.result = this.result;
		clon.instance = this.instance.clone();
        return clon;
    }
	
	public boolean getResult() {
    	return result;
    }
	
    public void setResult(boolean cond) {
    	this.result = cond;
    }
    
    public Instance getInstance() {
    	return instance;
    }
    
    public void setInstance(final Instance inst) {
    	this.instance = (inst);
    }
}
