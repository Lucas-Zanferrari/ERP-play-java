package controllers;

import models.ObterAjuda;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.obter_suporte;
import org.apache.commons.mail.EmailException;

/**
 * Created by dumorango on 4/11/16.
 */
public class ObterAjudaController extends Controller {

    public static Result index() {
        Form<ObterAjuda> ajudaForm = Form.form(ObterAjuda.class);
        return ok(index.render("", "", obter_suporte.render(ajudaForm,"")));
    }

    public static Result sendEmail() {
        Form<ObterAjuda> ajudaForm = Form.form(ObterAjuda.class);
        ajudaForm = ajudaForm.bindFromRequest();
        if (ajudaForm.hasErrors()) {
            return badRequest(index.render("", "", obter_suporte.render(ajudaForm, "")));
        } else {
            ObterAjuda ajudaObj = ajudaForm.get();
            String contato = "Contato:\n" + ajudaForm.field("phone").value() + "\n" + ajudaForm.field("email").value();
            String message = contato + "\n\n" + "Mensagem:\n" + ajudaForm.field("message").value();
            ObterAjuda email = new ObterAjuda();
            try {
                email.enviaEmailSimples(ajudaForm.field("name").value(),"sup.padaria@mail.com","sup.padaria@mail.com","Suporte Padaria",message);
            } catch (EmailException e) {
                e.printStackTrace();
            }
            ajudaForm = Form.form(ObterAjuda.class);
            return ok(index.render("", "", obter_suporte.render(ajudaForm, "Email enviado com sucesso.")));
        }
    }

}
