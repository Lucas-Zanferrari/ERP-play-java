package models;

import com.avaje.ebean.Model;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * Created by lucaszanferrari on 9/04/2016.
 */

public class ObterAjuda extends Model {

    private String name;
    private String email;
    private String phone;
    private String message;

    public void enviaEmailSimples(String nomeRementente, String emailRemetente,
                                  String emailDestinatario,
                                  String assunto, String mensagem) throws EmailException {

        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.mail.com"); // o servidor SMTP para envio do e-mail
        email.addTo(emailDestinatario); //destinatário
        email.setFrom(emailRemetente, nomeRementente); // remetente
        email.setSubject(assunto); // assunto do e-mail
        email.setMsg(mensagem); //conteudo do e-mail
        email.setAuthentication("sup.padaria@mail.com", "syspadaria2016"); //criar email e senha para envio (mesmo do destinatario)
        email.setCharset("UTF-8");
        email.setSmtpPort(587);
        email.setTLS(true);
        email.setSSL(true);
        email.send();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }




}
