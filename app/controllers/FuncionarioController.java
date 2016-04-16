package controllers;

import models.Funcionario;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

/**
 * Created by dumorango on 4/11/16.
 */
public class FuncionarioController extends Controller {

    public static Result index() {
        if(session().isEmpty()){
            return redirect(
                    routes.Application.login()
            );
        }
        Form<Funcionario> userForm = Form.form(Funcionario.class);
        return ok(index.render("", null, novo_funcionario.apply(userForm, "")));
    }

    public static Result create(){
        Form<Funcionario> userForm = Form.form(Funcionario.class);
        userForm = userForm.bindFromRequest();
        if (userForm.hasErrors()) {
            return badRequest(novo_funcionario.render(userForm,""));
        } else {
            Funcionario user = userForm.get();
            user.setNivel_acesso("regular");
            user.save();
            return ok(index.render("", null, novo_funcionario.apply(userForm, "Usuário cadastrado com sucesso")));
        }
    }

    public static Result list(){
        return ok(funcionarios.render(Funcionario.list(), null));
    }
}
