/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfactoryplugin;

import interfaces.IDocumentEditor;

/**
 *
 * @author Victor
 */
public class TextEditor implements IDocumentEditor {

    private TextEditor(){
        
    }
    
    @Override
    public void openDocument() {
        System.out.println("Visualizando Documento");
    }
    
    
    public static TextEditor getInstance(){
        if(textEditor == null)
            textEditor = new TextEditor();
        
        return textEditor;
    }
    
    private static TextEditor textEditor;
    
}
