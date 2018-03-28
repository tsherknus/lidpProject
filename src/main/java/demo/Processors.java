package demo;

public class Processors {

    private final String content;
    private final long maxMem;
    private final long usedMem;
    private final String totalFree;
    private final String inUse;
    private final String cpuUsage;
    
    public Processors(String content, long maxMem, long usedMem, String totalFree, String inUse, String cpuUsage) {
        this.content = content;
        this.maxMem = maxMem;
        this.usedMem = usedMem;
        this.totalFree = totalFree;
        this.inUse = inUse;
        this.cpuUsage = cpuUsage;
    }

    public String getContent() {
        return content;
    }
    
    public long getMaxMem() {
        return maxMem;
    }
    
    public long getUsedMem() {
        return usedMem;
    }
    public String getTotalFree() {
        return totalFree;
    }
    public String getInUse() {
        return inUse;
    }
    public String getCpuUsage() {
        return cpuUsage;
    }
}