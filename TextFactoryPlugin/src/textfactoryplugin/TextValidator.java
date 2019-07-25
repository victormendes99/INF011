/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfactoryplugin;

import interfaces.IDocumentValidator;

/**
 *
 * @author Victor
 */
public class TextValidator implements IDocumentValidator {
    
    
    @Override
    public void validateDocument() {
        System.out.println("Arquivo validado com sucesso!");
    }
   
    
    private static TextValidator textValidator;
}
