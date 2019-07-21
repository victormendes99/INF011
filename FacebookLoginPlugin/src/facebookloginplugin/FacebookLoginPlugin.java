/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookloginplugin;

import interfaces.ICore;
import interfaces.ILoginFactory;
import interfaces.ILoginType;
import interfaces.IPlugin;

/**
 *
 * @author victor
 */
public class FacebookLoginPlugin implements ILoginFactory, IPlugin{
    
    
    @Override
    public boolean initialize(ICore core) {
        this.getLoginMaker();
        return true;
    }
    
    @Override
    public ILoginType getLoginMaker() {
        ILoginType facebookLogin = new FacebookLogin();
        return facebookLogin;
    }

    
}
