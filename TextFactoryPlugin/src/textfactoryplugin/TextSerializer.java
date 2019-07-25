/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfactoryplugin;

import interfaces.IDocumentSerializer;

/**
 *
 * @author Victor
 */
public class TextSerializer implements IDocumentSerializer {

    
    @Override
    public void loadDocument() {
        System.out.println("Arquivo carregado com sucesso!");
    }

    @Override
    public void saveDocument() {
        System.out.println("Arquivo salvo com sucesso!");
    }
    
    
    private static TextSerializer textSerializer;
    
}
