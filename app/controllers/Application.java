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
        return ok(index.render(null));
    }

    public static Result login() {
        Form<Login> loginForm = form(Login.class);
        return ok(
                login.render("")
        );
    }

    public static Result authenticate() {
        DynamicForm dynamicForm = Form.form().bindFromRequest();
        Login loginObj = new Login(dynamicForm.get("username"),dynamicForm.get("password"));
        Funcionario funcionarioObj = loginObj.validate();
        if (funcionarioObj==null) {
            return badRequest(login.render("Usuário ou senha inválido"));
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

class Login {

    public String username;
    public String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Funcionario validate() {
        return Funcionario.authenticate(username, password);
    }
}

