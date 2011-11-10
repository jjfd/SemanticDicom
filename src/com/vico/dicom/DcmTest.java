package com.vico.dicom;

import java.io.IOException;

import org.dcm4che2.net.ConfigurationException;
import org.dcm4che2.tool.dcmecho.DcmEcho;;

public class DcmTest {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DcmEcho serv = new DcmEcho("test");
		serv.setRemoteHost("127.0.0.1");
		serv.setRemotePort(5678);
		serv.setCalledAET("CONQUESTSRV1    ", true);
		try {
			serv.open();
			serv.echo();
			serv.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
