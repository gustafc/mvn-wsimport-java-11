package github.gustafc.mvnwsimport11;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import calculator.AddResponse;


class CalculatorClient extends WebServiceGatewaySupport {

    public static final String WSDL_URI = "http://www.dneonline.com/calculator.asmx?WSDL";

    CalculatorClient() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("calculator");
        setMarshaller(marshaller);
        setUnmarshaller(marshaller);
    }

    int add(int intA, int intB) {
        calculator.Add add = new calculator.Add();
        add.setIntA(intA);
        add.setIntB(intB);
        AddResponse response = (AddResponse) getWebServiceTemplate()
                .marshalSendAndReceive(WSDL_URI, add, new SoapActionCallback(
                        "http://tempuri.org/Add"));
        return response.getAddResult();
    }
}
