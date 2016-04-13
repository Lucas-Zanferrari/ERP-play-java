package controllers;

import models.Funcionario;
import org.apache.commons.lang3.text.FormatFactory;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.funcionario;


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
        return ok(funcionario.render(userForm,""));
    }

    public static Result create(){
        Form<Funcionario> userForm = Form.form(Funcionario.class);
        userForm = userForm.bindFromRequest();
        if (userForm.hasErrors()) {
            return badRequest(funcionario.render(userForm,""));
        } else {
            Funcionario user = userForm.get();
            user.setNivel_acesso("regular");
            user.save();
            return ok(funcionario.render(userForm,"Usuário Cadastrado com Sucesso"));
        }
    }
}
