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

    @Override
    public void openDocument() {
        System.out.println("Visualizando Documento");
    }
    
    
    private static TextEditor textEditor;
    
}
