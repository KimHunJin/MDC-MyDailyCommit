package notes.server;

import javax.jws.WebService;

/**
 * Created by HunJin on 2017-04-24.
 */
@WebService(endpointInterface = "notes.server.TempVerter")
public class TempVerterImpl implements TempVerter {

    @Override
    public double c2f(double degrees) {
        return degrees*9.0/5.0+32;
    }

    @Override
    public double f2c(double degrees) {
        return (degrees-32)*5.0/9.0;
    }
}
