package com.wawi.ruler.bundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class SimpleBundle implements BundleActivator {

	@Override
	public void start(BundleContext arg0) throws Exception {
		// TODO Auto-generated method stub
		System.err.println("�������:" + arg0.getBundle().getBundleId());
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		// TODO Auto-generated method stub
		System.err.println("�˳����:" + arg0.getBundle().getBundleId());
	}

}
