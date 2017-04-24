package notes.server;

import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 * Created by HunJin on 2017-04-24.
 */
@WebService
public interface TempVerter {
    @WebMethod double c2f (double degrees);
    @WebMethod double f2c(double degrees);
}
