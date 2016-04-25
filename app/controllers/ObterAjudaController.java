package controllers;

import models.ObterAjuda;
import notifier.SendEmail;
import models.Produto;
import org.apache.commons.mail.EmailException;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.obter_suporte;


/**
 * Created by dumorango on 4/11/16.
 */
public class ObterAjudaController extends Controller {

    public static Result index() {
        if(session().get("nome") ==null){
            return redirect(
                    routes.Application.login()
            );
        }
        Form<ObterAjuda> ajudaForm = Form.form(ObterAjuda.class);
        return ok(index.render("", "", obter_suporte.render(ajudaForm,"")));
    }

    public static Result sendEmail()
    {
        Form<ObterAjuda> ajudaForm = Form.form(ObterAjuda.class);
        ajudaForm = ajudaForm.bindFromRequest();
        if (ajudaForm.hasErrors()) {
            return badRequest(index.render("", "", obter_suporte.render(ajudaForm, "")));
        } else {
            ObterAjuda ajudaObj = ajudaForm.get();
            String contato = "Contato\n" + ajudaForm.field("phone").value() + "\n" + ajudaForm.field("email").value();
            String message = contato + "\n\n" + "Mensagem:\n" + ajudaForm.field("message").value();
            ajudaObj.save();
            SendEmail email = new SendEmail();
            try {
                email.enviaEmailSimples(ajudaForm.field("name").value(),""," ","Teste",message);
            } catch (EmailException e) {
                e.printStackTrace();
            }

            return ok(index.render("", "", obter_suporte.render(ajudaForm, "Email enviado com sucesso.")));
        }
    }

}
