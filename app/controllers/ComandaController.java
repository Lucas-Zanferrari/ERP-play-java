package controllers;

import models.Comanda;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.nova_comanda;
import views.html.comandas;

public class ComandaController extends Controller {

    public static Result index() {
        if(session().isEmpty()){
            return redirect(
                    routes.Application.login()
            );
        }
        Form<Comanda> comandaForm = Form.form(Comanda.class);
        return ok(index.render("", "", nova_comanda.apply(comandaForm, "")));
    }

    public static Result create(){
        Form<Comanda> comandaForm = Form.form(Comanda.class);
        comandaForm = comandaForm.bindFromRequest();
        if (comandaForm.hasErrors()) {
            return badRequest(nova_comanda.render(comandaForm,""));
        } else {
            Comanda comanda = comandaForm.get();
            comanda.save();
            return ok(index.render("", "", nova_comanda.apply(comandaForm, "Comanda adicionada com sucesso.")));
        }
    }

}
