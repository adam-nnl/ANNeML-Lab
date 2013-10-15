/*
    Copyright 2013 Adam Lara

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaderJDOMFactory;
import org.jdom2.input.sax.XMLReaderXSDFactory;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.xpath.XPath;

public class AL_gui extends javax.swing.JFrame implements FileHistory.IFileHistory {
    private FileHistory fileHistory; 
    static volatile Document NNetMap; 
    final int low = -1;
    final int high = 1;
    final int decpl = 4;
    /**
     * Creates new form AL_gui
     */
    public AL_gui() {
        try {
            // Set System L&F
            UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) {
            // handle exception
        }
     
        initComponents();
        fileHistory = new FileHistory(this); // init FileHistory with our frame as the only parameter.
        fileHistory.initFileMenuHistory(); // Start file history initialization.
    }

    public JFrame getFrame() {
        return this;
    }    
    
    public void loadFile(String pathname, String filename) {

        try {
            // Build & creat the document with SAX, use XML schema validation
            URL path = ClassLoader.getSystemResource("ANNeML.xsd");
            if(path.getFile()==null) {
                jLabel2.setForeground(Color.RED);
                jLabel2.setText("error loading XML schema");  
            }
            else{
                //File argylexsd = new File(path.toURI());
                //XMLReaderJDOMFactory schemafac = new XMLReaderXSDFactory(argylexsd);
                XMLReaderJDOMFactory schemafac = new XMLReaderXSDFactory("ANNeML.xsd"); //***for .jar deployment
                SAXBuilder builder = new SAXBuilder(schemafac);
                AL_gui.NNetMap = builder.build(pathname);
                java.util.List subnets = XPath.newInstance("//SUBNET").selectNodes(AL_gui.NNetMap);
                java.util.List layers = XPath.newInstance("//LAYER").selectNodes(AL_gui.NNetMap);
                java.util.List inputNeurodes = XPath.newInstance("//NEURODE[SYNAPSE/@ORG_NEURODE='INPUT']").selectNodes(AL_gui.NNetMap);
                java.util.List hiddenNeurodes = XPath.newInstance("//LAYER[@LAYER_NAME='HIDDEN']/NEURODE").selectNodes(AL_gui.NNetMap);
                java.util.List outputNeurodes = XPath.newInstance("//LAYER[@LAYER_NAME='OUTPUT']/NEURODE").selectNodes(AL_gui.NNetMap);                
                jLabel2.setForeground(Color.GREEN);
                jLabel2.setText("Valid ANNeML file.");
            } 
            } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(AL_gui.this, "There was an error parsing the file.\n" + e.toString(), "Warning", JOptionPane.WARNING_MESSAGE);
        }
         
                    
    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ANNeML Lab - v0.9.5b");
        setResizable(false);

        jLabel1.setText("File:");

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Randomize");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Save File");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Status");

        jButton4.setText("ANNeML Wizard");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ANNeML-lab2.png"))); // NOI18N
        jLabel3.setToolTipText("");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(36, 36, 36)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, 0, 231, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(33, 33, 33)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton4)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //Browse/Load file button
        JFileChooser fc = new JFileChooser();
        xFilter x1= new xFilter();
        fc.setFileFilter(x1);
        fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int returnVal = fc.showOpenDialog(jButton2);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            if (f == null) {
                return;
            }
            if (f.getName().equals("")) {
                return;
            }
            String path = f.getAbsolutePath();
            String name=f.getName();
            fileHistory.insertPathname(path, name); // Hook into FileHistory class.
            loadFile(path, name); // Do the file processing activity in the application.

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //save nnet button/function
        try{
            SaveNet save = new SaveNet();
            save.WriteFile(NNetMap, jComboBox1.getSelectedItem().toString());
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(AL_gui.this, "Problem encountered while saving file\n" + e.toString(),"Warning", JOptionPane.WARNING_MESSAGE);
        }
        JOptionPane.showMessageDialog(AL_gui.this, (("File saved as:\n" + jComboBox1.getSelectedItem().toString()) + ".rnd.xml"), "File saved", JOptionPane.WARNING_MESSAGE);        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
        jLabel2.setForeground(Color.BLACK);
        jLabel2.setText("Randomizing synpase weights.");
        java.util.List synapses = XPath.newInstance("//SYNAPSE").selectNodes(AL_gui.NNetMap);  

        for (Iterator SynIt = synapses.iterator(); SynIt.hasNext();){        
            Element synapse=(Element)SynIt.next();
            String layerType = synapse.getParentElement().getParentElement().getAttributeValue("LAYER_NAME").toString();
            if(layerType.equals("INPUT")){
                synapse.setAttribute("WEIGHT", "1.00");  
            }
            else{
                Random rnd = new Random();
                synapse.setAttribute("WEIGHT", getRandomValue(rnd, low, high, decpl));            
            }
        } 
        jLabel2.setForeground(Color.BLACK);
        jLabel2.setText("Randomizing neurode biases.");        
        java.util.List nodes = XPath.newInstance("//NEURODE").selectNodes(AL_gui.NNetMap);         
        for (Iterator It = nodes.iterator(); It.hasNext();){        
            Element node=(Element)It.next();
            String layerType = node.getParentElement().getAttributeValue("LAYER_NAME").toString();
            if(layerType.equals("INPUT")){
                node.setAttribute("BIAS", "0.00");
            }
            else{
                Random rnd = new Random();
                node.setAttribute("BIAS", getRandomValue(rnd, low, high, decpl));              
            }
        }        
        jLabel2.setForeground(Color.BLACK);
        jLabel2.setText("All Done.");          
        
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(AL_gui.this, "Problem encountered while saving file\n" + e.toString(),"Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    try {
        String nnetName = JOptionPane.showInputDialog(jButton3,
                        "Enter a filename, excluding extention.",
                        "ANNeML Wizard",
                        JOptionPane.QUESTION_MESSAGE);
        if(nnetName==" "){
            JOptionPane.showMessageDialog(null, "An input value must be entered.");
        }        
 
    
        Element nnet = new Element("NNETWORK");
        nnet.setAttribute(new Attribute("noNamespaceSchemaLocation","ANNeML.xsd",Namespace.getNamespace("xsi","http://www.w3.org/2001/XMLSchema-instance")));
        nnet.setAttribute(new Attribute("NNET_NAME", nnetName));
	Document doc = new Document(nnet);

        String subnnets = JOptionPane.showInputDialog(jButton3,
                        "How many SUBNET(s)?",
                        "ANNeML Wizard",
                        JOptionPane.QUESTION_MESSAGE);
        if(subnnets==" "){
            JOptionPane.showMessageDialog(null, "An input value must be entered.");
        }
        int numSubs=java.lang.Integer.parseInt(subnnets);
        int i = 0;
        do{
            Element subnet = new Element("SUBNET");
            String learningRate = JOptionPane.showInputDialog(jButton3,
                        "SUBNET learning rate(eta)?",
                        "ANNeML Wizard",
                        JOptionPane.QUESTION_MESSAGE);
            if(learningRate==" "){
                JOptionPane.showMessageDialog(null, "An input value must be entered.");
            }  
            subnet.setAttribute(new Attribute("NNET_V2", learningRate));
            subnet.setAttribute(new Attribute("SNET_NAME", nnetName + "-subnet" + String.valueOf(i+1)));
            subnet.setAttribute(new Attribute("ADJUST_LOCK", "0"));
            
            String input_layers = JOptionPane.showInputDialog(jButton3,
                        "How many <<INPUT>> LAYERS(s) in this subnet?",
                        "ANNeML Wizard",
                        JOptionPane.QUESTION_MESSAGE);
            if(input_layers==" "){
                JOptionPane.showMessageDialog(null, "An input value must be entered.");
            }
            int numInLayers=java.lang.Integer.parseInt(input_layers);
            int x = 0;
            do{
                Element inLayer = new Element("LAYER");
                inLayer.setAttribute(new Attribute("LAYER_NAME", "INPUT"));
                String transferFunc = JOptionPane.showInputDialog(jButton3,
                        "Which transfer function for this LAYER? 1(hyberbolic tangent) or 2(logarithmic sigmoid)",
                        "ANNeML Wizard",
                        JOptionPane.QUESTION_MESSAGE);
                if(transferFunc==" "){
                    JOptionPane.showMessageDialog(null, "An input value must be entered.");
                }                
                inLayer.setAttribute(new Attribute("TRANSFER_FUNCTION", transferFunc));
                String inNodes = JOptionPane.showInputDialog(jButton3,
                        "How many NEURODE(s) in this <<INPUT>> LAYER?",
                        "ANNeML Wizard",
                        JOptionPane.QUESTION_MESSAGE);
                if(inNodes==" "){
                    JOptionPane.showMessageDialog(null, "An input value must be entered.");
                }
                int numInNodes=java.lang.Integer.parseInt(inNodes);
                int y = 0;
                do{
                    Element node = new Element("NEURODE");
                    node.setAttribute(new Attribute("N_ID", "IN" + String.valueOf(x+1) + String.valueOf(y+1)));
                    node.setAttribute(new Attribute("ACTIVE", "-1"));
                    node.setAttribute(new Attribute("ACTIVITY", "0.0"));
                    node.setAttribute(new Attribute("BIAS", "0.0"));
                    node.setAttribute(new Attribute("CNAME", "Input node#" + String.valueOf(y+1)));
                    node.setAttribute(new Attribute("NNET_V4", "0.0"));
                    Element inSynapse = new Element("SYNAPSE");
                    inSynapse.setAttribute(new Attribute("WEIGHT", "1.00"));
                    inSynapse.setAttribute(new Attribute("ORG_NEURODE", "INPUT"));
                    node.addContent(inSynapse);
                    inLayer.addContent(node);
                    y++;
                }while(y<numInNodes);
                subnet.addContent(inLayer);
                x++;
            }while(x<numInLayers);
            
            String hidden_layers = JOptionPane.showInputDialog(jButton3,
                        "How many <<HIDDEN>> LAYERS(s) in this subnet?",
                        "ANNeML Wizard",
                        JOptionPane.QUESTION_MESSAGE);
            if(hidden_layers==" "){
                JOptionPane.showMessageDialog(null, "An input value must be entered.");
            }
            int numHLayers=java.lang.Integer.parseInt(hidden_layers);
            int z = 0;
            do{
                Element hLayer = new Element("LAYER");
                hLayer.setAttribute(new Attribute("LAYER_NAME", "HIDDEN"));
                String transferFunc = JOptionPane.showInputDialog(jButton3,
                        "Which transfer function for this LAYER? 1(hyberbolic tangent) or 2(logarithmic sigmoid)",
                        "ANNeML Wizard",
                        JOptionPane.QUESTION_MESSAGE);
                if(transferFunc==" "){
                    JOptionPane.showMessageDialog(null, "An input value must be entered.");
                }                
                hLayer.setAttribute(new Attribute("TRANSFER_FUNCTION", transferFunc));
                String hNodes = JOptionPane.showInputDialog(jButton3,
                        "How many NEURODE(s) in this <<HIDDEN>> LAYER?",
                        "ANNeML Wizard",
                        JOptionPane.QUESTION_MESSAGE);
                if(hNodes==" "){
                    JOptionPane.showMessageDialog(null, "An input value must be entered.");
                }
                int numhNodes=java.lang.Integer.parseInt(hNodes);
                int a = 0;
                do{
                    Random rnd = new Random();
                    Element node = new Element("NEURODE");
                    node.setAttribute(new Attribute("N_ID", "N" + String.valueOf(z+1) +String.valueOf(a+1)));
                    node.setAttribute(new Attribute("ACTIVE", "-1"));
                    node.setAttribute(new Attribute("ACTIVITY", "0.0"));
                    node.setAttribute(new Attribute("BIAS", getRandomValue(rnd, low, high, decpl)));
                    node.setAttribute(new Attribute("CNAME", "Hidden node#" + String.valueOf(a+1)));
                    node.setAttribute(new Attribute("NNET_V4", "0.0"));    
                    hLayer.addContent(node);
                    a++;
                }while(a<numhNodes);
                subnet.addContent(hLayer);
                z++;
            }while(z<numHLayers);          
            
            String output_layers = JOptionPane.showInputDialog(jButton3,
                        "How many <<OUTPUT>> LAYERS(s) in this subnet?",
                        "ANNeML Wizard",
                        JOptionPane.QUESTION_MESSAGE);
            if(hidden_layers==" "){
                JOptionPane.showMessageDialog(null, "An input value must be entered.");
            }
            int numOLayers=java.lang.Integer.parseInt(output_layers);
            int b = 0;
            do{
                Element oLayer = new Element("LAYER");
                oLayer.setAttribute(new Attribute("LAYER_NAME", "OUTPUT"));
                String transferFunc = JOptionPane.showInputDialog(jButton3,
                        "Which transfer function for this LAYER? 1(hyberbolic tangent) or 2(logarithmic sigmoid)",
                        "ANNeML Wizard",
                        JOptionPane.QUESTION_MESSAGE);
                if(transferFunc==" "){
                    JOptionPane.showMessageDialog(null, "An input value must be entered.");
                }                
                oLayer.setAttribute(new Attribute("TRANSFER_FUNCTION", transferFunc));
                String oNodes = JOptionPane.showInputDialog(jButton3,
                        "How many NEURODE(s) in this <<OUTPUT>> LAYER?",
                        "ANNeML Wizard",
                        JOptionPane.QUESTION_MESSAGE);
                if(oNodes==" "){
                    JOptionPane.showMessageDialog(null, "An input value must be entered.");
                }
                int numoNodes=java.lang.Integer.parseInt(oNodes);
                int d = 0;
                do{
                    Random rnd = new Random();
                    Element node = new Element("NEURODE");
                    node.setAttribute(new Attribute("N_ID", "ON" + String.valueOf(b+1) + String.valueOf(d+1)));
                    node.setAttribute(new Attribute("ACTIVE", "-1"));
                    node.setAttribute(new Attribute("ACTIVITY", "0.0"));
                    node.setAttribute(new Attribute("BIAS", getRandomValue(rnd, low, high, decpl)));
                    node.setAttribute(new Attribute("CNAME", "Output node#" + String.valueOf(d+1)));
                    node.setAttribute(new Attribute("NNET_V4", "0.0"));
                    oLayer.addContent(node);
                    d++;
                }while(d<numoNodes);
                subnet.addContent(oLayer);
                b++;
            }while(b<numOLayers);             
            
            doc.getRootElement().addContent(subnet);
            i++;
        }while(i<numSubs);
        
        //generate fully interconnected SYNAPSE(s) for all NEURODE(s) within each SUBNET
        
        java.util.List subnets=XPath.newInstance("//SUBNET").selectNodes(doc);
        Iterator itSubslist=subnets.iterator();
        do{
            Element currentSnet=(Element) itSubslist.next();
            String snetName = currentSnet.getAttributeValue("SNET_NAME");
            //System.out.println(snetName);
            
            java.util.List Hnodes=XPath.newInstance("//SUBNET[@SNET_NAME='" + snetName + "']/LAYER[@LAYER_NAME='HIDDEN']/NEURODE").selectNodes(doc);
                Iterator itHNodelist=Hnodes.iterator();
                do{   
                Element node=(Element) itHNodelist.next();
                //System.out.println(node.getAttributeValue("N_ID"));
                java.util.List Inodes=XPath.newInstance("//SUBNET[@SNET_NAME='" + snetName + "']/LAYER[@LAYER_NAME='INPUT']/NEURODE").selectNodes(doc);
                Iterator itNodelist=Inodes.iterator();
                    do{ 
                        Element currentNode=(Element) itNodelist.next();
                        //System.out.println(currentNode.getAttributeValue("N_ID"));
                        Element hSynapse = new Element("SYNAPSE");
                        Random rnd = new Random();
                        hSynapse.setAttribute(new Attribute("WEIGHT", getRandomValue(rnd, low, high, decpl)));
                        hSynapse.setAttribute(new Attribute("ORG_NEURODE", currentNode.getAttributeValue("N_ID")));
                        node.addContent(hSynapse);
                    }while(itNodelist.hasNext());  
                }while(itHNodelist.hasNext());
                
            java.util.List Onodes=XPath.newInstance("//SUBNET[@SNET_NAME='" + snetName + "']/LAYER[@LAYER_NAME='OUTPUT']/NEURODE").selectNodes(doc);
                Iterator itONodelist=Onodes.iterator();
                do{   
                Element node=(Element) itONodelist.next();
                //System.out.println(node.getAttributeValue("N_ID"));
                java.util.List hnodes=XPath.newInstance("//SUBNET[@SNET_NAME='" + snetName + "']/LAYER[@LAYER_NAME='HIDDEN']/NEURODE").selectNodes(doc);
                Iterator itNodelist=hnodes.iterator();
                    do{ 
                        Element currentNode=(Element) itNodelist.next();
                        //System.out.println(currentNode.getAttributeValue("N_ID"));
                        Element hSynapse = new Element("SYNAPSE");
                        Random rnd = new Random();
                        hSynapse.setAttribute(new Attribute("WEIGHT", getRandomValue(rnd, low, high, decpl)));
                        hSynapse.setAttribute(new Attribute("ORG_NEURODE", currentNode.getAttributeValue("N_ID")));
                        node.addContent(hSynapse);
                    }while(itNodelist.hasNext());  
                }while(itONodelist.hasNext());
                
        }while(itSubslist.hasNext());
         
 
	// new XMLOutputter().output(doc, System.out);
	XMLOutputter xmlOutput = new XMLOutputter();
 
	// display nice nice
	xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(doc, System.out);
	xmlOutput.output(doc, new FileWriter(nnetName+".xml"));
 
	System.out.println("File Saved!");
        
	} catch (Exception e) {
            System.out.println(e.getMessage());
	}        

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(jButton3,
        "ANNeML Lab v0.9.5 beta \n"
        + "Copyright(c) 2013 Adam Lara \n"
        + "This software is distributed under an Apache v2 license \n"
        + "--------------------------------------------------------------- \n"
        + "This software utilizes the ANNeML v1 XML schema which is \n"
        + "distrubuted under Creative Commons \n"
        + "--------------------------------------------------------------- \n"
        + "This software uses the software libraries: \n"
        + "JDOM, JAXEN, and XML-APIS all distributed under Apache licenses  \n", "ANNeML Lab About", 1);
    }//GEN-LAST:event_jLabel3MouseClicked

public static String getRandomValue(final Random random,
    final int lowerBound,
    final int upperBound,
    final int decimalPlaces){

    if(upperBound <= lowerBound || decimalPlaces < 0){
        throw new IllegalArgumentException("Decimal range error");
    }

    final double dbl =
        ((random == null ? new Random() : random).nextDouble() //
            * (upperBound - lowerBound))
            + lowerBound;
    return String.format("%." + decimalPlaces + "f", dbl);

}    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AL_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AL_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AL_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AL_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AL_gui().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getApplicationName() {
        return "ANNeML Lab";
    }

    @Override
    public JComboBox getFileMenu() {
        return this.jComboBox1;
    }
}
