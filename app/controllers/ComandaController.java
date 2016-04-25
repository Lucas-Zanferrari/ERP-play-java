package controllers;

import models.Comanda;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.nova_comanda;
import views.html.comandas;

public class ComandaController extends Controller {

    public static Result index(String id) {
        if(session().get("nome") ==null){
            return redirect(
                    routes.Application.login()
            );
        }
        Form<Comanda> comandaForm = Form.form(Comanda.class);
        if(id!=null) comandaForm = comandaForm.fill(Comanda.byId(id));
        return ok(index.render("", "", nova_comanda.render(comandaForm,"")));
    }

    public static Result create(String id){
        Form<Comanda> comandaForm = Form.form(Comanda.class);
        comandaForm = comandaForm.bindFromRequest();
        if (comandaForm.hasErrors()) {
            return badRequest(index.render("", "", nova_comanda.render(comandaForm, "")));
        } else {
            Comanda comandaObj = comandaForm.get();
            if(id==null) {
                comandaObj.save();
                return ok(index.render("", "", nova_comanda.render(comandaForm, "Comanda cadastrada com sucesso.")));
            }else{
                comandaObj.setId(Integer.valueOf(id));
                comandaObj.update();
                return ok(index.render("", "", nova_comanda.render(comandaForm, "Comanda atualizada com sucesso.")));
            }
        }
    }

    public static Result delete(String id){
        Comanda comanda = Comanda.byId(id);
        comanda.delete();
        return ok(index.render("", "comanda", comandas.render(comanda.list(), "Comanda "+id+" removida com sucesso")));
    }
}
