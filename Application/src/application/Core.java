/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import interfaces.ICore;
import interfaces.ILoginController;
import interfaces.IPluginController;
import interfaces.IUIController;

/**
 *
 * @author aluno
 */
public class Core implements ICore {

    private Core() {
        uiController = new UIController();
        pluginController = new PluginController();
        loginController = new LoginController();
        uiController.initialize();
        pluginController.initialize(this);
        loginController.initialize(this);
    }
    @Override
    public IUIController getUIController() {
        return uiController;
    }

    @Override
    public IPluginController getPluginController() {
        return pluginController;
    }
    
     @Override
    public ILoginController getLoginController() {
        return loginController;
    }
    
    public static Core getInstance(){
        if(core == null)
            core = new Core();
        
        return core;
    }
    
    private IUIController uiController;
    private IPluginController pluginController;
    private ILoginController loginController;
    private static Core core;

   
}
