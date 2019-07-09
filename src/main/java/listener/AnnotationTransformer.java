package listener;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import utils.*;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class AnnotationTransformer extends Data implements IAnnotationTransformer {
	List<Data> list= DataReader.getDataObjectRepo();
	DataReader db = new DataReader();

    /*public boolean isTestDisabled(String testName){
    	boolean isRunDisabled=false;
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
    }*/

	/*@SuppressWarnings("rawtypes")
	@Override
	public void transform(ITestAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) {
		
		*//*if (isTestDisabled(testMethod.getName())) {
            annotation.setEnabled(false);
        }
		else{
			Utils.methodToBeExecuted.add(testMethod.getName());
		}*//*

		List<Data> list = DataReader.getDataObjectRepo();
		IRetryAnalyzer retry = annotation.getRetryAnalyzer();
		Iterator<Data> itr = list.iterator();
		OUTER_LOOP:
		while (itr.hasNext()) {
			Map<String, DataElements> dataMap = itr.next().getElementList();
			for (Map.Entry<String, DataElements> entry : dataMap.entrySet()) {
				if (entry.getValue().getTestMethodName().equalsIgnoreCase(testMethod.getName())) {
					if (entry.getValue().getRunStatus().equalsIgnoreCase("skip")) {
						annotation.setEnabled(false);
					}
				}
			}
		}

		if (retry == null) {
			annotation.setRetryAnalyzer(Retry.class);
		}
	}*/

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		try {
			db.setupDataSheet();
			//db.setDataObject(baseDirectory.getCanonicalPath() + "\\src\\main\\resources\\TestData\\testdata" + ".xlsx");
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Data> list = DataReader.getDataObjectRepo();
		IRetryAnalyzer retry = annotation.getRetryAnalyzer();
		Iterator<Data> itr = list.iterator();
		OUTER_LOOP:
		while (itr.hasNext()) {
			Map<String, DataElements> dataMap = itr.next().getElementList();
			for (Map.Entry<String, DataElements> entry : dataMap.entrySet()) {
				if (entry.getValue().getTestMethodName().equalsIgnoreCase(testMethod.getName())) {
					if (entry.getValue().getRunStatus().equalsIgnoreCase("skip")) {
						annotation.setEnabled(false);
					}
				}
			}
		}

		if (retry == null) {
			annotation.setRetryAnalyzer(Retry.class);
		}

	}
	
}