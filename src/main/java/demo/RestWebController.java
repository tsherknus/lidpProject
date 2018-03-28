package demo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

import java.util.Date;
import demo.Customer;
import demo.Greeting;
import demo.Processors;

@RestController
public class RestWebController {

	List<Customer> cust = new ArrayList<Customer>();

	@RequestMapping(value="/postcustomer", method=RequestMethod.POST)
	public String postCustomer(@RequestBody Customer customer){
		cust.add(customer);

		return Double.toString(customer.getFirstname() * 3.14 * 2);
	}
	
	private static Date day;
	private final static String appName = "demo.Application";
	
    @RequestMapping("/greeting")
    public Greeting greeting(String name) {
    	day = new Date();
        return new Greeting(String.format(String.valueOf(day), name), String.format(appName, name));
    }
     
    private final static int processors = Runtime.getRuntime().availableProcessors();
    private final static long maxMemory = Runtime.getRuntime().totalMemory()/1024;
    private final static long usedMemory = Runtime.getRuntime().freeMemory()/1024;
    
    public static long totalFree() {
        File[] roots = File.listRoots();
        Path p1 = Paths.get("C://");
        /* For each filesystem root, print some info */
        long totalFree = 0;
        for (File root : roots) {
        	if (root.getAbsolutePath().equals(p1.toString())){
        		
    		      totalFree = root.getTotalSpace();
        	}else {
        		break;
        	}
        }
    	return totalFree/1073741824;
    }
    
    public static long inUse() {
        File[] roots = File.listRoots();
        Path p1 = Paths.get("C://");
        /* For each filesystem root, print some info */
        long totalFree = 0;
        for (File root : roots) {
        	if (root.getAbsolutePath().equals(p1.toString())){
    		      totalFree = root.getFreeSpace();
        	}else {
        		break;
        	}
        }
    	return totalFree/1073741824;
    }
    
    public static double cpuUsage() {
		OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                OperatingSystemMXBean.class);
    	double usage = osBean.getSystemCpuLoad()*100.0;
    	return usage;
    }
    
    private final static String totalFree = Long.toString(totalFree());
    private final static String inUse = Long.toString((totalFree() - inUse()));
    private final static String cpuUsage = Double.toString(cpuUsage());
    
    @RequestMapping("/processors")
    public Processors processors(String name) {
        return new Processors(String.format(Integer.toString(processors), name), maxMemory, usedMemory, totalFree, inUse, cpuUsage);
    }
}
