/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfactoryplugin;

import interfaces.IPlugin;
import interfaces.ICore;
import interfaces.IDocumentEditor;
import interfaces.IDocumentFactory;
import interfaces.IDocumentSerializer;
import interfaces.IDocumentValidator;
/**
 *
 * @author Victor
 */
public class TextFactoryPlugin implements IPlugin , IDocumentFactory{
    @Override
    public boolean initialize(ICore core){
        return true;
    }

    @Override
    public IDocumentEditor createDocumentEditor() {
        return TextEditor.getInstance();
     }
    
    
    @Override
    public IDocumentValidator createDocumentValidator() {
        return TextValidator.getInstance();
    }

    @Override
    public IDocumentSerializer createDocumentSerializer() {
        return TextSerializer.getInstance();
    }

    @Override
    public String getSupportedExtensions() {
        return "pptx|txt|pdf";
    }
    
    @Override
    public void init(){
        createDocumentEditor().openDocument();
        createDocumentValidator().validateDocument();
        createDocumentSerializer().loadDocument();
    }
    
    
}
