package com.vico.dicom;

import java.io.IOException;
import java.util.List;

import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;
import org.dcm4che2.net.ConfigurationException;
import org.dcm4che2.tool.dcmecho.DcmEcho;
import org.dcm4che2.tool.dcmqr.DcmQR;


public class DcmTest {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DcmTest test = new DcmTest();
		test.qrTest();
//		test.echoTest();
	}
	
	public void echoTest(){
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
	
	public void qrTest(){
		DcmQR serv = new DcmQR("testqr");
		serv.setCalledAET("CONQESTSERV1", false);
		serv.setRemoteHost("127.0.0.1");
		serv.setRemotePort(5678);
		serv.setCFind(true);

		serv.setQueryLevel(org.dcm4che2.tool.dcmqr.DcmQR.QueryRetrieveLevel.PATIENT);
		try {
			serv.configureTransferCapability(false);
			serv.open();
			List<DicomObject> result;
			serv.addMatchingKey(Tag.toTagPath("00100010"), "HEAD EXP2");
			result = serv.query();
			serv.close();
			for(DicomObject o : result){
				System.out.println(o);
			}
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
