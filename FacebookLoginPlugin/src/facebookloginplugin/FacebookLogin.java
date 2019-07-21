/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookloginplugin;

import interfaces.ILoginType;

/**
 *
 * @author victor
 */
public class FacebookLogin implements ILoginType{

    @Override
    public void login() {
        System.out.println("Login feito pelo Facebook!");
    }
    
}
