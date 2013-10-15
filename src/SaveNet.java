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

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.output.XMLOutputter;

/*
 *
 * @author Adam
 */
public class SaveNet {
    
        public void WriteFile(Document nnet, String filename)throws JDOMException{
            
            try{
 
            String nnetFileName=filename + ".new.xml";
            XMLOutputter out = new XMLOutputter();
            java.io.FileWriter writer = new java.io.FileWriter(nnetFileName);
            out.output(nnet, writer);
            writer.flush();
            writer.close();
            
            }catch (Exception e) {
            e.printStackTrace();
            }
        }    
    
}
