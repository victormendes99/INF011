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
    
    private TextValidator(){
        
    }
    
    @Override
    public void validateDocument() {
        System.out.println("Arquivo validado com sucesso!");
    }
    
    public static TextValidator getInstance(){
        if(textValidator == null)
            textValidator = new TextValidator();
        return textValidator;
    }
   
    
    private static TextValidator textValidator;
}
