/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filenewopenplugin;

import interfaces.ICore;
import interfaces.IDocumentFactory;
import interfaces.ILoginFactory;
import interfaces.IPlugin;
import interfaces.IPluginController;
import interfaces.IUIController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class FileNewOpenPlugin implements IPlugin {
    List<IDocumentFactory> loadedPluginsByType = new ArrayList<>();
    
    @Override
    public boolean initialize(ICore core) {
        IUIController uiController = core.getUIController();
        IPluginController pluginController = core.getPluginController();
        JMenuItem fileNewItem = uiController.addMenuItem("File", "New");
        fileNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                castPluginsList(pluginController.getLoadedPluginsByType(IDocumentFactory.class));
                findExtensionSupport(getFileExtension(chooseFile()));
            }
        });        
        
        JMenuItem fileOpenItem = uiController.addMenuItem("File", "Open");
        fileOpenItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Voce clicou no File->Open");
            }
        });        
    return true;
    }
    
    private JFileChooser chooseFile(){
      JFileChooser chooser = new JFileChooser();   
        int returnVal = chooser.showOpenDialog(null);
      return chooser;
    }
    
    private String getFileExtension(JFileChooser chooser){
        String name[] = new String[2];
        name = chooser.getSelectedFile().getName().split("\\.");
        return name[1];
    }
    
    private <T>List<T> castPluginsList(List<T> loadedPlugins){
        for(T plugin: loadedPlugins){
            loadedPluginsByType.add((IDocumentFactory)plugin);
        }
        return loadedPlugins;
    }
    
    private boolean findExtensionSupport(String extension){
        for(IDocumentFactory plugin: loadedPluginsByType){
            String listExtensions[] = separatesStringExtension(plugin.getSupportedExtensions());
            for(int i = 0; i < listExtensions.length; i++){
                if(extension.equals(listExtensions[i])){
                    plugin.init();
                    return true;
                }
            }
        }
        JOptionPane.showMessageDialog(new JFrame(), "Não encontramos nenhum plugin que dê suporte ao arquivo selecionado", "Erro",
        JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    private String[] separatesStringExtension(String extensions){
        String listExtensions[] = new String[10];
        listExtensions = extensions.split("\\|");
        return listExtensions;
    }
}
