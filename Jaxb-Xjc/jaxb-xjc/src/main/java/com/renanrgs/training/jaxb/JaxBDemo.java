package com.renanrgs.training.jaxb;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.bharatthippireddy.patient.Patient;
import com.bharatthippireddy.patient.PaymentType;

public class JaxBDemo {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub
		JAXBContext context = JAXBContext.newInstance(Patient.class);
		Marshaller marshaller = context.createMarshaller();
		
		Patient patient = new Patient();
		patient.setAge(28);
		patient.setName("Renan");
		patient.setId(123);
		patient.setPayment(new PaymentType());
		patient.setPhone("222222222");
		
		StringWriter writer = new StringWriter();
		marshaller.marshal(patient, writer);
		
		System.out.println(writer.toString());
		
		Unmarshaller createUnmarshaller = context.createUnmarshaller();
		Patient patientJava = (Patient) createUnmarshaller.unmarshal(new StringReader(writer.toString()));
		System.out.println(patient.getName());
		
		
	}

}
