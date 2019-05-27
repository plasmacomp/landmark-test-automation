package listener;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import utils.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class AnnotationTransformer extends Data implements IAnnotationTransformer {

	//utils.DataReader dr=new utils.DataReader();
	List<Data> list= DataReader.getDataObjectRepo();

    public boolean isTestDisabled(String testName){
    	boolean isRunDisabled=false;
    	
    	/*try {
			@SuppressWarnings("unused")
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    	
    	Iterator<Data> itr=list.iterator();
    	OUTER_LOOP:
    	while(itr.hasNext()){
    		Map<String, DataElements> dataMap=itr.next().getElementList();
    		for(Map.Entry<String, DataElements> entry : dataMap.entrySet()){
    			if(entry.getValue().getTestMethodName().equalsIgnoreCase(testName)){
    				if(entry.getValue().getRunStatus().equalsIgnoreCase("skip")){
    					isRunDisabled=true;
    					break OUTER_LOOP;
    				}
        				
    			}
    			
    		}
    	}
    	
    	return isRunDisabled;
    }

	@SuppressWarnings("rawtypes")
	@Override
	public void transform(ITestAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) {
		
		if (isTestDisabled(testMethod.getName())) {
            annotation.setEnabled(false);
        }
		else{
			Utils.methodToBeExecuted.add(testMethod.getName());
		}
			
		
		
	}

	
}