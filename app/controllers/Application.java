package controllers;

import models.Funcionario;
import models.Produto;
import play.data.*;
import play.mvc.*;

import views.html.*;

import static play.data.Form.form;


public class Application extends Controller {

    public static Result index() {
        if(session().get("nome")==null){
            return redirect(
                    routes.Application.login()
            );
        }
        return ok(index.render(null, null, null));
    }

    public static Result login() {
        Form<Login> loginForm = form(Login.class);
        if(!session().isEmpty()){
            return redirect(
                    routes.Application.index()
            );
        }
        return ok(
                login.render(null, null)
        );
    }

    public static Result authenticate() {
        DynamicForm dynamicForm = Form.form().bindFromRequest();
        Login loginObj = new Login(dynamicForm.get("username"),dynamicForm.get("password"));
        Funcionario funcionarioObj = loginObj.validate();
        if (funcionarioObj==null) {
            return badRequest(login.render("Usuário ou senha inválido", null));
        } else {
            session().clear();
            session("nome", funcionarioObj.getNome());
            session("nivelAcesso",funcionarioObj.getNivel_acesso());
            return redirect(
                    routes.Application.index()
            );
        }
    }

    public static Result logout() {
        session().clear();
        return redirect(
            routes.Application.login()
        );
    }
}

