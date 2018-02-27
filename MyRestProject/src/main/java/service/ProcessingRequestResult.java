package service;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
public class ProcessingRequestResult {
    @XmlElement public boolean result;
    @XmlElement public String message;

    public ProcessingRequestResult()
    {
        result = false;
        message = "???";
    }

    public static ProcessingRequestResult GoodResult(String msg)
    {
        ProcessingRequestResult obj = new ProcessingRequestResult();
        obj.result = true;
        obj.message = msg;
        return obj;
    }

    public static ProcessingRequestResult BadResult(String msg)
    {
        ProcessingRequestResult obj = new ProcessingRequestResult();
        obj.message = msg;
        return obj;
    }

}
