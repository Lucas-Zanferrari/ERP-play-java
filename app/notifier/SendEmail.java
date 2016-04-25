package notifier;


import org.apache.commons.mail.*;

/**
 * Created by Vitor Domingues on 25/04/2016.
 */
public class SendEmail{


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


}
