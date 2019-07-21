/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import interfaces.ICore;
import interfaces.ILoginController;
import interfaces.ILoginFactory;
import interfaces.IPlugin;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author victor
 */
public class LoginController implements ILoginController{
    private List<ILoginFactory> loadedPluginsByType = new ArrayList<>();
    
    
    @Override
    public boolean initialize(ICore core){
        castPluginsList(core.getPluginController().getLoadedPluginsByType(ILoginFactory.class));
        ILoginFactory plugin = (ILoginFactory)searchClass(loadedPluginsByType);
        if(plugin != null)
            plugin.getLoginMaker().login();
        else
            System.out.println("O modo de login escolhido não é suportado");
            
        return true;
    }

    private <T>List<T> castPluginsList(List<T> loadedPlugins){
        for(T plugin: loadedPlugins){
            loadedPluginsByType.add((ILoginFactory)plugin);
        }
        return loadedPlugins;
    }
    
    private IPlugin searchClass(List<ILoginFactory> loginList){
        String loadXML = readXML().trim();    
        for(ILoginFactory plugin: loginList){
                if(loadXML.equals(getPluginName(plugin))){
                    return (IPlugin)plugin;
                } 
            }
           return null;
    }
    
    private String getPluginName(ILoginFactory plugin){
        String name;
        name  = plugin.getClass().getName().split("\\.")[1];
        return name;
    }
    
    private String readXML(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Node value = null;
        try{
            DocumentBuilder builder  = dbf.newDocumentBuilder();
            Document doc = builder.parse(new File("LoginCurrent.xml"));
            NodeList elements = doc.getElementsByTagName("root").item(0).getChildNodes();
            value = (Node) elements.item(0);
            
        }
        catch(ParserConfigurationException | SAXException | IOException ex){
            System.out.println("Erro ao ler o arquivo xml");
        }
       return value.getNodeValue(); 
    }   
}
