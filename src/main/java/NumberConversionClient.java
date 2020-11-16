import generated.NumberConversionSoapType;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NumberConversionClient {
    static final String SERVICE = "NumberConversion";
    static final String URL_STR = "http://www.dataaccess.com/webservicesserver/";
    static final String EXT = ".wso?WSDL";
    public static void main(String[] args) throws MalformedURLException {

        Scanner scanner = new Scanner(System.in);
        String url = String.format("%s%s%s", URL_STR, SERVICE, EXT);
        URL wsdContractURL = new URL(url);
        QName serviceName = new QName(URL_STR, SERVICE);
        Service service = Service.create(wsdContractURL, serviceName);
        NumberConversionSoapType client = service.getPort(NumberConversionSoapType.class);
        System.out.print("Please enter integer number: ");
        String result = client.numberToWords(scanner.nextBigInteger());
        System.out.println(result);
    }
}
