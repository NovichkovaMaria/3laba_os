
public class Page {
	private int processId;
    private int physicalAddress;
    private int virtualAddress;
    private boolean recourse;
    private boolean presence;

    public Page(int processId)
    {
        this.processId = processId;
        this.physicalAddress = -1;
        this.virtualAddress = -1;
        this.recourse = false;
        this.presence = false;
    }
    public boolean isRecourse()
    {
        return recourse;
    }
    public void setRecourse(boolean recourse)
    {
        this.recourse = recourse;
    }
    public boolean isPresent()
    {
        return presence;
    }
    public void setPresence(boolean presence)
    {
        this.presence = presence;
    }
    public int getProcessId()
    {
        return processId;
    }
    public int getPhysicalAddress()
    {
        return physicalAddress;
    }
    public void setPhysicalAddress(int physicalAddress)
    {
        this.physicalAddress = physicalAddress;
    }
    public int getVirtualAddress()
    {
        return virtualAddress;
    }
    public void setVirtualAddress(int virtualAddress)
    {
        this.virtualAddress = virtualAddress;
    }       
}