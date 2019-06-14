public enum Flag {
	//just flags to switch between read and write 
    WRITE(0), READ(1);
    final int FLAG;
    
    Flag(int flag) {
    	FLAG = flag;
    }
    
    public int getComm() {
    	return FLAG;
    }
}
