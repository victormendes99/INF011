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
    
    private TextFactoryPlugin(){}
    
    @Override
    public boolean initialize(ICore core){
        return true;
    }

    @Override
    public IDocumentEditor createDocumentEditor() {
        return new TextEditor();
     }
    
    
    @Override
    public IDocumentValidator createDocumentValidator() {
        return new TextValidator();
    }

    @Override
    public IDocumentSerializer createDocumentSerializer() {
        return new TextSerializer();
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
    
    public static TextFactoryPlugin getInstance(){
        
        if(textFactoryPlugin == null)
            textFactoryPlugin = new TextFactoryPlugin();
        return textFactoryPlugin;
    }
    
    private static TextFactoryPlugin textFactoryPlugin = null;
}
